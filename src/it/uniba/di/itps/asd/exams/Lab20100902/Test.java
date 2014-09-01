package it.uniba.di.itps.asd.exams.Lab20100902;

/**
 * Created by acidghost on 01/09/14.
 */
public class Test {
    public static void main(String[] args) {
        IndexGenerator indexGenerator = new IndexGenerator();
        String txt = "prima linea * seconda linea * terza linea";
        indexGenerator.buildIndex(txt);
        indexGenerator.showIndex();

        System.out.println();

        txt = "questo testo * e' solo una prova * una prova per provare * un testo";
        indexGenerator.buildIndex(txt);
        indexGenerator.showIndex();
    }
}
