package es.deusto.spq.clases;

public class Oferta{

    private int codigo;
    private String nombre;
    private Articulo articulo;

    public Oferta(int codigo, String nombre, Articulo articulo){
        this.codigo = codigo;
        this.nombre = nombre;
        this.articulo = articulo;
    }

    public int getCodigo(){
        return this.codigo;
    }
    public String getNombre(){
        return this.nombre;
    }
    public Articulo getArticulo(){
        return this.articulo;
    }

}