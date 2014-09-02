package it.uniba.di.itps.asd.exams.Lab20140415;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by acidghost on 02/09/14.
 */
public class Bag implements Iterable {
    protected Dictionary<Integer> freqParole = new DictionaryArray<Integer>();
    private List<Comparable> words = new LinkedList<Comparable>();

    public void addItem(Comparable item) {
        Integer i = freqParole.search(item);
        if(i != null) {
            freqParole.delete(item);
            freqParole.insert(i+1, item);
        } else {
            freqParole.insert(1, item);
            words.add(item);
        }
    }

    public void delItem(Comparable item) {
        if(isEmpty()) {
            throw new EmptyStructureException();
        }
        freqParole.delete(item);
        words.remove(item);
    }

    public int occurrences(Comparable item) {
        Integer i = freqParole.search(item);
        if(i != null) {
            return i;
        } else {
            return 0;
        }
    }

    public boolean isEmpty() {
        Iterator it = freqParole.iterator();
        return it.hasNext();
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            private int n = 0;

            @Override
            public boolean hasNext() {
                return (n < words.size());
            }

            @Override
            public Object next() {
                return words.get(n++);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
