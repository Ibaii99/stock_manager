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
	
	private Cliente a = new Cliente("pepe", "pepe@gmail.com", "1234", "Barakaldo");
	private Cliente b = new Cliente("luis", "luis@gmail.com", "1234", "Universidad Deusto");
	private Cliente c = new Cliente("mani", "mani@gmail.com", "1234", "Bilbao");
	private Cliente d = new Cliente("sandra", "sandra@gmail.com", "1234", "Universidad");
	private Cliente e = new Cliente("Ane", "ane@gmail.com", "1234", "DeustoTech");
	private Vendedor f = new Vendedor("MikelVendedor", "mikelVendedor@gmail.com");
	private Vendedor g = new Vendedor("JokinVendedor", "jokinVendedor@gmail.com");
	private Vendedor h = new Vendedor("IbaiVendedor", "ibailVendedor@gmail.com");
	private Vendedor i = new Vendedor("IzaiVendedor", "izaiVendedor@gmail.com");
	private Vendedor j = new Vendedor("UnaiVendedor", "unaiVendedor@gmail.com");
	private Articulo manzana = new Articulo("manzana", new Date(04/03/120), 1.20f, 400, "rica manzana", 0.95f, Categoria.FRUTA);
	private Articulo lechuga = new Articulo("lechuga", new Date(04/03/120), 1.20f, 400, "rica lechuga", 0.95f, Categoria.VEGETAL);
	private Articulo fresa = new Articulo("pimiento", new Date(04/03/120), 1.20f, 400, "rica fresa", 0.95f, Categoria.VEGETAL);
	private Articulo calabaza = new Articulo("lechuga", new Date(04/03/120), 1.20f, 400, "rica calabza", 0.95f, Categoria.VEGETAL);
	private Articulo pimiento = new Articulo("lechuga", new Date(04/03/120), 1.20f, 400, "rico pimiento", 0.95f, Categoria.VEGETAL);
	private Articulo a1 = new Articulo("coliflor",new Date(04/03/120), 1.20f, 400, "rica coliflor", 1.05f, Categoria.FRUTA);
	private Articulo a2 = new Articulo("pan",new Date(04/03/120), 1.20f, 400, "rica pan", 1.05f, Categoria.FRUTA);
	private Articulo a3 = new Articulo("agua",new Date(04/03/120), 1.20f, 400, "rica agua", 1.05f, Categoria.BEBIDA);
	private Articulo a4 = new Articulo("Mandarina",new Date(04/03/120), 1.20f, 400, "rica mandarina", 1.05f, Categoria.CARNICERIA);
	private ArrayList<Cesta> listaCestas= new ArrayList<Cesta>();
	private Cliente c1 = new Cliente("jokin", "jokin@gmail.com", "hola", "Deusto kalea 1");
	private Cliente c2 = new Cliente("aitor", "aitor@gmail.com", "hola", "Deusto kalea 1");
	private Integer cantidad1 = 400;
	private Integer cantidad2 = 500;
	private Integer cantidad3 = 300;
	private Integer cantidad4 = 600;
	private Cliente mikel = new Cliente("mikel", "mikel@gmail.com", "1234", "Barakaldo");
	private	Cliente jokin = new Cliente("jokin", "jokin@gmail.com", "1234", "Universidad Deusto");
	private	Cliente ibai = new Cliente("ibai", "ibail@gmail.com", "1234", "Bilbao");
	private	Cliente izai = new Cliente("izaia", "izai@gmail.com", "1234", "Universidad");
	private	Cliente unai = new Cliente("Unai", "unai@gmail.com", "1234", "DeustoTech");
	private	Opinion k = new Opinion("Me ha encantado la lechuga", 7,mikel);
	private	Opinion l = new Opinion("No me ha gusatdo el pimiento",1,jokin);
	private	Opinion m = new Opinion("No estaba buena del todo la calabaza pero estaba fresca", 6, ibai);
	private	Opinion n = new Opinion("No estaban fresca del todo las fresas pero estaban buenas", 5, izai);
	private	Opinion o = new Opinion("Habeis hecho un excelente trabajo",10,unai);
	
	
    @POST
	@Path("post")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Cliente> listaClientes() {
		ArrayList<Cliente> listaClientes= new ArrayList<Cliente>();
		listaClientes.add(a);
		listaClientes.add(b);
		listaClientes.add(c);
		listaClientes.add(d);
		listaClientes.add(e);
		listaClientes.add(mikel);
		listaClientes.add(jokin);
		listaClientes.add(ibai);
		listaClientes.add(izai);
		listaClientes.add(unai);
		dao.store(a);
		dao.store(b);
		dao.store(c);
		dao.store(d);
		dao.store(e);
		dao.store(mikel);
		dao.store(jokin);
		dao.store(ibai);
		dao.store(izai);
		dao.store(unai);
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
		listaVendedores.add(f);
		listaVendedores.add(g);
		listaVendedores.add(h);
		listaVendedores.add(i);
		listaVendedores.add(j);
		dao.store(f);
		dao.store(g);
		dao.store(h);
		dao.store(i);
		dao.store(j);
		return listaVendedores;
	}
	@GET
    @Path("get")
    @Produces(MediaType.APPLICATION_JSON)
    public String getItVendedores() {
        return "Vendedores devuelto!";
    }

    @POST
	@Path("post1")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Articulo> listaArticulos() {
		DAO dao = new DAO();
		ArrayList<Articulo> listaArticulos= new ArrayList<Articulo>();
		listaArticulos.add(a1);
		listaArticulos.add(a2);
		listaArticulos.add(a3);
		listaArticulos.add(a4);
		listaArticulos.add(lechuga);
		listaArticulos.add(pimiento);
		listaArticulos.add(fresa);
		listaArticulos.add(calabaza);
		listaArticulos.add(manzana);
		dao.store(a1);
		dao.store(a2);
		dao.store(a3);
		dao.store(a4);
		dao.store(lechuga);
		dao.store(pimiento);
		dao.store(fresa);
		dao.store(calabaza);
		dao.store(manzana);
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
		
		List<Articulo>listaArticulos1 = new ArrayList<Articulo>();
		List<Articulo>listaArticulos2 = new ArrayList<Articulo>();
		List<Integer> listaCantidades1 = new ArrayList<Integer>();
		List<Integer> listaCantidades2 = new ArrayList<Integer>();
		listaArticulos1.add(a1);
		listaArticulos1.add(a2);
		listaArticulos2.add(a3);
		listaArticulos2.add(a4);
		listaCantidades1.add(cantidad1);
		listaCantidades1.add(cantidad2);
		listaCantidades2.add(cantidad3);
		listaCantidades2.add(cantidad4);
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
       
		listaOpiniones.add(k);
		listaOpiniones.add(l);
		listaOpiniones.add(m);
		listaOpiniones.add(n);
		listaOpiniones.add(o);
		dao.store(k);
		dao.store(l);
		dao.store(m);
		dao.store(n);
		dao.store(o);
		return listaOpiniones;
	}
	@GET
    @Path("get")
    @Produces(MediaType.APPLICATION_JSON)
    public String getItOpiniones() {
        return "Opiniones devuelto!";
    }





}