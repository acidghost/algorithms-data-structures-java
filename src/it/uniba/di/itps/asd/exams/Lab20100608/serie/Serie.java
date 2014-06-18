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

    @Override
    public void add(Object dato) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public T getElement(int i) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int numberElements() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public T getMaximum(Comparator c) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean growing(Comparator c) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Iterator<T> iterator() {
        return new SerieIterator<T>(this);
    }

}
