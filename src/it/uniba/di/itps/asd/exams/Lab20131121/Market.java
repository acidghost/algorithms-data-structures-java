package it.uniba.di.itps.asd.exams.Lab20131121;

import java.util.Random;

/**
 * Created by acidghost on 03/09/14.
 */
public class Market {
    private static final int NCARRELLI = 10;
    private static final int MAXARTICOLI = 15;

    protected final Articolo[] merce = {
            new Articolo("Frollini Dixie", "500gr"),
            new Articolo("Mozzarelle di bufala", "1Kg"),
            new Articolo("Tonno in scatola", "300gr"),
            new Articolo("Pasta Barilla - rigatoni", "500gr"),
            new Articolo("Pasta De Cecco - spaghetti", "500gr"),
            new Articolo("Pasta Barilla - spaghetti", "500gr"),
            new Articolo("Patatine Lay", "100gr"),
            new Articolo("Patatine Lay", "200gr"),
            new Articolo("Sugo Sughetti", "1lt"),
            new Articolo("Latte Lola", "0.5lt"),
            new Articolo("Latte Lola", "1lt")
    };

    protected Carrello[] acquisti;

    public Market() {
        this(NCARRELLI, MAXARTICOLI);
    }

    public Market(int carrelli, int maxArticoli) {
        acquisti = new Carrello[carrelli];
        Random random = new Random();
        for (int i = 0; i < acquisti.length; i++) {
            Carrello c = new Carrello();
            int nArticoli = random.nextInt(maxArticoli)+1;
            for (int j = 0; j < nArticoli; j++) {
                c.aggArticolo(merce[random.nextInt(merce.length)]);
            }
            acquisti[i] = c;
        }
    }

    public void stampa() {
        for (int i = 0; i < acquisti.length; i++) {
            Carrello carrello = acquisti[i];
            System.out.println("Stampo carrello " + i);
            for (Articolo articolo : carrello) {
                System.out.println(carrello.quantita(articolo) + "x " + articolo.toString());
            }
            System.out.println();
        }
    }

    public void istogramma() {
        //TODO
    }
}
