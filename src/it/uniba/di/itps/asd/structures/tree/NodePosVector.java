package it.uniba.di.itps.asd.structures.tree;

/**
 * Created by acidghost on 30/08/14.
 */
class NodePosVector implements Node {
    Object info;
    Tree tree;
    int index;
    int arity;

    NodePosVector(Object info) {
        this.info = info;
    }

    NodePosVector(Object info, Tree tree) {
        this(info);
        this.tree = tree;
    }
}
