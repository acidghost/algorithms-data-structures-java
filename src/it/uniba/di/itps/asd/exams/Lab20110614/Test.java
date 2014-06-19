package it.uniba.di.itps.asd.exams.Lab20110614;

import it.uniba.di.itps.asd.exams.Lab20110614.referendum.Quesito;
import it.uniba.di.itps.asd.exams.Lab20110614.referendum.Referendum;

import java.util.Random;

/**
 * Created by acidghost on 19/06/14.
 */
public class Test {

    private static final int AVENTI_DIRITTO = 20;
    private static final int MIN_VOTO = 7;
    private static final int MAX_VOTO = 13;
    private static final String[] QUESITI = new String[]{
            "Abrogazione delle prove di esame",
            "Abrogazione della frequenza obbligatoria",
            "Abrogazione delle tasse universitarie",
            "Abrogazione del diritto allo studio"
    };
    private static final Referendum.Voto[] VOTI = new Referendum.Voto[]{
            Referendum.Voto.si, Referendum.Voto.no, Referendum.Voto.nulla, Referendum.Voto.bianca
    };

    private static void inizializza(Referendum referendum) {
        for(int i=0; i<QUESITI.length; i++) {
            Quesito q = new Quesito(QUESITI[i]);
            referendum.aggiungiQuesito(q);
            Random rnd = new Random();
            int N = rnd.nextInt(MAX_VOTO-MIN_VOTO+1)+MIN_VOTO;
            for(int j=0; j<N; j++) {
                Random rnd2 = new Random();
                Referendum.Voto voto = VOTI[rnd2.nextInt(VOTI.length)];
                referendum.scrutinaVoto(q, voto);
            }
        }
    }

    public static void main(String[] args) {
        Referendum referendum = new Referendum(AVENTI_DIRITTO);
        inizializza(referendum);

        for(int i=0; i<QUESITI.length; i++) {
            Quesito q = new Quesito(QUESITI[i]);
            System.out.println(q.quesito);
            int nVoti = referendum.numeroVoti(q);
            System.out.println("Voti scrutinati: " + nVoti);
            for(int j=0; j<nVoti; j++) {
                System.out.println(j + ": " + referendum.voto(q, j));
            }
            System.out.println("\nQuorum raggiunto: " + referendum.quorum(q) + "\n");
        }
    }

}
