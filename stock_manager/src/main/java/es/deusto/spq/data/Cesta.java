package es.deusto.spq.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import es.deusto.spq.data_access.DAO;

@PersistenceCapable(detachable = "true")
public class Cesta implements Serializable {
	//
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
    
    // En el indice 1 de articulos estara el articulo añadido primero
    // En el indice 1 de cantidades estara las cantidades dedl articulo 1
	
	@Persistent(mappedBy = "cestas")
	@Join
    private List<Articulo> articulos = new ArrayList<>();
    
    private List<Integer> cantidades = new ArrayList<>();
    private Estado estado = Estado.ACTUAL;

   public Cesta() {
	// TODO Auto-generated constructor stub
}


	public Cesta(List<Articulo> articulos, List<Integer> cantidades, Estado estado) {
		super();
		this.articulos = articulos;
		this.cantidades = cantidades;
		this.estado = estado;
	}

	public Cesta(Cesta cesta) {
		this.articulos = cesta.articulos;
		this.cantidades = cesta.cantidades;
		this.estado = Estado.PREPARACION;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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



    public void addArticulo(final Articulo articulo, final int cantidad) {
        
        if (this.articulos.contains(articulo)) {

			this.cantidades.set(this.articulos.indexOf(articulo), cantidad);
		
		}else {
			this.articulos.add(articulo);
			this.cantidades.add(cantidad);
		}; 
       
    }

   //A modificar por Oferta
   public float getRecibo() {
       float r = 0;
	   for (int i = 0; i < this.articulos.size(); i++) {
		   r += this.articulos.get(i).getPrecio() * this.cantidades.get(i);
	   }
       return r;
   }

//    @Override
// 	public String toString() {

//        String r = "";

//        for (final Map.Entry<Articulo, Integer> entry : this.articulos.entrySet()) {

//           r += "Cesta {" + entry.getKey().toString() + ", Cantidad: " + entry.getValue() + "  }";

//        }

// 		return r;
// 	}


	public void vaciarCesta() {
		/*
		for (int i = 0;i<articulos.size();i++) {
			articulos.remove(i);
			cantidades.remove(i);
		}
		*/
		articulos.clear();
		cantidades.clear();
	
	}

	public void modifyCesta(Articulo articulo, Integer cantidad) {

        if(this.getArticulos().contains(articulo)) {
            int i = articulos.indexOf(articulo);
            if (cantidad.equals(0)) {
                articulos.remove(i);
                cantidades.remove(i);
            }else {
                cantidades.remove(i);
                cantidades.add(i, cantidad);
            }
        }else{
            articulos.add(articulo);
            cantidades.add(cantidad);
        }
    }
	
	public void addCesta(Articulo articulo, Integer cantidad) {

	    if(this.getArticulos().contains(articulo)) {
	        int i = articulos.indexOf(articulo);
	        int cant = cantidad + cantidades.get(i);
	        cantidades.remove(i);
	        cantidades.add(i, cant);
	    }else{
	        articulos.add(articulo);
	        cantidades.add(cantidad);
	    }

	}
	public void removeArticuloCesta(Articulo articulo) {

        if(this.getArticulos().contains(articulo)) {
            int i = articulos.indexOf(articulo);
                articulos.remove(i);
                cantidades.remove(i);
        }
    }
}