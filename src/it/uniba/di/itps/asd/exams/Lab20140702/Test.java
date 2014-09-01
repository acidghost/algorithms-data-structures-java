package it.uniba.di.itps.asd.exams.Lab20140702;

/**
 * Created with IntelliJ IDEA.
 * User: acidghost
 * Date: 31/08/14
 * Time: 18:41
 * To change this template use File | Settings | File Templates.
 */
public class Test {
    public static void main(String[] args) {
        Rivista rivista = new Rivista();

        Articolo[] articoli = new Articolo[] {
                new Articolo(1, "Donato Malerba"),
                new Articolo(1, "Clay Woolam", "Latifur Khan"),
                new Articolo(2, "Vassilios S. Verykios", "Alexandros Karakasidis", "Vassilios K. Mitrogiannis"),
                new Articolo(3, "Massimiliano Caramia", "Stefano Giordani")
        };
        int i=0;
        rivista.addArticle("A relational perspective on spatial data mining", articoli[i++]);
        rivista.addArticle("Multi-label large margin hierarchical perception", articoli[i++]);
        rivista.addArticle("Privacy preserving record linkage approaches", articoli[i++]);
        rivista.addArticle("On the selection of k efficient paths by clustering techniques", articoli[i++]);
        rivista.addVolume(1, true);
        rivista.addVolume(2, true);
        rivista.addVolume(3, true);

        for(Integer volume : rivista.volumi) {
            if(rivista.volumi.search(volume) == true) {
                System.out.println("Stampa volume " + volume);
                for(String titolo : rivista.articoli) {
                    Articolo articolo = rivista.articoli.search(titolo);
                    if(articolo.volume == volume) {
                        System.out.println("Autori:\t" + articolo.autori.toString());
                        System.out.println("Titolo:\t" + titolo);
                        //System.out.println("Volume:\t" + volume);
                    }
                }
                System.out.println();
            }
        }
    }
}
