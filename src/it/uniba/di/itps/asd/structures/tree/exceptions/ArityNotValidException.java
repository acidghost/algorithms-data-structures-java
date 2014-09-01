package it.uniba.di.itps.asd.structures.tree.exceptions;

/**
 * Created by acidghost on 30/08/14.
 */
public class ArityNotValidException extends RuntimeException {
    public ArityNotValidException() {}

    public ArityNotValidException(String message) {
        super(message);
    }
}
