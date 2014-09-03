package it.uniba.di.itps.asd.exams.Lab20130903.dict;

public interface Dictionary<K, V> extends Iterable<K> {
	
	public void insert(K key, V value) throws KeyAlreadyExistsException;
	public void delete(K key);
	public V search(K key);
	
	public int size();
	
}
