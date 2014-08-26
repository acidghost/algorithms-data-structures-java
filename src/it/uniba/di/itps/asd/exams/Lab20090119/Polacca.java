package it.uniba.di.itps.asd.exams.Lab20090119;

import it.uniba.di.itps.asd.exams.Lab20090119.pila.EccezioneStrutturaVuota;
import it.uniba.di.itps.asd.exams.Lab20090119.pila.Pila;
import it.uniba.di.itps.asd.exams.Lab20090119.pila.PilaCollegata;

/**
 * Created by acidghost on 26/08/14.
 */
public class Polacca {

    private static boolean operatore(String op) {
        return (op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/"));
    }

    public static int valuta(String espressione) {
        String[] exp = espressione.split(" ");
        Pila pila = new PilaCollegata();
        for(String elm : exp) {
            if(!operatore(elm)) {
                try {
                    int operando = Integer.parseInt(elm);
                    pila.push(operando);
                } catch (NumberFormatException e) {
                    throw new EccezioneEspressioneNonValida(elm + ": non riconosciuto");
                }
            } else {
                int operando1, operando2;
                try {
                    operando2 = (Integer) pila.top();
                    pila.pop();
                    operando1 = (Integer) pila.top();
                    pila.pop();
                } catch(EccezioneStrutturaVuota e) {
                    throw new EccezioneEspressioneNonValida("Operando mancante");
                }
                if(elm.equals("+")) {
                    pila.push(operando1+operando2);
                } else if(elm.equals("-")) {
                    pila.push(operando1-operando2);
                } else if(elm.equals("*")) {
                    pila.push(operando1*operando2);
                } else if(elm.equals("/")) {
                    pila.push(operando1/operando2);
                }
            }
        }
        int risultato = ((Integer) pila.top()).intValue();
        pila.pop();
        if(!pila.isEmpty()) {
            throw new EccezioneEspressioneNonValida("Operatore mancante");
        }
        return risultato;
    }

}
