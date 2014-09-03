package it.uniba.di.itps.asd.exams.Lab20131121;

import it.uniba.di.itps.asd.exams.Lab20131121.dictionary.Dictionary;
import it.uniba.di.itps.asd.exams.Lab20131121.dictionary.LinkedDictionary;

import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * Created by acidghost on 02/09/14.
 */
public class Carrello implements Iterable<Articolo> {
    protected Dictionary<Integer> carrello = new LinkedDictionary<Integer>();

    public void aggArticolo(Articolo articolo) {
        Integer q = carrello.search(articolo);
        if(q == null) {
            carrello.insert(articolo, 1);
        } else {
            carrello.delete(articolo);
            carrello.insert(articolo, q+1);
        }
    }

    public void togliArticolo(Articolo articolo) {
        Integer q = carrello.search(articolo);
        if(q == null) {
            throw new NoSuchElementException();
        } else {
            carrello.delete(articolo);
        }
    }

    public int quantita(Articolo articolo) {
        Integer q = carrello.search(articolo);
        if(q == null) {
            return 0;
        } else {
            return q;
        }
    }

    public boolean vuoto() {
        for (Comparable a : carrello)
            return false;
        return true;
    }

    public boolean appartiene(Articolo articolo) {
        return quantita(articolo) != 0;
    }

    public int numArticoliDistinti() {
        Set<Articolo> l = new HashSet<Articolo>();
        for(Comparable a : carrello) {
            l.add((Articolo) a);
        }
        return l.size();
    }

    @Override
    public Iterator<Articolo> iterator() {
        return new Iterator<Articolo>() {
            Iterator<Comparable> iterator = carrello.iterator();

            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Articolo next() {
                return (Articolo) iterator.next();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
