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
    

	/**Constructor vacio de un articulo
	 * 
	 */
	public Articulo() {
	}
	/** Constructor de un articulo
	 * @param nombre Nombre del articulo
	 * @param caducidad Fecha de caducidad del articulo
	 * @param precio Precio original del articulo
	 * @param stock Cantidad de stock disponible
	 * @param descripcion Descripcion breve
	 * @param oferta Precio del articulo en promocion, si no esta en promocion poner el mismo
	 * @param categoria Categoria a la que pertenece el articulo(FRUTAS,FRUTOSSECOS,VERDURAS,ZUMOS)
	 * @param imageUrl Url de google de la imagen
	 */
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
	/**
	 * Devuelve la categoria introducida
	 * @return categoria
	 */
    
	public Categoria getCategoria() {
		return categoria;
	}
	/**
	 * Devuelve el id introducido
	 * @return id
	 */
	
    public long getId() {
		return id;
	}
	/**
	 * Permite modificar el Id
	 * @param id id a modificar
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * Devuelve el nombre introducido
	 * @return nombre
	 */

	public String getNombre() {
		return nombre;
	}
	/**
	 * Permite modificar el nombre
	 * @param nombre a modificar
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Devuelve la fecha introducida
	 * @return caducidad
	 */
	public Date getCaducidad() {
		return caducidad;
	}
	/**
	 * Permite modificar la fecha de caducidad
	 * @param caducidad a modificar
	 */
	public void setCaducidad(Date caducidad) {
		this.caducidad = caducidad;
	}
	/**
	 * Devuelve el precio introducido
	 * @return precio
	 */
	public float getPrecio() {
		return precio;
	}
	/**
	 * Permite modificar el precio
	 * @param precio a modificar
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	/**
	 * Devuelve el stock introducido
	 * @return stock
	 */
	public int getStock() {
		return stock;
	}
	/**
	 * Permite modificar el stock
	 * @param stock a modificar
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}
	/**
	 * Devuelve la descripcion introducida
	 * @return descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * Permite modificar la descripcion
	 * @param descripcion a modificar
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * Devuelve la oferta introducida
	 * @return oferta
	 */
	public float getOferta() {
		return oferta;
	}
	/**
	 * Permite modificar la oferta
	 * @param oferta a modificar
	 */
	public void setOferta(float oferta) {
		this.oferta = oferta;
	}
	/**
	 * Devuelve el vendedor introducido
	 * @return vendedor
	 */
	public Vendedor getVendedor() {
		return vendedor;
	}
	/**
	 * Permite modificar el vendedor
	 * @param vendedor a modificar
	 */
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	/**
	 * Permite modificar la categoria
	 * @param categoria a modificar
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	/**
	 * Devuelve la url introducida
	 * @return imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}
	/**
	 * Permite modificar la url
	 * @param imageUrl url a modificar
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
		
	}
	/**
	 * Metodo que convierte todos los atributos introducidos a un string.
	 * @return String 
	 */
	@Override
	public String toString() {
        return "Articulo:" + "[Id" + this.id + "Nombre: " + this.nombre + ", Caducidad: " + this.caducidad + ", Precio: " + this.precio +
        ", Stock: " + this.stock + ", Descripción: " + this.descripcion + ", Oferta: " + this.oferta + ", Categoria: " + this.categoria +     "]";
	}
	/**
	 * Metodo que compara si dos articulos son iguales. Para ello el equals debe ser el mismo.
	 * @return result
	 */
	@Override
	public int hashCode() {
		final int prime = 1;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}
	/**
	 * Metodo que compara articulos segun el id para saber si son iguales o distintos.
	 * @param obj el objeto referencia al que se compara.
	 * @return true 
	 * @return false 
	 */
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