package it.uniba.di.itps.asd.exams.Lab20100111.bio;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by acidghost on 12/06/14.
 */
public class Nucleotide extends Monomero {

    protected static final Map map = new HashMap<Character, String>();
    static {
        map.put('A', "Adenina");
        map.put('C', "Citosina");
        map.put('G', "Guanina");
        map.put('T', "Timina");

    };

    private final String MSG_ERROR = "";

    public Nucleotide(char symbol) {
        Iterator iterator = map.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            if(entry.getKey().equals(symbol)) {
                this.symbol = symbol;
                this.name = (String) entry.getValue();
                return;
            }
        }
        throw new IllegalNucleotide(MSG_ERROR);
    }

}
