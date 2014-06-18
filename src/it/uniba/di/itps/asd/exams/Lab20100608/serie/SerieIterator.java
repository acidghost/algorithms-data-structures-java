package it.uniba.di.itps.asd.exams.Lab20100608.serie;

import java.util.Iterator;
import java.util.List;

/**
 * Created by acidghost on 18/06/14.
 */
public class SerieIterator<T> implements Iterator<T> {
    private CompList<T> serie;
    private int pointer = -1;

    public SerieIterator(CompList<T> serie) {
        this.serie = serie;
    }

    @Override
    public boolean hasNext() {
        return (pointer < serie.numberElements()-1);
    }

    @Override
    public T next() {
        pointer++;
        return this.serie.getElement(pointer);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Operazione non supportata.");
    }
}
