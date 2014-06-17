package it.uniba.di.itps.asd.exams.Lab20100608;

import it.uniba.di.itps.asd.exams.Lab20100608.dict.Dictionary;

/**
 * Created with IntelliJ IDEA.
 * User: acidghost
 * Date: 17/06/14
 * Time: 19:04
 * To change this template use File | Settings | File Templates.
 */
public class Istogramma {

    protected Dictionary istogr;

    /**
     * Crea un nuovo istogramma
     */
    public Istogramma() {}

    /**
     * Aggiunge una serie all'istogramma
     * @param serie
     */
    public void aggiungiSerie(Serie serie) {}

    /**
     * Aggiunge un valore alla serie dell'istogramma
     * @param serie
     * @param valore
     */
    public void aggiungiValore(Serie serie, Object valore) {}

    /**
     * Ritorna la lunghezza di una serie
     * @param serie
     * @return
     */
    public int lunghSerie(Serie serie) {
        return 0;
    }

    /**
     * Ritorna il valore della serie alla data posizione
     * @param serie
     * @param pos
     * @return
     */
    public Object valore(Serie serie, int pos) {
        return null;
    }

    /**
     * Restituisce il massimo valore di una serie
     * @param serie
     * @return
     */
    public Object massimo(Serie serie) {
        return null;
    }

    /**
     * Stabilisce se una serie è monotona crescente
     * @param serie
     * @return
     */
    public boolean crescente(Serie serie) {
        return false;
    }

}
