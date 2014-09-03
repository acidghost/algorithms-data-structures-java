package it.uniba.di.itps.asd.exams.Lab20131121;

/**
 * Created by acidghost on 02/09/14.
 */
public class Articolo implements Comparable {
    public String nome;
    public String misura;

    public Articolo(String nome, String misura) {
        this.nome = nome;
        this.misura = misura;
    }

    @Override
    public int compareTo(Object o) {
        Articolo a = (Articolo) o;
        if(nome.compareTo(a.nome) == 0) {
            return misura.compareTo(a.misura);
        } else {
            return nome.compareTo(a.nome);
        }
    }

    @Override
    public String toString() {
        return nome + " " + misura;
    }
}
