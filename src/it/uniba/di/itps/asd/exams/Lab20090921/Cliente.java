package it.uniba.di.itps.asd.exams.Lab20090921;

/**
 * Created by acidghost on 27/08/14.
 */
public class Cliente {
    private int tempoArrivo;
    private int tempoPartenza;

    public Cliente(int tempoArrivo) {
        this.tempoArrivo = tempoArrivo;
    }

    public int getOraArrivo() {
        return tempoArrivo;
    }

    public void setOraPartenza(int ora) {
        tempoPartenza = ora;
    }

    public int getOraPartenza() {
        return tempoPartenza;
    }

    public int tempoAttesa() {
        return tempoPartenza - tempoArrivo;
    }
}
