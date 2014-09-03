package it.uniba.di.itps.asd.exams.Lab20130917;

/**
 * Created by acidghost on 03/09/14.
 */
public class Prodotto {
    private String nome;
    private int prezzo;

    public Prodotto(String nome, int prezzo) {
        this.nome = nome;
        this.prezzo = prezzo;
    }

    public String getNome() {
        return nome;
    }

    public int getPrezzo() {
        return prezzo;
    }
}
