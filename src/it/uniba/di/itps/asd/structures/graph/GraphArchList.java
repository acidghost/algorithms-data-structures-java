package it.uniba.di.itps.asd.structures.graph;


import java.util.LinkedList;
import java.util.List;

/**
 * Created by acidghost on 01/09/14.
 */
public class GraphArchList implements Graph {
    private NodeAL[] nodes = new NodeAL[1];
    private ArchAL[] arches = new ArchAL[1];
    private int nNodes = 0;
    private int nArches = 0;

    @Override
    public boolean isEmpty() {
        return nNodes == 0;
    }

    @Override
    public Node newNode(Object info) {
        return new NodeAL(info, this);
    }

    @Override
    public Arch newArch(Node x, Node y, Object info) {
        return new ArchAL(info, checkNode(x), checkNode(y));
    }

    @Override
    public void addNode(Node v) {
        for(int i=0; i<nNodes; i++) {
            if(nodes[i] == v) {
                throw new NodeExistsException();
            }
        }
        if(nNodes == nodes.length) {
            NodeAL[] tmp = new NodeAL[nNodes * 2];
            System.arraycopy(nodes, 0, tmp, 0, nNodes);
            nodes = tmp;
        }
        nodes[nNodes] = checkNode(v);
        nNodes++;
    }

    @Override
    public void addArch(Arch a) {
        for(int i=0; i<nArches; i++) {
            if(arches[i] == a) {
                throw new ArchExistsException();
            }
        }
        if(nArches == arches.length) {
            ArchAL[] tmp = new ArchAL[nArches* 2];
            System.arraycopy(arches, 0, tmp, 0, nArches);
            arches = tmp;
        }
        arches[nArches] = (ArchAL) a;
        nArches++;
    }

    @Override
    public void removeNode(Node v) {
        NodeAL node = checkNode(v);
        List<Node> adj = adjacentNodes(v);
        for(Node n : adj) {
            ArchAL a1 = (ArchAL) incidenceArch(node, n);
            ArchAL a2 = (ArchAL) incidenceArch(n, node);
            if(a1 != null) {
                removeArch(a1);
            }
            if(a2 != null) {
                removeArch(a2);
            }
        }
        for(int i=0, stop=0; i<nNodes && stop==0; i++) {
            if(nodes[i] == node) {
                System.arraycopy(nodes, i+1, nodes, i, nNodes-i-1);
                nNodes--;
                stop = 1;
            }
        }
        if(nNodes <= nodes.length/4) {
            NodeAL[] tmp = new NodeAL[nodes.length / 2];
            System.arraycopy(nodes, 0, tmp, 0, nNodes);
            nodes = tmp;
        }
    }

    @Override
    public void removeArch(Arch a) {
        for(int i=0, stop=0; i<nArches && stop==0; i++) {
            if(a == arches[i]) {
                System.arraycopy(arches, i+1, arches, i, nArches-i-1);
                nArches--;
                stop = 1;
            }
        }
        if(nArches <= arches.length/4) {
            ArchAL[] tmp = new ArchAL[arches.length / 2];
            System.arraycopy(arches, 0, tmp, 0, nArches);
            arches = tmp;
        }
    }

    @Override
    public Object infoNode(Node v) {
        return checkNode(v).info;
    }

    @Override
    public Object infoArch(Arch a) {
        return ((ArchAL) a).info;
    }

    @Override
    public void setInfoNode(Node v, Object info) {
        checkNode(v).info = info;
    }

    @Override
    public void setInfoArch(Arch a, Object info) {
        ((ArchAL) a).info = info;
    }

    @Override
    public List<Node> adjacentNodes(Node v) {
        List<Node> list = new LinkedList<Node>();
        NodeAL node = checkNode(v);
        for(int i=0; i<nArches; i++) {
            ArchAL a = arches[i];
            if(a.from == node) {
                list.add(a.to);
            } else if(a.to == node) {
                list.add(a.from);
            }
        }
        return list;
    }

    @Override
    public Arch incidenceArch(Node u, Node v) {
        NodeAL n1 = checkNode(u);
        NodeAL n2 = checkNode(v);
        for(int i=0; i<nArches; i++) {
            ArchAL a = arches[i];
            if((a.from == n1 && a.to == n2) || (a.from == n2 && a.to == n1))
                return a;
        }
        return null;
    }

    private NodeAL checkNode(Node n) {
        NodeAL node = (NodeAL) n;
        if(node != null && node.graph == this) {
            return node;
        } else {
            throw new InvalidNodeException();
        }
    }
}
