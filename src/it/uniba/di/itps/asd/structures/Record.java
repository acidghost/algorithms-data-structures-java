package it.uniba.di.itps.asd.structures;

/**
 * Created by acidghost on 12/06/14.
 */
class Record {
    Comparable key;
    Object value;
    Record prev;
    Record next;

    Record(Comparable k, Object v) {
        this.key = k;
        this.value = v;
        prev = next = null;
    }
}
