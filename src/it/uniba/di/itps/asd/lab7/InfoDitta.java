package it.uniba.di.itps.asd.lab7;

/**
 * Created by acidghost on 11/06/14.
 */
public abstract class InfoDitta {

    private String ragioneSociale;
    private String sede;

    public InfoDitta(String ragioneSociale, String sede) {
        this.ragioneSociale = ragioneSociale;
        this.sede = sede;
    }

    public String getRagioneSociale() {
        return ragioneSociale;
    }

    public void setRagioneSociale(String ragioneSociale) {
        this.ragioneSociale = ragioneSociale;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }
}
