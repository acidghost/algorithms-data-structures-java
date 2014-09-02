package it.uniba.di.itps.asd.exams.Lab20140415;

/**
 * Created by acidghost on 02/09/14.
 */
public class EntryAlreadyExistsException extends RuntimeException {
    public EntryAlreadyExistsException() {
        super();
    }

    public EntryAlreadyExistsException(String message) {
        super(message);
    }
}
