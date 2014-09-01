package it.uniba.di.itps.asd.structures.tree;

/**
 * Created with IntelliJ IDEA.
 * User: acidghost
 * Date: 31/08/14
 * Time: 23:05
 * To change this template use File | Settings | File Templates.
 */
class NodeBTreeCP implements Node {
    Object info;
    NodeBTreeCP parent;
    NodeBTreeCP left;
    NodeBTreeCP right;
    BTreeChildPointers tree;

    NodeBTreeCP(Object info) {
        this.info = info;
        parent = left = right = null;
    }

    NodeBTreeCP(Object info, BTreeChildPointers tree) {
        this(info);
        this.tree = tree;
    }

    public String toString() {
        return info.toString();
    }
}
