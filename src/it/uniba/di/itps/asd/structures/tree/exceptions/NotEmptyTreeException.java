package it.uniba.di.itps.asd.structures.tree.exceptions;

/**
 * Created by acidghost on 29/08/14.
 */
public class NotEmptyTreeException extends RuntimeException {
    public NotEmptyTreeException() {}

    public NotEmptyTreeException(String msg) {
        super(msg);
    }
}
