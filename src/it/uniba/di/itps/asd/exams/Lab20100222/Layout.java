package it.uniba.di.itps.asd.exams.Lab20100222;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by acidghost on 02/09/14.
 */
public class Layout {
    protected ListaIndicizzata<Block> blocchi;
    protected LinkedList<Relation> above;
    protected LinkedList<Relation> left;

    public Layout() {
        blocchi = new ListaArray<Block>();
        above = new LinkedList<Relation>();
        left = new LinkedList<Relation>();
    }

    public void addBlock(Block block) {
        blocchi.addElement(block, block.id);
    }

    public boolean isNew() {
        return blocchi.isEmpty();
    }

    private boolean blockExists(Block block) {
        for(Block b : blocchi) {
            if(b.id == block.id)
                return true;
        }
        return false;
    }

    public void addAbove(Block b1, Block b2) {
        if(!blockExists(b1) || !blockExists(b2)) {
            throw new InvalidBlockException();
        }
        if(b1.br.y >= b2.tl.y) {
            above.add(new Relation(b1.id, b2.id));
        } else {
            throw new InvalidBlockException();
        }
    }

    public void addLeft(Block b1, Block b2) {
        if(!blockExists(b1) || !blockExists(b2)) {
            throw new InvalidBlockException();
        }
        if(b1.br.x <= b2.tl.x) {
            left.add(new Relation(b1.id, b2.id));
        } else {
            throw new InvalidBlockException();
        }
    }

    public boolean above(Block b1, Block b2) {
        for(Relation relation : above) {
            if(b1.id == relation.b1 && b2.id == relation.b2)
                return true;
        }
        return false;
    }

    public boolean left(Block b1, Block b2) {
        for(Relation relation : left) {
            if(b1.id == relation.b1 && b2.id == relation.b2)
                return true;
        }
        return false;
    }

    public int numBlocks() {
        return blocchi.numberElements();
    }

    public List<Block> neightbour(Block block) {
        LinkedList<Block> list = new LinkedList<Block>();
        for(Relation r : above) {
            if(r.b1 == block.id)
                list.add(blocchi.getElement(r.b2));
            else if(r.b2 == block.id)
                list.add(blocchi.getElement(r.b1));
        }
        for(Relation r : left) {
            if(r.b1 == block.id)
                list.add(blocchi.getElement(r.b2));
            else if(r.b2 == block.id)
                list.add(blocchi.getElement(r.b1));
        }
        return list;
    }
}
