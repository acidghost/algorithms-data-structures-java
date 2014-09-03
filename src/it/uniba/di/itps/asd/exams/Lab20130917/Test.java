package it.uniba.di.itps.asd.exams.Lab20130917;

/**
 * Created by acidghost on 03/09/14.
 */
public class Test {
    public static void main(String[] args) {
        ItemRecommender itemRecommender = new ItemRecommender(20);
        int n = 1;
        for (SessioneLL sessione : itemRecommender.getSessioni()) {
            System.out.println("Stampo sessione " + n);
            for (Prodotto prodotto : sessione.prodotti) {
                System.out.println(prodotto.getNome());
            }
            System.out.println();
            n++;
        }

        for (int i = 0; i < ItemRecommender.prodotti.length; i++) {
            Prodotto p1 = ItemRecommender.prodotti[i];
            for (int j = i+1; j < ItemRecommender.prodotti.length; j++) {
                Prodotto p2 = ItemRecommender.prodotti[j];
                System.out.println("Occorrenze di " + p1.getNome() + " e " + p2.getNome() + "\t\t" + itemRecommender.acquistiAssociati(p1, p2));
            }
        }
    }
}
