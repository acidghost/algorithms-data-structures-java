package it.uniba.di.itps.asd.structures;

import it.uniba.di.itps.asd.structures.exceptions.EmptyStructureException;

/**
 * Created by acidghost on 11/06/14.
 */
public interface Dictionary {

    public void insert(Comparable k, Object v);
    public void delete(Comparable k) throws EmptyStructureException;
    public Object search(Comparable k);

}
