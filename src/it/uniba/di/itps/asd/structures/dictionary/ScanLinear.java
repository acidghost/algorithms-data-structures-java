package it.uniba.di.itps.asd.structures.dictionary;

/**
 * Created by acidghost on 12/06/14.
 */
public class ScanLinear implements Scan {
    @Override
    public int c(int hk, int i, int n) {
        return (hk + i) % n;
    }
}
