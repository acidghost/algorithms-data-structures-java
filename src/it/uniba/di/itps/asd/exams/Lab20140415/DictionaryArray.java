package it.uniba.di.itps.asd.exams.Lab20140415;

import java.util.Iterator;

/**
 * Created by acidghost on 02/09/14.
 */
public class DictionaryArray<S> implements Dictionary<S> {
    private Pair<S>[] dictionary = new Pair[1];
    private int n = 0;

    class Pair<S> {
        Comparable key;
        S value;

        Pair(Comparable key, S value) {
            this.key = key;
            this.value = value;
        }
    }

    @Override
    public void insert(S e, Comparable k) {
        if(search(k) != null) {
            throw new EntryAlreadyExistsException();
        }
        if(n == dictionary.length) {
            Pair[] tmp = new Pair[n * 2];
            System.arraycopy(dictionary, 0, tmp, 0, n);
            dictionary = tmp;
        }
        dictionary[n] = new Pair<S>(k, e);
        n++;
    }

    @Override
    public void delete(Comparable k) {
        for(int i=0; i<n; i++) {
            if(dictionary[i].key.compareTo(k) == 0) {
                //System.arraycopy(dictionary, i+1, dictionary, i, n-i-1);
                if(i == n-1) {
                    dictionary[i] = null;
                }
                System.arraycopy(dictionary, i + 1, dictionary, i, n - i -1);
                n--;
                if(n < dictionary.length/4) {
                    Pair[] tmp = new Pair[dictionary.length / 2];
                    System.arraycopy(dictionary, 0, tmp, 0, n);
                    dictionary = tmp;
                }
                return;
            }
        }
    }

    @Override
    public S search(Comparable k) {
        for(int i=0; i<n; i++) {
            if(dictionary[i].key.compareTo(k) == 0) {
                return dictionary[i].value;
            }
        }
        return null;
    }

    @Override
    public Iterator<Comparable> iterator() {
        return new Iterator<Comparable>() {
            private int current = 0;

            @Override
            public boolean hasNext() {
                return current < n;
            }

            @Override
            public Comparable next() {
                return dictionary[current++].key;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
