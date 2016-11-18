package it.alfasoft.francesca.client;

import it.alfasoft.francesca.model.Dipendente;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

public class ProvaClientPrimo {

	public static void main(String[] args) {

		//Factory pattern: è un metodo statico a creare il cliente
		Client cliente= ClientBuilder.newClient();
		
		//Mando una richiesta di tipo get all'indirizzo specificato
		//ed ottengo una risposta http
		Response response= cliente.target("http://localhost:8085/SecondoEsempioRest/alfasoft/dipendenti/cod001")
		                		.request()
		                		.get();

		Dipendente d= response.readEntity(Dipendente.class);
		System.out.println(d.getNome()+" "+ d.getCognome());
		
	}

}
