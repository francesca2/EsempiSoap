package it.alfasoft.francesca.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import it.alfasoft.francesca.dao.BustaPagaDao;
import it.alfasoft.francescal.model.BustaPaga;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class RisorseBuste {

	BustaPagaDao bpdao= new BustaPagaDao();
	
	@GET
	public List<BustaPaga> getAllBuste(){		
		return new ArrayList<BustaPaga>(bpdao.getBuste().values());
	}
	
	@Path("/{IdBusta}")
	@GET	
	public BustaPaga getBustaById(@PathParam("IdBusta") long id){
		return bpdao.getBuste().get(id);
	}
	
	@Path("/{IdBusta}/{num}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getBusta(@PathParam("IdBusta") long id,
			@PathParam("codiceDipendente") String codice,
			@PathParam("num") int num){
		
		return id + " " + codice + " " + num;
	}
	
//	@POST
//	@Consumes(MediaType.APPLICATION_JSON)
//	public Response addBusta(BustaPaga b, @Context UriInfo uri){
//		//Se lo passo ad un db il campo id della busta deve essere vuoto
//		//lo faccio generare al db
//		bpdao.getBuste().put(b.getId_Busta(), b);
//		
//		URI u= uri.getAbsolutePathBuilder().path(String.valueOf(b.getId_Busta())).build();
//		
//		return Response.created(u).entity(b).build();
//	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addBusta(BustaPaga b){
		//Se lo passo ad un db il campo id della busta deve essere vuoto
		//lo faccio generare al db
		bpdao.getBuste().put(b.getId_Busta(), b);

		return Response.status(Status.CREATED)
						.entity(b)
						.build();
	}
}
