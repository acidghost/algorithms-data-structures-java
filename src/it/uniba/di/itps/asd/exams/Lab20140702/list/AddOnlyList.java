package it.uniba.di.itps.asd.exams.Lab20140702.list;

/**
 * Created with IntelliJ IDEA.
 * User: acidghost
 * Date: 31/08/14
 * Time: 17:51
 * To change this template use File | Settings | File Templates.
 */
public interface AddOnlyList<S> extends Iterable<S> {
    public void add(S e);
    public String toString();
}
