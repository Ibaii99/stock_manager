package es.deusto.spq.remote;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import es.deusto.spq.data.Articulo;
import es.deusto.spq.data.Cesta;
import es.deusto.spq.data.Cliente;
import es.deusto.spq.data.Opinion;
import es.deusto.spq.data.Vendedor;
import es.deusto.spq.data.Articulo.Categoria;
import es.deusto.spq.data.Cesta.Estado;
import es.deusto.spq.data_access.DAO;

/**
 * Root resource (exposed at "api" path)
 */
@Path("api")
public class API {
	DAO dao = new DAO();
	

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
		Cliente c = new Cliente("ibai", "asdnhujkasdnas", "adsasdsad", "sadaddas");
		dao.store(c);
		return true;
	}
		
    @GET
    @Path("get")
    @Produces(MediaType.APPLICATION_JSON)
    public String getIt() {
        return "Got it!";
    
    
    }
}
