package it.uniba.di.itps.asd.exams.Lab20130903.list;

public interface AddOnlyList<S> extends Iterable<S> {
	public void add(S e);
	public String toString();
}
