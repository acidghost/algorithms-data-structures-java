package it.uniba.di.itps.asd.structures.tree;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by acidghost on 29/08/14.
 */
public class TreeIterator implements Iterator {
    private Tree tree;
    private LinkedList<Node> nodes = new LinkedList<Node>();
    private int i = 0;

    public enum VisitType {
        PRE, POS, IN
    }

    public TreeIterator(Tree tree) {
        this(tree, VisitType.PRE);
    }

    public TreeIterator(Tree tree, VisitType type) {
        this.tree = tree;
        if(!tree.isEmpty()) {
            if(type == VisitType.PRE) {
                previsita(tree.root());
            } else if(type == VisitType.IN) {
                invisita(tree.root());
            } else if(type == VisitType.POS) {
                postvisita(tree.root());
            }
        }
    }

    @Override
    public boolean hasNext() {
        return (i < nodes.size());
    }

    @Override
    public Object next() {
        Node node = nodes.get(i);
        i++;
        return node;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    private void previsita(Node u) {
        nodes.add(u);
        if(!tree.isLeaf(u)) {
            Node v = tree.firstChild(u);
            previsita(v);
            while(!tree.isLastSibling(v)) {
                v = tree.nextSibling(v);
                previsita(v);
            }
        }
    }

    private void invisita(Node u) {
        if(tree.isLeaf(u)) {
            nodes.add(u);
        } else {
            Node v = tree.firstChild(u);
            invisita(v);
            nodes.add(u);
            while (!tree.isLastSibling(v)) {
                v = tree.nextSibling(v);
                invisita(v);
            }
        }
    }

    private void postvisita(Node u) {
        if(!tree.isLeaf(u)) {
            Node v = tree.firstChild(u);
            postvisita(v);
            while (!tree.isLastSibling(v)) {
                v = tree.nextSibling(v);
                postvisita(v);
            }
        }
        nodes.add(u);
    }
}
