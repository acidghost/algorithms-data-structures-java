package it.uniba.di.itps.asd.exams.Lab20110614.dict;

import java.util.Iterator;

/**
 * Created by acidghost on 18/06/14.
 */
public class ArrayOrdinato<S> implements Dictionary<S> {
    private Coppia<S>[] lista = new Coppia[0];

    @Override
    public void insert(S e, Comparable k) {
        if(search(k) != null) {
            throw new ChiaveDuplicataException("Chiave " + k.toString() + " duplicata");
        } else {
            int i;
            Coppia<S>[] tmp = new Coppia[lista.length+1];
            for(i=0; i<lista.length && k.compareTo(lista[i].key) <= 0; i++) {
                tmp[i] = lista[i];
            }
            tmp[i] = new Coppia<S>(e, k);
            for(int j=i; j<lista.length; j++) {
                tmp[j+1] = lista[j];
            }
            lista = tmp;
        }
    }

    @Override
    public void delete(Comparable k) {
        if(search(k) == null) {
            throw new ChiaveNonValidaException("Chiave " + k.toString() + " non valida");
        } else {
            int pos = Integer.parseInt(search(k, false).toString());
            Coppia<S>[] tmp = new Coppia[lista.length-1];
            for(int i=0; i<pos; i++) {
                tmp[i] = lista[i];
            }
            for(int i=pos+1; i<lista.length; i++) {
                tmp[i-1] = lista[i];
            }
            lista = tmp;
        }
    }

    @Override
    public S search(Comparable k) {
        return (S) search(k, true);
    }

    @Override
    public Iterator<S> iterator() {
        return new ArrayOrdinatoIterator<S>(this, lista);
    }

    private Object search(Comparable k, boolean returnValue) {
        int i=0, j=lista.length, m;
        while(i<j) {
            m = (i+j)/2;
            int comp = k.compareTo(lista[m].key);
            if(comp == 0) {
                return returnValue ? lista[m].value : m;
            } else if(comp > 0) {
                j = m;
            } else {
                i = m+1;
            }
        }

        return returnValue ? null : -1;
    }
}
