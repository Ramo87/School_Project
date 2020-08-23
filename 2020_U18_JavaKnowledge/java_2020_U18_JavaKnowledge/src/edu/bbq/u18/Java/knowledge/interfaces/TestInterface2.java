package edu.bbq.u18.Java.knowledge.interfaces;

interface TestInterface2 
{
	default void printTI2() 
	{
		System.out.println("new Test().print() - TestInterface2");
	}
	
	public static void printStatic()
	{
		System.out.println("Testinterface2.printStatic() - statischer Aufruf aus dem Interface!");
	}
	
	abstract void printAbstractTI2();
}
