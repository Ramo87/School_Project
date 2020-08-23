package edu.bbq.u18.Java.knowledge.interfaces;

public class Test implements TestInterface1, TestInterface2
{

	public Test() 
	{ /* default void print()*/
		this.printTI1();
		this.printTI2();
	}

	public static void main(String[] args) 
	{	
		new Test();
		/*static void printStatic() */
		TestInterface1.printStatic();
		TestInterface2.printStatic();

	}
	
	/* abstract void printAbstract(); */
	@Override
	public void printAbstractTI1() 
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void printAbstractTI2() 
	{
		// TODO Auto-generated method stub
		
	}

}
