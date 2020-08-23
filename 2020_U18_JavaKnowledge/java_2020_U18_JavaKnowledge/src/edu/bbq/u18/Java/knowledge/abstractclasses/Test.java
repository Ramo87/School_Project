package edu.bbq.u18.Java.knowledge.abstractclasses;

public class Test extends TestAbstractClass1 //, TestAbstractClass2 <- UNMÖGLICH! Hier müssen Interfaces her ("implements")
{

	public Test() 
	{
		this.printTAC1();
	}
	
	public static void main(String[] args) 
	{
		new Test();
		
		TestAbstractClass1.printStatic();

	}
	
	void printAbstractTAC1() 
	{
		
	}

}
