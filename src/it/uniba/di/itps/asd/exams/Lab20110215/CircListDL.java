package it.uniba.di.itps.asd.exams.Lab20110215;

import java.util.Iterator;

/**
 * Created by acidghost on 04/09/14.
 */
public class CircListDL<T> implements CircList<T> {
    private Cella<T> head = new Cella<T>(null);
    private int n = 0;
    private Direzione direzione = Direzione.FORWARD;

    @Override
    public void addCircList(T item) {
        Cella<T> cella = new Cella<T>(item);
        if(head.next == head) {
            head.next = cella;
            head.prev = cella;
            cella.next = cella.prev = head;
        } else {
            cella.prev = head.prev;
            cella.next = head;
            head.prev.next = cella;
            head.prev = cella;
        }
        n++;
    }

    @Override
    public void delCircList() {
        if(isEmpty()) {
            throw new EccezioneListaVuota();
        }
        if(head.next.next == head) {
            head.next = head.prev = head;
        } else {
            head.next.next.prev = head;
            head.next = head.next.next;
        }
        n--;
    }

    @Override
    public T value() {
        if(isEmpty()) {
            throw new EccezioneListaVuota();
        }
        return head.value;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public int numItem() {
        return n;
    }

    @Override
    public void setDir(Direzione direzione) {
        this.direzione = direzione;
    }

    @Override
    public void ruota() {
        if(n < 2) {
            return;
        }
        /*
        if(direzione == Direzione.FORWARD) {
            Cella<T> c = head.next;
            c.next = head.prev;
            c.prev = head;
            head.prev = c;
            head.next = head.next.next;
        } else {
            Cella<T> c = head.prev;
            c.prev = head;
            c.next = head.next;
            head.prev = head.prev.prev;
            head.next = c;
        }
        */
        if(direzione == Direzione.FORWARD) {
            Cella<T> c = head.next;
            c.next = head.prev;
            c.prev = head;
            head.prev.prev = c;
            head.prev = c;
            head.next = head.next.next;
            head.next.prev = head;
        } else {
            Cella<T> c = head.prev;
            c.prev = head;
            c.next = head.next;
            head.prev = head.prev.prev;
            head.next = c;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Cella<T> current = (direzione == Direzione.FORWARD ? head.next : head.prev);

            @Override
            public boolean hasNext() {
                return current != head;
            }

            @Override
            public T next() {
                T e = current.value;
                current = (direzione == Direzione.FORWARD ? current.next : current.prev);
                return e;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
