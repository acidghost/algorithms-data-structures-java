package it.uniba.di.itps.asd.exams.Lab20110614.referendum;

import it.uniba.di.itps.asd.exams.Lab20110614.dict.ArrayOrdinato;
import it.uniba.di.itps.asd.exams.Lab20110614.dict.Dictionary;

/**
 * Created by acidghost on 18/06/14.
 */
public class Referendum {

    protected Dictionary<Quesito> referendum;
    private int numeroVotanti;

    public enum Voto { si, no, nulla, bianca }

    public Referendum(int numeroVotanti) {
        referendum = new ArrayOrdinato<Quesito>();
        this.numeroVotanti = numeroVotanti;
    }

    public void aggiungiQuesito(Quesito quesito) {
        referendum.insert(quesito, quesito.quesito);
    }

    public void scrutinaVoto(Quesito quesito, Voto voto) {
        Quesito q = referendum.search(quesito.quesito);
        if(q != null) {
            q.add(voto);
        } else {
            throw new QuesitoNonValidoException("Quesito " + quesito.quesito + " non valido");
        }
    }

    public int numeroVoti(Quesito quesito) {
        Quesito q = referendum.search(quesito.quesito);
        if(q != null) {
            return q.numberElements();
        } else {
            throw new QuesitoNonValidoException("Quesito " + quesito.quesito + " non valido");
        }
    }

    public Voto voto(Quesito quesito, int posizione) {
        Quesito q = referendum.search(quesito.quesito);
        if(q != null) {
           return (Voto) q.getElement(posizione);
        } else {
            throw new QuesitoNonValidoException("Quesito " + quesito.quesito + " non valido");
        }
    }

    public boolean quorum(Quesito quesito) {
        Quesito q = referendum.search(quesito.quesito);
        if(q != null) {
            return (numeroVoti(q) > (numeroVotanti/2));
        } else {
            throw new QuesitoNonValidoException("Quesito " + quesito.quesito + " non valido");
        }
    }

}
