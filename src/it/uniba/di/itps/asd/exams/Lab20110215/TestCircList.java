package it.uniba.di.itps.asd.exams.Lab20110215;

import java.util.Iterator;

/**
 * Created by acidghost on 04/09/14.
 */
public class TestCircList {
    public static void main(String[] args) {
        CircList<String> list = new CircListDL<String>();

        list.addCircList("alfa");
        list.addCircList("beta");
        list.addCircList("gamma");
        list.addCircList("delta");
        list.addCircList("epsilon");

        System.out.println("Stampo la lista in direzione FORWARD");
        for(String s : list) {
            System.out.println(s);
        }
        System.out.println();

        list.ruota();
        System.out.println("Stampo la lista in direzione FORWARD");
        for(String s : list) {
            System.out.println(s);
        }
        System.out.println();

        list.setDir(Direzione.BACKWARD);
        list.ruota();
        System.out.println("Stampo la lista in direzione BACKWARD");
        for(String s : list) {
            System.out.println(s);
        }
        System.out.println();

        list.setDir(Direzione.FORWARD);
        list.ruota();

        for (int i = 0; i < list.numItem(); i++) {
            if(list.value().startsWith("d")) {
                list.delCircList();
                break;
            } else {
                list.ruota();
            }
        }

        System.out.println("Stampo la lista in direzione FORWARD");
        for(String s : list) {
            System.out.println(s);
        }
        System.out.println();
    }
}
