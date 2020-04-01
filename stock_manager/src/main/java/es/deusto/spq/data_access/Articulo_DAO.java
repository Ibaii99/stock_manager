package es.deusto.spq.data_access;

import java.sql.Date;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import es.deusto.spq.data.Articulo;
import es.deusto.spq.data.Articulo.Categoria;
import es.deusto.spq.data_access.DAO;

/**
 * Root resource (exposed at "articulo_dao" path)
 */
@Path("articulo_dao")
public class Articulo_DAO {
	
	@POST
	@Path("post")
    @Consumes(MediaType.APPLICATION_JSON)
    public ArrayList<Articulo> lista() {
		DAO dao = new DAO();
		ArrayList<Articulo> listaArticulos= new ArrayList<Articulo>();
		Articulo a = new Articulo("manzana", new Date(04/03/120), 1.20f, 400, "rica manzana", 0.95f, Categoria.FRUTA);
		Articulo b = new Articulo("lechuga", new Date(04/03/120), 1.20f, 400, "rica lechuga", 0.95f, Categoria.VEGETAL);
		listaArticulos.add(a);
		listaArticulos.add(b);
		dao.store(a);
		dao.store(b);
		return listaArticulos;
	}
	@GET
    @Path("get")
    @Produces(MediaType.APPLICATION_JSON)
    public String getIt() {
        return "Articulo devuelto!";
    
    
    }
}