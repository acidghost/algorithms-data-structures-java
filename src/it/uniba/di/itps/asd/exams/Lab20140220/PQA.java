package it.uniba.di.itps.asd.exams.Lab20140220;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by acidghost on 02/09/14.
 */
public class PQA<Item> implements PQ<Item> {
    protected Record coda = null;
    private int n = 0;

    private class Record {
        public Item elem;
        public int priority;
        public Record next;

        Record(Item elem, int priority) {
            this.elem = elem;
            this.priority = priority;
            next = null;
        }
    }

    @Override
    public boolean isNew() {
        return coda == null;
    }

    @Override
    public void insert(Item item, int priority) {
        if(coda == null) {
            coda = new Record(item, priority);
        } else if(coda.next == null || priority < coda.priority) {
            Record r = new Record(item, priority);
            if(priority < coda.priority) {
                r.next = coda;
                coda = r;
            } else {
                coda.next = r;
            }
        } else {
            Record r = coda;
            while (r != null) {
                Record next = r.next;
                if(next != null) {
                    if(priority >= r.priority && priority < next.priority) {
                        r.next = new Record(item, priority);
                        r.next.next = next;
                        break;
                    }
                } else {
                    r.next = new Record(item, priority);
                    break;
                }
                r = r.next;
            }
        }
        n++;
    }

    @Override
    public Item first() {
        if(isNew()) {
            throw new EmptyStructureException();
        }
        return coda.elem;
    }

    @Override
    public void delFirst() {
        if(isNew()) {
            throw new EmptyStructureException();
        }
        coda = coda.next;
        n--;
    }

    @Override
    public void changePriority(Item item, int priority) {
        if (isNew()) {
            throw new EmptyStructureException();
        }
        if(item.equals(coda.elem)) {
            if (priority == coda.priority)
                return;
            coda = coda.next;
            insert(item, priority);
            return;
        }
        Record r = coda;
        while (r != null) {
            Record next = r.next;
            if(next == null) {
                throw new NoSuchElementException();
            } else {
                if(next.elem.equals(item)) {
                    if (priority == next.priority)
                        return;
                    r.next = next.next;
                    insert(item, priority);
                    return;
                }
            }
            r = next;
        }
        throw new NoSuchElementException();
    }

    @Override
    public int getPriority(Item item) {
        if(isNew()) {
            throw new EmptyStructureException();
        }
        Record r = coda;
        while (r != null) {
            if(r.elem.equals(item)) {
                return r.priority;
            }
            r = r.next;
        }
        throw new NoSuchElementException();
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private Record current = coda;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Item next() {
                Item e = current.elem;
                current = current.next;
                return e;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }




    public static void main(String[] args) {
        PQ<String> priorityQueue = new PQA<String>();
        priorityQueue.insert("Minima", 99);
        priorityQueue.insert("seconda", 3);
        priorityQueue.insert("terza", 40);
        priorityQueue.insert("Massima", 0);
        priorityQueue.insert("secondaBis", 3);

        for(String s : priorityQueue) {
            System.out.println(s);
        }
    }
}
