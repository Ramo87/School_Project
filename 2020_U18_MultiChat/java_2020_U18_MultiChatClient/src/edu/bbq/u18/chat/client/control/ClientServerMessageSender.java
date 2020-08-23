package edu.bbq.u18.chat.client.control;

import java.io.IOException;

import edu.bbq.u18.general.common.helpers.ConsolePrint;
import edu.bbq.u18.general.common.helpers.Debug;

public final class ClientServerMessageSender 
{
	/**************************************************************************************/
	private ClientServerMessageSender() {}
	/**************************************************************************************/
	public static void sendMessageToServer(String message)
	{
		Debug.show(new StringBuilder("[Client] Sende Nachricht \"").append(message).append("\" zum Server!"));
		
		try 
		{
			ClientServerConnection.getInstance().writeLine(message);
			Debug.show(new StringBuilder("[Client] Nachricht \"").append(message).append("\" zum Server gesendet!"));
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			Debug.show("[Client] Nachricht konnte nicht zum Server senden! [Encoding nicht unterstützt, Schreib-/Lesefähler oder der Server ist nicht Erreichbar]");
		}
		
	}
	/**************************************************************************************/
}
