package it.uniba.di.itps.asd.exams.Lab20130903;

import java.util.List;

public class Test {

	public static void main(String[] args) {
		Biblioteca bib = new Biblioteca();
		Volume v1 = new Volume("Progetto di algoritmi e strutture dati in Java", "McGraw Hill", 2007, "Camil Demetrescu", "Umberto Ferraro Petrillo", "Irene Finocchi", "Giuseppe F. Iteliano");
		Volume v2 = new Volume("Algoritmi e strutture dati", "CittaStudi Edizioni", 2009, "Alan Bertossi");
		Volume v3 = new Volume("Programmazione Java: Fondamenti", "Pearson-Prentice Hall", 2008, "Deitel & Deitel");
		Volume v4 = new Volume("Java Software Structures", "Pearson Education", 2010, "John Lewis", "Joseph Chase");
		try {
			bib.addVolume("AR12-SC03-PR47", v1);
			bib.addVolume("AR01-SC00-PR13", v1);
			bib.addVolume("AR07-SC33-PR22", v1);
			bib.addVolume("AR01-SC03-PR11", v2);
			bib.addVolume("AR11-SC01-PR01", v3);
			bib.addVolume("AR05-SC03-PR15", v3);
			bib.addVolume("AR10-SC09-PR04", v4);
			
			List<String> pos = bib.posizione(v3);
			if(pos.size() > 0) {
				bib.prestito(pos.get(0));
			}
			pos = bib.posizione(v2);
			if(pos.size() > 0) {
				bib.prestito(pos.get(0));
			}
			for(String p : bib.volumi) {
				boolean prestato = bib.prestato(p);
				System.out.println(p + (prestato ? " Prestato " : " Disponibile ") + bib.volume(p).toString());
			}
		} catch (EccezionePosizioneOccupata e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
