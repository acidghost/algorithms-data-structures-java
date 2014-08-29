package it.uniba.di.itps.asd.structures.list;

import java.util.Iterator;

/**
 * Created by acidghost on 29/08/14.
 */
public class DoubleLinkedList implements List {
    private DoublePointer head = null;

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public Object readList(Position p) {
        if(isEmpty()) {
            throw new IndexOutOfBoundsException("Lista vuota");
        }
        if(p == firstList()) {
            return head.link.value;
        } else {
            return ((DoublePointer) p).link.next.link.value;
        }
    }

    @Override
    public void writeList(Object e, Position p) {
        if(isEndList(p)) {
            throw new IndexOutOfBoundsException("Posizione fine lista non valida");
        } else {
            ((DoublePointer) p).link.next.link.value = e;
        }
    }

    @Override
    public Position firstList() {
        return null;
    }

    @Override
    public boolean isEndList(Position p) {
        if (isEmpty()) return true;
        if (p != firstList()) {
            if (((DoublePointer) p).link.next == null) return true;
        }
        return false;
    }

    @Override
    public Position next(Position p) {
        if (isEndList(p))
            throw new IndexOutOfBoundsException("Posizione fine lista non valida");
        if (isEmpty())
            throw new IndexOutOfBoundsException("Lista vuota");
        if (p == firstList()) // p==null
            return head;
        else
            return ((DoublePointer) p).link.next;
    }

    @Override
    public Position previous(Position p) {
        if(p == firstList()) {
            throw new IndexOutOfBoundsException("Posizione inizio lista non valida");
        }
        if(isEmpty()) {
            throw new IndexOutOfBoundsException("Lista vuota");
        }
        return ((DoublePointer) p).link.previous;
    }

    @Override
    public void insert(Object e, Position p) {
        DoublePointer temp, q;
        if (!isEmpty()) {
            if (firstList() == p) {
                temp = head;
                head = new DoublePointer(new DoubleCell(e));
                head.link.next = temp;
                temp.link.previous = head;
            }
            else {
                temp = ((DoublePointer) p).link.next;
                q = new DoublePointer(new DoubleCell(e));
                ((DoublePointer) p).link.next = q;
                q.link.next = temp;
                if (temp != null) //se elemento non è quello in ultima posizione
                    temp.link.previous = q;
                q.link.previous = (DoublePointer) p;
            }
        } else {
            head = new DoublePointer(new DoubleCell(e));
        }
    }

    @Override
    public void remove(Position p) {
        if(isEndList(p)) {
            throw new IndexOutOfBoundsException("Posizione fine lista non valida");
        }
        if(p == firstList()) {
            head = head.link.next;
            head.link.previous = null;
        } else {
            if(isEndList(((DoublePointer) p).link.next)) {
                ((DoublePointer) p).link.next = null;
            } else {
                ((DoublePointer) p).link.next = ((DoublePointer) p).link.next.link.next;
                ((DoublePointer) p).link.previous = ((DoublePointer) p).link.previous.link.previous;
            }
        }
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    public static void main(String[] args) {
        List list = new DoubleLinkedList();

        System.out.println("Creazione di lista 1");
        System.out.println("la lista inizialmente e' vuota: " + list.isEmpty() + "\n");

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
        Position q = null;
        while (!list.isEndList(p)) {
            q = p;
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

        // BUG HERE! doesn't insert the element
        //@Todo: resolve this bug..
        System.out.println("inserimento elemento posizione predecessore di 4");
        list.insert("posizione 3", list.previous(posizione4));

        p = list.firstList();

        while (!list.isEndList(p)) {

            System.out.println(list.readList(p));
            p = list.next(p);
        }

        System.out.println("sovrascivo elemento posizione 4");
        posizione4 = list.next(list.next(list.next(list.firstList())));
        list.writeList("sovrascritto", posizione4);

        p = list.firstList();

        while (!list.isEndList(p)) {

            System.out.println(list.readList(p));
            p = list.next(p);
        }

    }
}
