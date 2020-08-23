package edu.bbq.u18.Java.knowledge.polymorphie;

import edu.bbq.u18.general.common.helpers.HeapInspector;

//FIXME: Irgendwie dafür sorgen, dass dieser import aufgelöst werden kann...
//import edu.bbq.u18.general.common.helpers.HeapInspector;

public class Test 
{

	/*
	 * cd ~/eclipse-workspace/java_2020_U18_JavaKnowledge/bin;
	 * java -verbose:class edu.bbq.u18.Java.knowledge.polymorphie.Test
	 */
	
	public static void main(String[] args) 
	{
		System.out.println(HeapInspector.getMaxMemory(HeapInspector.DISPLAY_TYPE_MB));
		
		Saeugetier s1 = new Hund(); /* Polymorphie / Polymorphismus / engl. polymorphism / dynamische Bindung*/
		Saeugetier s2 = new Katze(); /* Polymorphie / Polymorphismus / engl. polymorphism / dynamische Bindung*/
		Saeugetier s3 = new Wal();
		
		System.out.println("Dieser Hund ist ein " + s1.showSpecies());
		System.out.println("Diese Katze ist ein " + s2.showSpecies());
		System.out.println("Dieser Wal ist ein " + s3.showSpecies());
	}

}
