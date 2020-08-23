package edu.bbq.u18.chat.client.view.terminal;

import edu.bbq.u18.chat.client.SETTINGS;
import edu.bbq.u18.chat.client.cache.IncomingMessageStore;
import edu.bbq.u18.general.common.helpers.ConsolePrint;

/*
 * Schreibt die eingehenden Messages die vom Server kommen und die IncomingMessageStore gespeichert werde 
 * 	-> auf die Konsolen - (Terminal) Ausgabe
 * 
 * Server -> schickt Message
 * 				-> ClientMessageReceiver$AutoClientServerMessageReceiver.receiveMessagefromClient()
 * 					-> receiveMessagefromClient() schreibt in den IncomingMessageStore
 */
public final class TerminalWriter 
{
	private static TerminalWriter instance;
	/**************************************************************************************/
	private TerminalWriter() {}
	/**************************************************************************************/
    public static TerminalWriter getInstance() 
    {
        if (instance == null) instance = new TerminalWriter();
        
        return instance;
        
    }
    /**************************************************************************************/
    public void write()
    {
    	while(IncomingMessageStore.getInstance().size() > 0)
    	{
    		/*
    		 * ConcurrentLinkedQueue
    		 * 
    		 * Warteschlange (Queue) / Stapelverarbeitung
    		 * 
    		 * [   Stapel  ]
    		 * --	....	--
    		 * -- message 4 --
    		 * -- message 3 --
    		 * -- message 2 --
    		 * 		-- message 1 -- poll() zieht den ersten Wert raus und removed ihn aus der Warteschlange
    		 */
    		ConsolePrint.showln(new StringBuilder("\r").append(IncomingMessageStore.getInstance().poll())); /*\r = Rollback <- führt zurück an den Beginn der 'Zeile' */
    	}
    	
    	TerminalReader.getInstance().read();
    }
    /**************************************************************************************/
}
