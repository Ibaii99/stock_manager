package es.deusto.spq.data_access;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import es.deusto.spq.data.Cesta;
import es.deusto.spq.data.Opinion;
//import es.deusto.spq.data.Usuario;
import es.deusto.spq.data.Vendedor;
import es.deusto.spq.data.Articulo.Categoria;
import es.deusto.spq.data.Cesta.Estado;
import es.deusto.spq.data.Articulo;
import es.deusto.spq.data.Cliente;

public class DAO {
	// JDO

	private PersistenceManagerFactory pmf;
	private PersistenceManager pm;

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
	
	//Si existe un mensaje salga por pantalla(el metodo si existe en Admin)
	public String existe() {
		String a= "Ya existe";
		return a;
	}
	
	public String noExiste() {
		String a= "No existe";
		return a;
	}
	




	// GET de un artículo
	public Articulo getArticulo(long idArticulo) {
		Articulo a = null;
		ArrayList<Articulo> articulos = new ArrayList<Articulo>();
		articulos = (ArrayList<Articulo>) this.getArticulos();
		for (int i = 0; i < articulos.size(); i++) {
			a = articulos.get(i);
			if (idArticulo == a.getId()) {
				return a;
			}
		}
		return a;
	}

	// GET de lista de clientes
	public List<Cliente> getClientes() {
		List<Cliente> ret = new ArrayList<Cliente>();
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

	// GET de un cliente
	public Cliente getCliente(String email, String contrasenya) {
		Cliente c = null;
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		clientes = (ArrayList<Cliente>) this.getClientes();
		for (int i = 0; i < clientes.size(); i++) {
			c = clientes.get(i);
			if (email.equals(c.getEmail_cliente()) && contrasenya.equals(c.getContrasenya_cliente())) {
				return c;
			}
		}
		return null;
	}
	
//	public List<Usuario> getUsuarios() {
//		List<Usuario> ret = new ArrayList<Usuario>();
//		Transaction tx = pm.currentTransaction();
//		try {
//			System.out.println("   * Retrieving an Extent for Usuario.");
//			tx.begin();
//			Extent<Usuario> extent = pm.getExtent(Usuario.class, true);
//			for (Usuario product : extent) {
//				ret.add(product);
//			}
//			tx.commit();
//		} catch (Exception ex) {
//			System.out.println("   $ Error retrieving an usuario: " + ex.getMessage());
//		} finally {
//			if (tx != null && tx.isActive()) {
//				tx.rollback();
//			}
//		}
//		return ret;
//	}
//
//	// GET de un cliente
//	
//	public Usuario getUsuario(String usuario, String contrasenya) {
//		Usuario u = null;
//		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
//		usuarios = (ArrayList<Usuario>) this.getUsuarios();
//		for (int i = 0; i < usuarios.size(); i++) {
//			u = usuarios.get(i);
//			if (usuario.equals(u.getUser()) && contrasenya.equals(u.getContrasenya())) {
//				return u;
//			}
//		}
//		return null;
//	}
	
	


	

	public List<Cesta> getCestas() {
		List<Cesta> ret = new ArrayList<Cesta>();
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
		for (int i = 0; i < cestas.size(); i++) {
			c = cestas.get(i);
			if (idCesta == c.getId()) {
				return c;
			}
		}
		return c;
	}



	// GET de lista de opiniones
	public List<Opinion> getOpiniones() {
		List<Opinion> ret = new ArrayList<Opinion>();
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

	// GET de una unica opinion
	public Opinion getOpinion(long id) {
		Opinion c = null;
		ArrayList<Opinion> Opiniones = new ArrayList<Opinion>();
		Opiniones = (ArrayList<Opinion>) this.getOpiniones();
		for (int i = 0; i < Opiniones.size(); i++) {
			c = Opiniones.get(i);
			if (id == c.getId()) {
				return c;
			}
		}
		return c;
	}



	// GET de lista de vendedores
	public List<Vendedor> getVendedores() {
		List<Vendedor> ret = new ArrayList<Vendedor>();
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

	// GET de un unico vendedor
	public Vendedor getVendedor(String email) {
		Vendedor v = null;
		ArrayList<Vendedor> vendedores = new ArrayList<Vendedor>();
		vendedores = (ArrayList<Vendedor>) this.getVendedores();
		for (int i = 0; i < vendedores.size(); i++) {
			v = vendedores.get(i);
			if (email.equals(v.getEmail_vendedor())) {
				return v;
			}
		}
		return v;
	}
	// Meter varios datos a la base de datos
	@SuppressWarnings("deprecation")
	public String meter_datos() {

		Cliente a = new Cliente("pepe", "pepe@gmail.com", "1234", "Barakaldo");
		Cliente b = new Cliente("luis", "luis@gmail.com", "1234", "Universidad Deusto");
		Cliente c = new Cliente("mani", "mani@gmail.com", "1234", "Bilbao");
		Cliente d = new Cliente("sandra", "sandra@gmail.com", "1234", "Universidad");
		Cliente e = new Cliente("Ane", "ane@gmail.com", "1234", "DeustoTech");
		Cliente mikel = new Cliente("mikel", "mikel@gmail.com", "1234", "Barakaldo");
		Cliente jokin = new Cliente("jokin", "jokin@gmail.com", "1234", "Universidad Deusto");
		Cliente ibai = new Cliente("ibai", "ibai@gmail.com", "1234", "Bilbao");
		Cliente izai = new Cliente("izaia", "izai@gmail.com", "1234", "Universidad");
		Cliente unai = new Cliente("Unai", "unai@gmail.com", "1234", "DeustoTech");
		Vendedor f = new Vendedor("MikelVendedor", "mikelVendedor@gmail.com");
		Vendedor g = new Vendedor("JokinVendedor", "jokinVendedor@gmail.com");
		Vendedor h = new Vendedor("IbaiVendedor", "ibailVendedor@gmail.com");
		Vendedor i = new Vendedor("IzaiVendedor", "izaiVendedor@gmail.com");
		Vendedor j = new Vendedor("UnaiVendedor", "unaiVendedor@gmail.com");
		Cliente c1 = new Cliente("jokin", "jokin@gmail.com", "hola", "Deusto kalea 1");
		Cliente c2 = new Cliente("aitor", "aitor@gmail.com", "hola", "Deusto kalea 1");
		Articulo manzana = new Articulo("manzana", new Date(121, 3, 21), 1.20f, 400, "rica manzana", 0.95f,
				Categoria.FRUTAS);
		Articulo lechuga = new Articulo("lechuga", new Date(121, 3, 21), 1.20f, 400, "rica lechuga", 0.95f,
				Categoria.VERDURAS);
		Articulo fresa = new Articulo("pimiento", new Date(121, 3, 21), 1.20f, 400, "rica fresa", 0.95f,
				Categoria.VERDURAS);
		Articulo calabaza = new Articulo("lechuga", new Date(121, 3, 21), 1.20f, 400, "rica calabza", 0.95f,
				Categoria.VERDURAS);
		Articulo pimiento = new Articulo("lechuga", new Date(121, 3, 21), 1.20f, 400, "rico pimiento", 0.95f,
				Categoria.VERDURAS);
		Articulo a1 = new Articulo("coliflor", new Date(121, 3, 21), 1.20f, 400, "rica coliflor", 1.05f,
				Categoria.FRUTAS);
		Articulo a2 = new Articulo("pan", new Date(121, 3, 21), 1.20f, 400, "rica pan", 1.05f, Categoria.FRUTAS);
		Articulo a3 = new Articulo("agua", new Date(121, 3, 21), 1.20f, 400, "rica agua", 1.05f, Categoria.ZUMOS);
		Articulo a4 = new Articulo("Mandarina", new Date(121, 3, 21), 1.20f, 400, "rica mandarina", 1.05f,
				Categoria.FRUTAS);
		ArrayList<Cesta> listaCestas = new ArrayList<Cesta>();
		Integer cantidad1 = 400;
		Integer cantidad2 = 500;
		Integer cantidad3 = 300;
		Integer cantidad4 = 600;
		Opinion k = new Opinion("Me ha encantado la lechuga", 7, mikel);
		Opinion l = new Opinion("No me ha gusatdo el pimiento", 1, jokin);
		Opinion m = new Opinion("No estaba buena del todo la calabaza pero estaba fresca", 6, ibai);
		Opinion n = new Opinion("No estaban fresca del todo las fresas pero estaban buenas", 5, izai);
		Opinion o = new Opinion("Habeis hecho un excelente trabajo", 10, unai);
//		Usuario mikelAdmin = new Usuario("mikel", "1234");
//		Usuario ibaiAdmin = new Usuario("ibai", "1234");
//		Usuario jokinAdmin = new Usuario("jokin", "1234");
//		Usuario izaiAdmin = new Usuario("izai", "1234");
//		Usuario unaiAdmin = new Usuario("unai", "1234");
//		Usuario admin = new Usuario("admin", "admin");
		
		
		ArrayList<Articulo> listaArticulos = new ArrayList<Articulo>();
		listaArticulos.add(a1);
		listaArticulos.add(a2);
		listaArticulos.add(a3);
		listaArticulos.add(a4);
		listaArticulos.add(lechuga);
		listaArticulos.add(pimiento);
		listaArticulos.add(fresa);
		listaArticulos.add(calabaza);
		listaArticulos.add(manzana);
		store(a1);
		store(a2);
		store(a3);
		store(a4);
		store(lechuga);
		store(pimiento);
		store(fresa);
		store(calabaza);
		store(manzana);
		
		ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
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
		store(a);
		store(b);
		store(c);
		store(d);
		store(e);
		store(mikel);
		store(jokin);
		store(ibai);
		store(izai);
		store(unai);
		
		
//		ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
//		listaUsuarios.add(admin);
//		listaUsuarios.add(mikelAdmin);
//		listaUsuarios.add(jokinAdmin);
//		listaUsuarios.add(ibaiAdmin);
//		listaUsuarios.add(izaiAdmin);
//		listaUsuarios.add(unaiAdmin);
//		store(admin);
//		store(mikelAdmin);
//		store(jokinAdmin);
//		store(ibaiAdmin);
//		store(izaiAdmin);
//		store(unaiAdmin);
//		
		
		List<Articulo> listaArticulos1 = new ArrayList<Articulo>();
		List<Articulo> listaArticulos2 = new ArrayList<Articulo>();
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
		
		Cesta aa = new Cesta(1, c1, listaArticulos1, listaCantidades1, Estado.ACTUAL);
		Cesta bb = new Cesta(2, c2, listaArticulos2, listaCantidades2, Estado.ACTUAL);
		store(aa);
		store(bb);
		
		ArrayList<Opinion> listaOpiniones = new ArrayList<Opinion>();
		ArrayList<Vendedor> listaVendedores = new ArrayList<Vendedor>();
		listaVendedores.add(f);
		listaVendedores.add(g);
		listaVendedores.add(h);
		listaVendedores.add(i);
		listaVendedores.add(j);
		store(f);
		store(g);
		store(h);
		store(i);
		store(j);
		
		listaOpiniones.add(k);
		listaOpiniones.add(l);
		listaOpiniones.add(m);
		listaOpiniones.add(n);
		listaOpiniones.add(o);
		store(k);
		store(l);
		store(m);
		store(n);
		store(o);
		
		return "Todos los datos han sido añadidos bien";

	}


	// No cerrar la conexion hasta cerrar el programa
	public void closeConection() {
		pmf.close();
	}

}
