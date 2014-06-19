package it.uniba.di.itps.asd.lab7;

import it.uniba.di.itps.asd.structures.dictionary.Dictionary;
import it.uniba.di.itps.asd.structures.dictionary.LinkedList;
import it.uniba.di.itps.asd.structures.exceptions.EmptyStructureException;

/**
 * Created by acidghost on 12/06/14.
 */
public class TestLinkedList {

    private static void inizializza(Dictionary d) {
        d.insert("080123456","Pippo");
        d.insert("080654321", "Giò");
        d.insert("081123456", "Lisa");
        d.insert("081654321", "Gennarino");
        d.insert("347112233", "Emy");
    }

    public static void main(String[] args) {
        Dictionary rubrica = new LinkedList();
        inizializza(rubrica);

        // Should find Gennarino
        System.out.println(rubrica.search("081654321"));

        try {
            // Delete and verify
            rubrica.delete("081654321");
            System.out.println(rubrica.search("081654321"));

            rubrica.delete("081654321");
            rubrica.delete("080123456");
            rubrica.delete("081123456");
            rubrica.delete("347112233");
            rubrica.delete("080654321");

            // Delete on empty dictionary
            rubrica.delete("021234567");
        } catch (EmptyStructureException e) {
            e.printStackTrace();
            System.exit(0);
        }

    }

}
