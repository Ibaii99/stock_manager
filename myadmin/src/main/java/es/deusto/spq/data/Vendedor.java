package es.deusto.spq.data;

import java.io.Serializable;


import java.util.List;


public class Vendedor {
	
    private long id;

	private String nombreVendedor;
	private String emailVendedor;

	private List<Articulo> articulos;
	
	/**Constructor de un vendedor vacio
	 * 
	 */
	public Vendedor(){
		
	}
	/** Constructor de un vendedor
	 * @param nombre Nombre del vendedor
	 * @param email Email del vendedor
	 * @param articulos Lista de articulos de un vendedor
	 */
	public Vendedor(String nombre, String email, List<Articulo> articulos) {
		this.nombreVendedor = nombre;
		this.emailVendedor = email;
		this.articulos = articulos;
	}
	/**
	 * Metodo que convierte todos los atributos introducidos a un string.
	 * @return String 
	 */
	@Override
	public String toString() {
		return "Nombre=" + nombreVendedor + ", email=" + emailVendedor + "]";
	}
	/**
	 * Devuelve el id introducido
	 * @return Id
	 */
	public long getId() {
		return id;
	}
	/**
	 * Permite modificar el id
	 * @param id a modificar
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * Devuelve el nombre introducido
	 * @return nombreVendedor
	 */
	public String getNombreVendedor() {
		return nombreVendedor;
	}
	/**
	 * Permite modificar el nombre del vendedor
	 * @param nombreVendedor a modificar
	 */
	public void setNombreVendedor(String nombreVendedor) {
		this.nombreVendedor = nombreVendedor;
	}
	/**
	 * Devuelve el email introducido
	 * @return emailVendedor
	 */
	public String getEmailVendedor() {
		return emailVendedor;
	}
	/**
	 * Permite modificar el email del vendedor
	 * @param emailVendedor a modificar
	 */
	public void setEmailVendedor(String emailVendedor) {
		this.emailVendedor = emailVendedor;
	}
	/**
	 * Devuelve la lista de articulos introducida
	 * @return articulos
	 */
	public List<Articulo> getArticulos() {
		return articulos;
	}
	/**
	 * Permite modificar la lista de articulos
	 * @param articulos a modificar
	 */
	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}

}
