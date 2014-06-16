package it.uniba.di.itps.asd.exams.Lab20100111.bio;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by acidghost on 12/06/14.
 */
public class Aminoacido extends Monomero {

    protected static final Map map = new HashMap<Character, String>();
    static {
        map.put('A', "Alanina");
        map.put('C', "Cisteina");
        map.put('D', "Acido aspartico");
        map.put('E', "Acido glutamminico");
        map.put('F', "Fenilanina");
        map.put('G', "Glicina");
        map.put('H', "Istidina");
        map.put('K', "Lisina");
        map.put('N', "Asparagina");
        map.put('Q', "Glutammina");
        map.put('W', "Triptofano");
        map.put('Y', "Tirosina");
    };

    private final String MSG_ERROR = "";

    public Aminoacido(char symbol) {
        Iterator iterator = map.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            if(entry.getKey().equals(symbol)) {
                this.symbol = symbol;
                this.name = (String) entry.getValue();
                return;
            }
        }
        throw new IllegalAminoacido(MSG_ERROR);
    }

}
