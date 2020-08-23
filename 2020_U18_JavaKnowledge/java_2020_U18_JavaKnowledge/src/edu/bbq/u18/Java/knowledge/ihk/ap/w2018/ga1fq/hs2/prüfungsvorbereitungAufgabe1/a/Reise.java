package edu.bbq.u18.Java.knowledge.ihk.ap.w2018.ga1fq.hs2.prüfungsvorbereitungAufgabe1.a;

import java.util.Date;

/**
 * Created by Loky on 23/08/2020.
 */
public abstract class Reise  {

    protected double grundPreis;
    private Date reiseBeginn;


    public Reise(Date reiseBeginn, double grundPreis){
        this.grundPreis = grundPreis;
        this.reiseBeginn = reiseBeginn;
    }

    public int tageBestimmen(int tage){
        return 0;
    }

    public double preisBerechnen( double preis){
        return 0;
    }

}
