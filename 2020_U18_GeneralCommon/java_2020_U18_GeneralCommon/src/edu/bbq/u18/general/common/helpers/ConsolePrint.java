package edu.bbq.u18.general.common.helpers;

import java.util.logging.Level;

import edu.bbq.u18.general.common.logging.LOGGER;

public final class ConsolePrint 
{
	
	private static boolean LOG= false;
	/* soll eigentlich dafür sorgen, dass die Klasse bemerkt, wenn ein etwaiger Aufrufparameter 
	 * den Wert für global.log auf true setzt; das funktioniert aber nicht richtig, weil
	 * in der main() trotzdem zuerst die Klasse ConsolePrint komplett eingelesen wird, selbst, wenn 
	 * handleArguments() eindeutig vor dem ersten Aufruf von ConsolePrint-Methoden ausgeführt wird
	 * */
	static
	{
		LOG = Boolean.parseBoolean(System.getProperty("global.log", "false"));
	}
	/**************************************************************************************/
	private ConsolePrint() {}
	/**************************************************************************************/
	public static void showln(String str)
	{
		LOG = Boolean.parseBoolean(System.getProperty("global.log", "false"));
		/* this method is meant to replace 
		 * System.out.println() in the application
		 * but of course it needs to use 
		 * System.out.println() itself
		 * */
		System.out.println(str);
		
		if(LOG) LOGGER.log(Level.INFO,str);
	}
	/**************************************************************************************/
	public static void showln(StringBuilder str)
	{
		showln(str.toString());
	}
	/**************************************************************************************/
	public static void show(String str)
	{
		System.out.print(str);
		if(LOG) LOGGER.log(Level.INFO,str);
	}
	/**************************************************************************************/
	public static void showErrorln(String str)
	{
		System.err.println(str);
		
		if(LOG) LOGGER.log(Level.SEVERE,str);
	}
	/**************************************************************************************/
}
