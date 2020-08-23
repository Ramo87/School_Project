package edu.bbq.u18.chat.server.control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.SocketException;

import edu.bbq.u18.general.common.communication.Communicable;



public class ServerClientConnection implements Communicable, Closeable
{
	private Socket serverToClientSocket;
	private BufferedReader connReader;
	private BufferedWriter connWriter;
	/**
	 * @throws IOException 
	 * @throws UnsupportedEncodingException 
	 * ************************************************************************************/
	public ServerClientConnection(Socket serverToClientSocket) throws UnsupportedEncodingException, IOException 
	{
		this.serverToClientSocket = serverToClientSocket;
		/*liest Strings aus der Verbindung zwischen Client und Server*/
		this.connReader = new BufferedReader(new InputStreamReader(this.serverToClientSocket.getInputStream(), "UTF-8"));
																/* ServerClient Connection serverClientConnection == Socket */
		/*schreibt Strings in die Verbindung zwischen Client und Server*/
		this.connWriter = new BufferedWriter(new OutputStreamWriter(this.serverToClientSocket.getOutputStream(), "UTF-8"));
																/* ServerClient Connection serverClientConnection == Socket */
	}
	/**
	 * @throws IOException ************************************************************************************/
	@Override
	public String readLine() throws IOException
	{
		
		return this.connReader.readLine();
	}
	/**
	 * @throws IOException 
	 * ************************************************************************************/
	public boolean isConnected()
	{
		if(this.serverToClientSocket == null) return false;
		
		return this.serverToClientSocket != null && this.serverToClientSocket.isConnected() ;
	}
	/**************************************************************************************/
	@Override
	public void writeLine(String message) throws BrokenSocketPipeException, IOException 
	{
		this.connWriter.write(message);
		this.connWriter.newLine();
		try
		{
			this.connWriter.flush();
		}
		catch(SocketException e)
		{
			if(e.getMessage().toLowerCase().contains("broken pipe")) 
			{
				throw new BrokenSocketPipeException();
			}
			else
			{
				throw new IOException(e);
			}
		}
	}
	/**************************************************************************************/
	@Override
	public void close()
	{
		try 
		{
			if(this.connReader != null) this.connReader.close();
			this.connReader = null;
		} 
		catch (IOException e2) {}
		try 
		{
			if(this.connWriter != null) this.connWriter.close();
			this.connWriter = null;
		} 
		catch (IOException e1) {}
		try 
		{
			if(this.serverToClientSocket != null) this.serverToClientSocket.close();
			this.serverToClientSocket = null;
		} 
		catch (IOException e) {}
	}
	/**************************************************************************************/
}
