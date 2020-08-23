package edu.bbq.u18.chat.server.control;

import java.net.SocketException;

@SuppressWarnings("serial")
class BrokenSocketPipeException extends SocketException
{
	public BrokenSocketPipeException()
	{
		super("Der Client-Verbindung wurde unerwartet unterbrochen!");
	}
}
