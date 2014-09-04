package it.uniba.di.itps.asd.exams.Lab20110215;

/**
 * Created by acidghost on 04/09/14.
 */
public interface CircList<T> extends Iterable<T> {
    public void addCircList(T item);
    public void delCircList();
    public T value();
    public boolean isEmpty();
    public int numItem();
    public void setDir(Direzione direzione);
    public void ruota();
}
