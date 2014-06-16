package it.uniba.di.itps.asd.structures;

import it.uniba.di.itps.asd.structures.exceptions.EmptyStructureException;

/**
 * Created by acidghost on 12/06/14.
 */
public class HashTableOpen implements Dictionary {

    private Pair[] s;
    private Hash hash;
    private Scan scan;
    private final Object canc = new Object();

    public HashTableOpen(int dimension, Hash hashFunc, Scan scanFunc) {
        s = new Pair[dimension];
        hash = hashFunc;
        scan = scanFunc;
    }

    @Override
    public void insert(Comparable k, Object v) {
        int hk = hash.h(k, s.length);
        for(int i=0; i<s.length; i++) {
            int pos = scan.c(hk, i, s.length);
            if(s[pos] == null) {
                s[pos] = new Pair(k, v);
                return;
            }
        }
    }

    @Override
    public void delete(Comparable k) throws EmptyStructureException {
        int hk = hash.h(k, s.length);
        for(int i=0; i<s.length; i++) {
            int pos = scan.c(hk, i, s.length);
            if(s[pos] == null) {
                break;
            }
            if(k.compareTo(s[pos].key) == 0 && s[pos].value != canc) {
                s[pos].value = canc;
                return;
            }
        }
    }

    @Override
    public Object search(Comparable k) {
        int hk = hash.h(k, s.length);
        for(int i=0; i<s.length; i++) {
            int pos = scan.c(hk, i, s.length);
            if(s[pos] == null) {
                continue;
            } else {
                if(k.compareTo(s[pos].key) == 0 && s[pos].value != canc) {
                    return s[pos].value;
                }
            }
        }
        return null;
    }
}
