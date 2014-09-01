package it.uniba.di.itps.asd.exams.Lab20100902.abr;

import java.util.Iterator;

/**
 * Created by acidghost on 01/09/14.
 */
public class ABRPF implements ABR {
    private Node root = null;

    public ABRPF() {}

    private ABRPF(Node root) {
        this.root = root;
    }

    @Override
    public boolean isEmpty() {
        return (root == null);
    }

    @Override
    public ABR leftSubTree() {
        if(root == null) {
            throw new EmptyTreeException();
        }
        return new ABRPF(root.left);
    }

    @Override
    public ABR rightSubTree() {
        if(root == null) {
            throw new EmptyTreeException();
        }
        return new ABRPF(root.right);
    }

    @Override
    public Comparable root() {
        if(isEmpty()) {
            throw new EmptyTreeException();
        }
        return root.value;
    }

    @Override
    public void insertValue(Comparable value) {
        if(root == null) {
            root = new Node(value);
        } else {
            int conf = value.compareTo(root.value);
            if (conf == 0) {
                throw new NodeExistsException();
            }
            if(conf < 0) {
                if(root.left == null) {
                    root.left = new Node(value);
                    root.left.parent = root.left;
                } else {
                    leftSubTree().insertValue(value);
                }
            } else {
                if(root.right == null) {
                    root.right = new Node(value);
                    root.right.parent = root.right;
                } else {
                    rightSubTree().insertValue(value);
                }
            }
        }
    }

    @Override
    public Iterator iterator() {
        return new ABRPFIterator(this);
    }
}
