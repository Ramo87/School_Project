package edu.bbq.u18.chat.server.control;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.Map.Entry;

import edu.bbq.u18.chat.server.cache.ServerClientConnectionCache;
import edu.bbq.u18.general.common.helpers.ConsolePrint;

public class ServerClientConnectionHandler extends Thread implements ServerClientMessageSender
{
	private String nickName;
	
	private ServerClientConnection serverClientConnection;
	/**************************************************************************************/
	/**
	 * @throws UnsupportedEncodingException 
	 * @throws UnknownHostException 
	 * @throws IOException
	 * */
		
	/*Konstruktor: */
	public ServerClientConnectionHandler(ServerClientConnection serverClientConnection) throws UnsupportedEncodingException, IOException 
	{
		this.serverClientConnection = serverClientConnection;
	}
	/**************************************************************************************/
	@Override
	public void run() 
	{
		this.receiveMessageFromClient();
	}
	/**************************************************************************************/
	private void receiveMessageFromClient() 
	{
		String clientResponse 			= null;
		// für nice2have: String verifiedClientNickName 	= null;
		
		try
		{	
			if(this.serverClientConnection == null) return;
			/* Hier wollen wir erstmal den Nickname haben, 
			 * um diesen zu verifizieren und anschließend 
			 * an den Client zu senden 
			 * */
			this.nickName = this.serverClientConnection.readLine().trim(); /* Als erstes kommt der Nick-(User-)Name herein! */
			
			/* nickName verifizieren & ggf. modifizieren! z. B.: Ben#1, Ben#2 / */
			this.nickName= this.getVerifiedNickName();
			/* sende verifizierten Nick-Name zum Client*/
			this.sendVerifiedNicknameToClient(this.nickName, this.serverClientConnection);
			
			ServerClientConnectionCache.getInstance().put(this.nickName,this.serverClientConnection);
			
			/* TODO: (nice2have): Authentifzierung */
			this.sendMessageToAllClients(this.nickName, new StringBuilder("[Server] ").append(this.nickName).append(" betritt den Chat!").toString());
			
			boolean communicationActive = true;
			/*in der Verbindung/Connection lesen! Kommunikation starten*/
			while((clientResponse= this.serverClientConnection.readLine()) != null) 
			{
				if((!clientResponse.isEmpty()))
				{
					clientResponse = clientResponse.trim();
					
					if(clientResponse.equalsIgnoreCase("exit")) clientResponse = "ende";
					
					switch(clientResponse.toLowerCase()) 
					{ /* Client verlässt den Chat*/
						case ("ende"):
							/*CLient verlässt den Chat -> Nachricht an alle! */
							this.sendMessageToAllClients(this.nickName, new StringBuilder("[Server] ").append(this.nickName).append(" hat den Chat verlassen!").toString());
							/* Kommunikation beenden! Socket schliessen und im Vorfeld Writer & Reader! */
							this.serverClientConnection.close();
							/* vom Cache entfernen */
							ServerClientConnectionCache.getInstance().remove(this.nickName);
							
							communicationActive = false;
							break;
						case "stop server now":
							/*TODO: lokale IP-Adresse ermitteln ermitteln und 
							 * mit der Server-IP abgleichen 
							 * -> Wenn identisch, dann shutdown 
							 * */
							
							/*TODO: Benachrichtigung an alle Chat-TN, dass der Server heruntergefahren wird! */
							/*TODO: Schließen den Reader */
							/*TODO: Schließen den Writer */
							/*TODO: Server herunterfahren */
							/*TODO: Schleife beenden! ggf. break! */
							break;
						default: 
							ConsolePrint.showln(new StringBuilder("Server-lokal -> Text vom Client \"").append(clientResponse).append("\""));
								// Sende Message an alle Chat-Teilnehmer (Clients)!
							sendMessageToAllClients(this.nickName, clientResponse);
					}
					
				}
				clientResponse = null;
				
				if(!communicationActive) break;
			}
		
		}
		catch(IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			ConsolePrint.showErrorln("Server: Client/Server-Kommunikationsfehler!");
		}
		this.interrupt();
	}
	/**************************************************************************************/
	/**
	 * @param
	 * @return
	 * Diese Methode analysiert ob ein Bneutzer bereits im Cache existiert (duplicate) und
	 * zählt ggf, den Identifier hoch.
	 * 
	 * z. B. : Client -> Ben
	 * --
	 * Cache
	 * 		Ben#1 <- der erste Ben
	 * 		Ben#2 <- der zweite Ben
	 * 
	 * */
	
	private String getVerifiedNickName() 
	{
		ConsolePrint.showln("Server: Überprüfe neuen Client/Benutzer-Nick-Name!");
		/*nickName = "Ben"*/
		String modifiedNickNamePart = new StringBuilder(this.nickName).append("#").toString();
		/* modifiedNickNamePart = "Ben#" */
		String modifiedNickName = new StringBuilder(modifiedNickNamePart).append(1).toString();
		
		if (ServerClientConnectionCache.getInstance().containsKey(modifiedNickName))
		{
			int count = 1;
			
			for (Map.Entry<String,ServerClientConnection> serverToClientSocket : ServerClientConnectionCache.getInstance().entrySet()) 
			{
				if(serverToClientSocket.getKey().toLowerCase().startsWith(modifiedNickNamePart.toLowerCase())) count++;
			}
			modifiedNickName = new StringBuilder(modifiedNickNamePart).append(count).toString();
		}
		
		return modifiedNickName;
	}
	/**************************************************************************************/
}
