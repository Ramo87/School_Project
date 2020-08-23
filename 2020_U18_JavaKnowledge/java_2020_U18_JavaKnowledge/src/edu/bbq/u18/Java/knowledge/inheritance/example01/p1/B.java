package edu.bbq.u18.Java.knowledge.inheritance.example01.p1;

import edu.bbq.u18.Java.knowledge.inheritance.example01.p1.A;


/**
 * java.lang.Object
 * 		edu.bbq.u18.chat.common.knowledge.inheritance.example01.A
 * 			edu.bbq.u18.chat.common.knowledge.inheritance.example01.B
 * */

public class B extends A
{
	/*
	public B() 
	{
		ConsolePrint.showLine("Konstruktor B.B()");
		System.out.println((this instanceof Object));
		System.out.println((this instanceof A));
	}
	*/
	public B(String param1) 
	{	
		super(param1);
		System.out.println("Konstruktor B.B(String param1)");
		System.out.println((this instanceof Object));
		System.out.println((this instanceof A));
	}
	
	public void publicVisibleMethodFromClassB() 
	{
		System.out.println("public visible method from class B");
	}
	
	void defaultVisibleMethodFromClassB() 
	{
		System.out.println("default visible method from class B");
	}
	
	protected void protectedVisibleMethodFromClassB() 
	{
		System.out.println("protected visible method from class B");
	}
	
	private void privateVisibleMethodFromClassB() 
	{
		System.out.println("private visible method from class B");
	}
}
