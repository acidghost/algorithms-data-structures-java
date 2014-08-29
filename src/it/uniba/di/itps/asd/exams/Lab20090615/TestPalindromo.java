package it.uniba.di.itps.asd.exams.Lab20090615;

import it.uniba.di.itps.asd.exams.Lab20090615.lista.AOLista;
import it.uniba.di.itps.asd.exams.Lab20090615.lista.Posizione;
import it.uniba.di.itps.asd.exams.Lab20090615.lista.WODoubleLinkedList;

/**
 * Created by acidghost on 29/08/14.
 */
public class TestPalindromo {
    private AOLista lista;

    private final char[] chars1 = new char[] {
            'a', 'b', 'b', 'a'
            //'k', 'a', 'y', 'a', 'k'
    };
    private final char[] chars2 = new char[] {
            'a', 'b', 'b', 'a', 'c', 'c', 'h', 'i', 'o'
    };

    public void inizializza1() {
        lista = new WODoubleLinkedList();

        for(char c : chars1) {
            lista.insert(c, lista.firstList());
        }
    }

    public void inizializza2() {
        lista = new WODoubleLinkedList();

        for(char c : chars2) {
            lista.insert(c, lista.firstList());
        }
    }

    public void stampaSD() {
        Posizione pos = lista.firstList();
        while (!lista.endList(pos)) {
            System.out.println(lista.readList(pos));
            pos = lista.succ(pos);
        }
    }

    public void stampaDS() {
        Posizione pos = lista.firstList();
        while (!lista.endList(pos)) {
            pos = lista.succ(pos);
        }
        do {
            pos = lista.pred(pos);
            System.out.println(lista.readList(pos));
        } while (pos != lista.firstList());
    }

    public boolean palindromo() {
        Posizione sx = lista.firstList();
        Posizione dx = sx;
        while (!lista.endList(dx)) {
            dx = lista.succ(dx);
        }
        while (!lista.endList(sx)) {
            dx = lista.pred(dx);
            if(lista.readList(sx) != lista.readList(dx)) {
                return false;
            }
            sx = lista.succ(sx);
        }
        return true;
    }

    public static void main(String[] args) {
        TestPalindromo testPalindromo = new TestPalindromo();

        testPalindromo.inizializza1();
        testPalindromo.stampaSD();
        System.out.println();
        testPalindromo.stampaDS();
        System.out.println();
        System.out.println("Palindroma? " + testPalindromo.palindromo());

        testPalindromo.inizializza2();
        testPalindromo.stampaSD();
        System.out.println();
        testPalindromo.stampaDS();
        System.out.println();
        System.out.println("Palindroma? " + testPalindromo.palindromo());
    }
}
