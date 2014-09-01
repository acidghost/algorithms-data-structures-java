package it.uniba.di.itps.asd.exams.Lab20100902.abr;

/**
 * Created by acidghost on 01/09/14.
 */
class Node {
    Comparable value;
    Node left;
    Node right;
    Node parent;

    Node(Comparable value) {
        this.value = value;
        parent = left = right = null;
    }
}
