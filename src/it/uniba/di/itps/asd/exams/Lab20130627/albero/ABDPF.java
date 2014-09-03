package it.uniba.di.itps.asd.exams.Lab20130627.albero;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by acidghost on 03/09/14.
 */
public class ABDPF<E> implements ABD<E> {
    private NodoPF<E> radice = null;

    private NodoPF<E> checkNode(Nodo<E> n) {
        NodoPF<E> nodo = (NodoPF<E>) n;
        if(nodo != null && nodo.albero == this) {
            return nodo;
        }
        throw new EccezioneNodoNonValido();
    }

    @Override
    public void aggiungiRadice(E e) {
        if(radice != null) {
            throw new EccezioneAlberoNonVuoto();
        }
        radice = new NodoPF<E>(e, this);
    }

    private void aggiornaAlbero(NodoPF<E> u) {
        if(u != null) {
            u.albero = this;
            aggiornaAlbero(u.vero);
            aggiornaAlbero(u.falso);
        }
    }

    @Override
    public void innestaVero(Nodo<E> u, ABD albero) {
        NodoPF<E> nodo = checkNode(u);
        if(nodo.vero != null) {
            throw new EccezioneNodoEsistente();
        }
        try {
            albero.radice();
        } catch (EccezioneAlberoVuoto eav) {
            return;
        }
        nodo.vero = (NodoPF<E>) albero.radice();
        ((ABDPF<E>) albero).radice = null;
        aggiornaAlbero(nodo.vero);
    }

    @Override
    public void innestaFalso(Nodo<E> u, ABD albero) {
        NodoPF<E> nodo = checkNode(u);
        if(nodo.falso != null) {
            throw new EccezioneNodoEsistente();
        }
        try {
            albero.radice();
        } catch (EccezioneAlberoVuoto eav) {
            return;
        }
        nodo.falso = (NodoPF<E>) albero.radice();
        ((ABDPF<E>) albero).radice = null;
        aggiornaAlbero(nodo.falso);
    }

    @Override
    public boolean foglia(Nodo<E> u) {
        NodoPF<E> nodo = checkNode(u);
        return nodo.vero == null && nodo.falso == null;
    }

    @Override
    public Nodo<E> radice() {
        if(radice == null) {
            throw new EccezioneAlberoVuoto();
        }
        return radice;
    }

    @Override
    public Nodo<E> vero(Nodo<E> u) {
        NodoPF<E> nodo = checkNode(u).vero;
        if(nodo == null) {
            throw new EccezioneNodoInesistente();
        }
        return nodo;
    }

    @Override
    public Nodo<E> falso(Nodo<E> u) {
        NodoPF<E> nodo = checkNode(u).falso;
        if(nodo == null) {
            throw new EccezioneNodoInesistente();
        }
        return nodo;
    }

    @Override
    public E info(Nodo<E> u) {
        return checkNode(u).e;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Queue<NodoPF<E>> nodes = new LinkedList<NodoPF<E>>();

            { visita(radice); }

            private void visita(NodoPF<E> nodo) {
                if(nodo != null) {
                    nodes.add(nodo);
                    visita(nodo.vero);
                    visita(nodo.falso);
                }
            }

            @Override
            public boolean hasNext() {
                return nodes.size() > 0;
            }

            @Override
            public E next() {
                return nodes.remove().e;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
