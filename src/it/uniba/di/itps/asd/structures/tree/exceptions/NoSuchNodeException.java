package it.uniba.di.itps.asd.structures.tree.exceptions;

import java.util.NoSuchElementException;

/**
 * Created by acidghost on 30/08/14.
 */
public class NoSuchNodeException extends NoSuchElementException {
    public NoSuchNodeException() {
        super();
    }

    public NoSuchNodeException(String message) {
        super(message);
    }
}
