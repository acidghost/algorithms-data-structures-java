package it.uniba.di.itps.asd.exams.Lab20100608;

import it.uniba.di.itps.asd.exams.Lab20100608.animali.*;
import it.uniba.di.itps.asd.exams.Lab20100608.serie.Istogramma;
import it.uniba.di.itps.asd.exams.Lab20100608.serie.Serie;

import java.util.HashMap;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: acidghost
 * Date: 18/06/14
 * Time: 14:02
 * To change this template use File | Settings | File Templates.
 */
public class Test {

    private static final Animale[] OBJECTS = new Animale[]{
            new Cane("Tizio", "Fido"),
            new Gatto("Caio", "Felix"),
            new Leone("Sempronio","Richard"),
            new Scorpione("Anne", "Biter"),
            new Tucano("Gabri","Poppy"),
            new Tucano("Gabri","Poppy")
    };

    private static final int INSTANCES = 15;

    private static void inizializza(Istogramma<Animale> istogramma, int n) {
        HashMap<String, Serie<Animale>> seriesMap = new HashMap<String, Serie<Animale>>();

        int i=0;
        Serie<Animale> cs = new Serie<Animale>(OBJECTS[i++].getClass().getSimpleName());
        seriesMap.put(cs.name, cs);
        Serie<Animale> gs = new Serie<Animale>(OBJECTS[i++].getClass().getSimpleName());
        seriesMap.put(gs.name, gs);
        Serie<Animale> ls = new Serie<Animale>(OBJECTS[i++].getClass().getSimpleName());
        seriesMap.put(ls.name, ls);
        Serie<Animale> ss = new Serie<Animale>(OBJECTS[i++].getClass().getSimpleName());
        seriesMap.put(ss.name, ss);
        Serie<Animale> ts = new Serie<Animale>(OBJECTS[i++].getClass().getSimpleName());
        seriesMap.put(ts.name, ts);

        istogramma.aggiungiSerie(cs);
        istogramma.aggiungiSerie(gs);
        istogramma.aggiungiSerie(ls);
        istogramma.aggiungiSerie(ss);
        istogramma.aggiungiSerie(ts);

        Random random = new Random();
        for(int j=0; j<n; j++ ) {
            Animale obj = OBJECTS[random.nextInt(OBJECTS.length)];
            String className = obj.getClass().getSimpleName();
            istogramma.aggiungiValore(seriesMap.get(className), obj);
        }
    }

    public static void main(String[] args) {
        Istogramma<Animale> istogramma = new Istogramma<Animale>();
        inizializza(istogramma, INSTANCES);

    }

}
