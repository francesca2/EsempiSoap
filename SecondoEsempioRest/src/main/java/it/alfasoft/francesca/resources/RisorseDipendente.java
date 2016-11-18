package it.alfasoft.francesca.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import it.alfasoft.francesca.dao.DipendenteDao;
import it.alfasoft.francescal.model.Dipendente;

@Path("dipendenti")
public class RisorseDipendente {
	
	private DipendenteDao ddao=new DipendenteDao();

//	@Path("/{codiceDipendente}")
//	@GET
//	@Produces(MediaType.APPLICATION_XML)
//	public Dipendente getDipendenteByCode(@PathParam("codiceDipendente") String codiceDipendente){
//		
//		return ddao.getDipendenti().get(codiceDipendente);
//	}
	
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<Dipendente> getDipendenti(){
//			
//		return new ArrayList<Dipendente>(ddao.getDipendenti().values());
//	}
	
//	@Path("/{num}")
//	@GET
//	@Produces(MediaType.TEXT_PLAIN)
//	public String testConversione(@PathParam("num") double n){
//			
//		return n + " " + (n+n);
//	}
	
	//Prendere un dipendente con json
	@Path("/{codiceDipendente}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Dipendente getDipendenteByCode(@PathParam("codiceDipendente") String codiceDipendente){
		
		return ddao.getDipendenti().get(codiceDipendente);
	}
	
//	@POST
//	@Produces(MediaType.APPLICATION_JSON)
//	public void addDipendente(Dipendente d){
//		
//		ddao.getDipendenti().put(d.getCodice(), d);
//		System.out.println(d.getNome() + " " + d.getCognome());
//	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public void updateDipendente(Dipendente d){
		
		ddao.getDipendenti().put(d.getCodice(), d);
		for(Dipendente dd: ddao.getDipendenti().values()){
			System.out.println(dd.getNome()+ " " + dd.getCognome());
		}
	}
	
	@Path("/{codiceDipendente}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteDipendente(@PathParam("codiceDipendente") String codice){
		
		ddao.getDipendenti().remove(codice);
		for(Dipendente dd: ddao.getDipendenti().values()){
			System.out.println(dd.getNome()+ " " + dd.getCognome());
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Dipendente sendParametri(@QueryParam("codice") String codiceDipendente, @QueryParam("num") int num){
		
		System.out.println(codiceDipendente +" " + (num+num));
		return ddao.getDipendenti().get(codiceDipendente);
	}
	
	//Se viene un url di questo tipo:
	//http://localhost:8085/NomeAplicazione/alfasoft/dipendenti/{codiceDipendente}/bustepaghe
	//arriva a questo metodo e viene reindirizzato a risorseBusta
	@Path("/{codiceDipendente}/bustepaghe")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public RisorseBuste getBustaPaga(){
		return new RisorseBuste();
	}
}







