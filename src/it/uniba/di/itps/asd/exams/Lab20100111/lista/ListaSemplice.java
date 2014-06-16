package it.uniba.di.itps.asd.exams.Lab20100111.lista;

/**
 * Created by acidghost on 16/06/14.
 */
public interface ListaSemplice {

    /**
     * Aggiunge o in coda
     * @param o
     */
    public void add(Object o);

    /**
     * Si posiziona sul primo elemento
     */
    public void reset();

    /**
     * Restituisce elemento puntato
     * @return elemento puntato
     */
    public Object next();

    /**
     * Verifica che ci siano altri elementi
     * @return true se ve ne sono, false altrimenti
     */
    public boolean hasNext();

}
