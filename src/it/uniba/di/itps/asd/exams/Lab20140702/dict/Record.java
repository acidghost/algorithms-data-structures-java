package it.uniba.di.itps.asd.exams.Lab20140702.dict;

/**
 * Created with IntelliJ IDEA.
 * User: acidghost
 * Date: 31/08/14
 * Time: 18:37
 * To change this template use File | Settings | File Templates.
 */
class Record<K, V> {
    K key;
    V value;
    Record<K, V> next;

    Record(K key, V value) {
        this.key = key;
        this.value = value;
    }

    Record(K key, V value, Record<K, V> next) {
        this(key, value);
        this.next = next;
    }
}
