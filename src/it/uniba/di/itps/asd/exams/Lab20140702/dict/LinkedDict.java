package it.uniba.di.itps.asd.exams.Lab20140702.dict;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: acidghost
 * Date: 31/08/14
 * Time: 18:08
 * To change this template use File | Settings | File Templates.
 */
public class LinkedDict<K, V> implements Dictionary<K, V> {
    protected Record<K, V> head = null;

    @Override
    public void insert(K key, V value) {
        Record<K, V> r = head;
        Record<K, V> newRecord = new Record<K, V>(key, value, null);
        if(head == null) {
            head = newRecord;
            return;
        }
        while (r != null) {
            if (r.key.equals(key)) {
                r.value = value;
                return;
            }
            if(r.next == null) {
                r.next = newRecord;
                return;
            }
            r = r.next;
        }
    }

    @Override
    public void delete(K key) {
        Record<K, V> r = head;
        if(r.key.equals(key)) {
            head = r.next;
            return;
        }
        while(r != null) {
            if(r.next != null && r.next.key.equals(key)) {
                r.next = r.next.next;
            }
            r = r.next;
        }
    }

    @Override
    public V search(K key) {
        Record<K, V> r = head;
        while(r != null) {
            if(r.key.equals(key)) {
                return r.value;
            }
            r = r.next;
        }
        return null;
    }

    @Override
    public Iterator<K> iterator() {
        return new LinkedDictIterator<K, V>(this);
    }
}
