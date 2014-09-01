package it.uniba.di.itps.asd.structures.tree;

import java.util.ArrayList;

/**
 * Created by acidghost on 30/08/14.
 */
class NodeChildList implements Node {
    Object info;
    ArrayList<NodeChildList> childNodes;
    Tree tree;
    int arity;

    NodeChildList() {
        childNodes = new ArrayList<NodeChildList>();
    }

    NodeChildList(Object info) {
        this();
        this.info = info;
    }

    NodeChildList(Object info, Tree tree) {
        this(info);
        this.tree = tree;
    }

    public void addChild(NodeChildList node) {
        childNodes.add(node);
    }

    @Override
    public String toString() {
        return info.toString();
    }
}
