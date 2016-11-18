package it.alfasoft.francesca.resources;

import java.util.ArrayList;
import java.util.List;

import it.alfasoft.francesca.dao.BustaPagaDao;
import it.alfasoft.francescal.model.BustaPaga;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
	
}
