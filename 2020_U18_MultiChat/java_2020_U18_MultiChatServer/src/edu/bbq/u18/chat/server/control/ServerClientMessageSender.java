package edu.bbq.u18.chat.server.control;

import java.io.IOException;
import java.util.Map.Entry;

import edu.bbq.u18.chat.server.cache.ServerClientConnectionCache;
import edu.bbq.u18.general.common.helpers.ConsolePrint;

interface ServerClientMessageSender 
{
	/**
	 * @throws IOException *******************************************************************/
	default void sendMessageToClient(String clientName, ServerClientConnection serverClientConnectionTo, String message) throws BrokenSocketPipeException, IOException
	{
		try
		{	
			ConsolePrint.showln(new StringBuilder("Server: sende Nachricht \"").append(message).append("\" zum Client \"").append(clientName).append("\"!"));
		
			serverClientConnectionTo.writeLine(message);
			
			ConsolePrint.showln("Server: Gesendet!");
		}
		catch(BrokenSocketPipeException bspe)
		{
			serverClientConnectionTo.close();
			
			throw new BrokenSocketPipeException();
		}
		catch(IOException e)
		{
			// TODO Auto-generated catch block
			ConsolePrint.showErrorln("Server: Konnte Nachricht nicht an Client senden!");
			
			throw new IOException(e);
		}
		
	}
	/**************************************************************************************/
	default void sendMessageToAllClients(String fromClientName, String message) throws IOException
	{
		ServerClientConnectionCache.getInstance().revalidate();
		ConsolePrint.showln(new StringBuilder("Server: Text wird an \"").append(ServerClientConnectionCache.getInstance().size() - 1).append("\" zum Client"));
		
		
		for(Entry<String, ServerClientConnection> serverClientConnection : ServerClientConnectionCache.getInstance().entrySet())
		{
			String recipientClient = serverClientConnection.getKey();
			
			
			
			if(!recipientClient.equals(fromClientName))
			{
				//String fromFlag = new StringBuilder("[").append(fromClientName).append("] > ").toString();
				String fromFlag = "";
				
				if(!message.startsWith("[Server]"))
				{
					fromFlag = new StringBuilder("[").append(fromClientName).append("] > ").toString();
				}
					
				try 
				{
					/* ...getKey() ->recipientClient, so geschrieben damit String nich gespeichert wird */
					sendMessageToClient(serverClientConnection.getKey(), serverClientConnection.getValue(), new StringBuilder(fromFlag).append(message).toString());
				}
				catch(BrokenSocketPipeException bspe)
				{
					ConsolePrint.showErrorln(new StringBuilder("Server: ").append(bspe.getMessage()).toString());
				}
				
				
			}
			
			recipientClient = null;
		}
	}
	/**************************************************************************************/
	default void sendVerifiedNicknameToClient(String verifiedNickname, ServerClientConnection serverClientConnectionTo) throws IOException
	{
		sendMessageToClient(verifiedNickname, serverClientConnectionTo, verifiedNickname);
	}
	
	/**************************************************************************************/
}
