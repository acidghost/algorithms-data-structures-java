package it.uniba.di.itps.asd.structures;

/**
 * Created by acidghost on 11/06/14.
 */
public class ArraySorted implements Dictionary {

    private Pair[] s = new Pair[0];

    public void insert(Comparable k, Object v) {
        int i, j;
        Pair[] tmp = new Pair[s.length+1];
        for(i=0; i<s.length; i++) {
            tmp[i] = s[i];
        }
        s = tmp;
        i=0;
        while(i<s.length-1 && k.compareTo(s[i].key) <= 0) {
            i++;
        }
        for(j=s.length-1; j>i; j--) {
            s[j] = s[j-1];
        }
        s[i] = new Pair(k, v);
    }

    public void delete(Comparable k) {
        int i, j;
        for(i=0; i<s.length; i++) {
            if(k.compareTo(s[i].key) == 0) {
                break;
            }
        }
        for(j=i; j<s.length-1; j++) {
            s[j] = s[j+1];
        }
        Pair[] tmp = new Pair[s.length-1];
        for(i=0; i<tmp.length; i++) {
            tmp[i] = s[i];
        }
        s = tmp;
    }

    public Object search(Comparable k) {
        int i=0, j=s.length-1, m=(i+j)/2;
        while(i<j) {
            if(k.compareTo(s[m].key) == 0) {
                return s[m].value;
            } else {
                if(k.compareTo(s[m].key) < 0) {
                    j = m-1;
                } else {
                    i = m+1;
                }
                m = (i+j)/2;
            }
        }
        return null;
    }

}
