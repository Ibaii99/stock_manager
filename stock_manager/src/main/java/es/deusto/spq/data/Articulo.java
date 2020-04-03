package es.deusto.spq.data;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;


@PersistenceCapable(detachable = "true")
public class Articulo implements Serializable {

	/**
	 * 
	 */
	public enum Categoria {
		FRUTA,
		VEGETAL, 
		CARNICERIA,
		PESCADERIA, 
		BEBIDA,
		DULCE
	}
	
	private static final long serialVersionUID = 1L;
	@Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT, primaryKey="true")
    private long id;
    private String nombre;
    private Date caducidad;
    private float precio;
    private int stock;
    private String descripcion;
    private float oferta;
    private Categoria categoria;
    
    
    private Vendedor vendedor;
    
	public Articulo() {
	}

	public Articulo(String nombre, Date caducidad, float precio, int stock, String descripcion, float oferta,
			Categoria categoria) {
        super();
		this.nombre = nombre;
		this.caducidad = caducidad;
		this.precio = precio;
		this.stock = stock;
		this.descripcion = descripcion;
		this.oferta = oferta;
		this.categoria = categoria;
    }
    
	public Categoria getCategoria() {
		return categoria;
	}

	
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getCaducidad() {
		return caducidad;
	}

	public void setCaducidad(Date caducidad) {
		this.caducidad = caducidad;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getOferta() {
		return oferta;
	}

	public void setOferta(float oferta) {
		this.oferta = oferta;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
        return "Articulo [Nombre=" + this.nombre + ", Caducidad=" + this.caducidad + ", Precio" + this.precio +
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