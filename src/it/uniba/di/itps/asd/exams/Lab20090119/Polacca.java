package it.uniba.di.itps.asd.exams.Lab20090119;

import it.uniba.di.itps.asd.exams.Lab20090119.pila.EccezioneStrutturaVuota;
import it.uniba.di.itps.asd.exams.Lab20090119.pila.Pila;
import it.uniba.di.itps.asd.exams.Lab20090119.pila.PilaCollegata;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by acidghost on 26/08/14.
 */
public class Polacca {

    private static String postfissa = null;

    private static boolean operatore(String op) {
        return (op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/"));
    }

    private static int priorita(String op) {
        if(op.equals("*") || op.equals("/"))
            return 3;
        else if(op.equals("+") || op.equals("-"))
            return 2;
        else
            return 1;
    }

    private static void trasferisci(Pila s, Queue c) {
        Object topElm = s.top();
        s.pop();
        c.add(topElm);
    }

    /**
     * Inizializza una espressione,
     * utilizzare converti() per immettere una stringa in notazione infissa
     */
    Polacca() {}

    /**
     * Inizializza una espressione in notazione polacca (postfissa)
     * @param espressione
     */
    Polacca(String espressione) {
        postfissa = espressione;
    }

    /**
     * Valuta una espressione postfissa (polacca)
     * @param espressione Stringa in notazione postfissa
     * @return Risultato della valutazione
     */
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

    /**
     * Valuta una espressione postfissa (polacca)
     * @return Risultato della valutazione
     */
    public int valuta() {
        return valuta(postfissa);
    }

    /**
     * Converte una espressione infissa in una postfissa (polacca)
     * [ aggiunta della lab. activity 9 ]
     * @param espressione
     * @return
     */
    public static String converti(String espressione) {
        Pila pila = new PilaCollegata();
        Queue coda = new LinkedList();
        for(String item : espressione.split(" ")) {
            item = item.trim();
            try {
                int i = Integer.parseInt(item);
                coda.add(i);
            } catch (NumberFormatException nfe) {
                if(pila.isEmpty()) {
                    pila.push(item);
                } else if(operatore(item)) {
                    if(priorita(item) > priorita((String) pila.top())) {
                        pila.push(item);
                    } else {
                        trasferisci(pila, coda);
                        pila.push(item);
                        boolean continua = !pila.isEmpty();
                        while(continua) {
                            item = (String) pila.top();
                            pila.pop();
                            System.out.println("[DEBUG] Ramo con bug eseguito...");
                            if(priorita(item) <= priorita((String) pila.top())) {
                                trasferisci(pila, coda);
                                continua = !pila.isEmpty();
                            } else {
                                continua = false;
                            }
                            pila.push(item);
                        }
                    }
                } else if(item.equals("(")) {
                    pila.push(item);
                } else { // item==")"
                    while(!pila.isEmpty()) {
                        if(pila.top().equals("("))
                            break;
                        trasferisci(pila, coda);
                    }
                    pila.pop();
                }
            }
        }
        while(!pila.isEmpty()) {
            trasferisci(pila, coda);
        }
        postfissa = "";
        for(Object item : coda) {
            postfissa += item + " ";
        }
        postfissa = postfissa.trim();
        return postfissa;
    }

}
