package it.uniba.di.itps.asd.structures.queue;

import it.uniba.di.itps.asd.structures.exceptions.EmptyStructureException;

/**
 * Created by acidghost on 19/06/14.
 */
public class LinkedQueue implements Queue {
    private Record inizio = null;
    private Record fine = null;

    @Override
    public boolean isEmpty() {
        return (inizio == null);
    }

    @Override
    public void enqueue(Object e) {
        if(isEmpty()) {
            inizio = fine = new Record(e);
        } else {
            fine.next = new Record(e);
            fine = fine.next;
        }
    }

    @Override
    public void dequeue() {
        if(isEmpty()) {
            throw new EmptyStructureException("Coda vuota");
        } else {
            inizio = inizio.next;
        }
    }

    @Override
    public Object first() {
        if(isEmpty()) {
            throw new EmptyStructureException("Coda vuota");
        } else {
            return inizio.element;
        }
    }
}
