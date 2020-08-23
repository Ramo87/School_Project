package edu.bbq.u18.chat.client;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public abstract class Configurations 
{
	static String APP_VERSION;
	private static Properties properties = new Properties();
	
	static
	{
		try 
		{
			properties.load(new BufferedReader(new FileReader(new StringBuilder("2020_U18_MultiChat\\java_2020_U18_MultiChatClient\\conf").append(System.getProperty("file.separator")).append("multichat.properties").toString())));
			
			//SystemInfo.showProperties(properties);
			//ersetzt durch nachfolgendes Lambda
			
			properties.forEach((k,v) -> {
											if(((String)k).startsWith("global")) 
											{
												System.getProperties().setProperty(((String)k),((String)v));
											}
											// bei der Bedingung findet ein Type-Cast statt; 
											// dieser muss durch Klammerung "voll qualifiziert werden, 
											// damit an dieser Stelle direkt die String-Methoden verfügbar sind"
											else if (((String)k).equalsIgnoreCase("app.version"))
											{
												SETTINGS.APP_VERSION= ((String)v);
											}
										});
		} 
		catch (FileNotFoundException e) 
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
	/**************************************************************************************/
	/* Pseudo-Methode, weil keine Ausführung drin ist, dient nur dazu, den Classloader zum 
	 * Einlesen der Klasse zu bewegen
	*/
	static void load() {}
	/**************************************************************************************/
}
