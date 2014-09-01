package it.uniba.di.itps.asd.structures.tree;

import it.uniba.di.itps.asd.structures.tree.exceptions.*;

import java.util.Iterator;

/**
 * Created by acidghost on 30/08/14.
 */
public class TreePosVector implements Tree {
    private NodePosVector[] nodes = new NodePosVector[0];
    // Max. degree for children
    private int degree;

    public TreePosVector(int degree) {
        if(degree < 2) {
            throw new ArityNotValidException();
        }
        this.degree = degree;
    }

    private boolean isValidNode(NodePosVector node) {
        return (node != null && node.tree == this);
    }

    @Override
    public boolean isEmpty() {
        return (nodes.length == 0);
    }

    @Override
    public void insertRoot(Object info) {
        if(!isEmpty()) {
            throw new NotEmptyTreeException();
        }
        NodePosVector node = new NodePosVector(info, this);
        node.arity = 1;
        node.index = 0;
        nodes = new NodePosVector[2];
        nodes[1] = node;
    }

    @Override
    public Node root() {
        if(isEmpty()) {
            throw new EmptyTreeException();
        }
        return nodes[1];
    }

    @Override
    public Node parent(Node node) {
        NodePosVector n = (NodePosVector) node;
        if(!isValidNode(n)) {
            throw new InvalidNodeException();
        }
        if(n == root()) {
            return null;
        }
        int parentPos = ((n.index - n.arity -1) / degree) + 1;
        return nodes[parentPos];
    }

    @Override
    public boolean isLeaf(Node node) {
        try {
            firstChild(node);
            return false;
        } catch(InvalidNodeException ine) {
            throw new InvalidNodeException();
        } catch (NoSuchNodeException nsne) {
            return true;
        }
    }

    @Override
    public Node firstChild(Node node) {
        NodePosVector n = (NodePosVector) node;
        if(!isValidNode(n)) {
            throw new InvalidNodeException();
        }
        // 2 because arity=1 => 1+1=2
        int childPos = degree * (n.index-1) + 2;
        if(childPos >= nodes.length || nodes[childPos] == null) {
            throw new NoSuchNodeException();
        }
        return nodes[childPos];
    }

    @Override
    public boolean isLastSibling(Node node) {
        try {
            nextSibling(node);
            return false;
        } catch (InvalidNodeException ine) {
            throw new InvalidNodeException();
        } catch (NoSuchNodeException nsne) {
            return true;
        }
    }

    @Override
    public Node nextSibling(Node node) {
        NodePosVector n = (NodePosVector) node;
        if(!isValidNode(n)) {
            throw new InvalidNodeException();
        }
        for(int i=1; i<=degree; i++) {
            int sibPos = degree * (n.index-1) + i +1;
            if(sibPos >= nodes.length || nodes[sibPos] == null) {
                throw new NoSuchNodeException();
            } else if(sibPos > n.index) {
                return nodes[sibPos];
            }
        }
        throw new NoSuchNodeException();
    }

    @Override
    public void insertFirstSubTree(Node node, Tree tree) {
        //Todo: to be implemented
    }

    @Override
    public void insertSubTree(Node node, Tree tree) {
        //Todo: to be implemented
    }

    @Override
    public void removeSubTree(Node node) {
        //Todo: to be implemented
    }

    @Override
    public Object getInfo(Node node) {
        NodePosVector n = (NodePosVector) node;
        if(!isValidNode(n)) {
            throw new InvalidNodeException();
        }
        return n.info;
    }

    @Override
    public void setInfo(Node node, Object info) {
        NodePosVector n = (NodePosVector) node;
        if(!isValidNode(n)) {
            throw new InvalidNodeException();
        }
        n.info = info;
    }

    @Override
    public Iterator iterator() {
        return new TreeIterator(this);
    }
}
