package it.uniba.di.itps.asd.exams.Lab20130627;

/**
 * Created by acidghost on 03/09/14.
 */
public class Etichetta {

    private String decisione = null;
    private String attributo = null;
    private String valore = null;

    public Etichetta(String decisione) {
        this.decisione = decisione;
    }

    public Etichetta(String attributo, String valore) {
        this.attributo = attributo;
        this.valore = valore;
    }

    public boolean isDecisione() {
        return (decisione != null);
    }

    public String decisione() {
        return decisione;
    }

    public boolean testProprieta(String attributo, String valore) {
        return (this.attributo.equals(attributo) && this.valore.equals(valore));
    }

    public boolean ugualeAttributo(String attributo) {
        return this.attributo.equals(attributo);
    }

    @Override
    public String toString() {
        if(decisione==null) {
            return attributo + " = " + valore;
        } else {
            return decisione;
        }
    }
}
