package it.uniba.di.itps.asd.exams.Lab20090907;

import java.util.HashMap;

/**
 * Created by acidghost on 01/09/14.
 */
public class AlberoDecisione {
    private HashMap<String, Integer> attributi = new HashMap<String, Integer>();
    {
        attributi.put("Tempo", 0);
        attributi.put("Temperatura", 1);
        attributi.put("Umidita", 2);
        attributi.put("Vento", 3);
        attributi.put("Ideale", 4);
    }

    private String[][] tabella = {
            {"soleggiato", "alta", "elevata", "debole", "no"},
            {"soleggiato", "bassa", "normale", "debole", "si"},
            {"coperto", "bassa", "elevata", "debole", "si"},
            {"coperto", "bassa", "elevata", "forte", "no"}
    };

    public String classifica(ABE alberoDecisione, int i) {
        String[] row = tabella[i];
        Nodo r = alberoDecisione.radice();
        while (r != null) {
            if(r.etichettaNodo().equals("si") || r.etichettaNodo().equals("no")) {
                return r.etichettaNodo();
            } else {
                if(attributi.containsKey(r.etichettaNodo())) {
                    String value = row[attributi.get(r.etichettaNodo())];
                    if(value.equals(r.etichettaRamoSin())) {
                        r = alberoDecisione.sin(r);
                    } else { // r.etichettaRamoDes().equals(value)
                        r = alberoDecisione.des(r);
                    }
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ABE albero = new ABEPF();
        albero.aggiungiRadice("Vento");
        ABE temperatura = new ABEPF();
        temperatura.aggiungiRadice("Temperatura");
        ABE no1 = new ABEPF();
        no1.aggiungiRadice("no");
        albero.innestaDes(albero.radice(), no1, "forte");
        ABE no2 = new ABEPF(), si = new ABEPF();
        no2.aggiungiRadice("no");
        si.aggiungiRadice("si");
        temperatura.innestaSin(temperatura.radice(), no2, "alta");
        temperatura.innestaDes(temperatura.radice(), si, "bassa");
        albero.innestaSin(albero.radice(), temperatura, "debole");

        AlberoDecisione alberoDecisione = new AlberoDecisione();
        for(int i=0; i<alberoDecisione.tabella.length; i++) {
            System.out.print("Classifico esempio " + i + ": ");
            for (int j = 0; j < alberoDecisione.tabella[i].length; j++) {
                System.out.print(alberoDecisione.tabella[i][j]);
                if(j != alberoDecisione.tabella[i].length-1)
                    System.out.print(", ");
            }
            System.out.println();
            System.out.println("Classificato: " + alberoDecisione.classifica(albero, i));
        }
    }
}
