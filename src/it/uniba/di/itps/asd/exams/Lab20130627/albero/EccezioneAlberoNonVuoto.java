package it.uniba.di.itps.asd.exams.Lab20130627.albero;

/**
 * Created by acidghost on 03/09/14.
 */
public class EccezioneAlberoNonVuoto extends RuntimeException {
    public EccezioneAlberoNonVuoto() {
        super();
    }

    public EccezioneAlberoNonVuoto(String message) {
        super(message);
    }
}
