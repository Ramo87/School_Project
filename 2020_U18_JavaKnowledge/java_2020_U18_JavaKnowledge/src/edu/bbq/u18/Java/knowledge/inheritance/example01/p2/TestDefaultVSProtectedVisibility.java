package edu.bbq.u18.Java.knowledge.inheritance.example01.p2;

import edu.bbq.u18.Java.knowledge.inheritance.example01.p1.C;

public class TestDefaultVSProtectedVisibility extends C
{
	/*Wichtiger Unterschied zwischen Default und Protected:
	 * Default ist NICHT vererbbar
	 * Protected IST vererbbar
	 * */
	
	//private int protectedVisibleInstanceField = 2000;
	// hierdurch wird das vererbte protectedVisibleInstanceField überdeckt, 
	// so dass plötzlich nur noch das lokale protectedVisibleInstanceField einen neuen Wert bekommt
	// und das Feld aus der super-Klasse unberührt bleibt (Stichwort: "hidden instance fields").
	// In der Praxis führt so etwas zu unerwartetem Verhalten von Software, dessen Ursache
	// nur sehr schwer zu finden ist. Also ist es zu vermeiden, lokale bzw. private Variablen
	// mit Bezeichnern zu definieren, die identisch mit etwaigen Bezeichnern der Oberklasse sind.
	// I. d. R. ist dieses Verhalten unerwünscht.
	
	/**************************************************************************************/
	
	public TestDefaultVSProtectedVisibility() //Durch Definition eines eigenen Konstruktors in C gibt es den Standard-Konstruktor nicht mehr
	{
		// TODO: Aufruf eines alternativen Konstruktors mit 2 Parametern (der natürlich in der Klasse vorhanden sein muss)
		
		super ("Test");
		
		/* this und super liefern noch identisch aus der Super- /Oberklasse ...*/
		System.out.println("super.protectedVisibleInstanceField = " + super.protectedVisibleInstanceField);
		System.out.println("this.protectedVisibleInstanceField = " + this.protectedVisibleInstanceField);
		
		/*Werden Werte unter Nutzung von This neu gesetzt, ... */
		this.protectedVisibleInstanceField = 10;
		
			
		/*... dann werden auch die supers frequentiert und geändert! Das gleiche Verhalten, wenn man super benutzt mit Auswirkung auf this. */
		System.out.println("-----");
		System.out.println("super.protectedVisibleInstanceField = " + super.protectedVisibleInstanceField);
		System.out.println("this.protectedVisibleInstanceField = " + this.protectedVisibleInstanceField);
		
		//TODO: Hier Kommentar aus Screenshots ergänzen
		
		super.protectedVisibleMethodFromClassA();
		super.publicVisibleMethodFromClassA();
		
		this.protectedVisibleMethodFromClassA();
		this.publicVisibleMethodFromClassA();
	}
	
	/**************************************************************************************/

	public static void main(String[] args) 
	{
		new TestDefaultVSProtectedVisibility();

	}
	/**************************************************************************************/
	@Override
	// Annotation, hilft dem Code-Verständnis, der Compiler hält nach, ob eine Annotation jeweils anwendbar bzw. gültig ist
	public void protectedVisibleMethodFromClassA() 
	{
		System.out.println("protected visible method from class A; overwritten in class TestDefaultVSProtectedVisibility");
	}
	/**************************************************************************************/
	@Override
	public void publicVisibleMethodFromClassA() 
	{
		System.out.println("public visible method from class A; overwritten in class TestDefaultVSProtectedVisibility");
	}
	/**************************************************************************************/
	// häufiges Beispiel für Override einer Standard-Methode, toString():
	@Override
	public String toString() 
	{
		return "Klasse: TestDefaultVSProtectedVisibility";
	}
	/**************************************************************************************/
}
