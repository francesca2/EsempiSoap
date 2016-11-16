package it.alfasoft.francesca.servizi;

import javax.jws.WebService;

import it.alfasoft.francesca.dao.FatturaDao;
import it.alfasoft.francesca.model.Fattura;

@WebService
public class FatturaServizi implements IFatturaServizi {
	
	/* (non-Javadoc)
	 * @see it.alfasoft.francesca.servizi.IFatturaServizi#getFatture()
	 */
	@Override
	public Fattura[] getFatture(){
		FatturaDao fdao= new FatturaDao();
		return fdao.getAllFatture();
	}
	
	/* (non-Javadoc)
	 * @see it.alfasoft.francesca.servizi.IFatturaServizi#getFatturaByCode(java.lang.String)
	 */
	@Override
	public Fattura getFatturaByCode(String code){
		FatturaDao fdao= new FatturaDao();
		return fdao.getFatturaByCode(code);
	}

}
