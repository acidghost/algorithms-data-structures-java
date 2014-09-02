package it.uniba.di.itps.asd.exams.Lab20140415;

/**
 * Created by acidghost on 02/09/14.
 */
public class Test {
    public static void main(String[] args) {
        BagOfWords A = new BagOfWords();
        BagOfWords B = new BagOfWords();
        BagOfWords C = new BagOfWords();
        A.addText("Questo è un sistema innovativo per la scoperta automatica di plagi");
        B.addText("Questo sistema innovativo permette la scoperta automatica di plagi");
        C.addText("Questo sistema non fa proprio nulla di interessante");

        System.out.println("Stampo bag A");
        for(Object o : A.bagOfWords) {
            System.out.println(o.toString() + " - " + A.bagOfWords.occurrences((Comparable) o));
        }
        System.out.println();

        System.out.println("Stampo bag B");
        for(Object o : B.bagOfWords) {
            System.out.println(o.toString() + " - " + B.bagOfWords.occurrences((Comparable) o));
        }
        System.out.println();

        System.out.println("Stampo bag C");
        for(Object o : C.bagOfWords) {
            System.out.println(o.toString() + " - " + C.bagOfWords.occurrences((Comparable) o));
        }
        System.out.println();

        System.out.println("Similarità fra A e B:\t" + A.similarity(B));
        System.out.println("Similarità fra B e C:\t" + B.similarity(C));
        System.out.println("Similarità fra A e C:\t" + A.similarity(C));
    }
}
