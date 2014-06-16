package it.uniba.di.itps.asd.sorting;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Main {

    public static void main(String[] args) {

        int i, maxDim, step;
        int bubbleCasuale, bubbleCrescente, bubbleDecrescente,
            selecCasuale, selecCrescente, selecDecrescente,
            insCasuale, insCrescente, insDecrescente,
            shellCasuale, shellCrescente, shellDecrescente,
            quickCasuale, quickCrescente, quickDecrescente,
            mergeCasuale, mergeCrescente, mergeDecrescente;
        maxDim=new Integer(args[0]).intValue();
        step=new Integer(args[1]).intValue();

        try {
            FileOutputStream file = new FileOutputStream("statistica.csv");
            PrintStream Output = new PrintStream(file);
            Output.println("dimArray, bubbleCasuale, bubbleCrescente, bubbleDecrescente, " +
                    "selecCasuale, selecCrescente, selecDecrescente, " +
                    "insCasuale, insCrescente, insDecrescente, " +
                    "shellCasuale, shellCrescente, shellDecrescente, " +
                    "quickCasuale, quickCrescente, quickDecrescente" +
                    "mergeCasuale, mergeCrescente, mergeDecrescente"
            );
            for(i=step; i<=maxDim; i+=step) {
                int A[]=new int[i];

                // Bubble sort
                //System.out.println("Array di dimensione " + i);
                //System.out.println("***************************************************");
                //System.out.println("Uso del generatore di numeri casuali");
                OrdinaArray.inizializzaArrayCasuale(A);
                //OrdinaArray.stampaArray(A);
                bubbleCasuale=OrdinaArray.bubblesort(A);
                //System.out.print(": " + bubbleCasuale + " confronti per ottenere ");
                //OrdinaArray.stampaArray(A);
                //System.out.println("");
                OrdinaArray.inizializzaArrayCrescente(A);
                //OrdinaArray.stampaArray(A);
                bubbleCrescente=OrdinaArray.bubblesort(A);
                //System.out.print(": " + bubbleCrescente + " confronti per ottenere ");
                //OrdinaArray.stampaArray(A);
                //System.out.println("");
                OrdinaArray.inizializzaArrayDecrescente(A);
                //OrdinaArray.stampaArray(A);
                bubbleDecrescente=OrdinaArray.bubblesort(A);
                //System.out.print(": " + bubbleDecrescente + " confronti per ottenere ");
                //OrdinaArray.stampaArray(A);
                //System.out.println("");

                // Selection sort
                OrdinaArray.inizializzaArrayCasuale(A);
                selecCasuale = OrdinaArray.selectionsort(A);
                OrdinaArray.inizializzaArrayCrescente(A);
                selecCrescente = OrdinaArray.selectionsort(A);
                OrdinaArray.inizializzaArrayDecrescente(A);
                selecDecrescente = OrdinaArray.selectionsort(A);

                // Insertion sort
                OrdinaArray.inizializzaArrayCasuale(A);
                insCasuale = OrdinaArray.insertionsort(A);
                OrdinaArray.inizializzaArrayCrescente(A);
                insCrescente = OrdinaArray.insertionsort(A);
                OrdinaArray.inizializzaArrayDecrescente(A);
                insDecrescente = OrdinaArray.insertionsort(A);

                // Shell sort
                OrdinaArray.inizializzaArrayCasuale(A);
                shellCasuale = OrdinaArray.shellsort(A);
                OrdinaArray.inizializzaArrayCrescente(A);
                shellCrescente = OrdinaArray.shellsort(A);
                OrdinaArray.inizializzaArrayDecrescente(A);
                shellDecrescente = OrdinaArray.shellsort(A);

                // Quick sort
                OrdinaArray.inizializzaArrayCasuale(A);
                quickCasuale = OrdinaArray.quicksort(A);
                //OrdinaArray.stampaArray(A);
                //System.out.println("");
                OrdinaArray.inizializzaArrayCrescente(A);
                quickCrescente = OrdinaArray.quicksort(A);
                //OrdinaArray.stampaArray(A);
                //System.out.println("");
                OrdinaArray.inizializzaArrayDecrescente(A);
                quickDecrescente = OrdinaArray.quicksort(A);
                //OrdinaArray.stampaArray(A);
                //System.out.println("");

                // Merge sort
                OrdinaArray.inizializzaArrayCasuale(A);
                mergeCasuale = OrdinaArray.mergesort(A);
                //OrdinaArray.stampaArray(A);
                //System.out.println("");
                OrdinaArray.inizializzaArrayCrescente(A);
                mergeCrescente = OrdinaArray.mergesort(A);
                //OrdinaArray.stampaArray(A);
                //System.out.println("");
                OrdinaArray.inizializzaArrayDecrescente(A);
                mergeDecrescente = OrdinaArray.mergesort(A);
                //OrdinaArray.stampaArray(A);
                //System.out.println("");

                Output.println(i + ", " + bubbleCasuale + ", " + bubbleCrescente + ", " + bubbleDecrescente + ", " +
                        selecCasuale + ", " + selecCrescente + ", " + selecDecrescente + ", " +
                        insCasuale + ", " + insCrescente + ", " + insDecrescente + ", " +
                        shellCasuale + ", " + shellCrescente + ", " + shellDecrescente + ", " +
                        quickCasuale + ", " + quickCrescente + ", " + quickDecrescente + ", " +
                        mergeCasuale + ", " + mergeCrescente + ", " + mergeDecrescente
                );
            }
            Output.close();
        } catch (IOException e) {
            System.out.println("Errore: " + e);
            System.exit(1);
        }

    }
}
