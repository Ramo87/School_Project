package edu.bbq.u18.Java.knowledge.ihk.ap.w2018.ga1fq.hs2.pruefungsvorbereitungAufgabe2.a;

import java.util.Date;

/**
 * Created by Loky on 23/08/2020.
 */
public abstract class TeeEtikett {

    protected String name;
    protected Date verfallsDatum;
    protected String[][] zutaten;

    public void berechneVerfallsDatum(){}

    public void druckeEtikett(){}

    public abstract double getPreis();


}
