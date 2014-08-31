package it.uniba.di.itps.asd.exams.Lab20140702.list;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: acidghost
 * Date: 31/08/14
 * Time: 17:59
 * To change this template use File | Settings | File Templates.
 */
public class VectorListIterator<S> implements Iterator<S> {
    private VectorList<S> list;
    private int current = 0;

    @Override
    public boolean hasNext() {
        return current < list.n;
    }

    @Override
    public S next() {
        S element = list.vector[current];
        current++;
        return element;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    public VectorListIterator(VectorList<S> list) {
        this.list = list;
    }
}
