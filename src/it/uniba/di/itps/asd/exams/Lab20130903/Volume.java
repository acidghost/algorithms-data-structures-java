package it.uniba.di.itps.asd.exams.Lab20130903;

import it.uniba.di.itps.asd.exams.Lab20130903.list.AddOnlyList;
import it.uniba.di.itps.asd.exams.Lab20130903.list.VectorList;

import java.util.LinkedList;
import java.util.List;

public class Volume {

	String titolo;
	String casaEditrice;
	int anno;
	AddOnlyList<String> autori;
	
	public Volume(String titolo, String casaEditrice, int anno, AddOnlyList<String> autori) {
		this.titolo = titolo;
		this.casaEditrice = casaEditrice;
		this.anno = anno;
		this.autori = autori;
	}
	
	public Volume(String titolo, String casaEditrice, int anno, String... autori) {
		this.titolo = titolo;
		this.casaEditrice = casaEditrice;
		this.anno = anno;
		this.autori = new VectorList<String>();
		for(String autore : autori) {
			this.autori.add(autore);
		}
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Volume) {
			Volume v = (Volume) obj;
			if(v.titolo.equals(titolo) && v.casaEditrice.equals(casaEditrice) && v.anno == anno) {
				// Una soluzione migliore sarebbe dotare la classe
				// AddOnlyList di due metodi: size():int e search(S e):boolean
				List<String> aList = new LinkedList<String>();
				for(String a : autori) {
					aList.add(a);
				}
				int n = 0;
				for(String a : v.autori) {
					if(!aList.contains(a)) {
						return false;
					}
					n++;
				}
				if(n == aList.size()) {
					return true;
				}
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return titolo + " - " + autori.toString() + " - " + casaEditrice + ", " + anno;
	}
		
}
