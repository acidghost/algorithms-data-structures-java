package it.uniba.di.itps.asd.exams.Lab20120907.lista;

/**
 * Created by acidghost on 04/09/14.
 */
public interface Lista<T> extends Iterable<T> {
    public boolean isEmpty();
    public Posizione firstList();
    public boolean endList(Posizione<T> p);
    public Posizione succ(Posizione<T> p);
    public Posizione pred(Posizione<T> p);
    public void insert(T e, Posizione<T> p);
    public T read(Posizione<T> p);
}
