package it.uniba.di.itps.asd.exams.Lab20120907;

import java.util.Random;

/**
 * Created by acidghost on 04/09/14.
 */
public class Sensore {
    private int identificativo;
    private int x;
    private int y;
    private Random random;

    public static final float NO_VALUE = Float.NaN;

    public Sensore(int x, int y) {
        identificativo = this.hashCode();
        this.x = x;
        this.y = y;
        random = new Random();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getIdentificativo() {
        return identificativo;
    }

    public float poll() {
        float r = (random.nextFloat()*40)-5;
        return Float.parseFloat(String.format("%.1f", r));
    }
}
