package edu.bbq.u18.Java.knowledge.ihk.ap.w2018.ga1fq.hs2.prüfungsvorbereitungAufgabe2.b;

import edu.bbq.u18.Java.knowledge.ihk.ap.w2018.ga1fq.hs2.prüfungsvorbereitungAufgabe2.a.TeeEtikett;

/**
 * Created by Loky on 23/08/2020.
 */
public abstract class EtikettenFabrik {

    public TeeEtikett erstelleEtikett(String name){
        TeeEtikett teeEttikett = fabrikMethode(name);
        teeEttikett.berechneVerfallsDatum();
        return teeEttikett;
    }

    protected abstract TeeEtikett fabrikMethode(String teeEtikett);
}
