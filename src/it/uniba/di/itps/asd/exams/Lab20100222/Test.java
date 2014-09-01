package it.uniba.di.itps.asd.exams.Lab20100222;

/**
 * Created by acidghost on 02/09/14.
 */
public class Test {
    public static void main(String[] args) {
        Layout layout = new Layout();
        Block[] blocks = {
                new Block(1, new Point2D(0, 2), new Point2D(3, 0), typeC.GRAPHICS),
                new Block(2, new Point2D(0, 5), new Point2D(3, 2), typeC.TEXT),
                new Block(3, new Point2D(3, 7), new Point2D(6, 5), typeC.TEXT),
                new Block(4, new Point2D(0, 7), new Point2D(3, 5), typeC.GRAPHICS),
                new Block(5, new Point2D(0, 10), new Point2D(6, 7), typeC.TEXT),
                new Block(6, new Point2D(2, 11), new Point2D(3, 10), typeC.TEXT)
        };

        for(Block b : blocks) {
            layout.addBlock(b);
        }

        layout.addAbove(blocks[5], blocks[4]);
        layout.addAbove(blocks[4], blocks[3]);
        layout.addAbove(blocks[4], blocks[2]);
        layout.addAbove(blocks[3], blocks[1]);
        layout.addAbove(blocks[2], blocks[1]);
        layout.addAbove(blocks[1], blocks[0]);
        layout.addLeft(blocks[3], blocks[2]);

        for(Block b : layout.neightbour(blocks[3])) {
            System.out.println(b.toString());
        }
        System.out.println();
        for(Block b : layout.neightbour(blocks[2])) {
            System.out.println(b.toString());
        }
        System.out.println();
        for(Block b : layout.neightbour(blocks[0])) {
            System.out.println(b.toString());
        }
    }
}
