package it.uniba.di.itps.asd.structures.tree;

import it.uniba.di.itps.asd.structures.tree.exceptions.EmptyTreeException;
import it.uniba.di.itps.asd.structures.tree.exceptions.InvalidNodeException;
import it.uniba.di.itps.asd.structures.tree.exceptions.NoSuchNodeException;
import it.uniba.di.itps.asd.structures.tree.exceptions.NotEmptyTreeException;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: acidghost
 * Date: 31/08/14
 * Time: 20:39
 * To change this template use File | Settings | File Templates.
 */
public class TreePFFS implements Tree {
    private NodePFFS root = null;

    private boolean isValidNode(NodePFFS node) {
        return (node != null && node.tree == this);
    }

    private NodePFFS checkValidity(Node node) {
        NodePFFS n = (NodePFFS) node;
        if(!isValidNode(n)) {
            throw new InvalidNodeException();
        }
        return n;
    }

    @Override
    public boolean isEmpty() {
        return (root == null);
    }

    @Override
    public void insertRoot(Object info) {
        if(!isEmpty()) {
            throw new NotEmptyTreeException();
        }
        NodePFFS node = new NodePFFS(info, this);
        root = node;
    }

    @Override
    public Node root() {
        if(isEmpty()) {
            throw new EmptyTreeException();
        }
        return root;
    }

    @Override
    public Node parent(Node node) {
        NodePFFS n = checkValidity(node);
        if(n == root) {
            throw new NoSuchNodeException();
        }
        return n.parent;
    }

    @Override
    public boolean isLeaf(Node node) {
        NodePFFS n = checkValidity(node);
        return (n.firstChild == null);
    }

    @Override
    public Node firstChild(Node node) {
        NodePFFS n = checkValidity(node);
        if(n.firstChild == null) {
            throw new NoSuchNodeException();
        }
        return n.firstChild;
    }

    @Override
    public boolean isLastSibling(Node node) {
        NodePFFS n = checkValidity(node);
        return (n.nextSibling == null);
    }

    @Override
    public Node nextSibling(Node node) {
        NodePFFS n = checkValidity(node);
        if(n.nextSibling == null) {
            throw new NoSuchNodeException();
        }
        return n.nextSibling;
    }

    @Override
    public void insertFirstSubTree(Node node, Tree tree) {
        NodePFFS n = checkValidity(node);
        NodePFFS exRoot = (NodePFFS) tree.root();
        NodePFFS secondNode = n.firstChild;     // could be null
        n.firstChild = exRoot;
        exRoot.parent = n;
        exRoot.nextSibling = secondNode;
        updateTree(n.firstChild);
    }

    private void updateTree(NodePFFS node) {
        node.tree = this;
        if(!isLeaf(node)) {
            node = node.firstChild;
            while (node.nextSibling != null) {
                updateTree(node);
                node = node.nextSibling;
            }
            updateTree(node);
        }
    }

    @Override
    public void insertSubTree(Node node, Tree tree) {
        NodePFFS n = checkValidity(node);
        if(n == root) {
            insertFirstSubTree(node, tree);
            return;
        }
        NodePFFS exRoot = (NodePFFS) tree.root();
        NodePFFS nextNode = n.nextSibling;     // could be null
        n.nextSibling = exRoot;
        exRoot.parent = n.parent;
        exRoot.nextSibling = nextNode;
        updateTree(n.nextSibling);
    }

    @Override
    public void removeSubTree(Node node) {
        NodePFFS n = checkValidity(node);
        if(n == root) {
            root = null;
            return;
        }
        NodePFFS parent = n.parent;
        if(parent.firstChild == n) {
            parent.firstChild = n.nextSibling;
        } else {
            NodePFFS current = parent.firstChild;
            for (; current.nextSibling != null; current = current.nextSibling) {
                if(current.nextSibling == n) {
                    current.nextSibling = n.nextSibling;
                    return;
                }
            }
            throw new NoSuchNodeException();
        }
    }

    @Override
    public Object getInfo(Node node) {
        NodePFFS n = checkValidity(node);
        return n.info;
    }

    @Override
    public void setInfo(Node node, Object info) {
        NodePFFS n = checkValidity(node);
        n.info = info;
    }

    @Override
    public Iterator iterator() {
        return new TreeIterator(this);
    }
}
