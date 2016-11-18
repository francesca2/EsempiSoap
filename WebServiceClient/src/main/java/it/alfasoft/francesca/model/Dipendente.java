package it.alfasoft.francesca.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Dipendente {
	
	private String nome;
	private String cognome;
	private double stipendio;
	private String codice;
	
	public Dipendente() {
	}

	public Dipendente(String nome, String cognome, double stipendio, String codice) {
		this.nome = nome;
		this.cognome = cognome;
		this.stipendio = stipendio;
		this.codice = codice;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public double getStipendio() {
		return stipendio;
	}

	public void setStipendio(double stipendio) {
		this.stipendio = stipendio;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}
	

}
