package edu.bbq.u18.chat.client;

import edu.bbq.u18.general.common.helpers.Debug;
//import edu.bbq.u18.Java.knowledge.DataTypes;
import edu.bbq.u18.general.common.handlers.ArgumentsHandler;

public abstract class Arguments 
{
	static 	
	{	
		handleArguments(ArgumentsHandler.getPropertiesFromAppCallbySystem());
	} 
	/**************************************************************************************/
	static void load() {}
	/**************************************************************************************/
	private static void handleArguments(String [] args) 
	{
		if(args.length > 0) 
		{
			for (int i=0; i < args.length; i++)
			{
				switch(args[i].toLowerCase())
				{
					case "debug":
					System.setProperty("global.debug","true");
					//Debug.show(new StringBuilder("Ich habe ").append(args.length).append(" Argumente!"));
					//PropertiesHandler.showProperties(System.getProperties(), PropertiesHandler.SHOW_WHILE_STYLE);
						break;
					
					case "log":
	                System.setProperty("global.log","true");
	                   	break;
	            }
			}
			Debug.show(new StringBuilder("Ich habe ").append(args.length).append(" Argument").append(((args.length > 1) ? "e" : "")).append("!\n"));
		}
		else 
		{
			Debug.showError("Keine Kommandozeilen-Argumente vorhanden");
		}
	}	
}	
