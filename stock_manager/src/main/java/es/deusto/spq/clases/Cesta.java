package es.deusto.spq.clases;

import java.util.HashMap;
import java.util.Map;

public class Cesta {

    private int ID_cliente;
    private final HashMap<Articulo, Integer> articulos;
    private String estado;

    public Cesta() {
        this.articulos = new HashMap<>();
    }

    public void addArticulo(final Articulo articulo, final int cantidad) {
        this.articulos.put(articulo, cantidad);
    }
  //Comentario

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(final String estado) {
        this.estado = estado;
    }

    public int getID() {
        return this.ID_cliente;
    }

    public void setID(final int ID_cliente) {
        this.ID_cliente = ID_cliente;
    }

    public HashMap<Articulo,Integer> getArticulos() {
        return this.articulos;
    }

    public float getRecibo() {

        int r = 0;

        for (final Map.Entry<Articulo, Integer> entry : this.articulos.entrySet()) {
           r += entry.getKey().getPrecio()*entry.getValue();
        }
       
        return r;
    }

	public Cesta(int iD_cliente, HashMap<Articulo, Integer> articulos, String estado) {
		super();
		ID_cliente = iD_cliente;
		this.articulos = articulos;
		this.estado = estado;
	}
    
    

}