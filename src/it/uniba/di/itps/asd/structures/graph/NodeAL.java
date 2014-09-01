package it.uniba.di.itps.asd.structures.graph;

/**
 * Created by acidghost on 01/09/14.
 */
class NodeAL implements Node {
    public Object info;
    public GraphArchList graph;

    public NodeAL(Object info, GraphArchList graph) {
        this.info = info;
        this.graph = graph;
    }
}
