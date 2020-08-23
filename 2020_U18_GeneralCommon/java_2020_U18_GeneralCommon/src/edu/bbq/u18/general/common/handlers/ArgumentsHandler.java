package edu.bbq.u18.general.common.handlers;

public final class ArgumentsHandler 
{
	/**************************************************************************************/
	private ArgumentsHandler(){}
	/**************************************************************************************/
	/**
	 * @param appCallString -> z. B.
	 * */
	public static String[] getPropertiesFromAppCallbySystem()
	{
		/* sun.java.command = edu.bbq.u18.chat.client.Start debug log showdatatypes */
		String appCall = System.getProperty("sun.java.command"); /* System.getProperty <- liefert null, wenn Property nicht vorhanden! */
		String[] args = new String[] {};
		
		if(appCall!= null) 
		{
			if (appCall.contains(" "))
			{
				String arguments= appCall.substring(appCall.indexOf(" ")+1);
			
				if (appCall.contains(" "))
				{
					return arguments.split(" ");
				}
				else 
				{
					return new String[]{arguments};
				} 
			}
		}
		return args;
	}
	/**************************************************************************************/
}
