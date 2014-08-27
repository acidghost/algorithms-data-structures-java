package it.uniba.di.itps.asd.exams.Lab20090921;

import it.uniba.di.itps.asd.exams.Lab20090921.coda.Coda;
import it.uniba.di.itps.asd.exams.Lab20090921.coda.CodaCollegata;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by acidghost on 27/08/14.
 */
public class SimulaCheckIn {
    public static final int PROCESSA = 120;
    public static final int MAX_SPORTELLI = 10;
    public static final int NUM_CLIENTI = 100;

    private Coda<Cliente> coda;

    public void inizializza() {
        coda = new CodaCollegata<Cliente>();
        Random rnd = new Random();
        for(int i=0; i<NUM_CLIENTI; i++) {
            int tempoArrivo = i + rnd.nextInt(10) + 10;
            Cliente c = new Cliente(tempoArrivo);
            coda.enqueue(c);
        }
    }

    public int tempoMedioAttesa(int numSportelli) {
        if(numSportelli < 1) {
            return -1;
        }
        int[] tempoSportello = new int[numSportelli];
        for (int i = 0; i < numSportelli; i++) {
            tempoSportello[i] = 0;
        }
        ArrayList<Integer> tempiAttesa = new ArrayList<Integer>();
        while(!coda.isEmpty()) {
            Cliente c = coda.first();
            int sportello = indexOfMin(tempoSportello);
            int oraLibero = c.getOraArrivo()+tempoSportello[sportello]+120;
            c.setOraPartenza(oraLibero);
            tempoSportello[sportello] = oraLibero;
            tempiAttesa.add(c.tempoAttesa());
            coda.dequeue();
        }
        int totale = 0;
        for(int attesa : tempiAttesa) {
            totale += attesa;
        }
        return (totale / tempiAttesa.size());
    }

    private int indexOfMin(int[] array) {
        int min = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] <= array[min]) {
                min = i;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        SimulaCheckIn simulazione = new SimulaCheckIn();
        for (int i = 1; i <= MAX_SPORTELLI; i++) {
            simulazione.inizializza();
            System.out.println("Simulazione inizializzata con " + NUM_CLIENTI + " utenti");
            System.out.println("Simulazione con " + i + " sportelli/o - tempo medio di attesa: " + simulazione.tempoMedioAttesa(i) + "\n");
        }

        int i=1;
        boolean found = false;
        while(!found) {
            simulazione.inizializza();
            int tempoAttesa = simulazione.tempoMedioAttesa(i);
            if(tempoAttesa <= 600) {
                System.out.println("Il numero di sportelli minimo necessario a garantire un tempo medio di attesa di 600s e' " + i + " (tempo " + tempoAttesa + "s)");
                found = true;
            }
            i++;
        }
    }
}
