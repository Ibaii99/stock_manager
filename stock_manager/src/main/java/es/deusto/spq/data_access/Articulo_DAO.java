package es.deusto.spq.data_access;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import es.deusto.spq.data.Cesta;
import es.deusto.spq.data.Cliente;
import es.deusto.spq.data.Articulo;
import es.deusto.spq.data.Articulo.Categoria;
import es.deusto.spq.data.Cesta.Estado;
import es.deusto.spq.data_access.DAO;

/**
 * Root resource (exposed at "articulo_dao" path)
 */
@Path("articulo_dao")
public class Articulo_DAO {
	
	@POST
	@Path("post1")
    @Consumes(MediaType.APPLICATION_JSON)
    public ArrayList<Articulo> listaArticulos() {
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
    @Path("get1")
    @Produces(MediaType.APPLICATION_JSON)
    public String devolucionArticulos() {
        return "Articulo devuelto!";
    
    
    }
	@POST
	@Path("post2")
    @Consumes(MediaType.APPLICATION_JSON)
    public ArrayList<Cesta> listaCestas() {
		DAO dao = new DAO();
		ArrayList<Cesta> listaCestas= new ArrayList<Cesta>();
		Cliente c1 = new Cliente("jokin", "jokin@gmail.com", "hola", "Deusto kalea 1");
		Cliente c2 = new Cliente("aitor", "aitor@gmail.com", "hola", "Deusto kalea 1");
		Articulo a1 = new Articulo("manzana",new Date(120,04,12), 1.20f, 400, "rica manzana", 1.05f, Categoria.FRUTA);
		Articulo a2 = new Articulo("pan",new Date(120,04,12), 1.20f, 400, "rica manzana", 1.05f, Categoria.FRUTA);
		Articulo a3 = new Articulo("agua",new Date(120,04,12), 1.20f, 400, "rica manzana", 1.05f, Categoria.BEBIDA);
		Articulo a4 = new Articulo("Carne",new Date(120,04,12), 1.20f, 400, "rica manzana", 1.05f, Categoria.CARNICERIA);
		List<Articulo>listaArticulos1 = new ArrayList<Articulo>();
		List<Articulo>listaArticulos2 = new ArrayList<Articulo>();
		List<Integer> listaCantidades1 = new ArrayList<Integer>();
		List<Integer> listaCantidades2 = new ArrayList<Integer>();
		listaArticulos1.add(a1);
		listaArticulos1.add(a2);
		listaArticulos2.add(a3);
		listaArticulos2.add(a4);
		Integer cantidad1 = 400;
		Integer cantidad2 = 500;
		Integer cantidad3 = 300;
		Integer cantidad4 = 600;
		listaCantidades1.add(cantidad1);
		listaCantidades1.add(cantidad2);
		Cesta a = new Cesta(1, c1, listaArticulos1, listaCantidades1, Estado.ACTUAL);
		Cesta b = new Cesta(2, c2, listaArticulos2, listaCantidades2, Estado.ACTUAL);
		dao.store(a);
		dao.store(b);
		return listaCestas;
	}
	@GET
    @Path("get2")
    @Produces(MediaType.APPLICATION_JSON)
    public String getIt() {
        return "Cesta devuelta!";
    
    
    }
}