package edu.bbq.u18.chat.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

import edu.bbq.u18.general.common.helpers.ConsolePrint;

public class Server extends ServerSocket
{
	private static Server instance;
	/**************************************************************************************/
	private Server() throws IOException
	{
		super();
		ConsolePrint.showln("---");
		super.bind(new InetSocketAddress(SETTINGS.SERVER_HOST, SETTINGS.SERVER_PORT));
		ConsolePrint.showln(new StringBuilder("Server: Gestartet an ").append(SETTINGS.SERVER_HOST).append(":").append(SETTINGS.SERVER_PORT));
		//ConsolePrint.showln("Server wartet auf Client-Verbindungsanfragen!");
		
		new ClientConnectionRequestObserver(this).start();
	}
	/**************************************************************************************/
	static Server getInstance() throws IOException 
	{
		if (!hasInstance()) instance = new Server();
		/*Es darf nur eine Instanz eines Server-Objekts geben. "Singleton" */
		return instance;
	}
	/**************************************************************************************/
	private static boolean hasInstance()
	{
		return (instance != null);
	}
	/**************************************************************************************/
	static void start() throws IOException 
	{
		getInstance();
		//TODO: Verarbeitung
	}
	/**************************************************************************************/
}
