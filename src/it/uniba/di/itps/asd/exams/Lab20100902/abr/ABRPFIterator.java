package it.uniba.di.itps.asd.exams.Lab20100902.abr;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by acidghost on 01/09/14.
 */
public class ABRPFIterator implements Iterator {
    private ArrayList dati = new ArrayList();
    private int i = 0;

    public ABRPFIterator(ABRPF tree) {
        scanTree(tree);
    }

    @Override
    public boolean hasNext() {
        return (i < dati.size());
    }

    @Override
    public Object next() {
        return dati.get(i++);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    private void scanTree(ABRPF tree) {
        try {
            scanTree((ABRPF) tree.leftSubTree());
        } catch (RuntimeException e) {}
        dati.add(tree.root());
        try {
            scanTree((ABRPF) tree.rightSubTree());
        } catch (RuntimeException e) {}
    }
}
