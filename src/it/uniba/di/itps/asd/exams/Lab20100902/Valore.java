package it.uniba.di.itps.asd.exams.Lab20100902;

/**
 * Created by acidghost on 01/09/14.
 */
public class Valore implements Comparable {
    public String parola;
    public int linea;

    public Valore(String parola, int linea) {
        this.parola = parola;
        this.linea = linea;
    }

    @Override
    public int compareTo(Object o) {
        Valore v = (Valore) o;
        if(parola.compareTo(v.parola) == 0 && linea == v.linea) {
            return 0;
        } else {
            if(parola.compareTo(v.parola) == 0) {
                return (linea < v.linea) ? -1 : 1;
            } else {
                return parola.compareTo(v.parola);
            }
        }
    }

    @Override
    public String toString() {
        return parola + ", " + linea;
    }
}
