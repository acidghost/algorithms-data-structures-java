package it.uniba.di.itps.asd.structures.tree;

/**
 * Created by acidghost on 29/08/14.
 */
class NodeParentsVector implements Node {
    public Object info;
    public int index;
    public Tree tree;

    public NodeParentsVector(Object info) {
        this.info = info;
    }

    public String toString() {
        return info.toString();
    }
}
