package it.uniba.di.itps.asd.exams.Lab20100111;

import it.uniba.di.itps.asd.exams.Lab20100111.bio.*;

/**
 * Created by acidghost on 16/06/14.
 */
public class Main {

    public static void main(String[] args) {
        DNA dna = new DNA("TACCTTAAGAGCGAG");
        Proteina proteina = new Proteina("WNKGFCADEFWWYQ");

        System.out.println("DNA:\t\t" + dna.toString());
        System.out.println("Proteina:\t\t" + proteina.toString());

        try {
            dna = new DNA("HELLO WORLD");
            System.out.println("DNA:\t\t" + dna.toString());
        } catch (IllegalNucleotide ex) {
            System.out.println("DNA non valido\t" + ex.getMessage());
        }

        try {
            proteina = new Proteina("HELLO WORLD");
            System.out.println("Proteina:\t\t" + proteina.toString());
        } catch (IllegalAminoacido ex) {
            System.out.println("Proteina non valida\t" + ex.getMessage());
        }
    }

}
