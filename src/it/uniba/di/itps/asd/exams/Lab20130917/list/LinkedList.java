package it.uniba.di.itps.asd.exams.Lab20130917.list;

import java.util.Iterator;

/**
 * Created by acidghost on 03/09/14.
 */
public class LinkedList<S> implements AddOnlyList<S> {
    private Record head = null;

    private class Record {
        S value;
        Record next;

        Record(S value) {
            this.value = value;
            next = null;
        }
    }

    @Override
    public void add(S e) {
        if(head == null) {
            head = new Record(e);
        } else {
            Record r = head;
            while (r != null) {
                if(r.next == null) {
                    r.next = new Record(e);
                    return;
                }
                r = r.next;
            }
        }
    }

    @Override
    public Iterator<S> iterator() {
        return new Iterator<S>() {
            private Record current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public S next() {
                S e = current.value;
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
