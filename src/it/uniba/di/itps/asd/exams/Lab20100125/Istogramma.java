package it.uniba.di.itps.asd.exams.Lab20100125;

import it.uniba.di.itps.asd.exams.Lab20100125.serie.Posizione;
import it.uniba.di.itps.asd.exams.Lab20100125.serie.Serie;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: acidghost
 * Date: 16/06/14
 * Time: 20:52
 * To change this template use File | Settings | File Templates.
 */
public class Istogramma {

    HashMap<Class, Integer> istogramma;

    public Istogramma(Serie serie) {
        istogramma = new HashMap<Class, Integer>();
        Posizione p = serie.first();
        while(!serie.end(p)) {
            Object currentClass = serie.read(p);
            int currentCount = istogramma.containsKey(currentClass.getClass()) ? istogramma.get(currentClass.getClass()) : 0;
            currentCount++;
            istogramma.put(currentClass.getClass(), currentCount);
            p = serie.next(p);
        }
    }

    public void print() {
        Iterator iterator = istogramma.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<Class, Integer> entry = (Map.Entry) iterator.next();
            for(int i=0; i<entry.getValue(); i++) {
                System.out.print("*");
            }
            String className = entry.getKey().toString();
            String[] splitted = className.split("\\.");
            className = splitted[splitted.length-1];
            System.out.println(" " + className);
        }
    }

}
