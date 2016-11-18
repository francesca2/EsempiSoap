package it.alfasoft.francesca.resources;

import it.alfasoft.francesca.dao.BustaPagaDao;
import it.alfasoft.francescal.model.BustaPaga;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class RisorseBuste {

	BustaPagaDao bpdao= new BustaPagaDao();
	
	@Path("/{IdBusta}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public BustaPaga getBustaById(@PathParam("IdBusta") long id){
		return bpdao.getBuste().get(id);
	}
	
}
