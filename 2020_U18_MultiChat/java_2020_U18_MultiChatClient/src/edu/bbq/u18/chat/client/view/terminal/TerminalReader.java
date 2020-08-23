package edu.bbq.u18.chat.client.view.terminal;

import java.util.Scanner;

import edu.bbq.u18.chat.client.SETTINGS;
import edu.bbq.u18.chat.client.control.ClientServerMessageReceiver;
import edu.bbq.u18.chat.client.control.ClientServerMessageSender;
import edu.bbq.u18.general.common.helpers.ConsolePrint;

public final class TerminalReader 
{
	/*
	 * Java ist auch eine Insel "Auflage 15 -> Seite: 384 (5.10.2 Yes we can, yes we Scan)"
	 */
	private Scanner in = new Scanner(System.in);
	
	private static TerminalReader instance;
	/**************************************************************************************/
	private TerminalReader() {}
	/**************************************************************************************/
    public static TerminalReader getInstance() 
    {
        if (instance == null) instance = new TerminalReader();
        
        return instance;
        
    }
    /**************************************************************************************/
    public void read()
    {
    	ConsolePrint.show(new StringBuilder("[").append(SETTINGS.NICK_NAME).append("] < ").toString());
    	
    	try
    	{
    		if(this.in.hasNextLine())
    		{	/* ausgehende Nachricht */
    			String message = this.in.nextLine().trim();
    			
    			if(!message.isEmpty())
    			{
    				ClientServerMessageSender.sendMessageToServer(message);
    				this.checkForExit(message);
    				/* works ? */
    				/*this.read(); (wenn hier eingebaut, muss auch in den "catch" block reingeworfen werden)*/ 
    			}
    			else
    			{
    				//this.read(); TerminalView.getInstance().work() sorgt für die nötige Rekursion!
    			}
    		}
    	}
    	catch(IndexOutOfBoundsException e)
    	{
    		//this.read(); TerminalView.getInstance().work() sorgt für die nötige Rekursion!
    	}
    }
    /**************************************************************************************/
    private void checkForExit(String message)
    {
    	if((message.equalsIgnoreCase("ende")) || (message.equalsIgnoreCase("exit")))
		{
			this.close();
		}
    }
    /**************************************************************************************/
    private boolean isValidNickname(String nickname)
    {
    	boolean isValid =(nickname != null);
    	
		if(isValid)
		{
    		nickname = nickname.trim();
			
			if(nickname.length()<3 || nickname.length() > 12)
			{
				ConsolePrint.showln("Der Benutzername muss min. 3 Zeichen und darf max. 12 Zeichen lang sein!");
				isValid= false;
			}
		}
    	return true;
    }
    /**************************************************************************************/
    boolean authorize()
    {
    	ConsolePrint.show("Bitte Nickname eingeben :");
    	
    	if(this.in.hasNextLine())
    	{
    		
    		String nickname = this.in.nextLine().trim();
    		this.checkForExit(nickname);
    		
    		if(this.isValidNickname(nickname))
    		{
    			ClientServerMessageSender.sendMessageToServer(nickname);
    			this.checkForExit(nickname);
    			ClientServerMessageReceiver.getInstance().receiveAuthorizationFromServer();
    		}
    		else
    		{
    			this.authorize();
    		}
    	}
    	else
    	{
    		this.authorize();
    	}
    	
    	return ((SETTINGS.NICK_NAME != null) && (SETTINGS.NICK_NAME.contains("#")));
    }
    /**************************************************************************************/
    public void close()
    {
    	ConsolePrint.showln("Chat wird beendet!");
    	
    	this.in.close();
    	System.exit(0);
    }
    /**************************************************************************************/
    
}
