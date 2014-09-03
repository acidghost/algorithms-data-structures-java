package it.uniba.di.itps.asd.exams.Lab20130627.albero;

/**
 * Created by acidghost on 03/09/14.
 */
public interface ABD<E> extends Iterable<E> {
    public void aggiungiRadice(E e);
    public void innestaVero(Nodo<E> u, ABD albero);
    public void innestaFalso(Nodo<E> u, ABD albero);
    public boolean foglia(Nodo<E> u);
    public Nodo<E> radice();
    public Nodo<E> vero(Nodo<E> u);
    public Nodo<E> falso(Nodo<E> u);
    public E info(Nodo<E> u);
}
