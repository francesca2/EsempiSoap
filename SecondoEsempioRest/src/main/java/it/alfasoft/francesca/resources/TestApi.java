package it.alfasoft.francesca.resources;

import it.alfasoft.francesca.bean.FiltriFattura;

import javax.ws.rs.BeanParam;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

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
	
	//Metodo per prendere i parametri dai cookies
	@GET
	@Path("/cookie")
	public String getCookiesParameter(@CookieParam("num") int num){
		return "La somma è " + (num+num);
	}
	
	//Metodo per prendere i parametri dal context
	@GET
	@Path("/context")
	public String getContextParameter(@Context UriInfo uriInfo, 
			@Context HttpHeaders httpHeaders){
//		String s= httpHeaders.getCookies().toString();
		//Serve per hateos
		String path= uriInfo.getAbsolutePath().toString();
		return path;
	}
	
	@GET
	@Path("/fattura")
	public String getContextParameter(@BeanParam FiltriFattura ff){
		
		return ff.getAnno()+ " " + ff.getOffset() + " " + ff.getLimit();
	}
	
	
}
