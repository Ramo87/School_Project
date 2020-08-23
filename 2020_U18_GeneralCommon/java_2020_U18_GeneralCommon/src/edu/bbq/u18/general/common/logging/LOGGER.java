package edu.bbq.u18.general.common.logging;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class LOGGER 
{
	static
	{
		File logDirPath = new File("logs");
		
		if(!logDirPath.exists())
		{
			logDirPath.mkdir();
		}
		else if(!logDirPath.isDirectory()) 
		{
			logDirPath.mkdir();
		}
		
		logDirPath= null;
		/* https://docs.oracle.com/en/java/javase/11/docs/api/java.logging/java/util/logging/LogManager.html */
		System.setProperty("java.util.logging.config.file", "conf/logging.properties"); 
				
	}
	private final static Logger APP_LOGGER= Logger.getLogger("general");
	
	/**************************************************************************************/
	private LOGGER(){}
	/**************************************************************************************/
	public static void log(Level level,
							String message) 
	{
		APP_LOGGER.log(level, 
						new StringBuilder("[").append(System.getProperty("user.name")).append("] ").append(message).toString());
	}
	/**************************************************************************************/
	public static void log(Level level, StringBuilder message) 
	{
		log(level, message.toString());
	}
	
	/**************************************************************************************/
}
