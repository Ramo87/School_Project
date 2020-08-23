package edu.bbq.u18.chat.client;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.UnknownHostException;

import edu.bbq.u18.chat.client.view.ViewFactory;
import edu.bbq.u18.general.common.helpers.CommandLineHelper;
import edu.bbq.u18.general.common.helpers.ConsolePrint;

/**
 * @author Jalapa
 */
public class Start 
{
	public static void main(String[] args) 
	{
		SETTINGS.load();
		Configurations.load();
		Arguments.load();
		ConsolePrint.showln(new StringBuilder("MultiChat-Client gestartet! Version: ").append(SETTINGS.APP_VERSION).append("\n"));
		
		/*Connect / Communicate -> ClientInterface ([G]UI) starten*/
		try 
		{
			ViewFactory.openView();
		} 
		catch (UnknownHostException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (UnsupportedEncodingException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
/*Kommentar - mit Doppelstern nach Einleitung kommt in die automatisch erzeugte Doku rein*/