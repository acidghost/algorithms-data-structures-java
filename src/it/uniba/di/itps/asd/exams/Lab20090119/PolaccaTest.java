package it.uniba.di.itps.asd.exams.Lab20090119;

/**
 * Created by acidghost on 26/08/14.
 */
public class PolaccaTest {

    public static void main(String[] args) {
        String[] tests = new String[] {
                "123 245 + 127 - 2 * 1 /",
                "35 17 40 9 - * + 7 -",
                "35 17 40 9 - * + 7 - 7 7 7 +",
                "35 17 40 9 - * + 7 - +"
        };

        for(String test : tests) {
            try {
                int val = Polacca.valuta(test);
                System.out.println("La stringa " + test + " e' valida e risulta: " + val);
            } catch (EccezioneEspressioneNonValida e) {
                System.out.println("La stringa " + test + " non e' valida (causa: " + e.getMessage() + ")");
            }
        }

        tests = new String[] {
                "35 + 17 * ( 40 - 9 ) - 7",
                "5 + ( 10 * 2 )",
                "( ( 10 * 2 ) + ( 4 - 5 ) ) / 2",
                "( 7 / 3 ) / ( ( 1 - 4 ) * 2 ) + 1" // Stringa che genera errore
        };
        for(String test : tests) {
            try {
                Polacca pol = new Polacca();
                System.out.println("Converto espressione infissa " + test + " in " + pol.converti(test) + " postfissa\tvalutazione: " + pol.valuta());
            } catch (RuntimeException re) {
                System.out.println("Errore per la stringa " + test);
            }
        }
    }

}
