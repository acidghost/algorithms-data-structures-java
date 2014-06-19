package it.uniba.di.itps.asd.exams.Lab20110614.dict;

import java.util.Iterator;

/**
 * Created by acidghost on 18/06/14.
 */
public class ArrayOrdinatoIterator<S> implements Iterator<S> {
    private Dictionary<S> dictionary;
    private Coppia<S>[] elementi;
    private int pointer = -1;

    public ArrayOrdinatoIterator(Dictionary<S> dictionary, Coppia<S>[] elementi) {
        this.dictionary = dictionary;
        this.elementi = elementi;
    }

    @Override
    public boolean hasNext() {
        return (pointer < elementi.length-1);
    }

    @Override
    public S next() {
        pointer++;
        try {
            return (S) elementi[pointer];
        } catch (NullPointerException e) {
            return null;
        }
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Operazione non supportata.");
    }
}
