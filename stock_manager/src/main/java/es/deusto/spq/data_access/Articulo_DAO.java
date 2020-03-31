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

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("articulo_dao")
public class Articulo_DAO {
	ArrayList<Articulo>todosArticulos = new ArrayList<Articulo>();
	@POST
	@Path("post")
    @Consumes(MediaType.APPLICATION_JSON)
    public Articulo test(String codigo) {
		DAO dao = new DAO();
		dao.getUsuarios();
		Articulo a = new Articulo("Manzana", new Date(05/9/120), 1.59f, 400, "Manzana Golden, al peso, compra mínima 1 kg", 1.20f, Categoria.FRUTA);
		for(int i = 0; i<todosArticulos.size(); i++) {
    		a = todosArticulos.get(i);
    		if(codigo == a.getNombre()) {
    			return a;
    		}
    	}
		return a;
	}

}