package it.uniba.di.itps.asd.exams.Lab20130903.dict;

import java.util.Iterator;

public class LinkedDict<K, V> implements Dictionary<K, V> {
	
	private Record head = null;
	private int n = 0;
	
	private class Record {
		K key;
		V value;
		Record next, prev;
		
		Record(K key, V value) {
			this.key = key;
			this.value = value;
			next = prev = null;
		}
	}

	@Override
	public Iterator<K> iterator() {
		return new Iterator<K>() {
			private Record current = head;

			@Override
			public boolean hasNext() {
				return current != null;
			}

			@Override
			public K next() {
				K k = current.key;
				current = current.next;
				return k;
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
			
		};
	}

	@Override
	public void insert(K key, V value) throws KeyAlreadyExistsException {
		Record record = new Record(key, value);
		if(head == null) {
			head = record;
			n++;
		} else {
			Record r = head;
			while(r != null) {
				if(r.key.equals(key)) {
					throw new KeyAlreadyExistsException();
				}
				if(r.next == null) {
					r.next = record;
					record.prev = r;
					n++;
					return;
				}
				r = r.next;
			}
			
		}
	}

	@Override
	public void delete(K key) {
		Record r = head;
		while(r != null) {
			if(r.key.equals(key)) {
				if(r == head) {
					head = head.next;
					head.prev = null;
				} else if(r.next == null) {
					r.prev.next = null;
				} else {
					r.prev.next = r.next;
					r.next.prev = r.prev;
				}
				n--;
				return;
			}
			r = r.next;
		}
	}

	@Override
	public V search(K key) {
		Record r = head;
		while(r != null) {
			if(r.key.equals(key)) {
				return r.value;
			}
			r = r.next;
		}
		return null;
	}
	
	@Override
	public int size() {
		return n;
	}

}
