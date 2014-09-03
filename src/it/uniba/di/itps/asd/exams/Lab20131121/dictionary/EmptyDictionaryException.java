package it.uniba.di.itps.asd.exams.Lab20131121.dictionary;

/**
 * Created by acidghost on 02/09/14.
 */
public class EmptyDictionaryException extends RuntimeException {
    public EmptyDictionaryException() {
        super();
    }

    public EmptyDictionaryException(String message) {
        super(message);
    }
}
