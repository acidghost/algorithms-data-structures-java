package it.uniba.di.itps.asd.structures.queue;

import java.util.Random;

/**
 * Created by acidghost on 19/06/14.
 */
public class TestLinkedQueue {

    private static final int N = 10;

    private static void inizializza(Queue queue, int n) {
        Random rdm = new Random();
        for(int i=0; i<n; i++) {
            int x = rdm.nextInt(n)+1;
            queue.enqueue(x);
            System.out.println("Inserted x: " + x);
        }
    }

    public static void main(String[] args) {
        Queue queue = new LinkedQueue();
        inizializza(queue, N);

        for(int i=0; i<N; i++) {
            System.out.println(queue.first());
            queue.dequeue();
        }
    }

}
