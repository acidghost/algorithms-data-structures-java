package it.uniba.di.itps.asd.structures.tree.exceptions;

import it.uniba.di.itps.asd.structures.exceptions.EmptyStructureException;

/**
 * Created by acidghost on 29/08/14.
 */
public class EmptyTreeException extends EmptyStructureException {
    public EmptyTreeException() {}

    public EmptyTreeException(String msg) {
        super(msg);
    }
}
