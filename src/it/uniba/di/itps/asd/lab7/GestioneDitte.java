package it.uniba.di.itps.asd.lab7;

import it.uniba.di.itps.asd.structures.dictionary.ArrayDoubling;
import it.uniba.di.itps.asd.structures.dictionary.Dictionary;

/**
 * Created by acidghost on 11/06/14.
 */
public class GestioneDitte {

    private enum TipoDitta { UNDEFINED, CLIENTE, FORNITORE };

    private static void inizializza(Dictionary tabella) {
        InfoDitta f1 = new InfoFornitore("Fornitore1", "Molfetta", InfoFornitore.Tipologia.PRINCIPALE);
        tabella.insert(f1.getRagioneSociale(), f1);
        InfoDitta f2 = new InfoFornitore("Fornitore2", "Bari", InfoFornitore.Tipologia.SECONDARIO);
        tabella.insert(f2.getRagioneSociale(), f2);
        InfoDitta f3 = new InfoFornitore("Fornitore3", "Barletta", InfoFornitore.Tipologia.PRINCIPALE);
        tabella.insert(f3.getRagioneSociale(), f3);

        InfoDitta c1 = new InfoCliente("Cliente1", "Mola", 2009);
        tabella.insert(c1.getRagioneSociale(), c1);
        InfoDitta c2 = new InfoCliente("Cliente2", "Monopoli", 2013);
        tabella.insert(c2.getRagioneSociale(), c2);
    }

    private static TipoDitta ricerca(Dictionary tabella, String ragioneSociale) {
        Object res = tabella.search(ragioneSociale);
        if(res == null) {
            return TipoDitta.UNDEFINED;
        } else {
            if(res.getClass().toString().endsWith("InfoFornitore")) {
                return TipoDitta.FORNITORE;
            } else if (res.getClass().toString().endsWith("InfoCliente")) {
                return TipoDitta.CLIENTE;
            } else {
                return TipoDitta.UNDEFINED;
            }
        }
    }

    public static void main(String[] args) {

        Dictionary tabella = new ArrayDoubling();
        inizializza(tabella);

        TipoDitta t1 = ricerca(tabella, "Fornitore2");
        System.out.println("Searching for " + "'Fornitore2':\t" + t1.toString());
        TipoDitta t2 = ricerca(tabella, "Cliente1");
        System.out.println("Searching for " + "'Cliente1':\t" + t2.toString());
        TipoDitta t3 = ricerca(tabella, "ABCDEFGHI");
        System.out.println("Searching for " + "'ABCDEFGHI':\t" + t3.toString());

    }

}
