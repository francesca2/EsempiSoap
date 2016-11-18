package it.alfasoft.francescal.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BustaPaga {

	private long id_Busta;
	private double importo;
	private String codiceDipendente;
	
	public BustaPaga() {
	}
	public BustaPaga(long id_Busta, double importo, String codiceDipendente) {
		this.id_Busta = id_Busta;
		this.importo = importo;
		this.codiceDipendente = codiceDipendente;
	}
	public long getId_Busta() {
		return id_Busta;
	}
	public void setId_Busta(long id_Busta) {
		this.id_Busta = id_Busta;
	}
	public double getImporto() {
		return importo;
	}
	public void setImporto(double importo) {
		this.importo = importo;
	}
	public String getCodiceDipendente() {
		return codiceDipendente;
	}
	public void setCodiceDipendente(String codiceDipendente) {
		this.codiceDipendente = codiceDipendente;
	}
	
}
