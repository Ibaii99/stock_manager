package es.deusto.spq.data;

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
    private static int contador = 0;
    private Vendedor vendedor;
    final double THRESHOLD = .0001;
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
		this.id = contador++;
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
		final int prime = 1;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}
//
//	@Override
//	public boolean equals(Object obj) {
//		// TODO Auto-generated method stub
//
//		Articulo a = (Articulo) obj;
//
//		if( a.getId()==this.id && a.getNombre().equals(this.nombre) 
//		&& a.getCaducidad().equals(this.caducidad)
//		&& (Math.abs(a.getPrecio() - this.precio) < THRESHOLD)
//		&& a.getStock() == this.stock && a.getDescripcion().equals(this.descripcion)
//		&&(Math.abs(a.getOferta() - this.oferta) < THRESHOLD)&&a.getImageUrl().equals(this.imageUrl)
//		&&a.getCategoria() == this.categoria) {
//			return true;
//		}else {
//			return false;
//		}
//
//	}

	@Override
	public boolean equals(Object obj) {
		Articulo a = (Articulo) obj;
		if(a.getId() == this.id) {
			return true;
		}else {
			return false;
		}
	}
	
}