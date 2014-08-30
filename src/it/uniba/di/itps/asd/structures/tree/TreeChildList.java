package it.uniba.di.itps.asd.structures.tree;

import it.uniba.di.itps.asd.structures.tree.exceptions.EmptyTreeException;
import it.uniba.di.itps.asd.structures.tree.exceptions.InvalidNodeException;
import it.uniba.di.itps.asd.structures.tree.exceptions.NoSuchNodeException;
import it.uniba.di.itps.asd.structures.tree.exceptions.NotEmptyTreeException;

import java.util.Iterator;

/**
 * Created by acidghost on 30/08/14.
 */
public class TreeChildList implements Tree {
    private NodeChildList rootNode = null;

    private boolean isValidNode(NodeChildList node) {
        return (node != null && node.tree == this);
    }

    private NodeChildList checkNode(Node node) throws InvalidNodeException {
        NodeChildList n = (NodeChildList) node;
        if(!isValidNode(n)) {
            throw new InvalidNodeException();
        }
        return n;
    }

    @Override
    public boolean isEmpty() {
        return (rootNode == null);
    }

    @Override
    public void insertRoot(Object info) {
        if(!isEmpty()) {
            throw new NotEmptyTreeException();
        }
        rootNode = new NodeChildList(info, this);
    }

    @Override
    public Node root() {
        if(isEmpty()) {
            throw new EmptyTreeException();
        }
        return rootNode;
    }

    @Override
    public Node parent(Node node) {
        NodeChildList n = checkNode(node);
        if(n == rootNode) {
            throw new NoSuchNodeException();
        }
        NodeChildList currentNode = rootNode;
        while (!isLeaf(currentNode)) {
            if (n.arity+1 < currentNode.childNodes.size() && currentNode.childNodes.get(n.arity + 1) == n) {
                return currentNode;
            }
            if(!isLastSibling(currentNode)) {
                currentNode = (NodeChildList) nextSibling(currentNode);
            } else {
                currentNode = (NodeChildList) firstChild(currentNode);
            }
        }
        throw new NoSuchNodeException();
    }

    @Override
    public boolean isLeaf(Node node) {
        NodeChildList n = checkNode(node);
        return n.childNodes.isEmpty();
    }

    @Override
    public Node firstChild(Node node) {
        NodeChildList n = checkNode(node);
        if(isLeaf(n)) {
            throw new NoSuchNodeException();
        }
        return n.childNodes.get(0);
    }

    @Override
    public boolean isLastSibling(Node node) {
        NodeChildList n = checkNode(node);
        if(n == rootNode) {
            return true;
        }
        NodeChildList parent = (NodeChildList) parent(n);
        return n.arity+1 == parent.childNodes.size();
    }

    @Override
    public Node nextSibling(Node node) {
        NodeChildList n = checkNode(node);
        NodeChildList parent = (NodeChildList) parent(n);
        if(isLastSibling(n)) {
            throw new NoSuchNodeException();
        }
        return parent.childNodes.get(n.arity);
    }

    @Override
    public void insertFirstSubTree(Node node, Tree tree) {
        NodeChildList n = checkNode(node);
        for(NodeChildList child : n.childNodes) {
            child.arity += 1;
        }
        NodeChildList root = (NodeChildList) tree.root();
        root.tree = this;
        root.arity = 1;
        n.childNodes.add(0, root);
        /*
        for(Object nn : tree) {
            NodeChildList newNode = (NodeChildList) nn;
            newNode.tree = this;
        }
        */
        NodeChildList currentNode = (NodeChildList) tree.root();
        while (!isLeaf(currentNode)) {
            currentNode.tree = this;
            if(!isLastSibling(currentNode)) {
                currentNode = (NodeChildList) nextSibling(currentNode);
            } else {
                currentNode = (NodeChildList) firstChild(currentNode);
            }
        }
    }

    @Override
    public void insertSubTree(Node node, Tree tree) {
        NodeChildList n = checkNode(node);
        NodeChildList sibling = n;
        while (!isLastSibling(sibling)) {
            sibling = (NodeChildList) nextSibling(sibling);
            sibling.arity += 1;
        }
        NodeChildList root = (NodeChildList) tree.root();
        root.tree = this;
        root.arity = n.arity+1;
        if(n != rootNode) {
            ((NodeChildList) parent(n)).childNodes.add(n.arity, root);
        } else {
            rootNode.childNodes.add(0, root);
        }
        /*
        Iterator iterator = tree.iterator();
        while (iterator.hasNext()) {
            NodeChildList newNode = (NodeChildList) iterator.next();
            newNode.tree = this;
        }
        */
        NodeChildList currentNode = (NodeChildList) tree.root();
        while (!isLeaf(currentNode)) {
            currentNode.tree = this;
            if(!isLastSibling(currentNode)) {
                currentNode = (NodeChildList) nextSibling(currentNode);
            } else {
                currentNode = (NodeChildList) firstChild(currentNode);
            }
        }
    }

    @Override
    public void removeSubTree(Node node) {
        NodeChildList n = checkNode(node);
        NodeChildList parent = (NodeChildList) parent(n);
        parent.childNodes.remove(n.arity-1);
        for(int i=n.arity-2; i<parent.childNodes.size(); i++) {
            parent.childNodes.get(i).arity -= 1;
        }
    }

    @Override
    public Object getInfo(Node node) {
        NodeChildList n = checkNode(node);
        return n.info;
    }

    @Override
    public void setInfo(Node node, Object info) {
        NodeChildList n = checkNode(node);
        n.info = info;
    }


    @Override
    public Iterator iterator() {
        return new TreeIterator(this, TreeIterator.VisitType.PRE);
    }
}
