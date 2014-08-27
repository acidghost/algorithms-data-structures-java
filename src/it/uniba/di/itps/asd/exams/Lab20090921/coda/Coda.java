package it.uniba.di.itps.asd.exams.Lab20090921.coda;

/**
 * Created by acidghost on 27/08/14.
 */
public interface Coda<T> {
    public boolean isEmpty();
    public void enqueue(T e);
    public T first();
    public void dequeue();
}
