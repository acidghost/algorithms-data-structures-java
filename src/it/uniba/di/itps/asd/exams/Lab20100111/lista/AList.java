package it.uniba.di.itps.asd.exams.Lab20100111.lista;

/**
 * Created by acidghost on 16/06/14.
 */
public class AList implements ListaSemplice {
    private Object[] lista = new Object[0];
    private int pointer = 0;

    @Override
    public void add(Object o) {
        Object[] tmp = new Object[lista.length+1];
        for(int i=0; i<lista.length; i++) {
            tmp[i] = lista[i];
        }
        tmp[tmp.length-1] = o;
        lista = tmp;
    }

    @Override
    public void reset() {
        pointer = 0;
    }

    @Override
    public Object next() {
        int tmp = pointer;
        pointer++;
        return lista[tmp];
    }

    @Override
    public boolean hasNext() {
        return pointer <= lista.length-1;
    }
}
