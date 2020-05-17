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





public class Articulo implements Serializable{

	
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
//	/**
//	 * Devuelve la categoria introducida
//	 * @return Un tipo de categoria
//	 */
    
	public Categoria getCategoria() {
		return categoria;
	}
//	/**
//	 * Devuelve el id introducido
//	 * @return Id
//	 */
//	
    public long getId() {
		return id;
	}
//	/**
//	 * Permite modificar el Id
//	 * @param id
//	 * @return Id modificado
//	 */
	public void setId(long id) {
		this.id = id;
	}
//	/**
//	 * Devuelve el nombre introducido
//	 * @return Nombre
//	 */

	public String getNombre() {
		return nombre;
	}
//	/**
//	 * Permite modificar el nombre
//	 * @param nombre
//	 * @return Nombre modificado
//	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
//	/**
//	 * Devuelve la fecha introducida
//	 * @return Fecha
//	 */
	public Date getCaducidad() {
		return caducidad;
	}
//	/**
//	 * Permite modificar la fecha de caducidad
//	 * @param fecha
//	 * @return Fecha modificada
//	 */
	public void setCaducidad(Date caducidad) {
		this.caducidad = caducidad;
	}
//	/**
//	 * Devuelve el precio introducido
//	 * @return precio
//	 */
	public float getPrecio() {
		return precio;
	}
//	/**
//	 * Permite modificar el precio
//	 * @param precio
//	 * @return Precio modificado
//	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}
//	/**
//	 * Devuelve el stock introducido
//	 * @return Stock
//	 */
	public int getStock() {
		return stock;
	}
//	/**
//	 * Permite modificar el stock
//	 * @param stock
//	 * @return Stock modificado
//	 */
	public void setStock(int stock) {
		this.stock = stock;
	}
//	/**
//	 * Devuelve la descripcion introducida
//	 * @return Descripcion
//	 */
	public String getDescripcion() {
		return descripcion;
	}
//	/**
//	 * Permite modificar la descripcion
//	 * @param descripcion
//	 * @return Descripcion modificada
//	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
//	/**
//	 * Devuelve la oferta introducida
//	 * @return Oferta
//	 */
	public float getOferta() {
		return oferta;
	}
//	/**
//	 * Permite modificar la oferta
//	 * @param oferta
//	 * @return Oferta modificada
//	 */
	public void setOferta(float oferta) {
		this.oferta = oferta;
	}
//	/**
//	 * Devuelve el vendedor introducido
//	 * @return Vendedor
//	 */
	public Vendedor getVendedor() {
		return vendedor;
	}
//	/**
//	 * Permite modificar el vendedor
//	 * @param vendedor
//	 * @return Vendedor modificado
//	 */
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
//	/**
//	 * Permite modificar la categoria
//	 * @param categoria
//	 * @return Categoria modificada
//	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
//	/**
//	 * Devuelve la url introducida
//	 * @return Url
//	 */
	public String getImageUrl() {
		return imageUrl;
	}
//	/**
//	 * Permite modificar la url
//	 * @param url
//	 * @return Url modificada
//	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
		
	}
//	/**
//	 * Metodo que convierte todos los atributos introducidos a un string.
//	 * @return String de los atributos de un articulo
//	 */
	@Override
	public String toString() {
        return "Articulo:" + "[Id" + this.id + "Nombre: " + this.nombre + ", Caducidad: " + this.caducidad + ", Precio: " + this.precio +
        ", Stock: " + this.stock + ", Descripción: " + this.descripcion + ", Oferta: " + this.oferta + ", Categoria: " + this.categoria +     "]";
	}
//	/**
//	 * Metodo que compara si dos articulos son iguales. Para ello el equals debe ser el mismo.
//	 * @return Resultado de la comparacion
//	 */
	@Override
	public int hashCode() {
		final int prime = 1;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}
//	/**
//	 * Metodo que compara articulos segun el id para saber si son iguales o distintos.
//	 * @param obj el objeto referencia al que se compara.
//	 * @return False(diferentes) o True(iguales)
//	 */
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