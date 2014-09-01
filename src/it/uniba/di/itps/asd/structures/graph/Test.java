package it.uniba.di.itps.asd.structures.graph;

import java.util.LinkedList;

/**
 * Created by acidghost on 01/09/14.
 */
public class Test {
    public static void main(String[] args) {
        Graph grafo= new GraphArchList();
        NodeAL nod1=(NodeAL) grafo.newNode("1");
        NodeAL nod2=(NodeAL) grafo.newNode("2");
        NodeAL nod3=(NodeAL) grafo.newNode("3");
        NodeAL nod4=(NodeAL) grafo.newNode("4");
        NodeAL nod5=(NodeAL) grafo.newNode("5");

        grafo.addNode(nod1);
        grafo.addNode(nod2);
        grafo.addNode(nod3);
        grafo.addNode(nod4);
        grafo.addNode(nod5);

        ArchAL arco1=(ArchAL)grafo.newArch(nod1, nod2, "1,2");
        ArchAL arco2=(ArchAL)grafo.newArch(nod1, nod5, "1,5");
        ArchAL arco3=(ArchAL)grafo.newArch(nod1, nod3, "1,3");
        ArchAL arco4=(ArchAL)grafo.newArch(nod2, nod5, "2,5");
        ArchAL arco5=(ArchAL)grafo.newArch(nod2, nod4, "2,4");
        ArchAL arco6=(ArchAL)grafo.newArch(nod5, nod4, "5,4");
        ArchAL arco7=(ArchAL)grafo.newArch(nod3, nod4, "3,4");
        ArchAL arco8=(ArchAL)grafo.newArch(nod5, nod3, "5,3");

        grafo.addArch(arco1);
        grafo.addArch(arco2);
        grafo.addArch(arco3);
        grafo.addArch(arco4);
        grafo.addArch(arco5);
        grafo.addArch(arco6);
        grafo.addArch(arco7);
        grafo.addArch(arco8);

        grafo.removeNode(nod1);

        LinkedList<Node> lista= (LinkedList) grafo.adjacentNodes(nod5);
        for(int i = 0 ; i <lista.size(); i ++){

            System.out.println(grafo.infoNode(lista.get(i)));
        }


    }
}
