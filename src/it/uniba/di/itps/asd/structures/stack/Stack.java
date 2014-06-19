package it.uniba.di.itps.asd.structures.stack;

import it.uniba.di.itps.asd.structures.exceptions.EmptyStructureException;

/**
 * Created by acidghost on 19/06/14.
 */
public interface Stack<T> {

    public boolean isEmpty();
    public void push(T e);
    public T top() throws EmptyStructureException;
    public void pop() throws EmptyStructureException;

}
