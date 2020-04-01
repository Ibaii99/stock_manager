package es.deusto.spq.data_access;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import es.deusto.spq.data.Cesta;
import es.deusto.spq.data.Opinion;
import es.deusto.spq.data.Vendedor;
import es.deusto.spq.data.Articulo;
import es.deusto.spq.data.Cliente;

@Path("usuarios")
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

	public List<Articulo> getUsuarios() {
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

	public Cliente getCliente(long id) {
		Cliente c = null;
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		clientes = (ArrayList<Cliente>) this.getClientes();
		for(int i = 0; i<clientes.size(); i++) {
			c = clientes.get(i);
			if(id == c.getId()) {
				return c;
			}
		}
		return c;
	}
	
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
	
	public Cesta getCesta(long id) {
		Cesta c = null;
		ArrayList<Cesta> cestas = new ArrayList<Cesta>();
		cestas = (ArrayList<Cesta>) this.getCestas();
		for(int i = 0; i<cestas.size(); i++) {
			c = cestas.get(i);
			if(id == c.getId()) {
				return c;
			}
		}
		return c;
	}
    
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

	//No cerrar la conexion hasta cerrar el programa
	public void closeConection() {
		pmf.close();
	}
	
}
