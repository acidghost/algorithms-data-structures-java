package it.uniba.di.itps.asd.exams.Lab20100222;

/**
 * Created by acidghost on 02/09/14.
 */
public class ElementAlreadyExistsException extends RuntimeException {
    public ElementAlreadyExistsException() {
        super();
    }

    public ElementAlreadyExistsException(String message) {
        super(message);
    }
}
