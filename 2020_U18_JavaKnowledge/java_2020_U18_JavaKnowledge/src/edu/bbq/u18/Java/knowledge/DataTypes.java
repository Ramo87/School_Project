package edu.bbq.u18.Java.knowledge;

import java.util.HashSet;

import edu.bbq.u18.general.common.lib.Numbers;


public class DataTypes 
{
	/**************************************************************************************/
	private DataTypes() {}
	/**************************************************************************************/
	public static void main (String[] args)
	{
		//for (String arg : args)
		for (int i = 0; i < args.length; i++) 
		{
			String dataType= DataTypes.getDataTypeAsString(args[i]);
			
			System.out.println(new StringBuilder(args[i]).append(" = ").append(dataType).append("Primitiver Datentyp = ").append(DataTypes.isPrimitiveDataType(dataType)).append(")"));
		}
	}
	/**************************************************************************************/
	public static String getDataTypeAsString(String str)
	{
		if (Numbers.isNumeric(str))
		{
			System.out.println(new StringBuilder("Das Argument \"").append(str).append("\" ist eine Zahl!"));
			
			return DataTypes.getNumericDataTypeAsString(str);
		}
		else 
		{
			System.out.println(new StringBuilder("Das Argument \"").append(str).append("\" ist keine Zahl (String, char o. boolean)!"));
			
			switch (str.length())
			{
				case 1:
					return "char";
				
				case 4:
					if (str.equalsIgnoreCase("true"))
					{
						return "boolean";
					}
					else 
					{
						return "String";
					}
				
				case 5:
					if (str.equalsIgnoreCase("false"))
					{
						return "boolean";
					}
					else 
					{
						return "String";
					}
				default:
					return "String";
			}
		}
	}
	/**************************************************************************************/
	private static String getNumericDataTypeAsString(String str) 
	{
		
		// TODO: JUnit-Test
		/*byte; short; integer; long*/
		/*Protipp: Ternäre Schreibweise als kompaktere Syntax für bedingte Anweisungen*/
		
		return ((!str.contains(".")) ? getNumericIntegerDataTypeAsString(str) : getNumericDecimalDataTypeAsString(str));
		
		/*"alte" / ausführliche Variante
		 * if (!str.contains(".")) 
		{	
			return DataTypes.getNumericIntegerDataTypeAsString(str);
			
		}
		else //float || double
			return DataTypes.getNumericDecimalDataTypeAsString(str);
			
		}
		*/
	}
	/**************************************************************************************/
	private static String getNumericIntegerDataTypeAsString(String str)
	{
		try
		
		{	
			System.out.println(new StringBuilder("Prüfe Byte-Wertebereich: ").append(Byte.MIN_VALUE).append(" bis ").append(Byte.MAX_VALUE));
			Byte.parseByte(str);
			return "byte";
		}
		catch(NumberFormatException ex)
		{
			try
			{	
				System.out.println(new StringBuilder("Prüfe Short-Wertebereich: ").append(Short.MIN_VALUE).append(" bis ").append(Short.MAX_VALUE));
				Short.parseShort(str);
				return "short";
			}
			catch(NumberFormatException ex2)
			{
				try
				{	
					System.out.println(new StringBuilder("Prüfe Integer-Wertebereich: ").append(Integer.MIN_VALUE).append(" bis ").append(Integer.MAX_VALUE));
					Integer.parseInt(str);
					return "integer";
				}
				catch(NumberFormatException ex3)
				{
					try
					{	
						System.out.println(new StringBuilder("Prüfe Long-Wertebereich: ").append(Long.MIN_VALUE).append(" bis ").append(Long.MAX_VALUE));
						Long.parseLong(str);
						return "long";
					}
					catch(NumberFormatException ex4)
					{
						return "Datatype unkown!";
					}
				}
			}
		}
		
	}
	/**************************************************************************************/
	private static String getNumericDecimalDataTypeAsString(String str)
	{
		System.out.println(new StringBuilder("Prüfe float-Wertebereich: ").append(Float.MIN_VALUE).append(" bis ").append(Float.MAX_VALUE));

		if(!Float.isInfinite(Float.parseFloat(str)))
		{
			return "float";
		}
		else
		{
			System.out.println(new StringBuilder("Prüfe double-Wertebereich: ").append(Double.MIN_VALUE).append(" bis ").append(Double.MAX_VALUE));
			
			try
			{
				Double.parseDouble(str);
				
				return "double";
			}
			catch(NumberFormatException ex)
			{
				return "Datatype unknown";
			}
		}
	}
	/**************************************************************************************/
	@SuppressWarnings("serial") 
	private static HashSet<String> PRIMITIVE_DATA_TYPES_AS_STRING = new HashSet<String>() {{add("byte");
																							add("short");
																							add("integer");
																							add("long");
																							add("double");
																							add("float");
																							add("boolean");
																							add("char");}};
	/**************************************************************************************/
	/**
	 * @param str < erwartet "byte" : "short" : "int" : "long" : "double" : "float" : "boolean" : "char" : "String"
	 * @return
	 */
	public static boolean isPrimitiveDataType(String str) 
	{
		return PRIMITIVE_DATA_TYPES_AS_STRING.contains(str);
	}
	/**************************************************************************************/
	
}
