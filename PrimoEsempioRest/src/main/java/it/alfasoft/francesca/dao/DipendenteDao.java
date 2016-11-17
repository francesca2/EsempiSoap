package it.alfasoft.francesca.dao;

import it.alfasoft.francescal.model.Dipendente;

import java.util.HashMap;
import java.util.Map;

public class DipendenteDao {
	
	private Map<String,Dipendente> dipendenti;

	public DipendenteDao() {
		dipendenti= new HashMap<String,Dipendente>();
		Dipendente d1= new Dipendente("Nome1","Cognome1",1200,"cod001");
		Dipendente d2= new Dipendente("Nome2","Cognome2",1200,"cod002");
		Dipendente d3= new Dipendente("Nome3","Cognome3",1200,"cod003");
		Dipendente d4= new Dipendente("Nome4","Cognome4",1200,"cod004");
		dipendenti.put(d1.getCodice(), d1);
		dipendenti.put(d2.getCodice(), d2);
		dipendenti.put(d3.getCodice(), d3);
		dipendenti.put(d4.getCodice(), d4);
	}

	public Map<String, Dipendente> getDipendenti() {
		return dipendenti;
	}

	public void setDipendenti(Map<String, Dipendente> dipendenti) {
		this.dipendenti = dipendenti;
	}
	
}
