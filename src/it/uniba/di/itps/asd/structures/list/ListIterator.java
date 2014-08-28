package it.uniba.di.itps.asd.structures.list;

import java.util.Iterator;

/**
 * Created by acidghost on 28/08/14.
 */
class ListIterator<T> implements Iterator<T> {
    private List<T> list;
    private Position p;

    ListIterator(ListDoubling<T> list) {
        this.list = list;
        p = list.firstList();
    }

    @Override
    public boolean hasNext() {
        return !list.isEndList(p);
    }

    @Override
    public T next() {
        Position q = p;
        p = list.next(p);
        return list.readList(q);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Metodo non supportato");
    }
}
