package edu.bbq.u18.Java.knowledge.ihk.ap.w2018.ga1fq.hs2.prüfungsvorbereitungAufgabe2.b;

import edu.bbq.u18.Java.knowledge.ihk.ap.w2018.ga1fq.hs2.prüfungsvorbereitungAufgabe2.a.TeeEtikett;

/**
 * Created by Loky on 23/08/2020.
 */
public abstract class EtikettenFabrik {

    public TeeEtikett erstelleEtikett(String typ){
        TeeEtikett teeEtikett = fabrikMethode(typ);
        teeEtikett.berechneVerfallsDatum();
        return teeEtikett;
    }

    protected abstract TeeEtikett fabrikMethode(String typ);

}

/**
 *
 *
 * */
