package src.main.java.es.deusto.spq.data;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;


//

public class Articulo implements Serializable {

	/**
	 * 
	 */
	public enum Categoria {
		FRUTAS,
		FRUTOSSECOS, 
		VERDURAS,
		ZUMOS
	}
	
	private static final long serialVersionUID = 1L;
    private long id;
    private String nombre;
    private Date caducidad;
    private float precio;
    private int stock;
    private String descripcion;
    private float oferta;
    private Categoria categoria;
    private String imageUrl;
    
    private Vendedor vendedor;
    
	public Articulo() {
	}

	public Articulo(String nombre, Date caducidad, float precio, int stock, String descripcion, float oferta,
			Categoria categoria, String imageUrl) {
        super();
		this.nombre = nombre;
		this.caducidad = caducidad;
		this.precio = precio;
		this.stock = stock;
		this.descripcion = descripcion;
		this.oferta = oferta;
		this.categoria = categoria;
		this.imageUrl = imageUrl;
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

	
	
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
		
	}

//	public void storeMe() {
//		DAO dao = new DAO();
//		dao.store(this);
//	}

	@Override
	public String toString() {
        return "Articulo:" + "[Id" + this.id + "Nombre: " + this.nombre + ", Caducidad: " + this.caducidad + ", Precio: " + this.precio +
        ", Stock: " + this.stock + ", Descripción: " + this.descripcion + ", Oferta: " + this.oferta + ", Categoria: " + this.categoria +     "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((caducidad == null) ? 0 : caducidad.hashCode());
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((imageUrl == null) ? 0 : imageUrl.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + Float.floatToIntBits(oferta);
		result = prime * result + Float.floatToIntBits(precio);
		result = prime * result + stock;
		result = prime * result + ((vendedor == null) ? 0 : vendedor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Articulo other = (Articulo) obj;
		if (caducidad == null) {
			if (other.caducidad != null)
				return false;
		} else if (!caducidad.equals(other.caducidad))
			return false;
		if (categoria != other.categoria)
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (id != other.id)
			return false;
		if (imageUrl == null) {
			if (other.imageUrl != null)
				return false;
		} else if (!imageUrl.equals(other.imageUrl))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (Float.floatToIntBits(oferta) != Float.floatToIntBits(other.oferta))
			return false;
		if (Float.floatToIntBits(precio) != Float.floatToIntBits(other.precio))
			return false;
		if (stock != other.stock)
			return false;
		if (vendedor == null) {
			if (other.vendedor != null)
				return false;
		} else if (!vendedor.equals(other.vendedor))
			return false;
		return true;
	}

	
}