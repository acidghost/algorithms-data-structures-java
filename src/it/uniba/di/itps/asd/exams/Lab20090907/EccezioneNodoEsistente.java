package it.uniba.di.itps.asd.exams.Lab20090907;

/**
 * Created by acidghost on 01/09/14.
 */
public class EccezioneNodoEsistente extends RuntimeException {
    public EccezioneNodoEsistente() {
        super();
    }

    public EccezioneNodoEsistente(String message) {
        super(message);
    }
}
