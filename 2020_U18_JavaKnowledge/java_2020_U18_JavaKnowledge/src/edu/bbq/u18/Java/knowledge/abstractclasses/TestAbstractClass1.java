package edu.bbq.u18.Java.knowledge.abstractclasses;

public abstract class TestAbstractClass1 
{

	void printTAC1() 
	{
		System.out.println("new Test().printTAC1() - TestInterface1");
	}
	
	public static void printStatic()
	{
		System.out.println("Testinterface1.printStatic() - statischer Aufruf aus der abstrakten Klasse!");
	}
	
	abstract void printAbstractTAC1();

}
