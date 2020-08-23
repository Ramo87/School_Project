package edu.bbq.u18.Java.knowledge.visibility;


/*
 S.114 Abs. 2.2.11 (Java ist auch ein Insel)
 S.198 Abs. 2.7.2	(Java ist auch ein Insel)
 
 private - Konstruktore, Variable, Methode und innere-Klasse kann es übernihmen (Sonst gibts mäker vom Kompeiler)
 public - kann überal aufgerufen werden (sichtbar)
 protected - Konstruktore, Variable, Methode und innere-Klasse - innerhalb des Blocks der Klassendefinition 
 (default) - wenn default, die kann nicht nach drausen vererbt werden (nur ausserhalb des Package), und die ist nur Packetweit sichtbar.
 
 */

/* (default) kann nicht angegeben werden, ist Standard-Sichbarkeit 
 * (kann nur in interfaces angegeben werden, nicht in Klassen) */
public class Test // Bei Deklaration der Klasse ist nur default-Sichtbarkeit (default) und public (aplikationsweite Sichtbarkeit)
{
	public static void main (String args [])
	{
		System.out.println("hallo epta");
	}
	
}
