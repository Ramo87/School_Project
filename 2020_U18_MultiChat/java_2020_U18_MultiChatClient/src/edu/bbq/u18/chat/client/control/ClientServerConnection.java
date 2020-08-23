package edu.bbq.u18.chat.client.control;

 

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.UnknownHostException;
import edu.bbq.u18.chat.client.SETTINGS;
import edu.bbq.u18.general.common.communication.Communicable;

 

public class ClientServerConnection extends Socket implements Communicable
{
    private BufferedReader connReader;
    private BufferedWriter connWriter;
    
    private static ClientServerConnection instance;
    /**************************************************************************************/
    private ClientServerConnection() throws UnknownHostException, 
                                                          IOException
    {
        super(SETTINGS.SERVER_HOST, SETTINGS.SERVER_PORT);
        
        
        /* die nachfolgende Notation verringert nicht nur Tipparbeit, sondern 
         * verknüpft auch die Speichernutzung des BufferedReaders, InputStreamReaders 
         * und des Sockets mit dem connReader, so dass der zugehörige Speicher automatisch
         * ebenfalls freigegeben wird, wenn man den connReader schließt und freigibt.
         * */
        /*liest Strings aus der Verbindung zwischen Client und Server*/
        this.connReader = new BufferedReader(new InputStreamReader(this.getInputStream(), "UTF-8"));
        /*schreibt Strings in die Verbindung zwischen Client und Server*/
        this.connWriter = new BufferedWriter(new OutputStreamWriter(this.getOutputStream(), "UTF-8"));
    }
    /**************************************************************************************/
    static ClientServerConnection getInstance() throws UnknownHostException, IOException, UnsupportedEncodingException
    {
        if (instance == null) instance = new ClientServerConnection();
        
        return instance;
        
    }
    
    
    /**************************************************************************************/
    /**
     * @throws IOException 
     */
    public String readLine() throws IOException 
    {
        return this.connReader.readLine();
    }
    /*************************************************************************************/
    /**
     * @throws IOException 
     */
    public void writeLine(String message) throws IOException 
    {
        this.connWriter.write(message);
        this.connWriter.newLine();
        this.connWriter.flush();
    }
    /**
     * @return 
     * @throws IOException 
     * @throws UnknownHostException ***************************************************************************/
    public static boolean establish() throws UnknownHostException, IOException, UnsupportedEncodingException
    { /* sicherstellen, dass ein Instanz existiert! */
    	return getInstance().isConnected();
    }
    /**************************************************************************************/
}