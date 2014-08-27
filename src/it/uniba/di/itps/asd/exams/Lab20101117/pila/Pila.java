package it.uniba.di.itps.asd.exams.Lab20101117.pila;

/**
 * Created by acidghost on 27/08/14.
 */
public interface Pila<T> {

    public boolean isEmpty();
    public void push(T e);
    public T top();
    public void pop();

}
