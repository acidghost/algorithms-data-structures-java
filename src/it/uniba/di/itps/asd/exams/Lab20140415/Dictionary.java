package it.uniba.di.itps.asd.exams.Lab20140415;

/**
 * Created by acidghost on 02/09/14.
 */
public interface Dictionary<S> extends Iterable<Comparable> {
    public void insert(S e, Comparable k);
    public void delete(Comparable k);
    public S search(Comparable k);
}
