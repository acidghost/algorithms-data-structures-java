package it.uniba.di.itps.asd.exams.Lab20101117;

/**
 * Created by acidghost on 27/08/14.
 */
public class Operatore implements ItemEspr {

    public String operatore;

    public Operatore(String operatore) {
        if(check(operatore)) {
            this.operatore = operatore;
        } else {
            throw new EccezioneOperatoreNonValido("Operatore " + operatore + " non valido");
        }
    }

    public static boolean check(String operatore) {
        return (operatore.equals("+") || operatore.equals("-") || operatore.equals("*") || operatore.equals("/"));
    }

}
