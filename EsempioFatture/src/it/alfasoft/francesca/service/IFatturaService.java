package it.alfasoft.francesca.service;

import it.alfasoft.francesca.model.Fattura;

import java.util.List;

import javax.jws.WebMethod;

public interface IFatturaService {

	public abstract Fattura[] getFatture();

	public abstract Fattura getFatturaByCode(String code);

}