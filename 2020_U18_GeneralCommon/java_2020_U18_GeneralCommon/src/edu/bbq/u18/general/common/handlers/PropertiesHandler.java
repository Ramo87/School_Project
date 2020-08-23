package edu.bbq.u18.general.common.handlers;

import java.util.*;

import edu.bbq.u18.general.common.helpers.ConsolePrint;
import edu.bbq.u18.general.common.helpers.Debug;

public final class PropertiesHandler 
{	
	public final static int SHOW_WHILE_STYLE				= 1;
	public final static int SHOW_WHILE_WIDTH_ITERATOR_STYLE = 2;
	public final static int SHOW_FOR_EACH_STYLE				= 3;
	public final static int SHOW_LAMBDA_FOR_EACH_STYLE		= 4;
	
	/**************************************************************************************/
	private PropertiesHandler(){}
	/**************************************************************************************/
	//Änderungen auf Standard = Lambda und privatisieren
	private static void showProperties(Properties properties,int styleType)
    {
            switch(styleType)
            {
                    case SHOW_WHILE_STYLE:
                            showPropertiesV1(properties);
                            break;
                    case SHOW_WHILE_WIDTH_ITERATOR_STYLE:
                            showPropertiesV2(properties);
                            break;
                    case SHOW_FOR_EACH_STYLE:
                            showPropertiesV3(properties);
                            break;
                    default: /* SHOW_LAMBDA_FOR_EACH_STYLE */
                            showPropertiesV4(properties);
                            break;
            }
          
    }
	
	/**************************************************************************************/
	public static void showProperties(Properties properties) 
	{
		showProperties(properties, SHOW_LAMBDA_FOR_EACH_STYLE);
	}
	/**************************************************************************************/
	/**
	 *@param properties <- java.util.Properties -> z. B. System.getProperties() 
	 *
	 *z. B. SystemInfos.showProperties(System.getProperties())
	 */
	private static void showPropertiesV1(Properties properties) 
	{
		Iterator<?> i = Collections.list( properties.propertyNames() ).iterator();
		
		Debug.show("Show Properties mit While-Schleife \n---");
		
		while(i.hasNext()) 
		{
			String pKey = ((String)i.next()); /*Property-Name, der Schlüssel*/
			String pValue = formatPropertyLineSeperatorValue(pKey,properties.getProperty(pKey));
			
			showProperty(pKey, pValue);
		}
	}
	/**************************************************************************************/
	private static void showPropertiesV2(Properties properties) 
	{
		Enumeration<?> pNames = properties.propertyNames();
		Debug.show("Show Properties mit While-Schleife und Iterator \n---");
		
		while(pNames.hasMoreElements()) 
		{
			String pKey = (String)pNames.nextElement(); /*Property-Name, der Schlüssel*/
			String pValue = formatPropertyLineSeperatorValue(pKey,properties.getProperty(pKey));
			
			showProperty(pKey, pValue);
		}
	}
	/**************************************************************************************/
	private static void showPropertiesV3(Properties properties) 
	{
		Debug.show("Show Properties mit For-Each-Schleife durch ein Entry-Set \n---");
		for(Map.Entry<Object,Object> property : properties.entrySet()) 
		{
			
			showProperty(property.getKey(),formatPropertyLineSeperatorValue(property.getKey(),property.getValue()));
		}
	}
	/**************************************************************************************/
	private static void showPropertiesV4(Properties properties) 
	{
		Debug.show("Show Properties mit Lambda-For-Each-Schleife \n---");
		
		//ACHTUNG: Hier muss alles im Lambda geschehen, es kann nichts "von außerhalb" hereingereicht werden
		properties.forEach((key,value) -> {
			showProperty(key,formatPropertyLineSeperatorValue(key,value));
		});
	}
	/**************************************************************************************/
	private static void showProperty(Object key, Object value) 
	{
		showProperty(((String)key),((String)value));
	}
	/**************************************************************************************/
	private static void showProperty(String key, String value) 
	{
		ConsolePrint.showln(new StringBuilder(key).append(" = ").append(value));
	}
	/**************************************************************************************/
	private static String formatPropertyLineSeperatorValue(Object key,
														  Object value) 
	{
		if(key.equals("line.separator"))
		{	  /*unix*/
			if (value.equals("\n")) 
			{
				value= "\\n";
			} /*windows*/
			else if(value.equals("\r\n")) 
			{
				value="\\r\\n";
			}
			
		}
		return (String) value;
	}
	/**************************************************************************************/
}	
