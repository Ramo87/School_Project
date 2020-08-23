package edu.bbq.u18.Java.knowledge.inheritance.example01.p1;

import edu.bbq.u18.Java.knowledge.inheritance.example01.p1.A;
import edu.bbq.u18.Java.knowledge.inheritance.example01.p1.B;

/**
 * java.lang.Object
 * 		edu.bbq.u18.chat.common.knowledge.inheritance.example01.A
 *			edu.bbq.u18.chat.common.knowledge.inheritance.example01.B
 *				edu.bbq.u18.chat.common.knowledge.inheritance.example01.C
 * */
public class C  extends B
{
	/*public C() 
	{
		ConsolePrint.showLine("Konstruktor C.C()");
		System.out.println((this instanceof Object));
		System.out.println((this instanceof A));
		System.out.println((this instanceof B));
		/*Magic Klasse "Object"
	}
	*/
	public C(String param1) 
	{
		super(param1);
		System.out.println("Konstruktor C.C(String param1)");
		System.out.println((this instanceof Object));
		System.out.println((this instanceof A));
		System.out.println((this instanceof B));
		/*Magic Klasse "Object"*/
		
	}
	
	public void publicVisibleMethodFromClassC() 
	{
		System.out.println("public visible method from class C");
	}
	
	void defaultVisibleMethodFromClassC() 
	{
		System.out.println("default visible method from class C");
	}
	
	protected void protectedVisibleMethodFromClassC() 
	{
		System.out.println("protected visible method from class C");
	}
	
	private void privateVisibleMethodFromClassC() 
	{
		System.out.println("private visible method from class C");
	}
}
