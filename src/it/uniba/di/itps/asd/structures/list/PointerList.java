package it.uniba.di.itps.asd.structures.list;

import java.util.Iterator;

/**
 * Created by acidghost on 28/08/14.
 */
public class PointerList implements List {
    public static final int MAXLEN = 100;
    private static Record[] space = new Record[MAXLEN];
    static {
        int i;
        space[0] = (new PointerList()).new Record(null, new Cursor(0));
        for (i = 1; i < space.length - 1; i++) {
            space[i]=(new PointerList()).new Record(null,new Cursor(i+1));
        }
        space[i] = (new PointerList()).new Record(null, new Cursor(0));
    }

    private class Record {
        public Object value;
        public Position next;

        Record(Object value, Position next) {
            this.value = value;
            this.next = next;
        }
    }

    private Cursor freeList = new Cursor(1);
    private Cursor start = null;

    @Override
    public boolean isEmpty() {
        return (start == null);
    }

    @Override
    public Object readList(Position p) {
        int index = ((Cursor) p).pointer;
        int pos;
        if(index == 0) {
            pos = start.pointer;
        } else {
            pos = ((Cursor) space[index].next).pointer;
        }
        return space[pos].value;
    }

    @Override
    public void writeList(Object e, Position p) {
        int index = ((Cursor) p).pointer;
        int pos;
        if(index == 0) {
            pos = start.pointer;
        } else {
            pos = ((Cursor) space[index].next).pointer;
        }
        space[pos].value = e;
    }

    @Override
    public Position firstList() {
        return new Cursor(0);
    }

    @Override
    public boolean isEndList(Position p) {
        int index = ((Cursor) p).pointer;
        if(isEmpty()) {
            return true;
        } else if(index == 0) {
            return false;
        } else {
            return ((Cursor) space[index].next).pointer == 0;
        }
    }

    @Override
    public Position next(Position p) {
        int index = ((Cursor) p).pointer;
        if(isEndList(p)) {
            throw new IndexOutOfBoundsException("Fine lista");
        }
        if(index == 0) {
            return start;
        } else {
            return space[index].next;
        }
    }

    @Override
    public Position previous(Position p) {
        int index = ((Cursor) p).pointer;
        if(index == 0) {
            throw new IndexOutOfBoundsException("Inizio lista");
        }
        Position prev = firstList();
        if(index == start.pointer) {
            return prev;
        }
        while(!isEndList(prev)) {
            if(((Cursor) next(prev)).pointer == index) {
                return prev;
            } else {
                prev = next(prev);
            }
        }
        throw new IndexOutOfBoundsException("Posizione " + index + " non valida");
    }

    @Override
    public void insert(Object e, Position p) {
        int index = ((Cursor) p).pointer;
        int freePosition = freeList.pointer;
        Cursor tmp;
        if(!isEmpty()) {
            tmp = (Cursor) space[freePosition].next;
            space[freePosition].value = e;
            if(index == 0) {
                space[freePosition].next = start;
                start = freeList;
            } else {
                space[freePosition].next = space[index].next;
                space[index].next = freeList;
            }
            freeList = tmp;
        } else {    // Empty list
            start = freeList;
            freeList = (Cursor) space[freePosition].next;
            space[freePosition].value = e;
            space[freePosition].next = new Cursor(0);
        }
    }

    @Override
    public void remove(Position p) {
        Cursor tmp;
        int index = ((Cursor) p).pointer;
        int pos;
        if(index == 0) {
            pos = start.pointer;
            tmp = start;
            start = (Cursor) space[pos].next;
        } else {
            pos = ((Cursor) space[index].next).pointer;
            tmp = (Cursor) space[index].next;
            space[index].next= space[pos].next;
        }
        // p coincide con primolista
        space[pos].next = start;
        start = tmp;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    public static void main(String[] args) {
        List list = new PointerList();

        System.out.println("Creazione di lista 1");
        System.out.println("la lista inizialmente e' vuota: " + list.isEmpty()+ "\n");

        list.insert(null, list.firstList());
        list.insert("b", list.firstList());
        list.insert("c", list.firstList());
        list.insert("d", list.firstList());
        list.insert("e", list.firstList());

        System.out.println("Stampo tutti gli elementi");
        Position p = list.firstList();

        while (!list.isEndList(p)) {

            System.out.println(list.readList(p));
            p = list.next(p);
        }

        System.out.println("inserisco f in seconda posizione \n");
        list.insert("f", list.next(list.firstList()));

        System.out.println("Stampo tutti gli elementi");
        p = list.firstList();

        while (!list.isEndList(p)) {

            System.out.println(list.readList(p));
            p = list.next(p);
        }

        System.out.println("\n eliminazione elemento in prima posizione");
        list.remove(list.firstList());

        p = list.firstList();

        while (!list.isEndList(p)) {

            System.out.println(list.readList(p));
            p = list.next(p);
        }



        System.out.println("\n eliminazione elemento in ultima posizione");
        p = list.firstList();
        Position q=null;
        while (!list.isEndList(p)) {
            q=p;
            p = list.next(p);
        }

        list.remove(q);

        p = list.firstList();

        while (!list.isEndList(p)) {
            if (list.readList(p) != null)
                System.out.println(list.readList(p));
            p = list.next(p);
        }

        System.out.println("\n eliminazione elemento in posizione 3");
        q = list.next(list.next(list.firstList()));
        list.remove(q);

        p = list.firstList();

        while (!list.isEndList(p)) {

            System.out.println(list.readList(p));
            p = list.next(p);
        }




        System.out.println("Inserimento elemento fine in coda");
        list.insert("fine", p);

        p = list.firstList();

        while (!list.isEndList(p)) {

            System.out.println(list.readList(p));
            p = list.next(p);
        }

        System.out.println("\n");

        System.out.println("inserimento elemento in posizione 4");
        Position posizione4 = list.next(list.next(list.next(list.firstList())));
        list.insert("posizione 4", posizione4);


        p = list.firstList();

        while (!list.isEndList(p)) {

            System.out.println(list.readList(p));
            p = list.next(p);
        }
        System.out.println("inserimento elemento posizione predecessore di 4");
        list.insert("posizione 3", list.previous(posizione4));

        p = list.firstList();

        while (!list.isEndList(p)) {

            System.out.println(list.readList(p));
            p = list.next(p);
        }


        System.out.println("sovrascivo elemento posizione 4");
        posizione4 = list.next(list.next(list.next(list.firstList())));
        list.insert("sovrascritto", posizione4);

        p = list.firstList();

        while (!list.isEndList(p)) {

            System.out.println(list.readList(p));
            p = list.next(p);
        }

        System.out.println("Creazione di Lista 2");
        List listNew = new PointerList();

        System.out.println("la lista inizialmente e' vuota: " + listNew.isEmpty()+ "\n");

        listNew.insert("c", listNew.firstList());
        listNew.insert("c", listNew.firstList());
        listNew.insert("e", listNew.firstList());


        System.out.println("Stampa Lista 1");
        p = list.firstList();

        while (!list.isEndList(p)) {

            System.out.println(list.readList(p));
            p = list.next(p);
        }

        System.out.println("Stampa Lista 2");
        p = listNew.firstList();

        while (!listNew.isEndList(p)) {

            System.out.println(listNew.readList(p));
            p = listNew.next(p);
        }

    }
}
