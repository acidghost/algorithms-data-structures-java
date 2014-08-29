package it.uniba.di.itps.asd.structures.tree;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by acidghost on 29/08/14.
 */
public interface Tree extends Iterable {
    public boolean isEmpty();
    public void insertRoot(Object info);
    public Node root();
    public Node parent(Node node);
    public boolean isLeaf(Node node);
    public Node firstChild(Node node);
    public boolean isLastSibling(Node node);
    public Node nextSibling(Node node);
    public void insertFirstSubTree(Node node, Tree tree);
    public void insertSubTree(Node node, Tree tree);
    public void removeSubTree(Node node);
    public Object getInfo(Node node);
    public void setInfo(Node node, Object info);

    @Override
    Iterator iterator();
}
