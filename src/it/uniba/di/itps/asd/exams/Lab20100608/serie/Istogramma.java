package it.uniba.di.itps.asd.exams.Lab20100608.serie;

import it.uniba.di.itps.asd.exams.Lab20100608.dict.ArrayOrdinato;
import it.uniba.di.itps.asd.exams.Lab20100608.dict.Dictionary;
import it.uniba.di.itps.asd.exams.Lab20100608.serie.Serie;

import java.util.Comparator;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: acidghost
 * Date: 17/06/14
 * Time: 19:04
 * To change this template use File | Settings | File Templates.
 */
public class Istogramma<T> implements Iterable<T> {

    protected Dictionary<Serie<T>> istogr;

    /**
     * Crea un nuovo istogramma
     */
    public Istogramma() {
        this.istogr = new ArrayOrdinato<Serie<T>>();
    }

    /**
     * Aggiunge una serie all'istogramma
     * @param serie
     */
    public void aggiungiSerie(Serie<T> serie) {
        this.istogr.insert(serie, serie.name);
    }

    /**
     * Aggiunge un valore alla serie dell'istogramma
     * @param serie
     * @param valore
     */
    public void aggiungiValore(Serie<T> serie, T valore) {
        Serie<T> s = this.istogr.search(serie.name);
        if(s != null) {
            s.add(valore);
        } else {
            throw new SerieNonValidaException("La serie "+serie.name+" non valida");
        }
    }

    /**
     * Ritorna la lunghezza di una serie
     * @param serie
     * @return
     */
    public int lunghSerie(Serie<T> serie) {
        Serie<T> s = this.istogr.search(serie.name);
        if(s != null) {
            return s.numberElements();
        } else {
            throw new SerieNonValidaException("La serie "+serie.name+" non valida");
        }
    }

    /**
     * Ritorna il valore della serie alla data posizione
     * @param serie
     * @param pos
     * @return
     */
    public T valore(Serie<T> serie, int pos) {
        Serie<T> s = this.istogr.search(serie.name);
        if(s != null) {
            return s.getElement(pos);
        } else {
            throw new SerieNonValidaException("La serie "+serie.name+" non valida");
        }
    }

    /**
     * Restituisce il massimo valore di una serie
     * @param serie
     * @return
     */
    public T massimo(Serie<T> serie, Comparator comparator) {
        Serie<T> s = this.istogr.search(serie.name);
        if(s != null) {
            return s.getMaximum(comparator);
        } else {
            throw new SerieNonValidaException("La serie "+serie.name+" non valida");
        }
    }

    /**
     * Stabilisce se una serie è monotona crescente
     * @param serie
     * @return
     */
    public boolean crescente(Serie<T> serie, Comparator comparator) {
        Serie<T> s = this.istogr.search(serie.name);
        if(s != null) {
            return s.growing(comparator);
        } else {
            throw new SerieNonValidaException("La serie "+serie.name+" non valida");
        }
    }

    @Override
    public Iterator<T> iterator() {
        return (Iterator<T>) istogr.iterator();
    }
}
