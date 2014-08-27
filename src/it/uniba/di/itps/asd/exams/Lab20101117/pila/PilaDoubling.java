package it.uniba.di.itps.asd.exams.Lab20101117.pila;

/**
 * Created by acidghost on 27/08/14.
 */
public class PilaDoubling<T> implements Pila<T> {
    private T[] pila = (T[]) new Object[1];
    private int n = 0;

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public void push(T e) {
        if(n == pila.length) {
            T[] tmp = (T[]) new Object[n * 2];
            System.arraycopy(pila, 0, tmp, 0, n);
            pila = tmp;
        }
        pila[n] = e;
        n++;
    }

    @Override
    public T top() {
        if(isEmpty()) {
            throw new EccezioneStrutturaVuota("Pila vuota");
        } else {
            return pila[n-1];
        }
    }

    @Override
    public void pop() {
        if(n <= pila.length/4) {
            T[] tmp = (T[]) new Object[n / 2];
            System.arraycopy(pila, 0, tmp, 0, n);
            pila = tmp;
        }
        n--;
    }
}
