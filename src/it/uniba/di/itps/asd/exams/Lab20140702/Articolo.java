package it.uniba.di.itps.asd.exams.Lab20140702;

import it.uniba.di.itps.asd.exams.Lab20140702.list.AddOnlyList;
import it.uniba.di.itps.asd.exams.Lab20140702.list.VectorList;

/**
 * Created with IntelliJ IDEA.
 * User: acidghost
 * Date: 31/08/14
 * Time: 18:06
 * To change this template use File | Settings | File Templates.
 */
public class Articolo {
    public AddOnlyList<String> autori;
    public int volume;

    public Articolo(int volume, String... autori) {
        this.volume = volume;
        this.autori = new VectorList<String>();
        for(String autore : autori) {
            this.autori.add(autore);
        }
    }
}
