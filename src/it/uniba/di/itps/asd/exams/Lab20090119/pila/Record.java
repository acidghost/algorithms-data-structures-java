package it.uniba.di.itps.asd.exams.Lab20090119.pila;

/**
 * Created by acidghost on 26/08/14.
 */
public class Record {
    Object value;
    Record next;

    Record() {
        value = null;
        next = null;
    }

    Record(Object value) {
        this.value = value;
        next = null;
    }

    Record(Object value, Record next) {
        this(value);
        this.next = next;
    }
}
