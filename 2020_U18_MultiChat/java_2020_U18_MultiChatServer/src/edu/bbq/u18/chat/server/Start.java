package edu.bbq.u18.chat.server;

import java.io.IOException;

import edu.bbq.u18.general.common.helpers.CommandLineHelper;
import edu.bbq.u18.general.common.helpers.ConsolePrint;

/*
 * usage: Normal
 *         1. [Terminal/Commandline] cd ~/git-workspace/2020_U18_MultiChat/java_2020_U18_MultiChatServer/bin
 *         2. [Terminal/Commandline] java -cp /home/dev/git-workspace/2020_U18_MultiChat/java_2020_U18_MultiChatServer/bin:/home/dev/git-workspace/2020_U18_GeneralCommon/java_2020_U18_GeneralCommon/bin edu.bbq.u18.chat.server.Start;
 *         3. [Terminal/Commandline] press [ENTER]
 *
 *        Server beenden:
 *        --
 *        dev@dev:~$ ps acx | grep java
 *        1807 tty2     Sl+   30:19 java <- Eclipse (s. Laufzeit 30:19)
 *        7489 pts/1    Sl+    0:00 java <- Server (eben gestarteter Prozess Laufzeit 0:00)
 *
 *        dev@dev:~$ kill 7489
 */

public class Start
{

	public static void main(String[] args)
	{
		//getFullQualifiedCallApplicationShellCommand();
		
		SETTINGS.load();
		Arguments.load();
		Configurations.load();
		
		try
		{
			Server.start();
		} 
		catch(IOException e)
		{
			// TODO Auto-generated catch block
			//e.printStackTrace();
			ConsolePrint.showErrorln("Server: Konnte nicht gestartet werden!");
			System.exit(1); // alle exitcodes > 0 sind anormale Zustände, die sich gesondert verarbeiten lassen
		}
		//CommandLineHelper.writeAppStartUnixShellScriptAndExit();

	}
	/*******************************************************************************/
}
