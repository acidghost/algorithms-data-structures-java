package it.uniba.di.itps.asd.structures.tree;

import it.uniba.di.itps.asd.structures.tree.exceptions.EmptyTreeException;
import it.uniba.di.itps.asd.structures.tree.exceptions.InvalidNodeException;
import it.uniba.di.itps.asd.structures.tree.exceptions.NotEmptyTreeException;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by acidghost on 29/08/14.
 */
public class TreePV implements Tree {
    private NodePV[] nodes = new NodePV[0];
    private NodePV[] parents = new NodePV[0];

    private boolean isValidNode(NodePV node) {
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
        NodePV node = new NodePV(info);
        node.index = 0;
        node.tree = this;
        nodes = new NodePV[1];
        nodes[0] = node;
        parents = new NodePV[1];
        parents[0] = null;
    }

    @Override
    public Node root() {
        if(isEmpty()) {
            throw new EmptyTreeException();
        }
        return nodes[0];
    }

    @Override
    public Node parent(Node node) {
        NodePV n = (NodePV) node;
        if(!isValidNode(n)) {
            throw new InvalidNodeException();
        }
        return parents[n.index];
    }

    @Override
    public boolean isLeaf(Node node) {
        return (firstChild(node) == null);
    }

    @Override
    public Node firstChild(Node node) {
        NodePV n = (NodePV) node;
        if(!isValidNode(n)) {
            throw new InvalidNodeException();
        }
        for(int i=n.index+1; i<parents.length; i++) {
            if(parents[i] == node) {
                return nodes[i];
            }
        }
        return null;
    }

    @Override
    public boolean isLastSibling(Node node) {
        NodePV n = (NodePV) node;
        if(!isValidNode(n)) {
            throw new InvalidNodeException();
        }
        for(int i=n.index+1; i<parents.length; i++) {
            if(parents[i] == parents[n.index]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Node nextSibling(Node node) {
        NodePV n = (NodePV) node;
        if(!isValidNode(n)) {
            throw new InvalidNodeException();
        }
        for(int i=n.index+1; i<parents.length; i++) {
            if(parents[i] == parents[n.index]) {
                return nodes[i];
            }
        }
        throw new InvalidNodeException();
    }

    @Override
    public void insertFirstSubTree(Node node, Tree tree) {
        NodePV n = (NodePV) node;
        if(!isValidNode(n)) {
            throw new InvalidNodeException();
        }
        int index = n.index;
        TreePV t = (TreePV) tree;
        NodePV[] tmpNodes = new NodePV[nodes.length + t.nodes.length];
        NodePV[] tmpParents = new NodePV[parents.length + t.parents.length];
        System.arraycopy(nodes, 0, tmpNodes, 0, index+1);
        System.arraycopy(parents, 0, tmpParents, 0, index+1);
        tmpNodes[index+1] = (NodePV) t.root();
        tmpNodes[index+1].tree = this;
        tmpNodes[index+1].index = index+1;
        tmpParents[index+1] = n;
        for(int i=index+1; i<nodes.length; i++) {
            tmpNodes[i+1] = nodes[i];
            tmpNodes[i+1].index = i+1;
            tmpParents[i+1] = parents[i+1];
        }
        // innesto
        for(int i=nodes.length+1, j=1; i<tmpNodes.length-1; i++, j++) {
            tmpNodes[i] = t.nodes[j];
            tmpNodes[i].index = i;
            tmpNodes[i].tree = this;
            tmpParents[i] = t.parents[j];
        }
        nodes = tmpNodes;
        parents = tmpParents;
    }

    @Override
    public void insertSubTree(Node node, Tree tree) {
        NodePV n = (NodePV) node;
        if(!isValidNode(n)) {
            throw new InvalidNodeException();
        }
        int index = n.index;
        TreePV t = (TreePV) tree;
        NodePV[] tmpNodes = new NodePV[nodes.length + t.nodes.length];
        NodePV[] tmpParents = new NodePV[parents.length + t.parents.length];
        System.arraycopy(nodes, 0, tmpNodes, 0, index+1);
        System.arraycopy(parents, 0, tmpParents, 0, index+1);
        tmpNodes[index+1] = (NodePV) t.root();
        tmpNodes[index+1].tree = this;
        tmpNodes[index+1].index = index+1;
        tmpParents[index+1] = (NodePV) parent(n);
        for(int i=index+1; i<nodes.length; i++) {
            tmpNodes[i+1] = nodes[i];
            tmpNodes[i+1].index = i+1;
            tmpParents[i+1] = parents[i+1];
        }
        // innesto
        for(int i=nodes.length+1, j=1; i<tmpNodes.length-1; i++, j++) {
            tmpNodes[i] = t.nodes[j];
            tmpNodes[i].index = i;
            tmpNodes[i].tree = this;
            tmpParents[i] = t.parents[j];
        }
        nodes = tmpNodes;
        parents = tmpParents;
    }

    private void removeNode(NodePV node) {
        if(!isValidNode(node)) {
            throw new InvalidNodeException();
        }
        int n = nodes.length;
        NodePV[] tmp = new NodePV[n - 1];
        System.arraycopy(nodes, 0, tmp, 0, node.index);
        System.arraycopy(nodes, node.index+1, tmp, node.index, tmp.length - node.index);
        nodes = tmp;
        tmp = new NodePV[n - 1];
        System.arraycopy(parents, 0, tmp, 0, node.index);
        System.arraycopy(parents, node.index+1, tmp, node.index, tmp.length - node.index);
        parents = tmp;
        for(int i=0; i<nodes.length; i++) {
            nodes[i].index = i;
        }
    }

    @Override
    public void removeSubTree(Node node) {
        NodePV n = (NodePV) node;
        if(!isValidNode(n)) {
            throw new InvalidNodeException();
        }
        if(!isLeaf(n)) {
            NodePV tmp = (NodePV) firstChild(n);
            LinkedList<NodePV> siblings = new LinkedList<NodePV>();
            siblings.add(tmp);
            while(!isLastSibling(tmp)) {
                tmp = (NodePV) nextSibling(tmp);
                siblings.add(tmp);
            }
            for(NodePV currentSibling : siblings) {
                removeSubTree(currentSibling);
            }
        }
        removeNode(n);
    }

    @Override
    public Object getInfo(Node node) {
        NodePV n = (NodePV) node;
        if(!isValidNode(n)) {
            throw new InvalidNodeException();
        }
        return n.info;
    }

    @Override
    public void setInfo(Node node, Object info) {
        NodePV n = (NodePV) node;
        if(!isValidNode(n)) {
            throw new InvalidNodeException();
        }
        n.info = info;
    }

    @Override
    public Iterator iterator() {
        return new TreeIterator(this, TreeIterator.VisitType.PRE);
    }
}
