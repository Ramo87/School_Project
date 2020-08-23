package edu.bbq.u18.Java.knowledge.inheritance.example01.p1;

import edu.bbq.u18.Java.knowledge.inheritance.example01.p1.A;
import edu.bbq.u18.Java.knowledge.inheritance.example01.p1.B;
import edu.bbq.u18.Java.knowledge.inheritance.example01.p1.C;

public class Test {

	public static void main(String[] args) 
	{
		C c=new C("x");
		/*Vererbungskette: Instanziierung eines C-Objekts führt implizit die Konstruktoren der Elternklassen aus*/
		
		c.defaultVisibleMethodFromClassA();
		c.defaultVisibleMethodFromClassB();
		c.defaultVisibleMethodFromClassC();
		
		c.protectedVisibleMethodFromClassA();
		c.protectedVisibleMethodFromClassB();
		c.protectedVisibleMethodFromClassC();
		
		/* NIcht sichtbar! Privatangelegenheit der vererbenden Klasse!
		c.privateVisibleMethodFromClassA();
		c.privateVisibleMethodFromClassB();
		c.privateVisibleMethodFromClassC();
		*/
		
		/* Type = new Instance*/
		// C c2 = new A("A"); //Type mismatch: cannot convert from A to C
		// C c2 = new B("B"); //Type mismatch: cannot convert from B to C
		// C c2 = new Object(); //Type mismatch: cannot convert from Object to C
		
		A a1 = new C ("A");
		
		a1.defaultVisibleMethodFromClassA();
		
		a1.protectedVisibleMethodFromClassA();
		
		a1.publicVisibleMethodFromClassA();
		
		
		B b1 = new C ("B");
		
		b1.defaultVisibleMethodFromClassA();
		b1.defaultVisibleMethodFromClassB();
		
		b1.protectedVisibleMethodFromClassA();
		b1.protectedVisibleMethodFromClassB();
		
		b1.publicVisibleMethodFromClassA();
		b1.publicVisibleMethodFromClassB();
		
		a1.defaultVisibleMethodFromClassA();
		
		a1.protectedVisibleMethodFromClassA();
		
		a1.publicVisibleMethodFromClassA();
		
		a1= new B("B");
		
		System.out.println("\n1.1 Ist a1 eine Instance von Object? " + (a1 instanceof Object) + " - Instanz-Type: " + a1.getClass().getTypeName() + " - ");
		System.out.println("\n1.2 Ist a1 eine Instance von A? " + (a1 instanceof A) + " - Instanz-Type: " + a1.getClass().getTypeName() + " - ");
		System.out.println("\n1.3 Ist a1 eine Instance von B? " + (a1 instanceof B) + " - Instanz-Type: " + a1.getClass().getTypeName() + " - ");
		System.out.println("\n1.4 Ist a1 eine Instance von C? " + (a1 instanceof C) + " - Instanz-Type: " + a1.getClass().getTypeName() + "\n");
		// Implizite Typumwandlung -> boxing / unboxing / autoboxing
		//a1=b1;
		
		System.out.println("\n2. Ist a1 eine Instance von B? " + (a1 instanceof B) + " - Instanz-Type: " + a1.getClass().getTypeName() + "\n");
		
		// Explizite Typumwandlung (Casting)
		a1=(A)b1;
		
		System.out.println("\n3.1 Ist a1 eine Instance von B? " + (a1 instanceof B) + " - Instanz-Type: " + a1.getClass().getTypeName() + " - ");
		System.out.println("\n3.2 Ist a1 eine Instance von C? " + (a1 instanceof C) + " - Instanz-Type: " + a1.getClass().getTypeName() + "\n");
		/* Trotz Instanzzuweisung zu B oder C nur die 3 Methoden aus A, da rechts Daten-Type A und links Instanziierung von B. 
		 * Folglich kann man einen Datentyp, der in der Vererbungshierarchie "niedriger" steht, nicht durch eine instanz eines
		 * "höheren" Typs "aufwerten".
		 * */
		a1.defaultVisibleMethodFromClassA();
		a1.protectedVisibleMethodFromClassA();
		a1.publicVisibleMethodFromClassA();
		
		Object o1 = new C("Object");
		
		if(o1 instanceof C) 
		{	// Explizite Typumwandlung
			C c3 = (C)o1;
		}
		
		System.out.println("\n4.1 Ist o1 eine Instance von C? " + (o1 instanceof C) + " - Instanz-Type: " + o1.getClass().getTypeName() + " - ");
	}

}
