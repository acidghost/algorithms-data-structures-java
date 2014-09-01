package it.uniba.di.itps.asd.exams.Lab20090907;

/**
 * Created by acidghost on 01/09/14.
 */
public interface ABE {
    public boolean ABEVuoto();
    public Nodo radice();
    public Nodo sin(Nodo v);
    public Nodo des(Nodo v);
    public void aggiungiRadice(String e);
    public void innestaSin(Nodo u, ABE albero, String e);
    public void innestaDes(Nodo u, ABE albero, String e);
}
