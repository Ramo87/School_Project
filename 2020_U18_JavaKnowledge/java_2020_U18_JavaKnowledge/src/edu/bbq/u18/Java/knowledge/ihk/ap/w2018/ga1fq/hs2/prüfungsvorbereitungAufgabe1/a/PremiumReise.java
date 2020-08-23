package edu.bbq.u18.Java.knowledge.ihk.ap.w2018.ga1fq.hs2.prüfungsvorbereitungAufgabe1.a;

import java.util.Date;

/**
 *
 */
public class PremiumReise extends Reise{

    PremiumReise(Date reiseBeginn, double preis){
        super(reiseBeginn, preis);
    }

    @Override
    public double preisBerechnen(double preis){
        return 0;
    }
}
