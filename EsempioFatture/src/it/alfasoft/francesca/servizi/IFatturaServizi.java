package it.alfasoft.francesca.servizi;

import it.alfasoft.francesca.model.Fattura;

public interface IFatturaServizi {

	public abstract Fattura[] getFatture();

	public abstract Fattura getFatturaByCode(String code);

}