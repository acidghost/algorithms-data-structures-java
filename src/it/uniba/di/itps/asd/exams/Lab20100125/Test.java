package it.uniba.di.itps.asd.exams.Lab20100125;

import it.uniba.di.itps.asd.exams.Lab20100125.animals.*;
import it.uniba.di.itps.asd.exams.Lab20100125.serie.Serie;
import it.uniba.di.itps.asd.exams.Lab20100125.serie.SerieDL;

import java.util.Random;

/**
 * Created by acidghost on 16/06/14.
 */
public class Test {

    private static Object[] classes = {
            new Cane(), new Gatto(), new Leone(), new Scorpione(), new Tucano()
    };

    public static void inizializza(Serie serie) {
        Random rnd = new Random();
        for(int i=0; i<30; i++) {
            serie.add(classes[rnd.nextInt(classes.length)]);
        }
    }

    public static void main(String[] args) {

        Serie serie = new SerieDL();
        inizializza(serie);

        Istogramma istogramma = new Istogramma(serie);
        istogramma.print();

    }

}
