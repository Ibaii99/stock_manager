package es.deusto.spq.data_access;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;
import javax.ws.rs.Path;


import es.deusto.spq.data.Cesta;
import es.deusto.spq.data.Opinion;
import es.deusto.spq.data.Vendedor;

public class DACesta {
	//JDO
	
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

}