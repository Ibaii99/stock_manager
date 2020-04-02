package es.deusto.spq.remote;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import es.deusto.spq.data.Cliente;
import es.deusto.spq.data_access.DAO;

/**
 * Root resource (exposed at "api" path)
 */
@Path("api")
public class API {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
	@POST
	@Path("post")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean register() {
		DAO db = new DAO();
		Cliente c = new Cliente("ibai", "asdnhujkasdnas", "adsasdsad", "sadaddas");
		db.store(c);
		return true;
	}
	
    @GET
    @Path("get")
    @Produces(MediaType.APPLICATION_JSON)
    public String getIt() {
        return "Got it!";
    
    
    }
}