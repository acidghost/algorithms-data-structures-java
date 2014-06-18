package it.uniba.di.itps.asd.exams.Lab20100608.serie;

import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: acidghost
 * Date: 17/06/14
 * Time: 18:58
 * To change this template use File | Settings | File Templates.
 */
public interface CompList<T> extends Iterable<T> {

    /**
     * Accoda dato alla lista
     * @param dato
     */
    public void add(T dato);

    /**
     * Ritorna elemento i-esimo
     * @param i
     * @return
     */
    public T getElement(int i);

    /**
     * Ritorna il numero di elementi
     * @return
     */
    public int numberElements();

    /**
     * Ritorna il massimo
     * @param c
     * @return
     */
    public T getMaximum(Comparator c);

    /**
     * Stabilisce se gli elementi della lista sono in ordine crescente
     * @param c
     * @return
     */
    public boolean growing(Comparator c);

}
