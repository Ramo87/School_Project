package edu.bbq.u18.Java.knowledge.ihk.ap.w2018.ga1fq.hs2.prüfungsvorbereitungAufgabe1.a;

import java.util.Date;

/**
 * Created by Loky on 23/08/2020.
 */
public class StandardReise extends Reise{

   public StandardReise(Date reiseBeginn, double grundPreis){
       super(reiseBeginn, grundPreis);
   }


@Override
 public double preisBerechnen(double preis){
    return 0;
}


}