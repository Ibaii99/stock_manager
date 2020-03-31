package es.deusto.spq.data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(detachable = "true")
public class Cesta implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	enum Estado {
        ACTUAL,
        PREPARACION,
        ENCAMINO,
        ENTREGADO
      }

	@PrimaryKey
    private long id;
    
	
    private Cliente cliente;
    
    // En el indice 1 de articulos estara el articulo añadido primero
    // En el indice 1 de cantidades estara las cantidades dedl articulo 1
    private List<Articulo> articulos;
    private List<Integer> cantidades;
    
    private Estado estado;

    public Cesta() {
    	articulos = null;
    } 

    public Cesta(Cliente cliente, Estado estado) {
        super();
        this.cliente = cliente;
        
        this.estado = estado;
    }


//    public void addArticulo(final Articulo articulo, final int cantidad) {
//        
//        if (this.articulos.containsKey(articulo)) {
//            this.articulos.replace(articulo, articulos.get(articulo)+cantidad);
//        }else this.articulos.put(articulo, cantidad); 
//       
//    }

    public Estado getEstado() {
        return this.estado;
    }

    public String getEstadoString() {
        return this.estado.toString();
    }

    public void setEstado(final Estado estado) {
        this.estado = estado;
    }

    public Cliente getIDCliente() {
        return this.cliente;
    }

    public void setIDCliente(Cliente cliente) {
        this.cliente = cliente;
    }

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

}