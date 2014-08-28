package it.uniba.di.itps.asd.structures.list;

/**
 * Created by acidghost on 28/08/14.
 */
public interface List<T> {
    /**
     * @return true se la lista è vuota falso altrimenti
     */
    public boolean isEmpty();

    /**
     * @param p posizione dell'elemento da leggere
     * @return il valore contenuto nell'elemento di posizione p
     * (sollevare eccezione PosizioneNonValida oppure OutOfBoundException)
     */
    public T readList(Position p);

    /**
     * @param e valore da scrivere
     * @param p posizione in cui scrivere l'elemento
     * (sollevare eccezione PosizioneNonValida o IndexOutOfBoundsException)
     */
    public void writeList(T e, Position p);

    /**
     * @return restituisce la posizione della testa della lista
     */
    public Position firstList();

    /**
     * @param p posizione
     * @return true se la p è la posizione dopo l'ultimo elemento
     */
    public boolean isEndList(Position p);

    /**
     * @param p posizione
     * @return posizione successiva alla posizione passata
     * sollevare una eccezione nel caso in cui viene passata l'ultima posizione
     */
    public Position next(Position p);

    /**
     * @param p posizione
     * @return la posizione dell'elemento precedente
     * lanciare una eccezione se poisizione == primolista
     */
    public Position previous(Position p);

    /**
     * @param e elemento
     * @param p posizione dopo la quale inserire un nuovo elemento
     * eccezione posizione non valida
     */
    public void insert(T e, Position p);

    /**
     * @param p posizione
     * rimuove l'elemento in posizion passata
     * solleva un eccezione per posizione non valida
     */
    public void remove(Position p);
}
