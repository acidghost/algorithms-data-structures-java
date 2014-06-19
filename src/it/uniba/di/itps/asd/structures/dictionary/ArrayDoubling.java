package it.uniba.di.itps.asd.structures.dictionary;

import it.uniba.di.itps.asd.structures.exceptions.EmptyStructureException;

/**
 * Created by acidghost on 11/06/14.
 */
public class ArrayDoubling implements Dictionary {

    private Pair[] s = new Pair[1];
    private int n = 0;

    public void insert(Comparable k, Object v) {
        if(n == s.length) {
            Pair[] tmp = new Pair[s.length * 2];
            for(int i=0; i<n; i++) {
                tmp[i] = s[i];
            }
            s = tmp;
        }
        s[n] = new Pair(k, v);
        n++;
    }

    public void delete(Comparable k) throws EmptyStructureException {
        if(n == 0) {
            throw new EmptyStructureException("Struttura vuota");
        } else {
            for(int i=0; i<n; i++) {
                if(k.compareTo(s[i].key) == 0) {
                    s[i] = s[n-1];
                    n--;
                    break;
                }
            }
            if(n == s.length/4) {
                Pair[] tmp = new Pair[s.length/2];
                for(int i=0; i<n; i++) {
                    tmp[i] = s[i];
                }
                s = tmp;
            }
        }
    }

    public Object search(Comparable k) {
        for(int i=0; i<n; i++) {
            if(k.compareTo(s[i].key) == 0) {
                return s[i].value;
            }
        }
        return null;
    }

}
