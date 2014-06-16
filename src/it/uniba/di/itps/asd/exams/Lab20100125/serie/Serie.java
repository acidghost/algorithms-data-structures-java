package it.uniba.di.itps.asd.exams.Lab20100125.serie;

/**
 * Created with IntelliJ IDEA.
 * User: acidghost
 * Date: 16/06/14
 * Time: 20:31
 * To change this template use File | Settings | File Templates.
 */
public interface Serie {

    public Posizione first();
    public void add(Object e);
    public Posizione next(Posizione p);
    public Posizione pred(Posizione p);
    public boolean end(Posizione p);
    public Object read(Posizione p);

}
