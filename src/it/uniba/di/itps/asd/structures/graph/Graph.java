package it.uniba.di.itps.asd.structures.graph;

import java.util.List;

/**
 * Created by acidghost on 01/09/14.
 */
public interface Graph {
    public boolean isEmpty();
    public Node newNode(Object info);
    public Arch newArch(Node x, Node y, Object info);
    public void addNode(Node v);
    public void addArch(Arch a);
    public void removeNode(Node v);
    public void removeArch(Arch a);
    public Object infoNode(Node v);
    public Object infoArch(Arch a);
    public void setInfoNode(Node v, Object info);
    public void setInfoArch(Arch a, Object info);
    public List<Node> adjacentNodes(Node v);
    public Arch incidenceArch(Node u, Node v);
}
