package it.uniba.di.itps.asd.exams.Lab20090720;

/**
 * Created by acidghost on 27/08/14.
 */
public class Posizione {
    private int x;
    private int y;

    Posizione(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        Posizione po = (Posizione) obj;
        return (this.x == po.getX() && this.y == po.getY());
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }
}
