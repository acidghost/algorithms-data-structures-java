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
    }

}
