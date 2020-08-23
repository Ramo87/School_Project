package edu.bbq.u18.chat.client.view;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.UnknownHostException;

import edu.bbq.u18.chat.client.SETTINGS;
import edu.bbq.u18.chat.client.view.terminal.TerminalView;

public final class ViewFactory 
{
	public final static int VIEW_TYPE_TERMINAL  = 1;
	public final static int VIEW_TYPE_SWING	 	= 2;
	public final static int VIEW_TYPE_JFX 		= 3;
	/**************************************************************************************/
	private ViewFactory() {}
    /**
     * @throws IOException 
     * @throws UnsupportedEncodingException 
     * @throws UnknownHostException ************************************************************************************/
    public static void openView() throws UnknownHostException, UnsupportedEncodingException, IOException
    {
    	switch(SETTINGS.VIEW_TYPE)
    	{
    		case VIEW_TYPE_TERMINAL:
    			TerminalView.getInstance().open();
    			break;
    		
    		case VIEW_TYPE_SWING:
    			// open swing
    			break;
    		case VIEW_TYPE_JFX:
    			// open jfx
    			break;
    			
    		default:
    			TerminalView.getInstance().open();
    	}
    }
    /**************************************************************************************/
}
