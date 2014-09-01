package it.uniba.di.itps.asd.exams.Lab20100902;

import it.uniba.di.itps.asd.exams.Lab20100902.abr.ABR;
import it.uniba.di.itps.asd.exams.Lab20100902.abr.ABRPF;

/**
 * Created by acidghost on 01/09/14.
 */
public class IndexGenerator {
    private ABR index;

    public IndexGenerator() {
        index = new ABRPF();
    }

    public void buildIndex(String text) {
        String[] lines = text.split("[*]");
        for (int i = 0; i < lines.length; i++) {
            String[] words = lines[i].split(" ");
            for (int j = 0; j < words.length; j++) {
                words[j] = words[j].trim();
                if(!words[j].equals(""))
                    index.insertValue(new Valore(words[j], i+1));
            }
        }
    }

    public void showIndex() {
        for(Object v : index) {
            Valore valore = (Valore) v;
            System.out.println(valore.toString());
        }
    }
}
