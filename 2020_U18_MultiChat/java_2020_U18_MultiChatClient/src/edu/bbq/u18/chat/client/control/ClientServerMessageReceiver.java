package edu.bbq.u18.chat.client.control;

import java.io.IOException;

import edu.bbq.u18.chat.client.SETTINGS;
import edu.bbq.u18.chat.client.cache.IncomingMessageStore;
import edu.bbq.u18.chat.client.view.terminal.TerminalWriter;
import edu.bbq.u18.general.common.helpers.ConsolePrint;
import edu.bbq.u18.general.common.helpers.Debug;

public final class ClientServerMessageReceiver 
{
	/**************************************************************************************/
	private static ClientServerMessageReceiver instance;
	/**************************************************************************************/
	private ClientServerMessageReceiver() {}
	/**************************************************************************************/
	public static ClientServerMessageReceiver getInstance() 
    {
        if (instance == null) instance = new ClientServerMessageReceiver();
        
        return instance;
        
    }
	/**************************************************************************************/
	public void receiveAuthorizationFromServer()
	{
		if(SETTINGS.NICK_NAME == null)
		{
			Debug.show("[Client] Empfange verifizierten Nickname vm Server!");
			
			try 
			{		/* Der erste gelesene Wert aus der Cloent <-> Server-Verbindung ist der virifizierte Nickname! */
				SETTINGS.NICK_NAME= ClientServerConnection.getInstance().readLine().trim();
				Debug.show("[Client] Verifizierte Nickname vom Server empfangen!");
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				Debug.show("[Client] Verifizierte Nickname vom Server konnt nicht empfangen werden!");
			}
		}
	}
	/**************************************************************************************/
	public void startAutoReceiving()
	{
		new AutoClientMessageReceiver().start();
	}
	/**************************************************************************************/

/**************************************************************************************/
	/*
	 * Diese Klasse realisiert den automatischer Empfang von Nachrichten aus der Verbindung
	 */
	// TODO: Änderung zu "Messages" prüfen
	private class AutoClientMessageReceiver extends Thread
	{
		private AutoClientMessageReceiver()
		{
			super.setName("Auto-Receiver");
			super.setDaemon(true);
		}
		/**************************************************************************************/
			/*
			 * Methode zum Lesen & Speichern in einem Cache [IncomingMessageStore] der reinkommenden - zu empfangenden - Messages.
			 */
		// TODO: Änderung zu "Messages" prüfen
		private void receiveMessageFromServer() 
		{
			String message = null;
				
			try
			{	/*in der Verbindung/Connection lesen*/
				while((message= ClientServerConnection.getInstance().readLine()) != null)  /* Empfang! Hier wird die Nachricht in der Variable message gespeichert! */
				{
					if((!message.isEmpty()))
						{	/* Speichern im Cache */
							IncomingMessageStore.getInstance().add(message);
							/* TODO: Cache für UI nötig ? */
							TerminalWriter.getInstance().write();
						}
						/* Explizite Referenz-Auflösung -> GC räume bitte ab! */
						message = null;
					}
				}
				
			catch(IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				Debug.show("[Client] Server-Kommunikationsfehler!");
			}
		}
		/**************************************************************************************/
		@Override
		public void run()
		{
			this.receiveMessageFromServer();
		}
		/**************************************************************************************/
	}
	/**************************************************************************************/
}
