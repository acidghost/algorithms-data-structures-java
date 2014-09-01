package it.uniba.di.itps.asd.exams.Lab20100902.abr;

/**
 * Created by acidghost on 01/09/14.
 */
public interface ABR extends Iterable {
    public boolean isEmpty();
    public ABR leftSubTree();
    public ABR rightSubTree();
    public Comparable root();
    public void insertValue(Comparable value);
}
