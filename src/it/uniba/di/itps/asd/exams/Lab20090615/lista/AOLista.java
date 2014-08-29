package it.uniba.di.itps.asd.exams.Lab20090615.lista;

/**
 * Created by acidghost on 29/08/14.
 */
public interface AOLista {
    public Posizione firstList();
    public void insert(Object e, Posizione p);
    public Posizione succ(Posizione p);
    public Posizione pred(Posizione p);
    public boolean endList(Posizione p);
    public Object readList(Posizione p);
}
