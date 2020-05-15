package es.deusto.spq.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jdo.annotations.Column;
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
	
	@Join
    private List<Articulo> articulos = new ArrayList<>();
    
    private List<Integer> cantidades = new ArrayList<>();
    private Estado estado = Estado.ACTUAL;

    private Cliente cliente;
    
   public Cesta() {
	// TODO Auto-generated constructor stub
}


	/**Constructor de Cesta
	 * @param articulos Lista de articulos que pertenece a la cesta
	 * @param cantidades Lista de las cantidades de los articulos que pertenece a la cesta
	 * @param estado El estado de la cesta
	 */
	public Cesta(List<Articulo> articulos, List<Integer> cantidades, Estado estado) {
		super();
		this.articulos = articulos;
		this.cantidades = cantidades;
		this.estado = estado;
	}

	/** Duplicador de cesta
	 * @param cesta Objeto Cesta para dupliclarla
	 */
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

	public static long getSerialVersionUid() {
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


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Estado getEstado() {
		return estado;
	}


	public void setEstado(Estado estado) {
		this.estado = estado;
	}



    /** Metodo para añadir un articulo a la cesta
     * @param articulo Articulo a añadir a la cesta
     * @param cantidad Cantidad del articulo a añadir
     */
    public void addArticulo(final Articulo articulo, final int cantidad) {
        
        if (this.articulos.contains(articulo)) {

			this.cantidades.set(this.articulos.indexOf(articulo), cantidad);
		
		}else {
			this.articulos.add(articulo);
			this.cantidades.add(cantidad);
		}; 
       
    }

   //A modificar por Oferta
   
    /** Devuelve el precio total de toda la cesta
     * @return Devuelve un float de la cantidad total
     */
    public float getRecibo() {
       float r = 0;
	   for (int i = 0; i < this.articulos.size(); i++) {
		   r += this.articulos.get(i).getOferta() * this.cantidades.get(i);
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


	/**Limpia la cesta, tanto articulos como cantidades
	 * 
	 */
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

	/** Modifica la cantidad de un articulo en la cesta
	 * @param articulo Articulo del que se modificara la cantidad
	 * @param cantidad Cantidad del articulo que se va a establecer
	 */
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
	
	/**Añadir un articulo a la cesta
	 * @param articulo Articulo a añadir a la cesta
	 * @param cantidad Cantidad de articulos a añadir
	 */
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
	/** Borrar un articulo de la cesta
	 * @param articulo Articulo a quitar de la cesta
	 */
	public void removeArticuloCesta(Articulo articulo) {

        if(this.getArticulos().contains(articulo)) {
            int i = articulos.indexOf(articulo);
                articulos.remove(i);
                cantidades.remove(i);
        }
    }
}