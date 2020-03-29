package es.deusto.spq.clases;

import java.util.HashMap;
import java.util.Map;

public class Cesta {

    private int ID;
    private final HashMap<Articulo, Integer> articulos;
    private String estado;

    public Cesta() {
        this.articulos = new HashMap<>();
    }

    public void addArticulo(final Articulo articulo, final int cantidad) {
        this.articulos.put(articulo, cantidad);
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(final String estado) {
        this.estado = estado;
    }

    public int getID() {
        return this.ID;
    }

    public void setID(final int ID) {
        this.ID = ID;
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

}