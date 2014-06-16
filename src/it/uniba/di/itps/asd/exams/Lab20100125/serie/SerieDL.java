package it.uniba.di.itps.asd.exams.Lab20100125.serie;

/**
 * Created with IntelliJ IDEA.
 * User: acidghost
 * Date: 16/06/14
 * Time: 20:37
 * To change this template use File | Settings | File Templates.
 */
public class SerieDL implements Serie {
    private Elemento listaHead = new Elemento(null);

    @Override
    public Posizione first() {
        return listaHead.successivo;
    }

    @Override
    public void add(Object e) {
        Elemento elemento = new Elemento(e);
        listaHead.precedente.successivo = elemento;
        elemento.precedente = listaHead.precedente;
        elemento.successivo = listaHead;
        listaHead.precedente = elemento;
    }

    @Override
    public Posizione next(Posizione p) {
        return ((Elemento) p).successivo;
    }

    @Override
    public Posizione pred(Posizione p) {
        return ((Elemento) p).precedente;
    }

    @Override
    public boolean end(Posizione p) {
        return ((Elemento) p).successivo == listaHead;
    }

    @Override
    public Object read(Posizione p) {
        return ((Elemento) p).dato;
    }
}
