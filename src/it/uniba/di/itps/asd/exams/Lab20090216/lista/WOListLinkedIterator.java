package it.uniba.di.itps.asd.exams.Lab20090216.lista;

import java.util.Iterator;

/**
 * Created by acidghost on 29/08/14.
 */
class WOListLinkedIterator implements Iterator {
    private WOListLinked list;
    private Puntatore p;

    public WOListLinkedIterator(WOListLinked woListLinked) {
        list = woListLinked;
        p = list.inizioLista;
    }

    @Override
    public boolean hasNext() {
        return p != null;
    }

    @Override
    public Object next() {
        Comparable e;
        try {
            e = p.link.value;
        } catch (NullPointerException npe) {
            throw new RuntimeException("Lista terminata");
        }
        p = p.link.next;
        return e;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Operazione non supportata");
    }
}
