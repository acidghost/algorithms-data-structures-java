package it.uniba.di.itps.asd.exams.Lab20100222;

/**
 * Created by acidghost on 02/09/14.
 */
public class Block {
    public int id;
    public Point2D tl;
    public Point2D br;
    public typeC tc;

    public Block(int id, Point2D tl, Point2D br, typeC tc) {
        this.id = id;
        this.tl = tl;
        this.br = br;
        this.tc = tc;
    }

    @Override
    public String toString() {
        return "id: " + id + " - tl: " + tl.toString() + " br: " + br.toString() + " tc: " + tc.toString();
    }
}
