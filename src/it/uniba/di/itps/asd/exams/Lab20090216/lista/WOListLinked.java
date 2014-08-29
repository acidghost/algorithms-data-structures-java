package it.uniba.di.itps.asd.exams.Lab20090216.lista;

import it.uniba.di.itps.asd.exams.Lab20090216.Partita;

import java.util.Iterator;

/**
 * Created by acidghost on 29/08/14.
 */
public class WOListLinked implements ListaOrdinata {
    protected Puntatore inizioLista = null;
    private int n = 0;

    @Override
    public void insert(Comparable e) {
        Puntatore p = new Puntatore(new Cella(e));
        if(n == 0) {
            p.link.next = inizioLista;
            inizioLista = p;
        } else {
            Puntatore tmp = inizioLista;
            Puntatore prev = null;
            while(tmp.link.value.compareTo(e) < 0) {
                prev = tmp;
                tmp = tmp.link.next;
                if(tmp == null)
                    break;
            }
            if(prev == null) {
                inizioLista = new Puntatore(new Cella(e, tmp));
            } else {
                prev.link.next = new Puntatore(new Cella(e, tmp));
            }
        }
        n++;
    }

    @Override
    public int numElementi() {
        return n;
    }

    @Override
    public Iterator iterator() {
        return new WOListLinkedIterator(this);
    }
}
