package es.deusto.spq.data_access;

import java.util.ArrayList;

import es.deusto.spq.data.Cliente;

public class getterYsetters {
	private DAO dao;
		
	    
	    public Cliente getCliente(long id) {
	    	Cliente c = null;
	    	ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	    	clientes = (ArrayList<Cliente>) dao.getClientes();
	    	for(int i = 0; i<clientes.size(); i++) {
	    		c = clientes.get(i);
	    		if(id == c.getId()) {
	    			return c;
	    		}
	    	}
			return c;
	    }

}
