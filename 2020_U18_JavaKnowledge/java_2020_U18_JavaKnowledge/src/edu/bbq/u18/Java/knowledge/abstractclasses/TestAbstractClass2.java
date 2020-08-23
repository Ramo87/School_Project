package edu.bbq.u18.Java.knowledge.abstractclasses;

public abstract class TestAbstractClass2 
{
	void printTAC2() 
	{
		System.out.println("new Test().printTAC2() - TestInterface1");
	}
	
	public static void printStatic()
	{
		System.out.println("Testinterface2.printStatic() - statischer Aufruf aus der abstrakten Klasse!");
	}
	
	abstract void printAbstractTAC2();
}
