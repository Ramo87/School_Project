package edu.bbq.u18.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import edu.bbq.u18.chat.server.control.ServerClientConnection;
import edu.bbq.u18.chat.server.control.ServerClientConnectionHandler;
import edu.bbq.u18.general.common.helpers.ConsolePrint;

public class ClientConnectionRequestObserver extends Thread
{

	private ServerSocket serverSocket;
	private boolean started = false;
	/**************************************************************************************/
	ClientConnectionRequestObserver(ServerSocket serverSocket)
	{
		this.serverSocket = serverSocket;
		ConsolePrint.showln("Neue Client-Verbindungsanfrage eingegangen!");
		
		// TODO: Verarbeitung der Verbindungsanfrage
	}
	/**************************************************************************************/	
	@Override
	public void run()
	{
		
		
		while(true) 
		{
			if (!this.started) 
			{
				ConsolePrint.showln("Server: Überwachung gestartet! Warte auf CLient-Verbindungsanfragen!");
				
				this.started = true;
			}
			//System.out.println("Server rennt!");
			try
			{
				Socket socketToClient = this.serverSocket.accept();
				
				ConsolePrint.showln("Server: Neue Verbindungsanfrage eingegangen!");
				/* Verarbeitung der Verbindungsanfrage */
				new ServerClientConnectionHandler(new ServerClientConnection(socketToClient)).start();
			} 
			catch(IOException e)
			{
				ConsolePrint.showErrorln("Server konnte die Client-Verbindungsanfrage nicht annehmen!");
				e.printStackTrace();
				System.exit(1);
			}
		}
	}
	/**************************************************************************************/
}
