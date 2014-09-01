package it.uniba.di.itps.asd.exams.Lab20140702.dict;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: acidghost
 * Date: 31/08/14
 * Time: 18:30
 * To change this template use File | Settings | File Templates.
 */
public class LinkedDictIterator<K, V> implements Iterator<K> {
    private Record<K, V> current;

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public K next() {
        K element = current.key;
        current = current.next;
        return element;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    public LinkedDictIterator(LinkedDict<K, V> dict) {
        current = dict.head;
    }
}
