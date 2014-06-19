package it.uniba.di.itps.asd.structures.dictionary;

import it.uniba.di.itps.asd.structures.exceptions.EmptyStructureException;

/**
 * Created by acidghost on 12/06/14.
 */
public class LinkedList implements Dictionary {
    Record list = null;

    @Override
    public void insert(Comparable k, Object v) {
        Record r = new Record(k, v);
        if(list == null) {
            list = r.next = r.prev = r;
        } else {
            r.next = list.next;
            list.next.prev = r;
            list.next = r;
            r.prev = list;
        }
    }

    @Override
    public void delete(Comparable k) throws EmptyStructureException {
        if(list == null) {
            throw new EmptyStructureException("Lista vuota");
        } else {
            Record r = list;
            do {
                if(k.compareTo(r.key) == 0) {
                    if(r == list) {
                        if(r.next == r) {
                            list = null;
                        } else {
                            list.next.prev = list.prev;
                            list.prev.next = list.next;
                            list = list.next;
                        }
                    } else {
                        r.next.prev = r.prev;
                        r.prev.next = r.next;
                    }
                    return;
                }
                r = r.next;
            } while(r!=list.prev);
        }
    }

    @Override
    public Object search(Comparable k) {
        if(list == null) return null;
        Record r = list;
        do {
            if(k.compareTo(r.key) == 0) {
                return r.value;
            }
            r = r.next;
        } while(r!=list.prev);
        return null;
    }
}
