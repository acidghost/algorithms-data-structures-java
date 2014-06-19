package it.uniba.di.itps.asd.structures.queue;

/**
 * Created by acidghost on 19/06/14.
 */
public interface Queue {

    public boolean isEmpty();
    public void enqueue(Object e);
    public void dequeue();
    public Object first();

}
