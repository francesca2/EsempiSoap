package it.alfasoft.francesca.eccezioni;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class EccezzioniGenerico implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable es) {
		MessaggioErrore msg=new MessaggioErrore(es.getMessage(),
				500,
				"google.com");
		
		return Response
				.status(Status.INTERNAL_SERVER_ERROR)
				.entity(msg)
				.build();
	}

}
