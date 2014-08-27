package it.uniba.di.itps.asd.exams.Lab20090720;

import it.uniba.di.itps.asd.exams.Lab20090720.pila.EccezioneStrutturaVuota;
import it.uniba.di.itps.asd.exams.Lab20090720.pila.Pila;
import it.uniba.di.itps.asd.exams.Lab20090720.pila.PilaCollegata;

/**
 * Created by acidghost on 27/08/14.
 */
public class Labirinto {
    private int[][] labirinto = {
            {1, 1, 0, 1, 1},
            {1, 0, 1, 1, 1},
            {1, 1, 1, 0, 1},
            {1, 0, 0, 1, 1},
            {0, 1, 1, 1, 1}
    };
    private Pila<Posizione> soluzione = new PilaCollegata<Posizione>();

    public boolean attraversa(Posizione inizio, Posizione fine) {
        soluzione.push(inizio);
        labirinto[inizio.getX()][inizio.getY()] = 3;
        if(inizio.equals(fine)) {
            return true;
        }
        // Right
        if(valido(inizio.getX(), inizio.getY()+1)) {
            if(attraversa(new Posizione(inizio.getX(), inizio.getY()+1), fine)) {
                return true;
            }
        }
        // Down
        if(valido(inizio.getX()+1, inizio.getY())) {
            if(attraversa(new Posizione(inizio.getX()+1, inizio.getY()), fine)) {
                return true;
            }
        }
        // Left
        if(valido(inizio.getX(), inizio.getY()+1)) {
            if(attraversa(new Posizione(inizio.getX(), inizio.getY()+1), fine)) {
                return true;
            }
        }
        // Up
        if(valido(inizio.getX()-1, inizio.getY())) {
            if(attraversa(new Posizione(inizio.getX()-1, inizio.getY()), fine)) {
                return true;
            }
        }

        // Elimina il passo iniziale se non trova la soluzione
        if(!soluzione.isEmpty())
            soluzione.pop();
        return false;
    }

    public boolean valido(int riga, int colonna) {
        return (
                riga >= 0 &&
                riga < labirinto.length &&
                colonna >= 0 &&
                colonna < labirinto[0].length &&
                labirinto[riga][colonna] == 1
        );
    }

    public Pila<Posizione> getSoluzione() {
        return soluzione;
    }

    public static void main(String[] args) {
        Posizione inizio = new Posizione(0,0);
        Posizione fine = new Posizione(4,4);
        Labirinto maze = new Labirinto();

        if (maze.attraversa(inizio,fine)) {
            System.out.println("Il labirinto ha una soluzione.");
            System.out.println("Il percorso da " + fine + " a " + inizio + " è il seguente:");
            while (!maze.getSoluzione().isEmpty()) {
                try {
                    System.out.println(maze.getSoluzione().top());
                    maze.getSoluzione().pop();
                } catch (EccezioneStrutturaVuota e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Il labirinto non ha una soluzione");
        }
    }
}
