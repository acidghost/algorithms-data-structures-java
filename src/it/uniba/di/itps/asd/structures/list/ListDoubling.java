package it.uniba.di.itps.asd.structures.list;

import it.uniba.di.itps.asd.structures.exceptions.EmptyStructureException;

/**
 * Created by acidghost on 28/08/14.
 */
public class ListDoubling implements List {
    private Object[] list = new Object[1];
    private int n = 0;

    @Override
    public boolean isEmpty() {
        return (n == 0);
    }

    @Override
    public Object readList(Position p) {
        Index index = (Index) p;
        if(!checkPosition(p)) {
            throw new IndexOutOfBoundsException("La posizione " + index.index + " non e' valida");
        }
        return list[index.index];
    }

    @Override
    public void writeList(Object e, Position p) {
        Index index = (Index) p;
        if(!checkPosition(p)) {
            throw new IndexOutOfBoundsException("La posizione " + index.index + " non e' valida");
        }
        list[index.index] = e;
    }

    @Override
    public Position firstList() {
        return new Index();
    }

    @Override
    public boolean isEndList(Position p) {
        return ((Index) p).index == n;
    }

    @Override
    public Position next(Position p) {
        Index i = (Index) p;
        if(isEndList(p)) {
            throw new IndexOutOfBoundsException("La posizione " + i.index + " e' l'ultima della lista");
        }
        Index next = new Index();
        next.index = i.index+1;
        return next;
    }

    @Override
    public Position previous(Position p) {
        Index i = (Index) p;
        if(((Index) firstList()).index == i.index) {
            throw new IndexOutOfBoundsException("La posizione " + i.index + " e' la prima della lista");
        }
        Index prev = new Index();
        prev.index = i.index-1;
        return prev;
    }

    @Override
    public void insert(Object e, Position p) {
        if(!checkPosition(p)) {
            throw new IndexOutOfBoundsException("Posizione di inserimento non valida");
        }
        Index index = (Index) p;
        System.arraycopy(list, index.index, list, index.index + 1, n - index.index);
        list[index.index] = e;
        n++;
        if(n == list.length) {
            Object[] tmp = new Object[n * 2];
            System.arraycopy(list, 0, tmp, 0, n);
            list = tmp;
        }
    }

    @Override
    public void remove(Position p) {
        Index index = (Index) p;
        if(isEmpty()) {
            throw new EmptyStructureException("La lista e' vuota");
        }
        if(!checkPosition(p)) {
            throw new IndexOutOfBoundsException("La posizione " + index.index + " non e' valida");
        }
        System.arraycopy(list, index.index + 1, list, index.index, n - 1 - index.index);
        n--;
        if(n <= list.length/4) {
            Object[] tmp = new Object[n / 2];
            System.arraycopy(list, 0, tmp, 0, n);
            list = tmp;
        }
    }

    private boolean checkPosition(Position p) {
        Index i = (Index) p;
        return (i.index >= 0 || i.index <= n);
    }

    public static void main(String[] args) {
        List list = new ListDoubling();
        System.out.println("la lista è vuota: " + list.isEmpty()+ "\n");
        list.insert("a", list.firstList());
        list.insert("b", list.firstList());
        list.insert("c", list.firstList());
        list.insert("d", list.firstList());
        list.insert("e", list.firstList());
        System.out.println("inserisco f in seconda posizione \n");
        list.insert("f", list.next(list.firstList()));
        System.out.println("Si stampa la lista");
        Position p = list.firstList();
        while (!list.isEndList(p)) {
            System.out.println(list.readList(p));
            p = list.next(p);
        }
        System.out.println("\n rimoz. Elem. in prima posizione");
        list.remove(list.firstList());
        p = list.firstList();
        while (!list.isEndList(p)) {
            System.out.println(list.readList(p));
            p = list.next(p);
        }
        System.out.println("\n rimoz. Elem. in ultima posizione");
        list.remove(list.next(list.next(list.next(list.next(list.firstList())))));
        p = list.firstList();
        while (!list.isEndList(p)) {
            System.out.println(list.readList(p));
            p = list.next(p);
        }
    }
}
