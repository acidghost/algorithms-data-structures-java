package it.uniba.di.itps.asd.exams.Lab20110614.dict;

/**
 * Created by acidghost on 18/06/14.
 */
public interface Dictionary<S> extends Iterable<S> {

    public void insert(S e, Comparable k);
    public void delete(Comparable k);
    public S search(Comparable k);

}
