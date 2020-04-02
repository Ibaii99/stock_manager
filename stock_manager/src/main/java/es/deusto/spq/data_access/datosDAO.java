package es.deusto.spq.data_access;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import es.deusto.spq.data.Articulo;
import es.deusto.spq.data.Articulo.Categoria;
import es.deusto.spq.data.Cesta;
import es.deusto.spq.data.Cesta.Estado;
import es.deusto.spq.data.Cliente;
import es.deusto.spq.data.Opinion;
import es.deusto.spq.data.Vendedor;

public class datosDAO {
	DAO dao = new DAO();
	
    @POST
	@Path("post")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Cliente> listaClientes() {
		ArrayList<Cliente> listaClientes= new ArrayList<Cliente>();
		Cliente a = new Cliente("mikel", "mikel@gmail.com", "1234", "Barakaldo");
		Cliente b = new Cliente("jokin", "jokin@gmail.com", "1234", "Universidad Deusto");
		Cliente c = new Cliente("ibai", "ibail@gmail.com", "1234", "Bilbao");
		Cliente d = new Cliente("izaia", "izai@gmail.com", "1234", "Universidad");
		Cliente e = new Cliente("Unai", "unai@gmail.com", "1234", "DeustoTech");
		listaClientes.add(a);
		listaClientes.add(b);
		listaClientes.add(c);
		listaClientes.add(d);
		listaClientes.add(e);
		dao.store(a);
		dao.store(b);
		dao.store(c);
		dao.store(d);
		dao.store(e);
		return listaClientes;
	}
	@GET
    @Path("get")
    @Produces(MediaType.APPLICATION_JSON)
    public String getItClietnes() {
        return "Cliente devuelto!";
	}
	

	@POST
	@Path("post")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Vendedor> listaVendedores() {
		ArrayList<Vendedor> listaVendedores= new ArrayList<Vendedor>();
		Vendedor a = new Vendedor("MikelVendedor", "mikelVendedor@gmail.com");
		Vendedor b = new Vendedor("JokinVendedor", "jokinVendedor@gmail.com");
		Vendedor c = new Vendedor("IbaiVendedor", "ibailVendedor@gmail.com");
		Vendedor d = new Vendedor("IzaiVendedor", "izaiVendedor@gmail.com");
		Vendedor e = new Vendedor("UnaiVendedor", "unaiVendedor@gmail.com");
		listaVendedores.add(a);
		listaVendedores.add(b);
		listaVendedores.add(c);
		listaVendedores.add(d);
		listaVendedores.add(e);
		dao.store(a);
		dao.store(b);
		dao.store(c);
		dao.store(d);
		dao.store(e);
		return listaVendedores;
	}
	@GET
    @Path("get")
    @Produces(MediaType.APPLICATION_JSON)
    public String getItVendedores() {
        return "Vendedores devuelto!";
    }

    @POST
	@Path("post")
    @Produces(MediaType.APPLICATION_JSON)
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
    @Produces(MediaType.APPLICATION_JSON)
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

    @POST
	@Path("post")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Opinion> listaOpiniones() {
        ArrayList<Opinion> listaOpiniones= new ArrayList<Opinion>();
        Cliente mikel = new Cliente("mikel", "mikel@gmail.com", "1234", "Barakaldo");
		Cliente jokin = new Cliente("jokin", "jokin@gmail.com", "1234", "Universidad Deusto");
		Cliente ibai = new Cliente("ibai", "ibail@gmail.com", "1234", "Bilbao");
		Cliente izai = new Cliente("izaia", "izai@gmail.com", "1234", "Universidad");
		Cliente unai = new Cliente("Unai", "unai@gmail.com", "1234", "DeustoTech");
		Opinion a = new Opinion("Me ha encantado la lechuga", 7,mikel);
		Opinion b = new Opinion("No me ha gusatdo el pimiento",1,jokin);
		Opinion c = new Opinion("No estaba buena del todo la calabaza pero estaba fresca", 6, ibai);
		Opinion d = new Opinion("No estaban fresca del todo las fresas pero estaban buenas", 5, izai);
		Opinion e = new Opinion("Habeis hecho un excelente trabajo",10,unai);
		listaOpiniones.add(a);
		listaOpiniones.add(b);
		listaOpiniones.add(c);
		listaOpiniones.add(d);
		listaOpiniones.add(e);
		dao.store(a);
		dao.store(b);
		dao.store(c);
		dao.store(d);
		dao.store(e);
		return listaOpiniones;
	}
	@GET
    @Path("get")
    @Produces(MediaType.APPLICATION_JSON)
    public String getItOpiniones() {
        return "Opiniones devuelto!";
    }





}