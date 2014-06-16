package it.uniba.di.itps.asd.exams.Lab20100111.bio;

import it.uniba.di.itps.asd.exams.Lab20100111.lista.ListaSemplice;

/**
 * Created by acidghost on 16/06/14.
 */
public abstract class Polimero {

    protected ListaSemplice sequenza = null;

    public String toString() {
        String str = "";
        while(sequenza.hasNext()) {
            Monomero monomero = (Monomero) sequenza.next();
            str += monomero.getSymbol();
        }
        return str;
    }

}
