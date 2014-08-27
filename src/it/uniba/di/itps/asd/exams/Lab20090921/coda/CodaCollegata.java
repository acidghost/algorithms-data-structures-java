package it.uniba.di.itps.asd.exams.Lab20090921.coda;

/**
 * Created by acidghost on 27/08/14.
 */
public class CodaCollegata<T> implements Coda<T> {
    private Record<T> inizio = null;
    private Record<T> fine = null;

    @Override
    public boolean isEmpty() {
        return (inizio == null);
    }

    @Override
    public void enqueue(T e) {
        if(isEmpty()) {
            inizio = fine = new Record<T>(e);
        } else {
            fine.next = new Record<T>(e);
            fine = fine.next;
        }
    }

    @Override
    public T first() {
        return inizio.value;
    }

    @Override
    public void dequeue() {
        inizio = inizio.next;
    }
}
