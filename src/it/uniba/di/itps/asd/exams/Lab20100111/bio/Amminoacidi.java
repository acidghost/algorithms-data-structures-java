package it.uniba.di.itps.asd.exams.Lab20100111.bio;

import java.util.HashMap;

/**
 * Created by acidghost on 16/06/14.
 */
public class Amminoacidi {

    public static HashMap<Character, Aminoacido> getCompounds() {
        HashMap<Character, Aminoacido> map = new HashMap<Character, Aminoacido>();
        map.put('A', new Aminoacido('A'));
        map.put('C', new Aminoacido('C'));
        map.put('D', new Aminoacido('D'));
        map.put('E', new Aminoacido('E'));
        map.put('F', new Aminoacido('F'));
        map.put('G', new Aminoacido('G'));
        map.put('H', new Aminoacido('H'));
        map.put('K', new Aminoacido('K'));
        map.put('N', new Aminoacido('N'));
        map.put('Q', new Aminoacido('Q'));
        map.put('W', new Aminoacido('W'));
        map.put('Y', new Aminoacido('Y'));
        return map;
    }

}
