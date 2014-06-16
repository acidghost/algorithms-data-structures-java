package it.uniba.di.itps.asd.exams.Lab20100111.bio;

import it.uniba.di.itps.asd.exams.Lab20100111.lista.AList;

import java.util.Map;

/**
 * Created by acidghost on 16/06/14.
 */
public class DNA extends Polimero {

    public DNA(String dnaString) {
        sequenza = new AList();
        Map compounds = Nucleotidi.getCompounds();
        char[] dnaChain = dnaString.toCharArray();
        for(int i=0; i<dnaChain.length; i++) {
            char c = dnaChain[i];
            Nucleotide compound = (Nucleotide) compounds.get(c);
            if(compound == null) {
                throw new IllegalNucleotide("");
            }
            sequenza.add(compounds.get(c));
        }
    }

}
