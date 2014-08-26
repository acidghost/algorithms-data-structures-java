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
            return coda[fine-1];
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
                fine = n+1;
            }
            fine--;
            n--;
        }
    }

    @Override
    public void inpila(Object elemento) {
        if(n == coda.length) {
            Object[] tmp = new Object[n * 2];
            System.arraycopy(coda, 0, tmp, (n/4)+1, n);
            coda = tmp;
            inizio = (n/4);
            fine = inizio+n+1;
        }
        if(inizio < 0 || coda[inizio] != null) {
            for(int i=fine-1; i>=inizio && i>=0; i--) {
                coda[i+(n/4)+1] = coda[i];
            }
            inizio = inizio < 0 ? 0 : inizio;
            fine = inizio+n+1;
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
            return coda[inizio+1];
        }
    }

    @Override
    public void fuoritesta() {
        if(codavuota()) {
            throw new EmptyStructureException("Deque vuota");
        } else {
            if(n <= coda.length/4) {
                Object[] tmp = new Object[coda.length/2];
                System.arraycopy(coda, inizio+1, tmp, n/4, n);
                coda = tmp;
                inizio = (n/4)-1;
                fine = inizio + n + 1;
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
