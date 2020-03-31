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
	public Articulo() {
		super();
		this.ID = 0;
		this.nombre = "";
		this.caducidad = new Date(0,0,0);
		this.precio = 0;
		this.stock = 0;
		this.descripcion = "";
		this.oferta = 0;
		this.categoria = "";
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

    @Override
	public boolean equals(Object o){
		
		if (!(o instanceof Articulo)) return false;
		
        Articulo p = (Articulo) o;

        return this.ID==p.ID;
        
        //&&this.nombre==p.nombre&&this.caducidad==p.caducidad&&this.categoria==p.categoria&&this.descripcion==p.descripcion
        //&&this.oferta==p.oferta&&this.precio==p.precio&&this.stock==p.stock;

    }

    @Override
	public String toString() {
        return "Articulo [ID=" + this.ID + ", nombre=" + this.nombre + ", Caducidad=" + this.categoria + ", Precio" + this.precio +
        ", Stock" + this.stock + ", Descrpción" + this.descripcion + ", Oferta" + this.oferta + ", Categoria" + this.categoria +     "]";
	}


    @Override
	public int hashCode() {
		
        int hash = 31 * this.ID;
        hash += 31 * this.caducidad.hashCode();
        hash += 31 * this.stock;
        hash += 31 * this.categoria.hashCode();
        hash += 31 * this.descripcion.hashCode();
        hash += 31 * this.nombre.hashCode();
        hash += 31 * Math.round(this.oferta);
        hash += 31 * Math.round( this.precio);
        
		return hash;
		
	}


}