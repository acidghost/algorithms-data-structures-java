package it.uniba.di.itps.asd.structures.tree;

import it.uniba.di.itps.asd.structures.tree.exceptions.InvalidNodeException;
import it.uniba.di.itps.asd.structures.tree.exceptions.NoSuchNodeException;
import it.uniba.di.itps.asd.structures.tree.exceptions.NotEmptyTreeException;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: acidghost
 * Date: 31/08/14
 * Time: 23:04
 * To change this template use File | Settings | File Templates.
 */
public class BTreeChildPointers implements BinaryTree {
    private NodeBTreeCP root = null;

    private NodeBTreeCP checkNode(Node node) {
        NodeBTreeCP n = (NodeBTreeCP) node;
        if(n == null || n.tree != this) {
            throw new InvalidNodeException();
        }
        return n;
    }

    @Override
    public boolean isEmpty() {
        return (root == null);
    }

    @Override
    public Node root() {
        if(isEmpty()) {
            throw new NoSuchNodeException();
        }
        return root;
    }

    @Override
    public void insertRoot(Object info) {
        if(!isEmpty()) {
            throw new NotEmptyTreeException();
        }
        root = new NodeBTreeCP(info, this);
    }

    @Override
    public Node parent(Node node) {
        NodeBTreeCP n = checkNode(node);
        if(n == root) {
            throw new NoSuchNodeException();
        }
        return n.parent;
    }

    @Override
    public Node left(Node node) {
        NodeBTreeCP n = checkNode(node);
        if(n.left == null) {
            throw new NoSuchNodeException();
        }
        return n.left;
    }

    @Override
    public Node right(Node node) {
        NodeBTreeCP n = checkNode(node);
        if(n.right == null) {
            throw new NoSuchNodeException();
        }
        return n.right;
    }

    @Override
    public void injectLeft(Node node, BinaryTree tree) {
        NodeBTreeCP n = checkNode(node);
        if(n.left != null) {
            throw new InvalidNodeException();
        }
        NodeBTreeCP exRoot = (NodeBTreeCP) tree.root();
        n.left = exRoot;
        exRoot.parent = n;
        updateNodes(exRoot);
    }

    private void updateNodes(NodeBTreeCP node) {
        node.tree = this;
        NodeBTreeCP left = node.left;
        if(left != null) {
            updateNodes(left);
        }
        NodeBTreeCP right = node.right;
        if(right != null) {
            updateNodes(right);
        }
    }

    @Override
    public void injectRight(Node node, BinaryTree tree) {
        NodeBTreeCP n = checkNode(node);
        if(n.right != null) {
            throw new InvalidNodeException();
        }
        NodeBTreeCP exRoot = (NodeBTreeCP) tree.root();
        n.right = exRoot;
        exRoot.parent = n;
        updateNodes(exRoot);
    }

    @Override
    public void prune(Node node) {
        NodeBTreeCP n = checkNode(node);
        if(n == root) {
            root = null;
        } else {
            NodeBTreeCP parent = n.parent;
            if(parent.left == n) {
                parent.left = null;
            } else if(parent.right == n) {
                parent.right = null;
            } else {
                throw new InvalidNodeException();
            }
            n.parent = null;
        }
    }

    @Override
    public Object getInfo(Node node) {
        NodeBTreeCP n = checkNode(node);
        return n.info;
    }

    @Override
    public void setInfo(Node node, Object info) {
        NodeBTreeCP n = checkNode(node);
        n.info = info;
    }

    @Override
    public Iterator iterator() {
        return new BTreeIterator(this);
    }
}
