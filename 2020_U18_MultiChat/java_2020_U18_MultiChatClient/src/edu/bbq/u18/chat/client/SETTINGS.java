package edu.bbq.u18.chat.client;

import edu.bbq.u18.chat.client.view.ViewFactory;

public class SETTINGS 
{
	//static boolean SHOWDATATYPES = false;
	static String APP_VERSION = "";
	
	public final static String SERVER_HOST = "127.0.0.1";
	public final static int SERVER_PORT 	= 6000;
	public static int VIEW_TYPE 			= ViewFactory.VIEW_TYPE_TERMINAL;
	
	public static String NICK_NAME			= null;
	/**************************************************************************************/
	private SETTINGS() {};
	/**************************************************************************************/
	/* pseudo */
	static void load() {}
	/**************************************************************************************/
}
