package it.uniba.di.itps.asd.ordinaArrayObjects;

import java.util.Random;

/**
 * Created by acidghost on 07/05/14.
 */
public class OrdinaArrayObject {

    static void stampaArray(String A[]) {
        System.out.print("[");
        for(int i=0; i<A.length; i++) {
            System.out.print("\"" + A[i]);
            if(i != A.length-1)
                System.out.print("\", ");
        }
        System.out.print("]");
    }

    static String randomString(int length) {
        Random r = new Random();
        String seed = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                    "abcdefghijklmnopqrstuvwxyz";
        char[] cstr = new char[length];
        for(int i=0; i<length; i++) {
            char c = seed.charAt(r.nextInt(seed.length()));
            cstr[i] = c;
        }
        return cstr.toString();
    }

    static void bubblesort(String A[]) {
        boolean scambiati = true;
        System.out.println("DEBUG: String A[]");
        for(int i=1; i<=A.length-1 && scambiati; i++) {
            scambiati = false;
            for(int j=1; j<=A.length-i; j++) {
                if(A[j-1].compareTo(A[j]) > 0) {
                    String tmp = A[j];
                    A[j] = A[j-1];
                    A[j-1] = tmp;
                    scambiati = true;
                }
            }
        }
    }

    /*
     * Algoritmo bubblesort per l'ordinamento di un array di oggetti A
     * per iquali sia definita una relazione d'ordine totale "<="
     * @param A
     */
    static void bubblesort(Comparable A[]){
        boolean scambiati = true;
        for(int i=1; i<=A.length-1 && scambiati; i++) {
            scambiati = false;
            for(int j=1; j<=A.length-i; j++) {
                if(A[j-1].compareTo(A[j]) > 0) {
                    Comparable tmp = A[j];
                    A[j] = A[j-1];
                    A[j-1] = tmp;
                    scambiati = true;
                }
            }
        }
    }


    /*
     * Stampa gli elementi contenuti nell'array A
     * @param A
     */
    static void stampaArray(Object A[]){
        int i;
        for(i=0;i<A.length;i++)
            System.out.println(A[i]);
    }

    public static void main(String args[])
    {

        String A[]= { "Malerba Donato", "Appice Annalisa", "Ceci Michelangelo", "Visaggio Giuseppe", "Fanelli Anna Maria", "Plantamura Vito Leonardo", "Plantamura Paola", "Malerba Donato" };


        stampaArray(A);
        System.out.println("\nOrdinamento");
        bubblesort(A);
        stampaArray(A);

        Integer B[]= { 3, 5, 12, 3, 3, 5, 7, 1 };

        stampaArray(B);
        System.out.println("\nOrdinamento");
        bubblesort(B);
        stampaArray(B);
    }


}
