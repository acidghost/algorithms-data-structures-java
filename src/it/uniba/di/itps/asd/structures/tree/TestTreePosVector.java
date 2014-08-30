package it.uniba.di.itps.asd.structures.tree;

import it.uniba.di.itps.asd.structures.tree.exceptions.ArityNotValidException;
import it.uniba.di.itps.asd.structures.tree.exceptions.InvalidNodeException;

import java.util.Iterator;

public class TestTreePosVector {

    public static void main(String[] args) {

        Tree A1 = new TreePosVector(3);
        Tree A2 = new TreePosVector(3);
        Tree A3 = new TreePosVector(3);
        Tree A4 = new TreePosVector(3);
        Tree A5 = new TreePosVector(3);
        Tree A6 = new TreePosVector(3);
        Tree A7 = new TreePosVector(3);
        Tree A8 = new TreePosVector(3);
        Tree A9 = new TreePosVector(3);
        Tree A10 = new TreePosVector(3);

        Tree A11 = new TreePosVector(3);
		Tree A12 = new TreePosVector(3);
		Tree A13 = new TreePosVector(3);
		Tree A14 = new TreePosVector(3);
		Tree A15 = new TreePosVector(3);
		Tree A16 = new TreePosVector(3);
		Tree A17 = new TreePosVector(3);
		Tree A18 = new TreePosVector(3);
		Tree A19 = new TreePosVector(3);
		Tree A20 = new TreePosVector(3);
		
		
		Tree A21 = new TreePosVector(3);
		Tree A22 = new TreePosVector(3);
		Tree A23 = new TreePosVector(3);
		Tree A24 = new TreePosVector(3);
		Tree A25 = new TreePosVector(3);
		Tree A26 = new TreePosVector(3);
		Tree A27 = new TreePosVector(3);
		Tree A28 = new TreePosVector(3);
		Tree A29 = new TreePosVector(3);
		Tree A30 = new TreePosVector(3);
		
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
			NodePosVector v=(NodePosVector)it.next();
			System.out.println(v);
		}
		
		
		System.out.println("Tree 2");
		
		Tree B1 = new TreePosVector(3);
		Tree B2 = new TreePosVector(3);
		Tree B3 = new TreePosVector(3);
		Tree B4 = new TreePosVector(3);
		Tree B5 = new TreePosVector(3);
		
		
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
			NodePosVector v=(NodePosVector)it.next();
			System.out.println(v);
		}
		
		
		System.out.println("Tree 3");
		
		Tree A = new TreePosVector(4);
		Tree B = new TreePosVector(4);
		Tree C = new TreePosVector(4);
		Tree D = new TreePosVector(4);
		Tree E = new TreePosVector(4);
		Tree F = new TreePosVector(4);
		Tree G = new TreePosVector(4);
		Tree H = new TreePosVector(4);
		Tree I = new TreePosVector(4);
		Tree L = new TreePosVector(4);
	
		
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
			NodePosVector v=(NodePosVector)it.next();
			System.out.println(v);
		}
		
		
		System.out.println("Potature del sottalbero di 3 radicato in C");
		A.removeSubTree(A.nextSibling(A.firstChild(A.root())));
	
		
		it= A.iterator();
		while(it.hasNext()){
			NodePosVector v=(NodePosVector)it.next();
			System.out.println(v);
		}
		
		System.out.println("Potature del sottalbero di 3 radicato in H");
		A.removeSubTree(A.nextSibling(A.nextSibling(A.firstChild(A.root()))));
		
		it= A.iterator();
		while(it.hasNext()){
			NodePosVector v=(NodePosVector)it.next();
			System.out.println(v);
		}
		
		
		
		
		
		System. out.println("Tree 4");
		
		Tree M = new TreePosVector(3);
		Tree N = new TreePosVector(3);
		Tree O = new TreePosVector(3);
		
		M.insertRoot("A");
		N.insertRoot("B");
		O.insertRoot("C");
		
		M.insertSubTree(M.root(), N);
		M.insertSubTree(M.firstChild(M.root()), O);
		
		it= M.iterator();
		while(it.hasNext()){
			NodePosVector v=(NodePosVector)it.next();
			System.out.println(v);
		}
		
		System.out.println("Ricerca primo figlio della root di Tree 3 nell' Tree 4");
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
		
		
		System.out.println("Potatura del sottalbero di 3 radicato in root");
		A.removeSubTree(A.root());
		
		
		
		it= A.iterator();
		while(it.hasNext()){
			NodePosVector v=(NodePosVector)it.next();
			System.out.println(v);
		}

	}

}
