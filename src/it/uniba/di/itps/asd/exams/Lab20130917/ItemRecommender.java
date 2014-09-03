package it.uniba.di.itps.asd.exams.Lab20130917;

import it.uniba.di.itps.asd.exams.Lab20130917.list.AddOnlyList;

import java.util.Random;

/**
 * Created by acidghost on 03/09/14.
 */
public class ItemRecommender {
    public static final Prodotto[] prodotti = {
            new Prodotto("Prodotto1", 10),
            new Prodotto("Prodotto2", 8),
            new Prodotto("Prodotto3", 18),
            new Prodotto("Prodotto4", 2),
            new Prodotto("Prodotto5", 10),
            new Prodotto("Prodotto6", 22),
            new Prodotto("Prodotto7", 37),
            new Prodotto("Prodotto8", 3)
    };
    
    private Sessioni sessioni;

    public ItemRecommender(int n) {
        sessioni = new Sessioni();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            SessioneLL sessione = new SessioneLL();
            for (int j = 0; j < random.nextInt(3)+2; j++) {
                sessione.prodotti.add(prodotti[random.nextInt(prodotti.length)]);
            }
            sessioni.sessioni.add(sessione);
        }
    }

    public int acquistiAssociati(Prodotto a, Prodotto b) {
        int occorrenze = 0;
        boolean foundA=false, foundB=false;
        for (SessioneLL sessione : sessioni.sessioni) {
            for (Prodotto p : sessione.prodotti) {
                if(p.equals(a)) {
                    foundA=true;
                }
                if(p.equals(b)) {
                    foundB=true;
                }
                if (foundA && foundB) {
                    occorrenze++;
                    // esci dalla sessione
                    break;
                }
            }
            foundA=false;
            foundB=false;
        }
        return occorrenze;
    }

    public AddOnlyList<SessioneLL> getSessioni() {
        return sessioni.sessioni;
    }
}
