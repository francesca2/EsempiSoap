package it.alfasoft.francescal.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BustaPaga {

	private long id_Busta;
	private double importo;
	private String codiceDipendente;
	private List<Link> riferimenti=new ArrayList<Link>();
	
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
	public List<Link> getRiferimenti() {
		return riferimenti;
	}
	public void setRiferimenti(List<Link> riferimenti) {
		this.riferimenti = riferimenti;
	}
	public void addLink(Link link){
		this.riferimenti.add(link);
	}
}
