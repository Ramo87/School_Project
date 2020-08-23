package edu.bbq.u18.general.common.helpers;

import java.io.BufferedWriter;
import java.io.Console;
import java.io.FileWriter;
import java.io.IOException;

public class CommandLineHelper
{
	/*******************************************************************************/
	private CommandLineHelper() {}
	/*******************************************************************************/
	public static void showFullQualifiedCallApplicationShellCommandAndExit()
	{
		ConsolePrint.showln(CommandLineHelper.getFullQualifiedCallApplicationShellCommand());
		System.exit(0);
	}
	/*******************************************************************************/
	private static String getFullQualifiedCallApplicationShellCommand()
	{
		String cp= System.getProperty("java.class.path");
		
		if(cp.toLowerCase().contains("/.p2/pool/plugins"))
		{
			if(cp.contains(System.getProperty("path.separator", ":")))
			{
				String[] classPathes= cp.split(System.getProperty("path.separator", ":"));
				
				if(classPathes.length>1)
				{
					StringBuilder cp_new= new StringBuilder();
					
					for(int i= 0; i < classPathes.length; i++)
					{
						if(!classPathes[i].toLowerCase().contains("/.p2/pool/plugins"))
						{
							cp_new.append(classPathes[i]).append((i<(classPathes.length-1)) ?  ":" : "");
						}
					}					
					
					cp= cp_new.toString();
					
					if(cp.endsWith(System.getProperty("path.separator", ":")))
					{
						cp= cp.substring(0, (cp.length()-1));
					}
				}
				else
				{
					cp= null;
				}
			}
			else
			{
				cp= null;
			}
		}
		
		StringBuilder command = new StringBuilder();
		command.append("java ").append((cp != null) ? "-cp " : "");
		command.append(((cp !=null) ? new StringBuilder(cp).append(" ") : ""));
		command.append(System.getProperty("sun.java.command"));
		
		return command.toString();
	}	
	/*******************************************************************************/
	public static void writeAppStartUnixShellScriptAndExit()
	{
		try {
			BufferedWriter out= new BufferedWriter(new FileWriter("start.sh"));
			
			out.write("#!/bin/sh");
			out.newLine();
			out.write(new StringBuilder("cd ").append(System.getProperty("user.dir")).append(";").toString());
			out.newLine();
			out.write(getFullQualifiedCallApplicationShellCommand());
			out.newLine();
			out.write("exit 0;");
			out.flush();  /* WICHTIG!!!! */
			out.close();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		ConsolePrint.showln("Start-Skript erzeugt!");
		System.exit(0);
		
	}
}