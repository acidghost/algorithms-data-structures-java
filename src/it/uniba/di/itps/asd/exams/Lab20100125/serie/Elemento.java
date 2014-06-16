package it.uniba.di.itps.asd.exams.Lab20100125.serie;

/**
 * Created with IntelliJ IDEA.
 * User: acidghost
 * Date: 16/06/14
 * Time: 20:37
 * To change this template use File | Settings | File Templates.
 */
class Elemento implements Posizione {

    Object dato;
    Elemento successivo;
    Elemento precedente;

    Elemento(Object dato) {
        this.dato = dato;
        successivo = precedente = null;
    }

}
