package it.uniba.di.itps.asd.exams.Lab20090907;

/**
 * Created by acidghost on 01/09/14.
 */
class NodoPF implements Nodo {
    private String e;
    protected NodoPF sin;
    protected NodoPF des;
    private String eSin;
    private String eDes;

    NodoPF(String e) {
        this.e = e;
        sin = des = null;
    }

    protected void setSin(NodoPF sin, String e) {
        this.sin = sin;
        this.eSin = e;
    }

    protected void setDes(NodoPF des, String e) {
        this.des = des;
        this.eDes = e;
    }

    @Override
    public String etichettaNodo() {
        return e;
    }

    @Override
    public String etichettaRamoSin() {
        return eSin;
    }

    @Override
    public String etichettaRamoDes() {
        return eDes;
    }
}
