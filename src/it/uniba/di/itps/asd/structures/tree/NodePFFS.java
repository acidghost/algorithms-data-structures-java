package it.uniba.di.itps.asd.structures.tree;

/**
 * Created with IntelliJ IDEA.
 * User: acidghost
 * Date: 31/08/14
 * Time: 20:41
 * To change this template use File | Settings | File Templates.
 */
class NodePFFS implements Node {
    Object info;
    NodePFFS parent = null;
    NodePFFS nextSibling = null;
    NodePFFS firstChild = null;
    Tree tree;

    NodePFFS(Object info) {
        this.info = info;
    }

    NodePFFS(Object info, Tree tree) {
        this(info);
        this.tree = tree;
    }

    public String toString() {
        return info.toString();
    }
}
