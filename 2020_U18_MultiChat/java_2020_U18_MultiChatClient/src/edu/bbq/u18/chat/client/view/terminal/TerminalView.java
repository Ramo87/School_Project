package edu.bbq.u18.chat.client.view.terminal;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.UnknownHostException;

import edu.bbq.u18.chat.client.control.ClientServerConnection;
import edu.bbq.u18.chat.client.control.ClientServerMessageReceiver;

public final class TerminalView 
{
	private static TerminalView instance;
	/**************************************************************************************/
	private TerminalView() {}
	/**************************************************************************************/
	public static TerminalView getInstance() 
    {
        if (instance == null) instance = new TerminalView();
        
        return instance;
        
    }
	/**
	 * @throws IOException 
	 * @throws UnsupportedEncodingException 
	 * @throws UnknownHostException *******************************************************/
	public void open() throws UnknownHostException, UnsupportedEncodingException, IOException
	{
		ClientServerConnection.establish();
		
		if(TerminalReader.getInstance().authorize())
		{ /* start es: Empfangs eingehender Nachrichten! */
			ClientServerMessageReceiver.getInstance().startAutoReceiving();
			work();
		}
	}
	/**************************************************************************************/
	private void work()
	{
		TerminalReader.getInstance().read();
		
		this.work(); //(Zweite möglichkeit für ne Rekursion um den Message einzulessen) -> TerminalReader Zeile 47 : read(), gleiche Rekursion, nur eine von Beiden muss bleiben!
		
	}
	/**************************************************************************************/
}
