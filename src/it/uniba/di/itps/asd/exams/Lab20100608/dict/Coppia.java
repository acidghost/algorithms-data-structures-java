package it.uniba.di.itps.asd.exams.Lab20100608.dict;

/**
 * Created by acidghost on 18/06/14.
 */
class Coppia<S> {

    public S value;
    public Comparable key;

    Coppia(S value, Comparable key) {
        this.value = value;
        this.key = key;
    }

}
