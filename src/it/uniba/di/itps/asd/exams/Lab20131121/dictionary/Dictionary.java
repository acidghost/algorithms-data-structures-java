package it.uniba.di.itps.asd.exams.Lab20131121.dictionary;

/**
 * Created by acidghost on 02/09/14.
 */
public interface Dictionary<V> extends Iterable<Comparable> {
    public void insert(Comparable k, V v);
    public void delete(Comparable k);
    public V search(Comparable k);
}
