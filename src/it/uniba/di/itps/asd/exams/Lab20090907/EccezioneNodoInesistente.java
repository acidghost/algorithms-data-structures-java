package it.uniba.di.itps.asd.exams.Lab20090907;

/**
 * Created by acidghost on 01/09/14.
 */
public class EccezioneNodoInesistente extends RuntimeException {
    public EccezioneNodoInesistente() {
        super();
    }

    public EccezioneNodoInesistente(String message) {
        super(message);
    }
}
