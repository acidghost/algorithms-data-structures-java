package it.uniba.di.itps.asd.lab7;

/**
 * Created by acidghost on 11/06/14.
 */
public class InfoFornitore extends InfoDitta {

    public enum Tipologia {
        PRINCIPALE, SECONDARIO
    }

    private Tipologia tipologia;

    public InfoFornitore(String ragioneSociale, String sede, Tipologia tipo) {
        super(ragioneSociale, sede);
        this.tipologia = tipo;
    }

    public Tipologia getTipologia() {
        return tipologia;
    }

    public void setTipologia(Tipologia tipologia) {
        this.tipologia = tipologia;
    }

}
