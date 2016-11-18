package it.alfasoft.francesca.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;

public class Invocazioni {

	private Client cliente= ClientBuilder.newClient();
	private WebTarget baseTarget= cliente.target("http://localhost:8085/SecondoEsempioRest/alfasoft");
	private WebTarget dipTarget= baseTarget.path("/dipendenti");
	
	public Invocazioni() {
		
	}
	
	public Invocation richiestaDipendenteByCode(String code){
		
		return dipTarget.path(code).request().buildGet();
	}
}
