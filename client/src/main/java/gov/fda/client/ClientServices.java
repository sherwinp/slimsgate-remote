package gov.fda.client;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/clientservices")
public class ClientServices {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
    public String getHello() {
        return "{\"results\": \"Hello World\"}";
    }

}