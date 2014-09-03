package it.uniba.di.itps.asd.searching;

import it.uniba.di.itps.asd.sorting.OrdinaArray;

import java.util.Random;

/**
 * Created by acidghost on 07/05/14.
 */
public class RicercaArray {

    public static boolean sequentialSearch(Object A[], Object key) {
        boolean found = false;
        for(int i=0; !found && i<A.length; i++) {
            if(A[i].equals(key))
                found = true;
        }
        return found;
    }

    public static boolean binarySearch(Object A[], Object key) {
        boolean found = false;

        return found;
    }

    /*
     * Algoritmo ri ricerca sequenziale di un elemento in un array
	 */
    public static boolean sequentialSearch(int A[], int x, int numeroConfronti[]) {
        numeroConfronti[0] = 0;
        boolean trovato = false;
        for (int i = 0; i < A.length; i++) {
            numeroConfronti[0]++;
            if (A[i] == x) {
                trovato = true;
                break;
            }
        }
        return trovato;
    }

    /*
     * Algoritmo ri ricerca binaria di un elemento in un array ordinamento
     */
    public static boolean binarySearch(int A[], int x, int numeroConfronti[]) {
        numeroConfronti[0] = 0;
        boolean trovato = false;

        int cpy[] = new int[A.length];
        System.arraycopy(A, 0, cpy, 0, A.length);
        numeroConfronti[0] += OrdinaArray.mergesort(cpy);

        int inizio=0;
        int fine=cpy.length-1;
        int m = cpy.length/2;
        while(!trovato && inizio<=fine) {
            numeroConfronti[0]++;
            if(x == cpy[m]) {
                trovato = true;
            } else if(x < cpy[m]) {
                fine = m-1;
                m = (inizio+fine)/2;
            } else {
                inizio = m+1;
                m = (inizio+fine)/2;
            }
        }

        return trovato;
    }


    /*
     * Inizializza l'array di interi A con i numeri interi 1, 2, 3,..., A.length
     * @param A
     */
    static void inizializzaArrayCrescente(int A[]) {
        int i;
        for (i = 0; i < A.length; i++)
            A[i] = i + 1;
    }

    /*
     * Inizializza l'array di interi A con numeri interi generati in maniera casuale
     * con valore tra 1 e A.length
     * @param A
     */
    public static void inizializzaArrayCasuale(int A[]){
        for(int i=0; i<A.length; i++)
            A[i] = new Random().nextInt(A.length)+1;
    }

    /*
     * Stampa gli elementi contenuti nell'array A
     * @param A
     */
    static void stampaArray(int A[]) {
        int i;
        for (i = 0; i < A.length; i++)
            System.out.print(A[i] + " ");
    }

}
