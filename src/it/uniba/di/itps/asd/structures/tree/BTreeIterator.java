package it.uniba.di.itps.asd.structures.tree;

import it.uniba.di.itps.asd.structures.tree.exceptions.NoSuchNodeException;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: acidghost
 * Date: 01/09/14
 * Time: 10:44
 * To change this template use File | Settings | File Templates.
 */
public class BTreeIterator implements Iterator {
    private BinaryTree tree;
    private List<Node> nodes = new LinkedList<Node>();

    public BTreeIterator(BinaryTree tree) {
        this(tree, null);
    }

    public BTreeIterator(BinaryTree tree, TreeVisitType visitType) {
        this.tree = tree;
        if(!tree.isEmpty()) {
            if(visitType == null) {
                nodes = visitaBFS();
            } else if(visitType == TreeVisitType.PRE) {
                previsita(tree.root());
            } else if(visitType == TreeVisitType.IN) {
                invisita(tree.root());
            } else if(visitType == TreeVisitType.POS) {
                postvisita(tree.root());
            } else {
                previsita(tree.root());
            }
        }
    }

    @Override
    public boolean hasNext() {
        return (nodes.size() > 0);
    }

    @Override
    public Object next() {
        Node node = nodes.remove(0);
        return node;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    public List<Node> visitaBFS() {
        List<Node> nodes = new LinkedList<Node>();
        Queue<Node> q = new LinkedList<Node>();
        q.add(tree.root());
        while (!q.isEmpty()) {
            Node u = q.remove();
            if(u != null) {
                nodes.add(u);
                try {
                    q.add(tree.left(u));
                } catch (NoSuchNodeException e) {
                    q.add(null);
                }
                try {
                    q.add(tree.right(u));
                } catch (NoSuchNodeException e) {
                    q.add(null);
                }
            }
        }
        return nodes;
    }

    private void previsita(Node node) {
        nodes.add(node);
        try {
            Node left = tree.left(node);
            previsita(left);
        } catch (NoSuchNodeException e) {
            return;
        }
        try {
            Node right = tree.right(node);
            previsita(right);
        } catch (NoSuchNodeException e) {
            return;
        }
    }

    private void invisita(Node node) {
        try {
            Node left = tree.left(node);
            previsita(left);
        } catch (NoSuchNodeException e) {
            return;
        }
        nodes.add(node);
        try {
            Node right = tree.right(node);
            previsita(right);
        } catch (NoSuchNodeException e) {
            return;
        }
    }

    private void postvisita(Node node) {
        try {
            Node left = tree.left(node);
            previsita(left);
        } catch (NoSuchNodeException e) {
            return;
        }
        try {
            Node right = tree.right(node);
            previsita(right);
        } catch (NoSuchNodeException e) {
            return;
        }
        nodes.add(node);
    }
}
