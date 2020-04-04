package es.deusto.spq.data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import es.deusto.spq.data_access.DAO;

@PersistenceCapable(detachable = "true")
public class Cesta implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public enum Estado {
        ACTUAL,
        PREPARACION,
        ENCAMINO,
        ENTREGADO
      }

	@Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT, primaryKey="true")
    private long id;
    
	
    private Cliente cliente;
    
    // En el indice 1 de articulos estara el articulo añadido primero
    // En el indice 1 de cantidades estara las cantidades dedl articulo 1
    private List<Articulo> articulos;
    private List<Integer> cantidades;
    private Estado estado;

   public Cesta() {
	// TODO Auto-generated constructor stub
}


	public Cesta(long id, Cliente cliente, List<Articulo> articulos, List<Integer> cantidades, Estado estado) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.articulos = articulos;
		this.cantidades = cantidades;
		this.estado = estado;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public List<Articulo> getArticulos() {
		return articulos;
	}


	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}


	public List<Integer> getCantidades() {
		return cantidades;
	}


	public void setCantidades(List<Integer> cantidades) {
		this.cantidades = cantidades;
	}


	public Estado getEstado() {
		return estado;
	}


	public void setEstado(Estado estado) {
		this.estado = estado;
	}



//    public void addArticulo(final Articulo articulo, final int cantidad) {
//        
//        if (this.articulos.containsKey(articulo)) {
//            this.articulos.replace(articulo, articulos.get(articulo)+cantidad);
//        }else this.articulos.put(articulo, cantidad); 
//       
//    }

 

//	public HashMap<Articulo,Integer> getArticulos() {
//        return this.articulos;
//    }
//
//    //A modificar por Oferta
//    public float getRecibo() {
//
//        int r = 0;
//
//        for (final Map.Entry<Articulo, Integer> entry : this.articulos.entrySet()) {
//           r += entry.getKey().getPrecio()*entry.getValue();
//        }
//       
//        return r;
//    }
//
//    @Override
//	public String toString() {
//
//        String r = "";
//
//        for (final Map.Entry<Articulo, Integer> entry : this.articulos.entrySet()) {
//
//           r += "Cesta {" + entry.getKey().toString() + ", Cantidad: " + entry.getValue() + "  }";
//
//        }
//
//		return r;
//	}
//
public void anyadirCesta(Articulo articulo, Integer cantidad) {
	articulos.add(articulo);
	cantidades.add(cantidad);
	DAO dao = new DAO();
	dao.store(this);
}

public void eliminarCesta(Articulo articulo, Integer cantidad) {
	DAO dao = new DAO();
	Cesta cesta = dao.getCesta(this.getId());
	if(cesta!=null) {
		if(cesta.getArticulos().contains(articulo)) {
			int i = articulos.indexOf(articulo);
			if (cantidad == 0) {
				articulos.remove(i);
				cantidades.remove(i);
			}else {
				cantidades.remove(i);
				cantidades.add(i, cantidad);
			}
		}
	}
}

public void eliminarCestaEntera() {
	/*
	for (int i = 0;i<articulos.size();i++) {
		articulos.remove(i);
		cantidades.remove(i);
	}
	*/
	articulos.clear();
	cantidades.clear();

}



}