package it.uniba.di.itps.asd.exams.Lab20140220;

/**
 * Created by acidghost on 02/09/14.
 */
public interface PQ<Item> extends Iterable<Item> {
    public boolean isNew();
    public void insert(Item item, int priority);
    public Item first();
    public void delFirst();
    public void changePriority(Item item, int priority);
    public int getPriority(Item item);
    public int size();
}
