package it.alfasoft.francesca.resources;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("test")
@Produces(MediaType.TEXT_PLAIN)
public class TestApi {
	
	@GET
	public String metodoProva(){
		return "Ciao!";
	}

	//Metodo per usare i parametri passati dentro l'header
	@GET
	@Path("/head")
	public String getHeaderParameter(@HeaderParam("num") int num){
		return "La somma è " + (num+num);
	}
}
