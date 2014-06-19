package it.uniba.di.itps.asd.structures.deque;

/**
 * Created by acidghost on 19/06/14.
 */
public interface DoubleQueue {

    public void accoda(Object elemento);
    public Object leggicoda();
    public void fuoricoda();
    public void inpila(Object elemento);
    public Object leggitesta();
    public void fuoritesta();
    public boolean codavuota();

}
