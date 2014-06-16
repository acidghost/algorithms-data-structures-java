package it.uniba.di.itps.asd.exams.Lab20100111.bio;

import java.util.HashMap;

/**
 * Created by acidghost on 12/06/14.
 */
public class Nucleotidi {

    public static HashMap<Character, Nucleotide> getCompounds() {
        HashMap<Character, Nucleotide> map = new HashMap<Character, Nucleotide>();
        map.put('A', new Nucleotide('A'));
        map.put('C', new Nucleotide('C'));
        map.put('G', new Nucleotide('G'));
        map.put('T', new Nucleotide('T'));
        return map;
    }

}
