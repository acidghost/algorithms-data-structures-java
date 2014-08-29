package it.uniba.di.itps.asd.structures.tree.exceptions;

/**
 * Created by acidghost on 29/08/14.
 */
public class InvalidNodeException extends RuntimeException {
    public InvalidNodeException() {}

    public InvalidNodeException(String msg) {
        super(msg);
    }
}
