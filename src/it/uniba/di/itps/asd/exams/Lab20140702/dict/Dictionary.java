package it.uniba.di.itps.asd.exams.Lab20140702.dict;

/**
 * Created with IntelliJ IDEA.
 * User: acidghost
 * Date: 31/08/14
 * Time: 18:07
 * To change this template use File | Settings | File Templates.
 */
public interface Dictionary<K, V> extends Iterable<K> {
    public void insert(K key, V value);
    public void delete(K key);
    public V search(K key);
}
