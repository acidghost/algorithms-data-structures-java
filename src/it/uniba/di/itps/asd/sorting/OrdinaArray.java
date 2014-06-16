package it.uniba.di.itps.asd.sorting;

import java.util.Random;

/**
 * Created by acidghost on 05/05/14.
 */
public class OrdinaArray {

    /*
	 * Algoritmo bubblesort per l'ordinamento di un array di interi A
	 * usando come relazione d'ordine totale "<="
	 * @param A
	 */
    public static int bubblesort(int A[]){
        int numeroConfronti=0;
        boolean scambiEffettuati = true;
        for(int i=1; i<=A.length-1 && scambiEffettuati; i++) {
            scambiEffettuati = false;
            for(int j=1; j<=A.length-i; j++) {
                numeroConfronti++;
                if(A[j] <= A[j-1]) {
                    swap(A, j, j-1);
                    scambiEffettuati = true;
                }
            }
        }
        return numeroConfronti;
    }

    /*
	 * Algoritmo selectionsort per l'ordinamento di un array di interi A
	 * usando come relazione d'ordine totale "<="
	 * @param A
	 */
    public static int selectionsort(int A[]) {
        int numeroConfronti = 0;
        for(int i=-1; i<A.length-1; i++) {
            int min = i + 1;
            for(int j=i+2; j<A.length; j++) {
                numeroConfronti++;
                if(A[j] < A[min]) {
                    min = j;
                }
            }
            if(min != i+1) {
                swap(A, i+1, min);
            }
        }
        return numeroConfronti;
    }

    /*
	 * Algoritmo insertionsort per l'ordinamento di un array di interi A
	 * usando come relazione d'ordine totale "<="
	 * @param A
	 */
    public static int insertionsort(int A[]) {
        int numeroConfronti = 0;
        int min = indiceElementoMinimo(A);
        swap(A, min, 0);
        numeroConfronti += A.length;
        for(int i=1; i<A.length-1; i++) {
            int x = A[i+1],
                j;
            for(j=i; j>=1; j--) {
                numeroConfronti++;
                if(A[j] <= x)
                    break;
            }
            for(int k=i; k>=j+1; k--) {
                A[k+1] = A[k];
            }
            A[j+1] = x;
        }
        return numeroConfronti;
    }

    /*
	 * Algoritmo shellsort per l'ordinamento di un array di interi A
	 * usando come relazione d'ordine totale "<="
	 * @param A
	 */
    public static int shellsort(int A[]) {
        int numeroConfronti = 0;
        int inc = A.length / 2;
        while(inc >= 1) {
            for(int i=0; i<inc; i++) {
                numeroConfronti += ordinaCatena(A, i, inc);
            }
            inc/=2;
        }
        return numeroConfronti;
    }

    private static int ordinaCatena(int A[], int i, int inc) {
        int numeroConfronti = 0;
        int k = i+inc;
        while(k < A.length) {
            boolean inserito = false;
            int x = A[k];
            int corrente = k;
            int precedente = corrente - inc;
            while(precedente >= i && !inserito) {
                numeroConfronti++;
                if(x < A[precedente]) {
                    // shift a destra di A[precedente]
                    A[corrente] = A[precedente];
                    corrente = precedente;
                    precedente -= inc;
                } else {
                    inserito = true;
                }
            }
            A[corrente] = x;
            k += inc;
        }
        return numeroConfronti;
    }

    /*
	 * Algoritmo quicksort per l'ordinamento di un array di interi A
	 * usando come relazione d'ordine totale "<="
	 * @param A
	 * @param inf
	 * @param sup
	 */
    static int quicksort(int A[], int inf, int sup) {
        int numeroConfronti = 0;
        if(sup-inf >= 1) {
            int[] nConf = new int[1];
            int pos = partition(A, inf, sup, nConf);
            numeroConfronti += nConf[0];
            if((pos-inf) < (sup-pos+1)) {
                numeroConfronti += quicksort(A, inf, pos-1);
                numeroConfronti +=quicksort(A, pos+1, sup);
            } else {
                numeroConfronti +=quicksort(A, pos+1, sup);
                numeroConfronti +=quicksort(A, inf, pos-1);
            }
        }
        return numeroConfronti;
    }

    private static int partition(int A[], int inf, int sup, int numConfronti[]) {
        numConfronti[0] = 0;
        int i = inf;
        int j = sup;
        int med = (inf+sup) / 2;

        // garantisce che la partizione destra
        // non si espanda oltre inf
        int x = A[med];
        swap(A, inf, med);

        boolean stop = false;
        while(!stop) {
            while(i<=sup && A[i]<=x) { i++; numConfronti[0]++; }
            while(j>=inf && A[j]>x) { j--; numConfronti[0]++; }
            if(i<j) {
                swap(A, i, j);
            } else {
                stop = true;
            }
        }
        swap(A, inf, j);
        return j;
    }

    /*
	 * Algoritmo quicksort per l'ordinamento di un array di interi A
	 * usando come relazione d'ordine totale "<="
	 * @param A
	 */
    public static int quicksort(int A[]) {
        return quicksort(A, 0, A.length-1);
    }

    /*
	 * Algoritmo mergesort per l'ordinamento di un array di interi A
	 * usando come relazione d'ordine totale "<="
	 * @param A
	 */
    public static int mergesort(int A[]) {
        return mergesort(A, 0, A.length - 1);
    }

    static int mergesort(int A[], int inf, int sup) {
        int numeroConfronti = 0;
        if(inf < sup) {
            int m = (inf+sup) / 2;
            numeroConfronti += mergesort(A, inf, m);
            numeroConfronti += mergesort(A, m+1, sup);
            numeroConfronti += merge(A, inf, m, sup);
        }
        return numeroConfronti;
    }

    private static int merge(int A[], int inf, int m, int sup) {
        int numeroConfronti = 0;
        int p1=inf, q1=m+1;
        int aus[] = new int[(sup-inf)+1];
        int k=0;
        while(p1<=m && q1<=sup) {
            numeroConfronti++;
            if(A[q1] <= A[p1]) {
                aus[k] = A[q1];
                q1++;
            } else {
                aus[k] = A[p1];
                p1++;
            }
            k++;
        }
        if(p1<=m) {  // svuota seq. sinistra copiando in coda ad A
            // spostare A[p1..m] in coda ad A
            int inizio = m;
            for(int fine=sup; fine>=inf+k; fine--) {
                A[fine] = A[inizio];
                inizio--;
            }
        }
        // copiare aus[] in testa ad A
        for(int inizio=0; inizio<=k-1; inizio++)
            A[inf+inizio] = aus[inizio];
        return numeroConfronti;
    }

    private static void swap(int A[], int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    private static int indiceElementoMinimo(int A[]) {
        int min=0;
        for(int i=0; i<A.length; i++) {
            if(A[i] < A[min]) {
                min = i;
            }
        }
        return min;
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
     * Inizializza l'array di interi A con i numeri interi 1, 2, 3,..., A.length
     * @param A
     */
    public static void inizializzaArrayCrescente(int A[]){
        for(int i=0; i<A.length; i++)
            A[i] = i+1;
    }
    /*
     * Inizializza l'array di interi A con numeri interi A.length, A.length-1,...,2, 1
     * @param A
     */
    public static void inizializzaArrayDecrescente(int A[]){
        for(int i=0; i<A.length; i++)
            A[i] = A.length-i;
    }


    /*
     * Stampa gli elementi contenuti nell'array A
     * @param A
     */
    public static void stampaArray(int A[]){
        for(int i=0; i<A.length; i++)
            System.out.print(A[i] + ((i!=A.length-1) ? (" ") : ("")));
    }

}
