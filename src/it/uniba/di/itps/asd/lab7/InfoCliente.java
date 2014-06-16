package it.uniba.di.itps.asd.lab7;

/**
 * Created by acidghost on 11/06/14.
 */
public class InfoCliente extends InfoDitta {

    private int anno;

    public InfoCliente(String ragioneSociale, String sede, int anno) {
        super(ragioneSociale, sede);
        this.anno = anno;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }
}
