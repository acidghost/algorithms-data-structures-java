package it.uniba.di.itps.asd.exams.Lab20131121.dictionary;

import java.util.Iterator;

/**
 * Created by acidghost on 02/09/14.
 */
public class LinkedDictionary<V> implements Dictionary<V> {
    private Pair head = null;

    private class Pair {
        V value;
        Comparable key;
        Pair next, parent;

        Pair(V value, Comparable key) {
            this.value = value;
            this.key = key;
            next = parent = null;
        }
    }

    @Override
    public void insert(Comparable k, V v) {
        if(isEmpty()) {
            head = new Pair(v, k);
        } else {
            if(search(k) == null) {
                Pair p = new Pair(v, k);
                p.next = head;
                head.parent = p;
                head = p;
            } else {
                throw new ElementAlreadyExistsException();
            }
        }
    }

    @Override
    public void delete(Comparable k) {
        if(isEmpty()) {
            throw new EmptyDictionaryException();
        }
        if(head.key.compareTo(k) == 0) {
            head = head.next;
            head.parent = null;
        } else {
            Pair p = head.next;
            while (p != null) {
                if(p.next==null) {
                    if(p.key.compareTo(k) == 0) {
                        p.parent.next = null;
                    }
                    return;
                }
                if(p.key.compareTo(k) == 0) {
                    p.parent.next = p.next;
                    p.next.parent = p.parent;
                    return;
                }
                p = p.next;
            }
        }
    }

    @Override
    public V search(Comparable k) {
        if(isEmpty()) {
            return null;
        }
        Pair p = head;
        while (p != null) {
            if(p.key.compareTo(k) == 0) {
                return p.value;
            }
            p = p.next;
        }
        return null;
    }

    private Pair searchPair(Comparable k) {
        Pair p = head;
        while (p != null) {
            if(p.key.compareTo(k) == 0) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    private boolean isEmpty() {
        return head == null;
    }

    @Override
    public Iterator<Comparable> iterator() {
        return new Iterator<Comparable>() {
            private Pair current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Comparable next() {
                Comparable e = current.key;
                current = current.next;
                return e;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
