package es.deusto.spq.data;

import java.util.HashMap;
import java.util.Map;

public class Cesta {

    enum Estado {
        ACTUAL,
        PREPARACION,
        ENCAMINO,
        ENTREGADO
      }

    private int ID_cliente;
    private int ID_cesta;
    private final HashMap<Articulo, Integer> articulos;
    private Estado estado;

    public Cesta(){

    }

    public Cesta(int idCesta, int idCliente, Estado estado) {
        this.ID_cesta = idCesta;
        this.ID_cliente = idCliente;
        this.articulos = new HashMap<>();
        this.estado = estado;
    }

    public int getID_cesta() {
        return ID_cesta;
    }

    public void setID_cesta(int iD_cesta) {
        this.ID_cesta = iD_cesta;
    }

    public void addArticulo(final Articulo articulo, final int cantidad) {
        
        if (this.articulos.containsKey(articulo)) {
            this.articulos.replace(articulo, articulos.get(articulo)+cantidad);
        }else this.articulos.put(articulo, cantidad); 
       
    }

    public Estado getEstado() {
        return this.estado;
    }

    public String getEstadoString() {
        return this.estado.toString();
    }

    public void setEstado(final Estado estado) {
        this.estado = estado;
    }

    public int getIDCliente() {
        return this.ID_cliente;
    }

    public void setIDCliente(final int ID_cliente) {
        this.ID_cliente = ID_cliente;
    }

    public HashMap<Articulo,Integer> getArticulos() {
        return this.articulos;
    }

    //A modificar por Oferta
    public float getRecibo() {

        int r = 0;

        for (final Map.Entry<Articulo, Integer> entry : this.articulos.entrySet()) {
           r += entry.getKey().getPrecio()*entry.getValue();
        }
       
        return r;
    }

    @Override
	public String toString() {

        String r = "";

        for (final Map.Entry<Articulo, Integer> entry : this.articulos.entrySet()) {

           r += "Cesta {" + entry.getKey().toString() + ", Cantidad: " + entry.getValue() + "  }";

        }

		return r;
	}


}