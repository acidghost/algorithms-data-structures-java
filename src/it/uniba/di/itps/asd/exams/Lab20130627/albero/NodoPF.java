package it.uniba.di.itps.asd.exams.Lab20130627.albero;

/**
 * Created by acidghost on 03/09/14.
 */
class NodoPF<T> implements Nodo<T> {
    T e;
    NodoPF<T> vero;
    NodoPF<T> falso;
    ABDPF<T> albero;

    NodoPF(T e, ABDPF<T> albero) {
        this.e = e;
        this.albero = albero;
        vero = falso = null;
    }
}
