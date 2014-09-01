package it.uniba.di.itps.asd.structures.graph;

/**
 * Created by acidghost on 01/09/14.
 */
class ArchAL implements Arch {
    public Object info;
    public NodeAL from, to;

    public ArchAL(Object info, NodeAL from, NodeAL to) {
        this.info = info;
        this.from = from;
        this.to = to;
    }
}
