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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;

import it.alfasoft.francesca.dao.DipendenteDao;
import it.alfasoft.francescal.model.Dipendente;
import it.alfasoft.francescal.model.Link;

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
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Dipendente> getDipendenti(){
			
		return new ArrayList<Dipendente>(ddao.getDipendenti().values());
	}
	
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
	public Dipendente getDipendenteByCode(@PathParam("codiceDipendente") String codiceDipendente,
			@Context UriInfo uriInfo){
		
		Dipendente d = ddao.getDipendenti().get(codiceDipendente);
		String link = uriInfo.getBaseUriBuilder()
				.path(RisorseDipendente.class)
				.path(codiceDipendente)
				.build()
				.toString();
		d.addLink(link, "self");	
		String linkBuste = uriInfo.getBaseUriBuilder()
				.path(RisorseDipendente.class)
				.path(codiceDipendente)
				.path("bustepaghe")
				.build()
				.toString();
		d.addLink(linkBuste,"self");
		
		return ddao.getDipendenti().get(codiceDipendente);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response addDipendente(Dipendente d){
		
		ddao.getDipendenti().put(d.getCodice(), d);
		
		System.out.println("Post arrivato!" + d.getNome() +" " + d.getCognome());
		return Response.status(Status.CREATED)
				.build();
	}
	
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
	
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public Dipendente sendParametri(@QueryParam("codice") String codiceDipendente, @QueryParam("num") int num){
//		
//		System.out.println(codiceDipendente +" " + (num+num));
//		return ddao.getDipendenti().get(codiceDipendente);
//	}
	
	//Se viene un url di questo tipo:
	//http://localhost:8085/NomeAplicazione/alfasoft/dipendenti/{codiceDipendente}/bustepaghe
	//arriva a questo metodo e viene reindirizzato a risorseBusta
	@Path("/{codiceDipendente}/bustepaghe")
	public RisorseBuste getBustaPaga(){
		return new RisorseBuste();
	}
}







