package it.uniba.di.itps.asd.exams.Lab20140702.list;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: acidghost
 * Date: 31/08/14
 * Time: 17:53
 * To change this template use File | Settings | File Templates.
 */
public class VectorList<S> implements AddOnlyList<S> {
    protected S[] vector = (S[]) new Object[1];
    protected int n = 0;

    @Override
    public String toString() {
        String s = "";
        for(int i=0; i<n; i++) {
            s += vector[i].toString() + ", ";
        }
        s = s.trim();
        return s.substring(0, s.length()-1);
    }

    @Override
    public void add(S e) {
        if(n == vector.length) {
            S[] tmp = (S[]) new Object[n * 2];
            System.arraycopy(vector, 0, tmp, 0, n);
            vector = tmp;
        }
        vector[n] = e;
        n++;
    }

    @Override
    public Iterator<S> iterator() {
        return new VectorListIterator<S>(this);
    }
}
