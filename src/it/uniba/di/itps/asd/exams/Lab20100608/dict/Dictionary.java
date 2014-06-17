package it.uniba.di.itps.asd.exams.Lab20100608.dict;

/**
 * Created with IntelliJ IDEA.
 * User: acidghost
 * Date: 17/06/14
 * Time: 19:10
 * To change this template use File | Settings | File Templates.
 */
public interface Dictionary<S> extends Iterable<S> {

    public void insert(S e, Comparable k);
    public void delete(Comparable k);
    public S search(Comparable k);

}
