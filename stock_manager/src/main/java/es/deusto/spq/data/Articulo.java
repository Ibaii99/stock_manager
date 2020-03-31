package es.deusto.spq.data;

import java.io.Serializable;
import java.util.Date;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(detachable = "true")
public class Articulo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PrimaryKey
    private long id;
    private String nombre;
    private Date caducidad;
    private double precio;
    private int stock;
    private String descripcion;
    private double oferta;
    private String categoria;
    
    
    private Vendedor vendedor;
    
	public Articulo() {
	}

	public Articulo(String nombre, Date caducidad, float precio, int stock, String descripcion, float oferta,
			String categoria) {
        super();
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

	public double getOferta() {
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

    public double getPrecio() {
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
 

    @Override
	public String toString() {
        return "Articulo [Nombre=" + this.nombre + ", Caducidad=" + this.categoria + ", Precio" + this.precio +
        ", Stock" + this.stock + ", Descrpción" + this.descripcion + ", Oferta" + this.oferta + ", Categoria" + this.categoria +     "]";
	}


    @Override
	public int hashCode() {
		
        int hash = 31 * this.caducidad.hashCode();
        hash += 31 * this.stock;
        hash += 31 * this.categoria.hashCode();
        hash += 31 * this.descripcion.hashCode();
        hash += 31 * this.nombre.hashCode();
        hash += 31 * Math.round(this.oferta);
        hash += 31 * Math.round( this.precio);
        
		return hash;
		
	}


}