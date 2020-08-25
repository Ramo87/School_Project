package edu.bbq.u18.Java.knowledge.ihk.ap.w2018.ga1fq.hs2.pruefungsvorbereitungAufgabe2.a;

/**
 * Created by Loky on 23/08/2020.
 */
public class KoelnerBronchialTeeEtikett extends TeeEtikett {

    public KoelnerBronchialTeeEtikett(){}

    public KoelnerBronchialTeeEtikett(String name, String[][] zutaten){
        super.name = name;
        super.zutaten = zutaten;

    }

    @Override
    public double getPreis(){
        return 0;
    }
}
