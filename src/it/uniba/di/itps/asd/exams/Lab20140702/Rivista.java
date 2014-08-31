package it.uniba.di.itps.asd.exams.Lab20140702;

import it.uniba.di.itps.asd.exams.Lab20140702.dict.Dictionary;
import it.uniba.di.itps.asd.exams.Lab20140702.dict.LinkedDict;

/**
 * Created with IntelliJ IDEA.
 * User: acidghost
 * Date: 31/08/14
 * Time: 18:39
 * To change this template use File | Settings | File Templates.
 */
public class Rivista {
    protected Dictionary<String, Articolo> articoli = new LinkedDict<String, Articolo>();
    protected Dictionary<Integer, Boolean> volumi = new LinkedDict<Integer, Boolean>();

    public void addArticle(String title, Articolo dati) {
        articoli.insert(title, dati);
    }

    public void addVolume(int volume, boolean pubblicato) {
        volumi.insert(volume, pubblicato);
    }
}
