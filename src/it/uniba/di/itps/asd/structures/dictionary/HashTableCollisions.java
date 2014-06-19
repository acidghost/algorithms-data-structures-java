package it.uniba.di.itps.asd.structures.dictionary;

import it.uniba.di.itps.asd.structures.exceptions.EmptyStructureException;

/**
 * Created by acidghost on 12/06/14.
 */
public class HashTableCollisions implements Dictionary {

    private LinkedList[] s;
    private Hash hash;

    public HashTableCollisions(int dimension, Hash hashFunc) {
        s = new LinkedList[dimension];
        hash = hashFunc;
    }

    @Override
    public void insert(Comparable k, Object v) {
        int pos = hash.h(k, s.length);
        if(s[pos] == null) {
            s[pos] = new LinkedList();
        }
        s[pos].insert(k, v);
    }

    @Override
    public void delete(Comparable k) throws EmptyStructureException {
        int pos = hash.h(k, s.length);
        if(s[pos] == null) {
            return;
        }
        s[pos].delete(k);
    }

    @Override
    public Object search(Comparable k) {
        int pos = hash.h(k, s.length);
        if(s[pos] == null) {
            return null;
        } else {
            return s[pos].search(k);
        }
    }
}
