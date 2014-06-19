package it.uniba.di.itps.asd.exams.Lab20100608.animali;

/**
 * Created with IntelliJ IDEA.
 * User: acidghost
 * Date: 18/06/14
 * Time: 13:56
 * To change this template use File | Settings | File Templates.
 */
public class Animale implements Comparable {

    public String padrone;
    public String nome;

    public Animale(String padrone, String nome) {
        this.padrone = padrone;
        this.nome = nome;
    }

    @Override
    public int compareTo(Object o) {
        Animale oa = (Animale) o;
        if(padrone.compareTo(oa.padrone) == 0) {
            return nome.compareTo(oa.nome);
        } else {
            return padrone.compareTo(oa.padrone);
        }
    }
}
