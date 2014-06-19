package it.uniba.di.itps.asd.exams.Lab20110614.referendum;

import it.uniba.di.itps.asd.exams.Lab20110614.queue.AddOnlyQueue;

/**
 * Created by acidghost on 18/06/14.
 */
public class Quesito<T> implements AddOnlyQueue<T> {
    private T[] queue;
    private int top = 0;

    public String quesito;

    public Quesito() {
        this("NoName");
    }

    public Quesito(String quesito) {
        this.quesito = quesito;
        this.queue = (T[]) new Object[1];
    }

    @Override
    public void add(T dato) {
        if(top >= queue.length) {
            T[] tmp = (T[]) new Object[top*2];
            for(int i=0; i<queue.length; i++) {
                tmp[i] = queue[i];
            }
            queue = tmp;
        }
        queue[top] = dato;
        top++;
    }

    @Override
    public T getElement(int i) {
        if(i<0 || i>=top) {
            throw new IllegalArgumentException("Posizione non valida: " + i + " top: " + top);
        } else {
            return queue[i];
        }
    }

    @Override
    public int numberElements() {
        return top;
    }
}
