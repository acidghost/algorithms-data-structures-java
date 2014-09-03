package it.uniba.di.itps.asd.exams.Lab20100608.dict;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: acidghost
 * Date: 17/06/14
 * Time: 19:19
 * To change this template use File | Settings | File Templates.
 */
public class ArrayOrdinatoIterator<S> implements Iterator<S> {
    private Dictionary<S> dictionary;

    private Coppia[] elementi;
    private int pointer = -1;

    public ArrayOrdinatoIterator(Dictionary<S> dictionary, Coppia[] elementi) {
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
