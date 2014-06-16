package it.uniba.di.itps.asd.lab8;

import it.uniba.di.itps.asd.structures.*;
import it.uniba.di.itps.asd.structures.exceptions.EmptyStructureException;

/**
 * Created by acidghost on 12/06/14.
 */
public class TestHashTables {

    private static void inizializza(Dictionary d) {
        d.insert("080123456","Pippo");
        d.insert("080654321", "Giò");
        d.insert("081123456", "Lisa");
        d.insert("081654321", "Gennarino");
        d.insert("347112233", "Emy");
    }

    public static void main(String[] args) {
        Dictionary rubrica = new HashTableOpen(4, new HashDivision(), new ScanLinear());
        inizializza(rubrica);
        // Should be Gennarino
        System.out.println(rubrica.search("081654321"));
        // Should be null
        System.out.println(rubrica.search("081654323"));
        // Should be Lisa
        System.out.println(rubrica.search("081123456"));

        try {
            rubrica.delete("081654321");
            System.out.println(rubrica.search("081654321"));
            rubrica.delete("081654321");
            rubrica.delete("081654322");
        } catch (EmptyStructureException e) {
            e.printStackTrace();
        }

        rubrica = new HashTableCollisions(4, new HashDivision());
        inizializza(rubrica);
        // Should be Gennarino
        System.out.println(rubrica.search("081654321"));
        // Should be null
        System.out.println(rubrica.search("081654323"));
        // Should be Lisa
        System.out.println(rubrica.search("081123456"));

        try {
            rubrica.delete("081654321");
            System.out.println(rubrica.search("081654321"));
            rubrica.delete("081654321");
            rubrica.delete("081654322");
        } catch (EmptyStructureException e) {
            e.printStackTrace();
        }

    }

}
