package it.uniba.di.itps.asd.structures.deque;

/**
 * Created by acidghost on 19/06/14.
 */
public class TestDoubleQueue {

    private static final int N = 5;

    private static void inizializza(DoubleQueue queue, int n) {
        for (int i = 0; i < n; i++) {
            queue.accoda(i);
            queue.inpila(n-i-1);
        }
    }

    public static void main(String[] args) {
        DoubleQueue queue = new ArrayDoubleQueue();
        inizializza(queue, N);

        while(!queue.codavuota()) {
            Object o = queue.leggitesta();
            System.out.println("Testa: " + o.toString());
            queue.fuoritesta();
        }
    }

}
