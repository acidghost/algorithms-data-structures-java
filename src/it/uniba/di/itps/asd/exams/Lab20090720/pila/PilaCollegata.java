package it.uniba.di.itps.asd.exams.Lab20090720.pila;

/**
 * Created by acidghost on 27/08/14.
 */
public class PilaCollegata<T> implements Pila<T> {
    private Record<T> top = null;

    @Override
    public boolean isEmpty() {
        return (top == null);
    }

    @Override
    public void push(T e) {
        Record<T> r = new Record<T>(e);
        r.next = top;
        top = r;
    }

    @Override
    public T top() {
        return top.value;
    }

    @Override
    public void pop() {
        if(isEmpty()) {
            throw new EccezioneStrutturaVuota("Pila vuota");
        }
        top = top.next;
    }
}
