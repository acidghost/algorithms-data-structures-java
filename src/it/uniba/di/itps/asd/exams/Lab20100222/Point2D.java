package it.uniba.di.itps.asd.exams.Lab20100222;

/**
 * Created by acidghost on 02/09/14.
 */
public class Point2D {
    public int x;
    public int y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "[" + x + "," + y + "]";
    }
}
