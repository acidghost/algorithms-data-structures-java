package it.uniba.di.itps.asd.structures.deque;

import it.uniba.di.itps.asd.structures.exceptions.EmptyStructureException;

/**
 * Created by acidghost on 19/06/14.
 */
public class ArrayDoubleQueue implements DoubleQueue {
    private Object[] coda = new Object[1];
    private int n = 0;
    private int inizio = 0;
    private int fine = 0;

    @Override
    public void accoda(Object elemento) {
        if(n == coda.length) {
            Object[] tmp = new Object[n * 2];
            inizio = 0;
            System.arraycopy(coda, inizio, tmp, 0, n);
            coda = tmp;
            inizio = 0;
            fine = n;
        }
        coda[fine] = elemento;
        n++;
        fine++;
    }

    @Override
    public Object leggicoda() {
        if(codavuota()) {
            throw new EmptyStructureException("Deque vuota");
        } else {
            return coda[fine];
        }
    }

    @Override
    public void fuoricoda() {
        if(codavuota()) {
            throw new EmptyStructureException("Deque vuota");
        } else {
            if(n <= coda.length/4) {
                Object[] tmp = new Object[coda.length/2];
                System.arraycopy(coda, inizio, tmp, 0, n);
                coda = tmp;
                inizio = 0;
                fine = n;
            }
            fine--;
            n--;
        }
    }

    @Override
    public void inpila(Object elemento) {
        if(n == coda.length) {
            Object[] tmp = new Object[n * 2];
            System.arraycopy(coda, inizio, tmp, (n/2), n);
            coda = tmp;
            inizio = (n/2)-1;
            fine = n;
        }
        coda[inizio] = elemento;
        inizio--;
        n++;
    }

    @Override
    public Object leggitesta() {
        if(codavuota()) {
            throw new EmptyStructureException("Deque vuota");
        } else {
            return coda[inizio];
        }
    }

    @Override
    public void fuoritesta() {
        if(codavuota()) {
            throw new EmptyStructureException("Deque vuota");
        } else {
            if(n <= coda.length/4) {
                Object[] tmp = new Object[coda.length/2];
                System.arraycopy(coda, inizio, tmp, n/2, n);
                coda = tmp;
                inizio = (n/2)-1;
                fine = n;
            }
            inizio++;
            n--;
        }
    }

    @Override
    public boolean codavuota() {
        return (n ==0);
    }
}
