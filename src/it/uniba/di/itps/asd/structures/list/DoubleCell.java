package it.uniba.di.itps.asd.structures.list;

/**
 * Created by acidghost on 29/08/14.
 */
class DoubleCell {
    Object value;
    DoublePointer next;
    DoublePointer previous;

    public DoubleCell() {
        next = previous = null;
    }

    public DoubleCell(Object value) {
        this();
        this.value = value;
    }
}
