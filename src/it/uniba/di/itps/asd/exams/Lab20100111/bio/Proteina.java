package it.uniba.di.itps.asd.exams.Lab20100111.bio;

import it.uniba.di.itps.asd.exams.Lab20100111.lista.AList;

import java.util.Map;

/**
 * Created by acidghost on 16/06/14.
 */
public class Proteina extends Polimero {

    public Proteina(String proteinString) {
        sequenza = new AList();
        Map compounds = Amminoacidi.getCompounds();
        char[] proteinChain = proteinString.toCharArray();
        for(int i=0; i<proteinChain.length; i++) {
            char c = proteinChain[i];
            Aminoacido compound = (Aminoacido) compounds.get(c);
            if(compound == null) {
                throw new IllegalAminoacido("");
            }
            sequenza.add(compounds.get(c));
        }
    }

}
