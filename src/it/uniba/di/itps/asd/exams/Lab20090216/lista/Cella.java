package it.uniba.di.itps.asd.exams.Lab20090216.lista;

/**
 * Created by acidghost on 29/08/14.
 */
class Cella {
    Comparable value;
    Puntatore next;

    Cella() {
        next = null;
    }

    Cella(Comparable value) {
        this();
        this.value = value;
    }

    public Cella(Comparable e, Puntatore next) {
        this(e);
        this.next = next;
    }
}
