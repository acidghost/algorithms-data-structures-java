package it.uniba.di.itps.asd.exams.Lab20130627;

import it.uniba.di.itps.asd.exams.Lab20130627.albero.ABD;
import it.uniba.di.itps.asd.exams.Lab20130627.albero.ABDPF;
import it.uniba.di.itps.asd.exams.Lab20130627.albero.Nodo;

/**
 * Created by acidghost on 03/09/14.
 */
public class Test {
    private static final String[][] casi = {
            { "Intelligenza", "Fisico", "Reddito", "Carattere", "Famiglia" },
            { "mediocre", "obeso", "basso", "polemico", "cattiva" },
            { "spiccata", "slanciato", "elevato", "buono", "buona" },
            { "mediocre", "obeso", "basso", "buono", "carttiva" },
            { "spiccata", "obeso", "basso", "polemico", "buona" }
    };

    public static void main(String[] args) {
        ABD<Etichetta> albero = new ABDPF<Etichetta>();
        albero.aggiungiRadice(new Etichetta("Fisico", "slanciato"));

        ABD<Etichetta> intell = new ABDPF<Etichetta>();
        intell.aggiungiRadice(new Etichetta("Intelligenza", "spiccata"));

        ABD<Etichetta> redd = new ABDPF<Etichetta>();
        redd.aggiungiRadice(new Etichetta("Reddito", "elevato"));

        Etichetta si = new Etichetta("SI");
        ABD<Etichetta> si1 = new ABDPF<Etichetta>();
        si1.aggiungiRadice(si);
        ABD<Etichetta> si2 = new ABDPF<Etichetta>();
        si2.aggiungiRadice(si);

        Etichetta no = new Etichetta("NO");
        ABD<Etichetta> no1 = new ABDPF<Etichetta>();
        no1.aggiungiRadice(no);
        ABD<Etichetta> no2 = new ABDPF<Etichetta>();
        no2.aggiungiRadice(no);

        intell.innestaVero(intell.radice(), si1);
        intell.innestaFalso(intell.radice(), no1);
        redd.innestaVero(redd.radice(), si2);
        redd.innestaFalso(redd.radice(), no2);

        albero.innestaVero(albero.radice(), intell);
        albero.innestaFalso(albero.radice(), redd);

        System.out.println("Stampo i nodi dell'albero");
        for(Etichetta etichetta : albero) {
            System.out.println(etichetta.toString());
        }
        System.out.println();

        for (int i = 1; i < casi.length; i++) {
            String[] caso = casi[i];
            Nodo<Etichetta> n = albero.radice();
            Etichetta etichetta;
            while (true) {
                etichetta = albero.info(n);
                if (albero.foglia(n)) {
                    break;
                }
                for (int j = 0; j < caso.length; j++) {
                    if(etichetta.ugualeAttributo(casi[0][j])) {
                        if(etichetta.testProprieta(casi[0][j], caso[j])) {
                            n = albero.vero(n);
                        } else {
                            n = albero.falso(n);
                        }
                        break;
                    }
                }
            }
            System.out.print("Caso: [");
            for (int j = 0; j < caso.length; j++) {
                System.out.print(caso[j]);
                if (j != caso.length-1)
                    System.out.print(", ");
            }
            System.out.println("]\t" + etichetta.decisione());
        }
    }
}
