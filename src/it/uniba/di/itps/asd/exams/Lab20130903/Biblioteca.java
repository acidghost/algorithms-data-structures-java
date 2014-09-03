package it.uniba.di.itps.asd.exams.Lab20130903;

import it.uniba.di.itps.asd.exams.Lab20130903.dict.LinkedDict;

public class Biblioteca extends BibliotecaAbs {

	public Biblioteca() {
		volumi = new LinkedDict<String, Record>();
	}
	
}
