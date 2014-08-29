package it.uniba.di.itps.asd.structures.list;

import java.util.Iterator;

/**
 * Created by acidghost on 28/08/14.
 */
public class LinkedList implements List {
    private Pointer head = null;

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
            return ((Pointer) p).link.next.link.value;
        }
    }

    @Override
    public void writeList(Object e, Position p) {
        if(isEndList(p)) {
            throw new IndexOutOfBoundsException("Posizione fine lista non valida");
        } else {
            ((Pointer) p).link.next.link.value = e;
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
            if (((Pointer) p).link.next == null) return true;
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
            return ((Pointer) p).link.next;
    }

    @Override
    public Position previous(Position p) {
        if(p == firstList()) {
            throw new IndexOutOfBoundsException("Posizione inizio lista non valida");
        }
        if(isEmpty()) {
            throw new IndexOutOfBoundsException("Lista vuota");
        }
        Pointer pos = (Pointer) firstList();
        while(!isEndList(pos)) {
            if(next(pos) == p) {
                return pos;
            }
        }
        throw new IndexOutOfBoundsException("Impossibile trovare l'elemento precedente...");
    }

    @Override
    public void insert(Object e, Position p) {
        Pointer temp, q;
        if (!isEmpty()) {
            if (firstList() == p) {
                temp = head;
                head = new Pointer(new Cell(e));
                head.link.next = temp;
            } else {
                temp = ((Pointer) p).link.next;
                q = new Pointer(new Cell(e));
                ((Pointer) p).link.next = q;
                q.link.next = temp;
            }
        } else {
            head = new Pointer(new Cell(e));
        }
    }

    @Override
    public void remove(Position p) {
        if(isEmpty()) {
            throw new IndexOutOfBoundsException("Lista vuota");
        }
        if(p == firstList()) {
            head = head.link.next;
        } else if(isEndList(p)) {
            //((Pointer) previous(p)).link.next = null;
            throw new IndexOutOfBoundsException("Posizione fine lista non valida");
        } else {
            ((Pointer) p).link.next = ((Pointer) p).link.next.link.next;
        }
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    public static void main(String[] args) {
        List list = new LinkedList();

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


    }
}
