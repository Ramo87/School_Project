package edu.bbq.u18.general.common.communication;

import java.io.IOException;

public interface Communicable 
{
	String readLine() throws IOException;
	void writeLine(String message) throws Exception;
}
