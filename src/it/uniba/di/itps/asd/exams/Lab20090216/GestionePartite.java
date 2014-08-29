package it.uniba.di.itps.asd.exams.Lab20090216;

import it.uniba.di.itps.asd.exams.Lab20090216.lista.ListaOrdinata;
import it.uniba.di.itps.asd.exams.Lab20090216.lista.WOListLinked;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by acidghost on 29/08/14.
 */
public class GestionePartite {
    private ListaOrdinata lista;

    public void inizializza() {
        lista = new WOListLinked();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        try {
            Partita[] partite = new Partita[] {
                    new Partita(sdf.parse("03/11/01"), "Bari", "Milan", 3, 2),
                    new Partita(sdf.parse("11/03/02"), "Milan", "Inter", 0, 0),
                    new Partita(sdf.parse("04/11/01"), "Sampdoria", "Fiorentina", 1, 2),
                    new Partita(sdf.parse("03/12/01"), "Torino", "Lione", 1, 1),
                    new Partita(sdf.parse("01/01/02"), "Roma", "Viggevano", 0, 4),
                    new Partita(sdf.parse("20/05/00"), "Bari", "Atalanta", 3, 1)
            };
            for(Partita partita : partite) {
                lista.insert(partita);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public int partiteVinteOspitante(String sqOspitante, Date d) {
        int vinte = 0;
        for(Object obj : lista) {
            Partita partita = (Partita) obj;
            if(partita.data.compareTo(d) <= 0) {
                if(partita.sqOspitante.equals(sqOspitante)) {
                    if(partita.retiOspitante > partita.retiOspitata) {
                        vinte++;
                    }
                }
            } else {
                // Esci fal ciclo se superata la data
                break;
            }
        }
        return vinte;
    }

    public void stampa() {
        for(Object obj : lista) {
            Partita partita = (Partita) obj;
            System.out.println(partita.toString());
        }
    }

    public static void main(String[] args) {
        GestionePartite partite = new GestionePartite();
        partite.inizializza();
        System.out.println("Elenco partite inizializzato...\n");
        partite.stampa();
        System.out.println();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        try {
            System.out.println("Partite vinte per Bari fino al 30/06/00: " + partite.partiteVinteOspitante("Bari", sdf.parse("30/06/00")));
            System.out.println("Partite vinte per Bari fino al 30/06/03: " + partite.partiteVinteOspitante("Bari", sdf.parse("30/06/03")));
            System.out.println("Partite vinte per Roma fino al 29/08/14: " + partite.partiteVinteOspitante("Roma", sdf.parse("29/08/14")));
            System.out.println("Partite vinte per Milan fino al 29/08/14: " + partite.partiteVinteOspitante("Milan", sdf.parse("29/08/14")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
