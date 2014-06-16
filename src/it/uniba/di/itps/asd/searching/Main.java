package it.uniba.di.itps.asd.searching;

import java.util.Random;

/**
 * Created by acidghost on 07/05/14.
 */
public class Main {

    private static class Point2D {
        private int x, y;
        Point2D(int x, int y) {
            this.x = x;
            this.y = y;
        }
        Point2D() {
            this.x = new Random().nextInt(50);
            this.y = new Random().nextInt(50);
        }
        public int getX() {
            return x;
        }
        public int getY() {
            return y;
        }
    }
    private static class Line2D {
        public Point2D p1, p2;
        Line2D(Point2D p1, Point2D p2) {
            this.p1 = p1;
            this.p2 = p2;
        }
        public int length() {
            return (int) Math.floor(Math.sqrt(Math.pow((p1.getX()-p2.getX()), 2) + Math.pow((p1.getY()-p2.getY()), 2)));
        }
        public boolean equals(Object o) {
            if(o instanceof Line2D) {
                float l2 = ((Line2D) o).length();
                float l1 = this.length();
                if(l1 == l2)
                    return true;
            }
            return false;
        }
    }

    public static void main(String args[]) {

        int A[] = new int[20];
        int nConf[] = new int[1];
        RicercaArray.inizializzaArrayCasuale(A);
        RicercaArray.stampaArray(A);
        System.out.println("");
        int x = new Random().nextInt(A.length)+1;
        System.out.println("Ricerca: " + x);
        System.out.println("Trovato: " + ((RicercaArray.binarySearch(A, x, nConf)) ? ("vero") : ("falso")));
        System.out.println("\nConfronti: " + nConf[0]);

        System.out.println("\n\n");

        Line2D[] lines = new Line2D[20];
        for (int i = 0; i < 20; i++) {
            Point2D p1 = new Point2D();
            Point2D p2 = new Point2D();
            lines[i] = new Line2D(p1, p2);
        }
        Line2D l = new Line2D(new Point2D(), new Point2D());
        for(Line2D li : lines) {
            System.out.println("p1: ("+li.p1.getX()+","+li.p1.getY()+") p2: ("+li.p2.getX()+","+li.p2.getY()+")\t\tlen: "+li.length());
        }
        boolean lineFound = RicercaArray.sequentialSearch(lines, l);
        System.out.println("\nRicerca: " + l.length());
        System.out.println("Trovato: " + (lineFound ? "vero" : "falso"));



    }

}
