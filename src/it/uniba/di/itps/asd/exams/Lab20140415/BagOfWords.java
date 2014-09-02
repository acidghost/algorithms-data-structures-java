package it.uniba.di.itps.asd.exams.Lab20140415;

/**
 * Created by acidghost on 02/09/14.
 */
public class BagOfWords {
    protected Bag bagOfWords = new Bag();
    protected int occurrences = 0;

    public void addText(String text) {
        String[] words = text.split(" ");
        for(String word : words) {
            bagOfWords.addItem(word.toLowerCase());
            occurrences++;
        }
    }

    public float similarity(BagOfWords bow) {
        float sim = 0;
        for(Object w : bagOfWords) {
            float p1 = ((float) (bagOfWords.occurrences((Comparable) w) + 1) / (occurrences + 2));
            float p2 = ((float) (bow.bagOfWords.occurrences((Comparable) w) + 1) / (bow.occurrences + 2));
            sim += p1 + p2;
        }
        for(Object w : bow.bagOfWords) {
            float p1 = ((float) (bagOfWords.occurrences((Comparable) w) + 1) / (occurrences + 2));
            float p2 = ((float) (bow.bagOfWords.occurrences((Comparable) w) + 1) / (bow.occurrences + 2));
            sim += p1 + p2;
        }
        return sim;
    }
}
