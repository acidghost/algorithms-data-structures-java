package it.uniba.di.itps.asd.structures.graph;

/**
 * Created by acidghost on 01/09/14.
 */
public class InvalidNodeException extends RuntimeException {
    public InvalidNodeException() {
        super();
    }

    public InvalidNodeException(String message) {
        super(message);
    }
}
