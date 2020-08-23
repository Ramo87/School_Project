package edu.bbq.u18.Java.knowledge.polymorphie;

public class Hund extends Saeugetier 
{
	/* geht nicht, wenn Methode aus Saeugetier final ist
	@Override
	public String showSpecies() 
	{
		return "Säugetier";
	}
	*/
	public String sound = "Wuff!";
}
