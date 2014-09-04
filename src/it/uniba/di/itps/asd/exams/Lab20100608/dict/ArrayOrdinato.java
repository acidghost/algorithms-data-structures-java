package it.uniba.di.itps.asd.exams.Lab20100608.dict;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: acidghost
 * Date: 17/06/14
 * Time: 19:16
 * To change this template use File | Settings | File Templates.
 */
public class ArrayOrdinato<T> implements Dictionary<T> {
    Coppia[] lista;

    public ArrayOrdinato() {
        lista = new Coppia[0];
    }

    private int searchPositionInsert(Comparable k) {
        int i=0, j=lista.length-1, m;
        while (i<j) {
            m = (i+j)/2;
            int comp = k.compareTo(lista[m].key);
            if(comp == 0) {
                return m;
            } else if(comp > 0) {
                i = m+1;
            } else {
                j = m;
            }
        }
        return -1;
    }

    @Override
    public void insert(T e, Comparable k) {
        int pos = searchPositionInsert(k);
        Coppia[] tmp = new Coppia[lista.length+1];
        for(int i=0; i<pos; i++) {
            tmp[i] = lista[i];
        }
        tmp[pos] = new Coppia(e, k);
        for(int i=pos+1; i<tmp.length; i++) {
            tmp[i] = lista[i-1];
        }
        lista = tmp;
    }

    @Override
    public void delete(Comparable k) {
        if(search(k) != null) {
            int i=0, j=lista.length-1, m;
            while(i<j) {
                m = (i+j)/2;
                if(k.compareTo(lista[m].key) == 0) {
                    Coppia[] tmp = new Coppia[lista.length-1];
                    for(int z=0; z<m; z++) {
                        tmp[z] = lista[z];
                    }
                    for(int z=m+1; z<lista.length; z++) {
                        tmp[z-1] = lista[z];
                    }
                    lista = tmp;
                    return;
                } else if(k.compareTo(lista[m].key) < 0) {
                    j = m - 1;
                } else {
                    i = m + 1;
                }
            }
        }
    }

    @Override
    public T search(Comparable k) {
        int i=0, j=lista.length-1, m;
        while(i<j) {
            m = (i+j)/2;
            int comp = k.compareTo(lista[m].key);
            if(comp == 0) {
                return (T) lista[m].value;
            } else if(comp > 0) {
                i = m+1;
            } else {
                j = m-1;
            }
        }
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayOrdinatoIterator<T>(this, lista);
    }
}
