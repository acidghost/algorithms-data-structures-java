package it.uniba.di.itps.asd.exams.Lab20100222;

import java.util.Iterator;

/**
 * Created by acidghost on 02/09/14.
 */
public interface ListaIndicizzata<T> extends Iterable<T> {
    public boolean isEmpty();
    public void addElement(T e, int i);
    public T getElement(int i);
    public int numberElements();

    @Override
    Iterator<T> iterator();
}
