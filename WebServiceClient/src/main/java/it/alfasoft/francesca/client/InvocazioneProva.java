package it.alfasoft.francesca.client;

import it.alfasoft.francesca.model.Dipendente;

import javax.ws.rs.core.Response;

public class InvocazioneProva {

	public static void main(String[] args) {

		Invocazioni invocazione= new Invocazioni();
		
		Response risposta=invocazione.richiestaDipendenteByCode("cod001")
					.invoke();
		
		Dipendente d=risposta.readEntity(Dipendente.class);
		
		System.out.println(d.getNome()+ " " + d.getCognome());

	}

}
