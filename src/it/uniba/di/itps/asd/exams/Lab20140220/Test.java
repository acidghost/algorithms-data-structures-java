package it.uniba.di.itps.asd.exams.Lab20140220;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by acidghost on 02/09/14.
 */
public class Test {
    public static final int INSTANCES = 17;
    public static final int ROUNDS = 20;
    public static final String[] Q_NAMES = { "unrunnable", "runnable", "stoppable" };
    public static final int MAX_PRIORITY = 100      +1;

    public static Map<String, PQ<Process>> pqs = new HashMap<String, PQ<Process>>();
    static {
        for(String s : Q_NAMES) {
            pqs.put(s, new PQA<Process>());
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < INSTANCES; i++) {
            pqs.get(Q_NAMES[0]).insert(new Process("/dev/sd0" + i), random.nextInt(MAX_PRIORITY));   // [0-100]
        }
        System.out.println("Generata coda \"" + Q_NAMES[0] + "\":");
        for(Process process : pqs.get(Q_NAMES[0])) {
            System.out.println(process + "\tP " + pqs.get(Q_NAMES[0]).getPriority(process));
        }
        System.out.println("\n");

        for (int i = 0; i < ROUNDS; i++) {
            String qName = Q_NAMES[random.nextInt(Q_NAMES.length)];
            PQ<Process> pq = pqs.get(qName);
            if(!pq.isNew()) {
                changeStatePriority(pq.first(), pq.getPriority(pq.first()), qName);
            }
        }

        for(String qName : Q_NAMES) {
            PQ<Process> queue = pqs.get(qName);
            System.out.println("Printing queue \"" + qName + "\"");
            for(Process p : queue) {
                System.out.println(p.toString() + "\tP " + queue.getPriority(p));
            }
            System.out.println();
        }
    }

    public static void changeStatePriority(Process p, int priority, String currentQueue) {
        Random random = new Random();
        PQ<Process> pq = pqs.get(currentQueue);
        priority = random.nextInt(10) == 0 ? random.nextInt(MAX_PRIORITY) : priority;
        pq.delFirst();
        int queue;
        if (currentQueue.equals(Q_NAMES[0]) || currentQueue.equals(Q_NAMES[2])) {
            queue = 1;
        } else {
            if(random.nextInt(2) == 0) {
                queue = 0;
            } else {
                queue = 2;
            }
        }
        pqs.get(Q_NAMES[queue]).insert(p, priority);
    }
}
