package it.uniba.di.itps.asd.structures.queue;

/**
 * Created by acidghost on 19/06/14.
 */
class Record {

    Object element;
    Record next;

    Record(Object element) {
        this.element = element;
        next = null;
    }

}
