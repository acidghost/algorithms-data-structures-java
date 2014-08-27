package it.uniba.di.itps.asd.exams.Lab20101117;

/**
 * Created by acidghost on 27/08/14.
 */
public class Operando implements ItemEspr {

    public int operando;

    public Operando(String operando) {
        try {
            this.operando = Integer.parseInt(operando);
        } catch(NumberFormatException e) {
            throw new EccezioneOperandoNonValido("Operando " + operando + " non valido");
        }
    }

    public Operando(int operando) {
        this.operando = operando;
    }

}
