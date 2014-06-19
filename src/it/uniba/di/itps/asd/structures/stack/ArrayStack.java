package it.uniba.di.itps.asd.structures.stack;

import it.uniba.di.itps.asd.structures.exceptions.EmptyStructureException;

/**
 * Created by acidghost on 19/06/14.
 */
public class ArrayStack<T> implements Stack<T> {
    @SuppressWarnings("unchecked")
    private T[] S = (T[]) new Object[1];
    private int n = 0;

    @Override
    public boolean isEmpty() {
        return (n == 0);
    }

    @Override
    public void push(T e) {
        if(n == S.length) {
            @SuppressWarnings("unchecked")
            T[] tmp = (T[]) new Object[S.length * 2];
            System.arraycopy(S, 0, tmp, 0, S.length);
            S = tmp;
        }
        S[n] = e;
        n++;
    }

    @Override
    public T top() throws EmptyStructureException {
        if(isEmpty()) {
            throw new EmptyStructureException("Pila vuota");
        } else {
            return S[n-1];
        }
    }

    @Override
    public void pop() throws EmptyStructureException {
        if(isEmpty()) {
            throw new EmptyStructureException("Pila vuota");
        } else {
            n--;
        }
    }
}
