package edu.bbq.u18.chat.server.cache;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import edu.bbq.u18.chat.server.control.ServerClientConnection;
import edu.bbq.u18.general.common.helpers.ConsolePrint;
import edu.bbq.u18.general.common.helpers.Debug;

@SuppressWarnings("serial")
public class ServerClientConnectionCache extends HashMap <String,ServerClientConnection>
{
	private static ServerClientConnectionCache instance;
	/**************************************************************************************/
	public ServerClientConnectionCache() {}
	/**************************************************************************************/
	public static ServerClientConnectionCache getInstance() 
	{
		if (instance == null) instance = new ServerClientConnectionCache();
		
		return instance;
	}
	/**************************************************************************************/
	private static void checkClientConnections()
	{
		HashSet<String> closedConnections = new HashSet<String>();
		if(instance.size() > 1)
		{
			for(Map.Entry<String, ServerClientConnection> serverClientConnection : instance.entrySet())
			{
				/* wenn Socket nicht mehr connected, dann schließen und aus dem Cache entfernen */
				if(!serverClientConnection.getValue().isConnected())
				{
					
						serverClientConnection.getValue().close();
						ConsolePrint.showErrorln("Server: Unabgemeldete Client-Verbindung abgeschlossen!");
						closedConnections.add(serverClientConnection.getKey());
					
				}
			}
			
			closedConnections.forEach((k) -> instance.remove(k));
		}
	}
	/**************************************************************************************/
	public void revalidate()
	{
		System.out.println(new StringBuilder("Server: Client-Cache-Size vor Überprüfung").append(this.size()));
		//Debug.show(new StringBuilder("Server: "));
		checkClientConnections();
		System.out.println(new StringBuilder("Server: Client-Cache-Size nach Überprüfung").append(this.size()).append("\n--------"));
	}
	/**************************************************************************************/
	
}
