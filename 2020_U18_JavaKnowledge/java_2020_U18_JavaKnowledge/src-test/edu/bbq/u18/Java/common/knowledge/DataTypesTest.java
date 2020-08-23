package edu.bbq.u18.Java.common.knowledge;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.bbq.u18.Java.knowledge.DataTypes;

class DataTypesTest {

	@Test
	void testGetDataTypeAsString() 
	{
		assertTrue(DataTypes.getDataTypeAsString("-127").equals("byte"));
		assertFalse(DataTypes.getDataTypeAsString("128").equals("byte"));
		
		assertTrue(DataTypes.getDataTypeAsString("-256").equals("short"));
		assertFalse(DataTypes.getDataTypeAsString("33000").equals("short"));
		
		assertTrue(DataTypes.getDataTypeAsString("-12345678").equals("integer"));
		assertFalse(DataTypes.getDataTypeAsString("2147483649").equals("integer"));
		
		assertTrue(DataTypes.getDataTypeAsString("-9223372036854775800").equals("long"));
		assertFalse(DataTypes.getDataTypeAsString("10223372036854775807").equals("long"));
		
		assertTrue(DataTypes.getDataTypeAsString("x").equals("char"));
		assertFalse(DataTypes.getDataTypeAsString("128").equals("char"));
		
		assertTrue(DataTypes.getDataTypeAsString("Peter").equals("String"));
		assertFalse(DataTypes.getDataTypeAsString("1235468").equals("String"));
		
		assertTrue(DataTypes.getDataTypeAsString("false").equals("boolean"));
		assertFalse(DataTypes.getDataTypeAsString("Peter").equals("boolean"));
		
		assertTrue(DataTypes.getDataTypeAsString("3.1415927").equals("float"));
		assertFalse(DataTypes.getDataTypeAsString("3.4028235E3810").equals("float"));
		
		assertTrue(DataTypes.getDataTypeAsString("1.7976931348623157E308").equals("double"));
		/*mit System.out.printf("%f", Float.MAX_VALUE) den Maximalwert in lesbarer Schreibweise ermitteln 
		 * und dann den Test anpassen 
		 * */
		//assertFalse(DataTypes.getDataTypeAsString("1.8E308").equals("double"));
		assertTrue(DataTypes.isPrimitiveDataType("byte"));
		assertTrue(DataTypes.isPrimitiveDataType("short"));
		assertTrue(DataTypes.isPrimitiveDataType("integer"));
		assertTrue(DataTypes.isPrimitiveDataType("long"));
		assertTrue(DataTypes.isPrimitiveDataType("float"));
		assertTrue(DataTypes.isPrimitiveDataType("double"));
		assertTrue(DataTypes.isPrimitiveDataType("boolean"));
		assertTrue(DataTypes.isPrimitiveDataType("char"));
		assertFalse(DataTypes.isPrimitiveDataType("String"));
		assertFalse(DataTypes.isPrimitiveDataType("Nananananana"));
		
		assertTrue(DataTypes.isPrimitiveDataType(DataTypes.getDataTypeAsString("-127")));
	}

}
