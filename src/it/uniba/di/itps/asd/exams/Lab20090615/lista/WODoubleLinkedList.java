package it.uniba.di.itps.asd.exams.Lab20090615.lista;

/**
 * Created by acidghost on 29/08/14.
 */
public class WODoubleLinkedList implements AOLista {
    private Elemento listHead = new Elemento(null);

    @Override
    public Posizione firstList() {
        return listHead;
    }

    @Override
    public void insert(Object e, Posizione p) {
        Elemento elemento = new Elemento(e);
        Elemento q = (Elemento) p;
        elemento.next = q;
        elemento.prev = q.prev;
        q.prev.next = elemento;
        q.prev = elemento;
        /*
        Elemento el = (Elemento) p;
        Elemento elemento = new Elemento(e);
        if(listHead.next == null){
            listHead.next = elemento;
            listHead.prev = elemento;
            elemento.next = listHead;
            elemento.prev = listHead;
        } else if(el.value == null) {
            elemento.next = listHead.next;
            elemento.prev = listHead;
            listHead.prev.next = elemento;
            listHead.next.prev = elemento;
        } else if(endList(p)) {
            elemento.next = listHead;
            elemento.prev = listHead.prev;
            listHead.prev.next = elemento;
            listHead.prev = elemento;
        } else {
            elemento.next = el;
            elemento.prev = el.prev;
            el.prev.next = elemento;
            el.prev = elemento;
        }
        */
    }

    @Override
    public Posizione succ(Posizione p) {
        if(endList(p)) {
            throw new EccezioneLista("Fine lista raggiunta");
        }
        return ((Elemento) p).next;
    }

    @Override
    public Posizione pred(Posizione p) {
        if(p == firstList()) {
            throw new EccezioneLista("Inizio lista");
        }
        return ((Elemento) p).prev;
    }

    @Override
    public boolean endList(Posizione p) {
        return ((Elemento) p).next == listHead;
    }

    @Override
    public Object readList(Posizione p) {
        if(endList(p)) {
            throw new EccezioneLista("Lista terminata");
        }
        return ((Elemento) p).next.value;
    }
}
