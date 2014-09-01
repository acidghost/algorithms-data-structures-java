package it.uniba.di.itps.asd.structures.graph;

/**
 * Created by acidghost on 01/09/14.
 */
public class NodeExistsException extends RuntimeException {
    public NodeExistsException() {
        super();
    }

    public NodeExistsException(String message) {
        super(message);
    }
}
