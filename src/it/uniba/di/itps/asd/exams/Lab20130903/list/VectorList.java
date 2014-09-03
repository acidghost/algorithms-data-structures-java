package it.uniba.di.itps.asd.exams.Lab20130903.list;

import java.util.Iterator;

public class VectorList<S> implements AddOnlyList<S> {
	
	private S[] list = (S[]) new Object[1];
	private int n = 0;

	@Override
	public void add(S e) {
		if(n == list.length) {
			S[] tmp = (S[]) new Object[n * 2];
			System.arraycopy(list, 0, tmp, 0, n);
			list = tmp;
		}
		list[n] = e;
		n++;
	}
	
	@Override
	public Iterator<S> iterator() {
		return new Iterator<S>() {
			int current = 0;

			@Override
			public boolean hasNext() {
				return current < n;
			}

			@Override
			public S next() {
				return list[current++];
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
			
		};
	}
	
	@Override
	public String toString() {
		String str = "";
		for(int i = 0; i < n; i++) {
			str += list[i].toString();
			if(i != n-1) {
				str += ", ";
			}
		}
		return str;
	}

}
