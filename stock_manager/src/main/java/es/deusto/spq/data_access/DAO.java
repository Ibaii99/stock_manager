package es.deusto.spq.data_access;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;
import javax.ws.rs.Path;

import es.deusto.spq.data.Articulo;
import es.deusto.spq.data.Cliente;


public class DAO {
	//JDO
	
	private PersistenceManagerFactory pmf;
	private PersistenceManager pm;

	public DAO() {
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		pm = pmf.getPersistenceManager();
	}
	
	public void store(Object u) {
		Transaction tx = this.pm.currentTransaction();
		try {
			tx.begin();
			System.out.println("   * Storing an object: " + u);
			pm.makePersistent(u);
			tx.commit();
		} catch (Exception ex) {
			System.out.println("   $ Error storing an object: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

		}
	}
	//Hacer stores de cada clase
	//Hacer 

	public List<Articulo> getUsuarios(){
		List <Articulo> ret = new ArrayList<Articulo>();
		Transaction tx = pm.currentTransaction();
		try {
			System.out.println("   * Retrieving an Extent for Articulos.");
			tx.begin();
			Extent<Articulo> extent = pm.getExtent(Articulo.class, true);
			for (Articulo product : extent) {
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
	
	
	//No cerrar la conexion hasta cerrar el programa
	public void closeConection() {
		pmf.close();
	}
}
