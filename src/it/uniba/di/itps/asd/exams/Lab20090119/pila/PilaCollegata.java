package it.uniba.di.itps.asd.exams.Lab20090119.pila;

/**
 * Created by acidghost on 26/08/14.
 */
public class PilaCollegata implements Pila {
    private Record top = null;

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public void push(Object e) {
        Record r = new Record(e, top);
        top = r;
    }

    @Override
    public Object top() {
        if(isEmpty()) {
            throw new EccezioneStrutturaVuota("Pila vuota");
        } else {
            return top.value;
        }
    }

    @Override
    public void pop() {
        if(isEmpty()) {
            throw new EccezioneStrutturaVuota("Pila vuota");
        } else {
            top = top.next;
        }
    }
}
