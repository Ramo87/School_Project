package edu.bbq.u18.general.common.lib;

public final class Numbers 
{
	/**************************************************************************************/
	private Numbers() {}
	/**************************************************************************************/
	public static boolean isNumeric(String arg)
	{
		try
		{	
			Double.parseDouble(arg);
			return true;
		}
		catch(NumberFormatException ex)
		{
			return false;
		}
	}
	/**************************************************************************************/
}
