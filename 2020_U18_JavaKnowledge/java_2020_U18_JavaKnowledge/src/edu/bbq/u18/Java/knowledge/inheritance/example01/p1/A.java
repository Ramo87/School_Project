package edu.bbq.u18.Java.knowledge.inheritance.example01.p1;


public class A 
{
	
	/* default */ int defaultVisibleInstanceField 	= 1;
	protected int protectedVisibleInstanceField 	= 2;
	public int publicVisibleInstanceField 			= 3;
	private int privateVisibleInstanceField 		= 4;
	
	/*
	 * public A() 
	
	{
		ConsolePrint.showLine("Konstruktor A.A()");
		System.out.println((this instanceof Object));
	}
	*/
	
	public A(String param1) 
	{
		System.out.println("Konstruktor A.A(String param1)");
		//System.out.println((this instanceof Object));
		//TODO: Überschreiben der vom übergeordneten Object geerbten Methode toString()
	}
	
	public void publicVisibleMethodFromClassA() 
	{
		System.out.println("public visible method from class A");
	}
	
	void defaultVisibleMethodFromClassA() 
	{
		System.out.println("default visible method from class A");
	}
	
	protected void protectedVisibleMethodFromClassA() 
	{
		System.out.println("protected visible method from class A");
	}
	
	private void privateVisibleMethodFromClassA() 
	{
		System.out.println("private visible method from class A");
	}
}
