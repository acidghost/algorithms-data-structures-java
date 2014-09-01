package it.uniba.di.itps.asd.exams.Lab20100222;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by acidghost on 02/09/14.
 */
public class ListaArray<T> implements ListaIndicizzata<T> {
    private Record<T>[] lista = new Record[1];
    private int n = 0;

    class Record<T> {
        T value;
        int index;

        Record(T value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    @Override
    public boolean isEmpty() {
        return (n == 0);
    }

    private Record<T> searchElement(int i) {
        for (int i1 = 0; i1 < n; i1++) {
            Record<T> r = lista[i1];
            if (r.index == i)
                return r;
        }
        return null;
    }

    @Override
    public void addElement(T e, int i) {
        if(searchElement(i) != null) {
            throw new ElementAlreadyExistsException();
        }
        if(n == lista.length) {
            Record<T>[] tmp = new Record[n * 2];
            System.arraycopy(lista, 0, tmp, 0, n);
            lista = tmp;
        }
        lista[n] = new Record<T>(e, i);
        n++;
    }

    @Override
    public T getElement(int i) {
        if(n == 0) {
            throw new EmptyStructureException();
        }
        Record<T> r = searchElement(i);
        if(r == null) {
            throw new NoSuchElementException();
        }
        return r.value;
    }

    @Override
    public int numberElements() {
        return n;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int current = 0;

            @Override
            public boolean hasNext() {
                return (current < n);
            }

            @Override
            public T next() {
                return lista[current++].value;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        ListaArray<String> l = new ListaArray<String>();
        l.addElement("terza", 3);
        l.addElement("prima", 1);
        l.addElement("seconda", 2);

        for(String s : l) {
            System.out.println(s);
        }
        for (int i = 1; i < 4; i++) {
            System.out.println(l.getElement(i));
        }
    }
}
