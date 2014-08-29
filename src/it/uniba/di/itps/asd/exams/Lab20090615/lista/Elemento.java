package it.uniba.di.itps.asd.exams.Lab20090615.lista;

/**
 * Created by acidghost on 29/08/14.
 */
class Elemento implements Posizione {
    Object value;
    Elemento next;
    Elemento prev;

    Elemento() {
        value = null;
        next = prev = this;
    }

    Elemento(Object value) {
        this();
        this.value = value;
    }
}
