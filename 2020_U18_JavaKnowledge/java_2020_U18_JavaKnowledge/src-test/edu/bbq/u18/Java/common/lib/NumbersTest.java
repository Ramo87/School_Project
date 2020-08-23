package edu.bbq.u18.Java.common.lib;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.bbq.u18.general.common.lib.Numbers;

/**
 * @author lotek
 *
 */

class NumbersTest {

	@Test
	void testIsNumeric() 
	{
		/*Logik bei assertions beachten, damit der Test auch das korrekte Ergebnis liefert.
		 * assertTrue(Numbers.isNumeric("keine Zahl")) würde ein falsches Ergebnis liefern, 
		 * weil isNumeric bei einem übergebenen String false zurückliefern SOLL.
		 * 
		 * */
		assertFalse(Numbers.isNumeric("keine Zahl")); 
		assertTrue(Numbers.isNumeric("1.4"));
		assertTrue(Numbers.isNumeric(" 1.4"));
		assertFalse(Numbers.isNumeric(" 1,4"));
		assertTrue(Numbers.isNumeric("123456789"));
		assertTrue(Numbers.isNumeric("0123456789"));
		assertTrue(Numbers.isNumeric("000000123456789"));
		assertFalse(Numbers.isNumeric(" 1.4.6"));
	}

}
