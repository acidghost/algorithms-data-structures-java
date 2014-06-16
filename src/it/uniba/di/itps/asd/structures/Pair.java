package it.uniba.di.itps.asd.structures;

/**
 * Created by acidghost on 11/06/14.
 */
class Pair {
    Comparable key;
    Object value;

    Pair(Comparable k, Object v) {
        key = k;
        value = v;
    }

    public String toString() {
        return "Key: " + key + "\tValue: " + value;
    }
}
