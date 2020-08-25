package edu.bbq.u18.Java.knowledge.ihk.ap.w2018.ga1fq.hs2.pruefungsvorbereitungAufgabe2.b;

import edu.bbq.u18.Java.knowledge.ihk.ap.w2018.ga1fq.hs2.pruefungsvorbereitungAufgabe2.a.KoelnerBronchialTeeEtikett;
import edu.bbq.u18.Java.knowledge.ihk.ap.w2018.ga1fq.hs2.pruefungsvorbereitungAufgabe2.a.KoelnerMagenTeeEtikett;
import edu.bbq.u18.Java.knowledge.ihk.ap.w2018.ga1fq.hs2.pruefungsvorbereitungAufgabe2.a.TeeEtikett;

/**
 * Created by Loky on 23/08/2020.
 */
public class EtikettenFabrikKoeln extends EtikettenFabrik{

    @Override
    protected TeeEtikett fabrikMethode(String name){
        switch(name) {
            case "Bronchial":
                return new KoelnerBronchialTeeEtikett();
            case "Magen":
                return new KoelnerMagenTeeEtikett();
            default:
                throw new IllegalArgumentException( "Case not handled!" );
        }
    }
}


/** wenn tzp gleich "Bronchial", dann new KölnerBronchialTeeEtikett()
 *...
 *
 * ende
 * Rückgaben : etikett
 * SELECT typ
 *  CASE "Bronchial" :
 * */