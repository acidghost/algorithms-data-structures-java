package it.uniba.di.itps.asd.structures.list;

/**
 * Created by acidghost on 29/08/14.
 */
class DoublePointer implements Position {
    public DoubleCell link;

    public DoublePointer(DoubleCell link) {
        this.link = link;
    }
}
