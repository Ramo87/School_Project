package edu.bbq.u18.Java.knowledge.interfaces;

// public interface TestTestInterface1 extends TestAbstractClassInterface2 
// ^- Erweiterung nicht möglich mit Klassen (Klasse importierten, dann kommt Fehlermeldung von der IDE)

public interface TestInterface1 extends TestInterface2 // <-Erweiterung möglich, aber nur mit Interfaces
{
	//abstract void show();
	
	/*
	 * Ab Java 8 (1.8) wurde die Möglichkeit von default- und static-Methoden hinzugefügt
	 *
	 * alle Interface-Methoden-Typen abstract, default, static sind automatisch public
	 */
	
	default void printTI1() 
	{
		System.out.println("new Test().print() - TestInterface1");
	}
	
	public static void printStatic()
	{
		System.out.println("Testinterface1.printStatic() - statischer Aufruf aus dem Interface!");
	}
	
	abstract void printAbstractTI1();
}
