package it.uniba.di.itps.asd.exams.Lab20101117;

import it.uniba.di.itps.asd.exams.Lab20101117.pila.EccezioneStrutturaVuota;
import it.uniba.di.itps.asd.exams.Lab20101117.pila.Pila;
import it.uniba.di.itps.asd.exams.Lab20101117.pila.PilaDoubling;

import java.util.LinkedList;

/**
 * Created by acidghost on 27/08/14.
 */
public class EspressionePolacca {

    private LinkedList<ItemEspr> espr;

    EspressionePolacca(String espressione) {
        espr = new LinkedList<ItemEspr>();
        for(String str : espressione.split(" ")) {
            str = str.trim();
            if(!Operatore.check(str)) {
                try {
                    espr.add(new Operando(str));
                } catch (EccezioneOperandoNonValido e) {
                    throw new EccezioneEspressioneNonValida("Espressione non valida: " + e.getMessage());
                }
            } else {
                espr.add(new Operatore(str));
            }
        }
    }

    public int valuta() {
        Pila<ItemEspr> pila = new PilaDoubling<ItemEspr>();
        for(ItemEspr item : espr) {
            if(item instanceof Operando) {
                pila.push(item);
            } else if(item instanceof Operatore) {
                int op1, op2;
                try {
                    op2 = ((Operando) pila.top()).operando;
                    pila.pop();
                    op1 = ((Operando) pila.top()).operando;
                    pila.pop();
                } catch (EccezioneStrutturaVuota e) {
                    throw new EccezioneEspressioneNonValida();
                }
                String op = ((Operatore) item).operatore;
                if(op.equals("+"))
                    pila.push(new Operando(op1 + op2));
                else if(op.equals("-"))
                    pila.push(new Operando(op1 - op2));
                else if(op.equals("*"))
                    pila.push(new Operando(op1 * op2));
                else if(op.equals("/"))
                    pila.push(new Operando(op1 / op2));
            } else {
                throw new EccezioneEspressioneNonValida("Espressione non valida: elemento non riconosciuto");
            }
        }

        if(pila.top() instanceof Operando && !pila.isEmpty()) {
            int res = ((Operando) pila.top()).operando;
            pila.pop();
            if(!pila.isEmpty()) {
                throw new EccezioneEspressioneNonValida();
            }
            return res;
        } else {
            throw new EccezioneEspressioneNonValida();
        }
    }

    public static void main(String[] args) {
        String[] tests = new String[] {
                "1",
                "125 +",
                "125 12 +",
                "123 245 + 127 - 4 * 2 /"
        };

        for(String s : tests) {
            try {
                EspressionePolacca exp = new EspressionePolacca(s);
                System.out.println("Espressione " + s + " valida valutata " + exp.valuta());
            } catch (EccezioneEspressioneNonValida e) {
                System.out.println("Espressione " + s + " non valida");
            }
        }
    }

}
