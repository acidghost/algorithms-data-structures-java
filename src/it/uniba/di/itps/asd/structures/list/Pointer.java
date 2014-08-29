package it.uniba.di.itps.asd.structures.list;

/**
 * Created by acidghost on 28/08/14.
 */
class Pointer implements Position {
    public Cell link;

    public Pointer(Cell link) {
        this.link = link;
    }
}
