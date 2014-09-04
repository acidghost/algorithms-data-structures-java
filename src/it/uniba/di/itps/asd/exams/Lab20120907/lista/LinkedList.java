package it.uniba.di.itps.asd.exams.Lab20120907.lista;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by acidghost on 04/09/14.
 */
public class LinkedList<T> implements Lista<T> {
    private Pointer<T> head = null;

    private Pointer<T> checkNode(Posizione<T> p) {
        if(p == null) {
            throw new NoSuchElementException();
        }
        return (Pointer<T>) p;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public Posizione firstList() {
        if(isEmpty()) {
            throw new EccezioneListaVuota();
        }
        return head;
    }

    @Override
    public boolean endList(Posizione<T> p) {
        return checkNode(p).next == null;
    }

    @Override
    public Posizione succ(Posizione<T> p) {
        if(endList(p)) {
            throw new NoSuchElementException();
        }
        return checkNode(p).next;
    }

    @Override
    public Posizione pred(Posizione<T> p) {
        if(head == p) {
            throw new NoSuchElementException();
        }
        return checkNode(p).prev;
    }

    @Override
    public void insert(T e, Posizione<T> p) {
        Pointer<T> newElement = new Pointer<T>(e);
        if(p == head) {
            newElement.next == head
        } else {

        }
        Pointer<T> posizione = checkNode(p);
        Pointer<T> pointer = head;

    }

    @Override
    public T read(Posizione<T> p) {
        return checkNode(p).value;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Pointer<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T v = current.value;
                current = current.next;
                return v;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
