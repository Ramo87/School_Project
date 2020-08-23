package edu.bbq.u18.general.common.helpers;

public final class Debug 
{
	private static boolean DEBUG = false;
	
	static
	{
		DEBUG = Boolean.parseBoolean(System.getProperty("global.debug", "false"));
	}
	/**************************************************************************************/
	private Debug() {}
	/**************************************************************************************/
	public static void show(String message)
	{
		if(DEBUG) ConsolePrint.showln(new StringBuilder("[DEBUG] ").append(message));
	}
	/**************************************************************************************/
	public static void show(StringBuilder message)
	{
		show(message.toString());
	}
	/**************************************************************************************/
	public static void showError(String message)
	{
		if(DEBUG) ConsolePrint.showErrorln(message);
	}
}
