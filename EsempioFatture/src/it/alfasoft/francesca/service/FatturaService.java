package it.alfasoft.francesca.service;

import it.alfasoft.francesca.dao.FatturaDao;
import it.alfasoft.francesca.model.Fattura;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style=Style.DOCUMENT)
public class FatturaService implements IFatturaService {

	/* (non-Javadoc)
	 * @see it.alfasoft.francesca.service.IFatturaService#getFatture()
	 */
	@Override
	@WebMethod
	public Fattura[] getFatture(){
		FatturaDao fdao= new FatturaDao();
		return fdao.getAllFatture();
	}
	
	/* (non-Javadoc)
	 * @see it.alfasoft.francesca.service.IFatturaService#getFatturaByCode(java.lang.String)
	 */
	@Override
	@WebMethod
	public Fattura getFatturaByCode(String code){
		FatturaDao fdao= new FatturaDao();
		return fdao.getFatturaByCode(code);
	}
	
}
