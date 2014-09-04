package it.uniba.di.itps.asd.exams.Lab20110215;

/**
 * Created by acidghost on 04/09/14.
 */
class Cella<T> {
    T value;
    Cella<T> next, prev;

    Cella(T value) {
        this.value = value;
        next = prev = this;
    }
}
