package es.deusto.spq.data_access;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import es.deusto.spq.data.Cesta;
import es.deusto.spq.data.Opinion;
import es.deusto.spq.data.Vendedor;
import es.deusto.spq.data.Articulo.Categoria;
import es.deusto.spq.data.Cesta.Estado;
import es.deusto.spq.data.Articulo;
import es.deusto.spq.data.Cliente;

@Path("dao")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DAO {
	//JDO
	
	private final PersistenceManagerFactory pmf;
	private final PersistenceManager pm;
	
	

	public DAO() {
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		pm = pmf.getPersistenceManager();
	}

	public void store(final Object u) {
		final Transaction tx = this.pm.currentTransaction();
		try {
			tx.begin();
			System.out.println("   * Storing an object: " + u);
			pm.makePersistent(u);
			tx.commit();
		} catch (final Exception ex) {
			System.out.println("   $ Error storing an object: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

		}
	}
	
	
	//Hacer stores de cada clase
	//Hacer 
	
	//DATOS_DAO
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
	DAO dao = new DAO();

//ARTÍCULOS
	//STORE de artículos
	 @POST
		@Path("postArticulos")
	    @Consumes(MediaType.APPLICATION_JSON)
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
	
	//GET de lista de artículos
	public List<Articulo> getArticulos() {
		final List<Articulo> ret = new ArrayList<Articulo>();
		final Transaction tx = pm.currentTransaction();
		try {
			System.out.println("   * Retrieving an Extent for Articulos.");
			tx.begin();
			final Extent<Articulo> extent = pm.getExtent(Articulo.class, true);
			for (final Articulo product : extent) {
				ret.add(product);
			}
			tx.commit();
		} catch (final Exception ex) {
			System.out.println("   $ Error retrieving an usuario: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		return ret;
	}
	//GET de un artículo
		public Articulo getArticulo(long idArticulo) {
			Articulo a = null;
			ArrayList<Articulo> articulos = new ArrayList<Articulo>();
			articulos = (ArrayList<Articulo>) this.getArticulos();
			for(int i = 0; i<articulos.size(); i++) {
				a = articulos.get(i);
				if(idArticulo == a.getId()) {
					return a;
				}
			}
			return a;
		}

	 
//GET de artículos	 
//		@GET
//	    @Path("get2")
//	    @Produces(MediaType.APPLICATION_JSON)
//	    public String devuelveArticulos() {
//	        return "Articulo devuelto!";
//	    }
	
		
//CLIENTES
		//STORE de clientes
	 @POST
		@Path("postClientes")
	    @Consumes(MediaType.APPLICATION_JSON)
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
	//GET de lista de clientes
	public List<Cliente> getClientes(){
		List <Cliente> ret = new ArrayList<Cliente>();
		Transaction tx = pm.currentTransaction();
		try {
			System.out.println("   * Retrieving an Extent for Cliente.");
			tx.begin();
			Extent<Cliente> extent = pm.getExtent(Cliente.class, true);
			for (Cliente product : extent) {
				ret.add(product);
			}
			tx.commit();
		} catch (Exception ex) {
			System.out.println("   $ Error retrieving an usuario: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		return ret;
	}
	//GET de un cliente
	public Cliente getCliente(long idCliente) {
		Cliente c = null;
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		clientes = (ArrayList<Cliente>) this.getClientes();
		for(int i = 0; i<clientes.size(); i++) {
			c = clientes.get(i);
			if(idCliente == c.getId()) {
				return c;
			}
		}
		return c;
	}
	
//GET de clientes
//		@GET
//	    @Path("get0")
//	    @Produces(MediaType.APPLICATION_JSON)
//	    public String devuelveClientes() {
//	        return "Cliente devuelto!";
//		}

//CESTAS
	//STORE de cestas
	@POST
	@Path("postCestas")
	@Consumes(MediaType.APPLICATION_JSON)
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
	
    //GET de lista de cestas
	public List<Cesta> getCestas(){
		List <Cesta> ret = new ArrayList<Cesta>();
		Transaction tx = pm.currentTransaction();
		try {
			System.out.println("   * Retrieving an Extent for Cestas.");
			tx.begin();
			Extent<Cesta> extent = pm.getExtent(Cesta.class, true);
			for (Cesta cesta : extent) {
				ret.add(cesta);
			}
			tx.commit();
		} catch (Exception ex) {
			System.out.println("   $ Error retrieving an usuario: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		return ret;
	}
	
	public Cesta getCesta(long idCesta) {
		Cesta c = null;
		ArrayList<Cesta> cestas = new ArrayList<Cesta>();
		cestas = (ArrayList<Cesta>) this.getCestas();
		for(int i = 0; i<cestas.size(); i++) {
			c = cestas.get(i);
			if(idCesta == c.getId()) {
				return c;
			}
		}
		return c;
	}
//GET de cestas
//	@GET
//    @Path("get3")
//    @Produces(MediaType.APPLICATION_JSON)
//    public String devuelveCestas() {
//        return "Cesta devuelta!";
//	}
    
//OPINION
	//STORE de opiniones
    @POST
	@Path("postOpiniones")
    @Consumes(MediaType.APPLICATION_JSON)
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
	//GET de lista de opiniones
    public List<Opinion> getOpiniones(){
		List <Opinion> ret = new ArrayList<Opinion>();
		Transaction tx = pm.currentTransaction();
		try {
			System.out.println("   * Retrieving an Extent for Opiniones.");
			tx.begin();
			Extent<Opinion> extent = pm.getExtent(Opinion.class, true);
			for (Opinion product : extent) {
				ret.add(product);
			}
			tx.commit();
		} catch (Exception ex) {
			System.out.println("   $ Error retrieving an usuario: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		return ret;
	}
    //GET de una unica opinion
	public Opinion getOpinion(long id) {
		Opinion c = null;
		ArrayList<Opinion> Opiniones = new ArrayList<Opinion>();
		Opiniones = (ArrayList<Opinion>) this.getOpiniones();
		for(int i = 0; i<Opiniones.size(); i++) {
			c = Opiniones.get(i);
			if(id == c.getId()) {
				return c;
			}
		}
		return c;
	}
	
//GET de opinion
//@GET
//@Path("get4")
//@Produces(MediaType.APPLICATION_JSON)
//public String devuelveOpiniones() {
//    return "Opiniones devuelto!";
//}

//VENDEDOR
	//STORE de vendedores
	@POST
	@Path("postVendedores")
	@Consumes(MediaType.APPLICATION_JSON)
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
	//GET de lista de vendedores
    public List<Vendedor> getVendedores(){
		List <Vendedor> ret = new ArrayList<Vendedor>();
		Transaction tx = pm.currentTransaction();
		try {
			System.out.println("   * Retrieving an Extent for Vendedores.");
			tx.begin();
			Extent<Vendedor> extent = pm.getExtent(Vendedor.class, true);
			for (Vendedor product : extent) {
				ret.add(product);
			}
			tx.commit();
		} catch (Exception ex) {
			System.out.println("   $ Error retrieving an usuario: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		return ret;
	}
    //GET de un unico vendedor
	public Vendedor getVendedor(long id) {
		Vendedor c = null;
		ArrayList<Vendedor> Vendedores = new ArrayList<Vendedor>();
		Vendedores = (ArrayList<Vendedor>) this.getVendedores();
		for(int i = 0; i<Vendedores.size(); i++) {
			c = Vendedores.get(i);
			if(id == c.getId()) {
				return c;
			}
		}
		return c;
	}
//GET de vendedores
//@GET
//@Path("get1")
//@Produces(MediaType.APPLICATION_JSON)
//public String devuelveVendedores() {
//    return "Vendedores devuelto!";
//}

	
	//No cerrar la conexion hasta cerrar el programa
	public void closeConection() {
		pmf.close();
	}
	
}
