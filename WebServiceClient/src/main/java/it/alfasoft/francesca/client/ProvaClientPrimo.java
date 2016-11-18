package it.alfasoft.francesca.client;

import java.util.List;

import it.alfasoft.francesca.model.Dipendente;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

public class ProvaClientPrimo {

	public static void main(String[] args) {

		//Factory pattern: è un metodo statico a creare il cliente
		Client cliente= ClientBuilder.newClient();
		
		//Target di base al quale poi aggiungiamo pezzi
		WebTarget baseTarget= cliente.target("http://localhost:8085/SecondoEsempioRest/alfasoft");
		
		WebTarget dipTarget= baseTarget.path("/dipendenti");
		
		WebTarget singoloDipTarget = dipTarget.path("/{codiceDip}");
		
		//Mando una richiesta di tipo get all'indirizzo specificato
		//ed ottengo una risposta http
//		Response response= singoloDipTarget
//								.resolveTemplate("codiceDip", "cod001")
//		                		.request()
//		                		.get();
//
//		Dipendente d= response.readEntity(Dipendente.class);
//		System.out.println(d.getNome()+" "+ d.getCognome());
//		
//		Dipendente d2=new Dipendente("aaa", "bbb", 1200, "cod010");
//		
//		Response responsePost= dipTarget
//        		.request()
//        		.post(Entity.json(d2));
//		
//		if(responsePost.getStatus()!=201){
//			System.out.println("Qualcosa è andato storto!");
//		}
//
//		System.out.println(responsePost.getStatus());
		
		Response response=dipTarget
        		.request()
        		.get();
		
		List<Dipendente> dipendenti= response.
				readEntity(new GenericType<List<Dipendente>>(){});
		
		for(Dipendente dd: dipendenti){
			System.out.println(dd.getNome()+" "+ dd.getCognome() +" "+ dd.getStipendio());
		}
		
	}

}
