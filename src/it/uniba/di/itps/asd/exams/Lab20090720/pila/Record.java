package it.uniba.di.itps.asd.exams.Lab20090720.pila;

/**
 * Created by acidghost on 27/08/14.
 */
public class Record<T> {
    protected T value;
    protected Record<T> next;

    Record() {
        value = null;
        next = null;
    }

    Record(T value) {
        this();
        this.value = value;
    }
}
