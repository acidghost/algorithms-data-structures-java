package it.uniba.di.itps.asd.structures.tree;

import it.uniba.di.itps.asd.structures.tree.exceptions.ArityNotValidException;
import it.uniba.di.itps.asd.structures.tree.exceptions.InvalidNodeException;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: acidghost
 * Date: 31/08/14
 * Time: 21:17
 * To change this template use File | Settings | File Templates.
 */
public class TestTreePFFS {
    public static void main(String[] args) {

        Tree A1 = new TreePFFS();
        Tree A2 = new TreePFFS();
        Tree A3 = new TreePFFS();
        Tree A4 = new TreePFFS();
        Tree A5 = new TreePFFS();
        Tree A6 = new TreePFFS();
        Tree A7 = new TreePFFS();
        Tree A8 = new TreePFFS();
        Tree A9 = new TreePFFS();
        Tree A10 = new TreePFFS();

        Tree A11 = new TreePFFS();
        Tree A12 = new TreePFFS();
        Tree A13 = new TreePFFS();
        Tree A14 = new TreePFFS();
        Tree A15 = new TreePFFS();
        Tree A16 = new TreePFFS();
        Tree A17 = new TreePFFS();
        Tree A18 = new TreePFFS();
        Tree A19 = new TreePFFS();
        Tree A20 = new TreePFFS();


        Tree A21 = new TreePFFS();
        Tree A22 = new TreePFFS();
        Tree A23 = new TreePFFS();
        Tree A24 = new TreePFFS();
        Tree A25 = new TreePFFS();
        Tree A26 = new TreePFFS();
        Tree A27 = new TreePFFS();
        Tree A28 = new TreePFFS();
        Tree A29 = new TreePFFS();
        Tree A30 = new TreePFFS();

        System.out.println("Tree 1");

        A1.insertRoot("1");
        A2.insertRoot("2");
        A3.insertRoot("3");
        A4.insertRoot("4");
        A5.insertRoot("5");
        A6.insertRoot("6");
        A7.insertRoot("7");
        A8.insertRoot("8");
        A9.insertRoot("9");
        A10.insertRoot("10");
        A11.insertRoot("11");
        A12.insertRoot("12");
        A13.insertRoot("13");
        A14.insertRoot("14");
        A15.insertRoot("15");
        A16.insertRoot("16");
        A17.insertRoot("17");
        A18.insertRoot("18");
        A19.insertRoot("19");
        A20.insertRoot("20");
        A21.insertRoot("21");
        A22.insertRoot("22");
        A23.insertRoot("23");
        A24.insertRoot("24");
        A25.insertRoot("25");
        A26.insertRoot("26");
        A27.insertRoot("27");
        A28.insertRoot("28");
        A29.insertRoot("29");
        A30.insertRoot("30");


        A5.insertSubTree(A5.root(), A16);
        A5.insertSubTree(A5.root(), A15);
        A5.insertSubTree(A5.root(), A14);

        A6.insertSubTree(A6.root(), A19);
        A6.insertSubTree(A6.root(), A18);
        A6.insertSubTree(A6.root(), A17);


        A7.insertSubTree(A7.root(), A22);
        A7.insertSubTree(A7.root(), A21);
        A7.insertSubTree(A7.root(), A20);

        A8.insertSubTree(A8.root(), A25);
        A8.insertSubTree(A8.root(), A24);
        A8.insertSubTree(A8.root(), A23);

        A9.insertSubTree(A9.root(), A28);
        A9.insertSubTree(A9.root(), A27);
        A9.insertSubTree(A9.root(), A26);

        A10.insertSubTree(A10.root(), A30);

        A10.insertSubTree(A10.root(), A29);

        A2.insertSubTree(A2.root(), A7);
        A2.insertSubTree(A2.root(), A6);
        A2.insertSubTree(A2.root(), A5);


        A3.insertSubTree(A3.root(), A10);
        A3.insertSubTree(A3.root(), A9);
        A3.insertSubTree(A3.root(), A8);

        A4.insertSubTree(A4.root(), A13);
        A4.insertSubTree(A4.root(), A12);
        A4.insertSubTree(A4.root(), A11);


        A1.insertSubTree(A1.root(), A4);
        A1.insertSubTree(A1.root(), A3);
        A1.insertSubTree(A1.root(), A2);


        Iterator it= A1.iterator();
        while(it.hasNext()){
            NodePFFS v=(NodePFFS)it.next();
            System.out.println(v);
        }


        System.out.println("Tree 2");

        Tree B1 = new TreePFFS();
        Tree B2 = new TreePFFS();
        Tree B3 = new TreePFFS();
        Tree B4 = new TreePFFS();
        Tree B5 = new TreePFFS();


        B1.insertRoot("1");
        B2.insertRoot("2");
        B3.insertRoot("3");
        B4.insertRoot("4");
        B5.insertRoot("5");
        try{
            B1.insertSubTree(B1.root(), B5);
            B1.insertSubTree(B1.root(), B4);
            B1.insertSubTree(B1.root(), B3);
            B1.insertSubTree(B1.root(), B2);
        }
        catch(ArityNotValidException e){
            System.out.println(e);
        }

        it= B1.iterator();
        while(it.hasNext()){
            NodePFFS v=(NodePFFS)it.next();
            System.out.println(v);
        }


        System.out.println("Tree 3");

        Tree A = new TreePFFS();
        Tree B = new TreePFFS();
        Tree C = new TreePFFS();
        Tree D = new TreePFFS();
        Tree E = new TreePFFS();
        Tree F = new TreePFFS();
        Tree G = new TreePFFS();
        Tree H = new TreePFFS();
        Tree I = new TreePFFS();
        Tree L = new TreePFFS();


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


        B.insertSubTree(B.root(), D);
        A.insertSubTree(A.root(), B);

        F.insertSubTree(F.root(), G);
        C.insertSubTree(C.root(), E);
        C.insertSubTree(C.firstChild(C.root()), F);
        A.insertSubTree(A.firstChild(A.root()), C);

        A.insertSubTree(A.nextSibling(A.firstChild(A.root())), H);

        I.insertSubTree(I.root(), L);

        A.insertSubTree(A.nextSibling(A.firstChild(A.root())), I);

        it= A.iterator();
        while(it.hasNext()){
            NodePFFS v=(NodePFFS)it.next();
            System.out.println(v);
        }


        System.out.println("Potature del sottalbero di 3 radicato in C");
        A.removeSubTree(A.nextSibling(A.firstChild(A.root())));


        it= A.iterator();
        while(it.hasNext()){
            NodePFFS v=(NodePFFS)it.next();
            System.out.println(v);
        }

        System.out.println("Potature del sottalbero di 3 radicato in H");
        A.removeSubTree(A.nextSibling(A.nextSibling(A.firstChild(A.root()))));

        it= A.iterator();
        while(it.hasNext()){
            NodePFFS v=(NodePFFS)it.next();
            System.out.println(v);
        }





        System. out.println("Tree 4");

        Tree M = new TreePFFS();
        Tree N = new TreePFFS();
        Tree O = new TreePFFS();

        M.insertRoot("A");
        N.insertRoot("B");
        O.insertRoot("C");

        M.insertSubTree(M.root(), N);
        M.insertSubTree(M.firstChild(M.root()), O);

        it= M.iterator();
        while(it.hasNext()){
            NodePFFS v=(NodePFFS)it.next();
            System.out.println(v);
        }

        System.out.println("Ricerca primo figlio della root di Tree 3 nell' Tree ");
        try{
            M.firstChild(A.root());
        }
        catch(InvalidNodeException e)
        {
            System.out.println(e);
        }
        catch(RuntimeException e)
        {
            System.out.println(e);
        }


        System.out.println("Potatura del sottalbero di  radicato in root");
        A.removeSubTree(A.root());



        it= A.iterator();
        while(it.hasNext()){
            NodePFFS v=(NodePFFS)it.next();
            System.out.println(v);
        }

    }
}
