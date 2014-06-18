package it.uniba.di.itps.asd.exams.Lab20100608;

import it.uniba.di.itps.asd.exams.Lab20100608.dict.ArrayOrdinato;
import it.uniba.di.itps.asd.exams.Lab20100608.dict.Dictionary;
import it.uniba.di.itps.asd.exams.Lab20100608.serie.Serie;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: acidghost
 * Date: 17/06/14
 * Time: 19:04
 * To change this template use File | Settings | File Templates.
 */
public class Istogramma<T> implements Iterable<T> {

    protected Dictionary<T> istogr;

    /**
     * Crea un nuovo istogramma
     */
    public Istogramma() {
        this.istogr = new ArrayOrdinato<T>();
    }

    /**
     * Aggiunge una serie all'istogramma
     * @param serie
     */
    public void aggiungiSerie(Serie<T> serie) {}

    /**
     * Aggiunge un valore alla serie dell'istogramma
     * @param serie
     * @param valore
     */
    public void aggiungiValore(Serie<T> serie, T valore) {}

    /**
     * Ritorna la lunghezza di una serie
     * @param serie
     * @return
     */
    public int lunghSerie(Serie<T> serie) {
        return 0;
    }

    /**
     * Ritorna il valore della serie alla data posizione
     * @param serie
     * @param pos
     * @return
     */
    public T valore(Serie<T> serie, int pos) {
        return null;
    }

    /**
     * Restituisce il massimo valore di una serie
     * @param serie
     * @return
     */
    public T massimo(Serie<T> serie) {
        return null;
    }

    /**
     * Stabilisce se una serie è monotona crescente
     * @param serie
     * @return
     */
    public boolean crescente(Serie<T> serie) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
