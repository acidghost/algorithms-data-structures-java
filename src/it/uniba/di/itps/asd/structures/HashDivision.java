package it.uniba.di.itps.asd.structures;

/**
 * Created by acidghost on 12/06/14.
 */
public class HashDivision implements Hash {
    @Override
    public int h(Comparable key, int n) {
        return Math.abs(key.hashCode()) % n;
    }
}
