package es.deusto.spq.clases;

import java.sql.Date;

public class Articulo {

    private int ID;
    private String nombre;
    private Date caducidad;
    private float precio;
    private int stock;
    private String descripcion;
    private float oferta;
    private String categoria;

	public Articulo(int iD, String nombre, Date caducidad, float precio, int stock, String descripcion, float oferta,
			String categoria) {
		super();
		this.ID = iD;
		this.nombre = nombre;
		this.caducidad = caducidad;
		this.precio = precio;
		this.stock = stock;
		this.descripcion = descripcion;
		this.oferta = oferta;
		this.categoria = categoria;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public float getOferta() {
        return oferta;
    }

    public void setOferta(float oferta) {
        this.oferta = oferta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Date getCaducidad() {
        return caducidad;
    }

    public void setCaducidad(Date caducidad) {
        this.caducidad = caducidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        this.ID = iD;
    }
    


}