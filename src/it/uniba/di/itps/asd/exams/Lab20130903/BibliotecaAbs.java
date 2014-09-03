package it.uniba.di.itps.asd.exams.Lab20130903;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import it.uniba.di.itps.asd.exams.Lab20130903.dict.Dictionary;
import it.uniba.di.itps.asd.exams.Lab20130903.dict.KeyAlreadyExistsException;

public abstract class BibliotecaAbs {
	
	protected Dictionary<String, Record> volumi;
	
	public boolean bibliotecaVuota() {
		return volumi.size()==0;
	}
	
	public void addVolume(String posizione, Volume volume) throws EccezionePosizioneOccupata {
		try {
			volumi.insert(posizione, new Record(volume, false));
		} catch (KeyAlreadyExistsException e) {
			throw new EccezionePosizioneOccupata();
		}
	}
	
	public Volume volume(String posizione) {
		Record r = volumi.search(posizione);
		if(r != null) {
			return r.volume;
		}
		throw new NoSuchElementException();
	}
	
	public void prestito(String posizione) {
		Record r = volumi.search(posizione);
		if(r != null && r.flag == false) {
			r.flag = true;
			volumi.delete(posizione);
			try {
				volumi.insert(posizione, r);
			} catch (KeyAlreadyExistsException e) {}
		} else {
			throw new NoSuchElementException();
		}
	}
	
	public void restituzione(String posizione) {
		Record r = volumi.search(posizione);
		if(r != null && r.flag == true) {
			r.flag = false;
			volumi.delete(posizione);
			try {
				volumi.insert(posizione, r);
			} catch (KeyAlreadyExistsException e) {}
		} else {
			throw new NoSuchElementException();
		}
	}
	
	public boolean prestato(String posizione) {
		Record r = volumi.search(posizione);
		if(r != null) {
			return r.flag;
		}
		throw new NoSuchElementException();
	}
	
	public List<String> posizione(Volume volume) {
		List<String> list = new LinkedList<String>();
		for(String posizione : volumi) {
			Record r = volumi.search(posizione);
			if(r != null) {
				Volume v = r.volume;
				if(v.equals(volume)) {
					list.add(posizione);
				}
			}
		}
		return list;
	}

}
