package it.uniba.di.itps.asd.structures.tree;

/**
 * Created by acidghost on 29/08/14.
 */
public class TestTreePV {
    public static void main(String[] args) {
        Tree M = new TreeParentsVector();
        Tree N = new TreeParentsVector();
        Tree O = new TreeParentsVector();

        M.insertRoot("A");
        N.insertRoot("B");
        O.insertRoot("C");
        M.insertFirstSubTree(M.root(), N);
        M.insertSubTree(M.firstChild(M.root()), O);

        for (Object element : M) {
            Node node = (Node) element;
            System.out.println(node);
        }
    }
}
