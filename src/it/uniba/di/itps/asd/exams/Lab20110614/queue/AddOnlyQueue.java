package it.uniba.di.itps.asd.exams.Lab20110614.queue;

/**
 * Created by acidghost on 18/06/14.
 */
public interface AddOnlyQueue<T> {

    /**
     * Aggiunge un elemento
     * @param dato
     */
    public void add(T dato);

    /**
     * Ritorna l'elemento i-esimo
     * @param i
     * @return
     */
    public T getElement(int i);

    /**
     * Ritorna il numero di elementi
     * @return
     */
    public int numberElements();

}
