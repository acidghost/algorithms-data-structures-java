package it.uniba.di.itps.asd.structures.tree;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: acidghost
 * Date: 01/09/14
 * Time: 10:39
 * To change this template use File | Settings | File Templates.
 */
public class TestBinTreeCP {
    public static void main(String[] args) {



        BTreeChildPointers A = new BTreeChildPointers();
        BTreeChildPointers B = new BTreeChildPointers();
        BTreeChildPointers C = new BTreeChildPointers();
        BTreeChildPointers D = new BTreeChildPointers();
        BTreeChildPointers E = new BTreeChildPointers();
        BTreeChildPointers F = new BTreeChildPointers();
        BTreeChildPointers G = new BTreeChildPointers();
        BTreeChildPointers H = new BTreeChildPointers();
        BTreeChildPointers I = new BTreeChildPointers();
        BTreeChildPointers L = new BTreeChildPointers();

        BTreeChildPointers M = new BTreeChildPointers();
        BTreeChildPointers N = new BTreeChildPointers();
        BTreeChildPointers O = new BTreeChildPointers();


        A.insertRoot("A");
        B.insertRoot("B");
        C.insertRoot("C");
        D.insertRoot("D");
        E.insertRoot("E");
        F.insertRoot("F");
        G.insertRoot("G");
        H.insertRoot("H");
        I.insertRoot("I");
        L.insertRoot("L");
        M.insertRoot("M");
        N.insertRoot("N");
        O.insertRoot("O");



        I.injectRight(I.root(), O);
        G.injectLeft(G.root(),H);
        G.injectRight(G.root(), I);

        C.injectLeft(C.root(), F);
        C.injectRight(C.root(), G);

        A.injectRight(A.root(), C);
        A.injectLeft(A.root(), B);

        D.injectLeft(D.root(), N);
        E.injectLeft(E.root(), L);
        E.injectRight(E.root(), M);

        A.injectLeft(A.left(A.root()), D);
        A.injectRight(A.left(A.root()), E);

        Iterator it=((BTreeChildPointers)A).iterator();
        while(it.hasNext()){
            NodeBTreeCP v=(NodeBTreeCP)it.next();
            System.out.println(v);
        }


        System.out.println("prune l'albero radicato in N");
        A.prune(A.left(A.left(A.left(A.root()))));
        it=((BTreeChildPointers)A).iterator();
        while(it.hasNext()){
            NodeBTreeCP v=(NodeBTreeCP)it.next();
            System.out.println(v);
        }

        System.out.println("prune l'albero radicato in B");
        A.prune(A.left(A.root()));

        it=((BTreeChildPointers)A).iterator();
        while(it.hasNext()){
            NodeBTreeCP v=(NodeBTreeCP)it.next();
            System.out.println(v);
        }

        System.out.println("prune l'albero radicato in F");
        A.prune(A.left(A.right(A.root())));

        it=((BTreeChildPointers)A).iterator();
        while(it.hasNext()){
            NodeBTreeCP v=(NodeBTreeCP)it.next();
            System.out.println(v);
        }

        System.out.println("prune l'albero radicato in A");
        A.prune(A.root());

        it=((BTreeChildPointers)A).iterator();
        while(it.hasNext()){
            NodeBTreeCP v=(NodeBTreeCP)it.next();
            System.out.println(v);
        }

    }
}
