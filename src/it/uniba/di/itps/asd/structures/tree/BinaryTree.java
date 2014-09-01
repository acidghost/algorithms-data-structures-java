package it.uniba.di.itps.asd.structures.tree;

/**
 * Created with IntelliJ IDEA.
 * User: acidghost
 * Date: 31/08/14
 * Time: 22:56
 * To change this template use File | Settings | File Templates.
 */
public interface BinaryTree extends Iterable {
    public boolean isEmpty();
    public Node root();
    public void insertRoot(Object info);
    public Node parent(Node node);
    public Node left(Node node);
    public Node right(Node node);
    public void injectLeft(Node node, BinaryTree tree);
    public void injectRight(Node node, BinaryTree tree);
    public void prune(Node node);
    public Object getInfo(Node node);
    public void setInfo(Node node, Object info);
}
