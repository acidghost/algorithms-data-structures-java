package it.uniba.di.itps.asd.exams.Lab20120907.lista;

/**
 * Created by acidghost on 04/09/14.
 */
class Pointer<T> implements Posizione<T> {
    T value;
    Pointer next;
    Pointer prev;

    Pointer(T value) {
        this.value = value;
        next = prev = null;
    }
}
