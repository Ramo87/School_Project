package edu.bbq.u18.chat.client.cache;
import java.util.concurrent.ConcurrentLinkedQueue;



@SuppressWarnings("serial")
public class IncomingMessageStore extends ConcurrentLinkedQueue<String>
{
	/**************************************************************************************/
	private static IncomingMessageStore instance;
	/**************************************************************************************/
	private IncomingMessageStore() {}
	/**************************************************************************************/
	public static IncomingMessageStore getInstance() 
    {
        if (instance == null) instance = new IncomingMessageStore();
        
        return instance;
        
    }
    /**************************************************************************************/
}
