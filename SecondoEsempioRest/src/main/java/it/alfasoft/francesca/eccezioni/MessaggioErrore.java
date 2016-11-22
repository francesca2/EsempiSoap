package it.alfasoft.francesca.eccezioni;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MessaggioErrore {

	private String errorMessage;
	private int errorCode;
	private String paginaRedirect;
	
	public MessaggioErrore() {
	}
	
	public MessaggioErrore(String errorMessage, int errorCode,
			String paginaRedirect) {
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
		this.paginaRedirect = paginaRedirect;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getPaginaRedirect() {
		return paginaRedirect;
	}
	public void setPaginaRedirect(String paginaRedirect) {
		this.paginaRedirect = paginaRedirect;
	}
	
}
