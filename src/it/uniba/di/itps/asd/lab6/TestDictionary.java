package it.uniba.di.itps.asd.lab6;

import it.uniba.di.itps.asd.structures.ArraySorted;
import it.uniba.di.itps.asd.structures.Dictionary;
import it.uniba.di.itps.asd.structures.exceptions.EmptyStructureException;

/**
 * Created by acidghost on 11/06/14.
 */
public class TestDictionary {

    private static void initialize(Dictionary d) {
        d.insert("080123456", "Pippo");
        d.insert("080654321", "Giò");
        d.insert("081123456", "Lisa");
        d.insert("081654321", "Gennarino");
        d.insert("347112233", "Emy");
    }

    private static void initialize2(Dictionary d) {
        d.insert("080123456","Pippo");
        d.insert("080123456","Pippo2");
    }

    public static void main(String[] args) {

        Dictionary dict = new ArraySorted();
        initialize(dict);

        try {
            dict.delete("081654321");
        } catch (EmptyStructureException e) {
            e.printStackTrace();
        }

        Object s1 = dict.search("081123456");
        System.out.println("Searching for " + "'081123456':\t" + (s1 != null ? s1 : "false"));
        Object s2 = dict.search("0805479860");
        System.out.println("Searching for " + "'0805479860':\t" + (s2 != null ? s2 : "false"));

        Dictionary dict2 = new ArraySorted();
        initialize2(dict2);
        System.out.println(dict2.search("080123456"));

    }

}
