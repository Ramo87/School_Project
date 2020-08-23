package edu.bbq.u18.Java.common.knowledge;

//import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringTests
/**
 * kindly provided by Mr. Roberto Stech 
 */
{
	 /**********************************************************************************/
	@Test
	void test()
	{
		testStringConcatenation();
		testStringBufferConcatenation();
		testStringBuilderConcatenation();
	}
	/**********************************************************************************/
	void testStringBufferConcatenation()
	{
		StringBuffer x= new StringBuffer();
		
		final long timeStart = System.nanoTime();
		
		for(int i= 0; i < 10000; i++)
		{
			x.append("x");
		}

		final long timeEnd = System.nanoTime();

		System.out.println(new StringBuilder("[StringBuffer-Concatenation-Test]  Benötigte Zeit: ").append((timeEnd - timeStart)));
	}
	/**********************************************************************************/
	void testStringBuilderConcatenation()
	{
		StringBuilder x= new StringBuilder();
		
		final long timeStart = System.nanoTime();
		
		for(int i= 0; i < 10000; i++)
		{
			x.append("x");
		}

		final long timeEnd = System.nanoTime();

		System.out.println(new StringBuilder("[StringBuilder-Concatenation-Test] Benötigte Zeit: ").append((timeEnd - timeStart)));
	}
	/**********************************************************************************/
	void testStringConcatenation()
	{
		@SuppressWarnings("unused")
		String x= "";
		
		final long timeStart = System.nanoTime();
		
		for(int i= 0; i < 10000; i++)
		{
			x+= "x";
		}

		final long timeEnd = System.nanoTime();

		System.out.println(new StringBuilder("[String-Concatenation-Test]        Benötigte Zeit: ").append((timeEnd - timeStart)));
	}
	/**********************************************************************************/
	void testString()
	{
		String xs= "Schüler";

		System.out.println(xs);
		System.out.println();

		modifyString(xs);

		System.out.println(xs);
	}
	/**********************************************************************************/
	void modifyString(String s)
	{
		s= "Dozent";
	}
	/**********************************************************************************/
	void testStringBuilder()
	{
		StringBuilder xb= new StringBuilder("Ich fühle mich leer! ");
		
		System.out.println(xb);
		System.out.println();

		modifyStringBuilder(xb);

		System.out.println(xb);
	}
	/**********************************************************************************/
	void modifyStringBuilder(StringBuilder sb)
	{
		sb.append("Ich fühle mich ergänzt!");
	}
	/**********************************************************************************/
	void immutableStringBuilderTest()
	{
		StringBuilder x= new StringBuilder("Schüler");
		
		System.out.println(new StringBuilder("x1 (objectRef): ").append(objectRef(x)));
		System.out.println(new StringBuilder("x1 (stringRef): ").append(stringRef(x)));
		
		x.append(" & Dozent");
		
		System.out.println();
		System.out.println(new StringBuilder("x2 (objectRef): ").append(objectRef(x)));
		System.out.println(new StringBuilder("x2 (stringRef): ").append(stringRef(x)));
	}
	/**********************************************************************************/
	void immutableStringTest()
	{
		String x= "Schüler";
		
		System.out.println(new StringBuilder("x1 (objectRef): ").append(objectRef(x)));
		System.out.println(new StringBuilder("x1 (stringRef): ").append(stringRef(x)));
		
		x= "Dozent";
		
		System.out.println();
		System.out.println(new StringBuilder("x2 (objectRef): ").append(objectRef(x)));
		System.out.println(new StringBuilder("x2 (stringRef): ").append(stringRef(x)));
	}
    /**********************************************************************************/
    public static final int BY_SYSTEM_IDENTITY_HASH_CODE= 1;
    public static final int BY_STRING_HASH_CODE         = 2;
    /*
        Object.hashCode() Returns a hash code value for the object.
        String.hashCode() Returns a hash code for this string.
        System.identityHashCode(Object) Returns the same hash code for the given object
                                        as would be returned by the default method hashCode(),
                                        whether or not the given object's class overrides
                                        hashCode().
     */
    public static String stringRef(StringBuilder s,
                                   int METHOD_TYPE)
    {
        switch(METHOD_TYPE)
        {
            case BY_STRING_HASH_CODE:
                return new StringBuilder(s.getClass().getName()).append("@").append(Integer.toHexString(s.hashCode())).toString();
            case BY_SYSTEM_IDENTITY_HASH_CODE:
                return new StringBuilder(s.getClass().getName()).append("@").append(Integer.toHexString(System.identityHashCode(s))).toString();
            default:
                return new StringBuilder(s.getClass().getName()).append("@").append(Integer.toHexString(s.hashCode())).toString();
        }
    }
    /***********************************************************************************/
    /**
     * @param s
     * @param METHOD_TYPE
     * @return 
     */
    public static String stringRef(String s,
                                   int METHOD_TYPE)
    {
        switch(METHOD_TYPE)
        {
            case BY_STRING_HASH_CODE:
                return new StringBuilder(s.getClass().getName()).append("@").append(Integer.toHexString(s.hashCode())).toString();
            case BY_SYSTEM_IDENTITY_HASH_CODE:
                return new StringBuilder(s.getClass().getName()).append("@").append(Integer.toHexString(System.identityHashCode(s))).toString();
            default:
                return new StringBuilder(s.getClass().getName()).append("@").append(Integer.toHexString(s.hashCode())).toString();
        }
    }
    /**********************************************************************************/
    /**
     * @param s
     * @return 
     */
    public static String stringRef(StringBuilder s)
    {
        return stringRef(s,BY_SYSTEM_IDENTITY_HASH_CODE);
    }
    /**********************************************************************************/
    /**
     * @param s
     * @return 
     */
    public static String stringRef(String s)
    {
        return stringRef(s,BY_SYSTEM_IDENTITY_HASH_CODE);
    }
    /**********************************************************************************/
    /**
     * @param o
     * @return 
     */
    public static String objectRef(Object o)
    {
        try
        {
            return new StringBuilder(o.getClass().getName()).append("@").append(Integer.toHexString(o.hashCode())).toString();
        }
        catch(NullPointerException nex)
        {
            return "null";
        }
    }
    /***********************************************************************************/	
}
