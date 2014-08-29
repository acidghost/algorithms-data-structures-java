package it.uniba.di.itps.asd.exams.Lab20090216;

import java.util.Date;

/**
 * Created by acidghost on 29/08/14.
 */
public class Partita implements Comparable {
    public Date data;
    public String sqOspitata;
    public String sqOspitante;
    public int retiOspitata;
    public int retiOspitante;

    public Partita(Date data) {
        this.data = data;
    }

    public Partita(Date data, String sqOspitante, String sqOspitata, int retiOspitante, int retiOspitata) {
        this(data);
        this.sqOspitante = sqOspitante;
        this.sqOspitata = sqOspitata;
        this.retiOspitante = retiOspitante;
        this.retiOspitata = retiOspitata;
    }

    @Override
    public int compareTo(Object o) {
        return data.compareTo(((Partita) o).data);
    }

    @Override
    public String toString() {
        return data.toString() + "\t" + sqOspitante + " " + retiOspitante + " - " + retiOspitata + " " + sqOspitata;
    }
}
