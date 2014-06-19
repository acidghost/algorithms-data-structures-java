package it.uniba.di.itps.asd.exams.Lab20100608.serie;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: acidghost
 * Date: 17/06/14
 * Time: 19:02
 * To change this template use File | Settings | File Templates.
 */
public class Serie<T> implements CompList<T> {

    public String name;

    private List<T> lista = new ArrayList<T>();

    public Serie(String name) {
        this.name = name;
    }

    @Override
    public void add(T dato) {
        lista.add(dato);
    }

    @Override
    public T getElement(int i) {
        return lista.get(i);
    }

    @Override
    public int numberElements() {
        return lista.size();
    }

    @Override
    public T getMaximum(Comparator c) {
        T max = lista.get(0);
        for(int i=1; i<lista.size(); i++) {
            T current = lista.get(i);
            if(c.compare(current, max) > 0) {
                max = current;
            }
        }
        return max;
    }

    @Override
    public boolean growing(Comparator c) {
        boolean grows = true;
        for(int i=0; i<lista.size()-1 && grows; i++) {
            if(c.compare(lista.get(i), lista.get(i+1)) > 0) {
                grows = false;
            }
        }
        return grows;
    }

    @Override
    public Iterator<T> iterator() {
        return new SerieIterator<T>(this);
    }

}
