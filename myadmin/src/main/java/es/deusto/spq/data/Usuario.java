package es.deusto.spq.data;

import java.io.IOException;
import java.io.Serializable;

public class Usuario implements Serializable {
	//
	private static final long serialVersionUID = 1L;
	private long id;
	private static int contador=0;
	

	private String nombre;
	private String contrasenya;
	
	public Usuario() {

	}
	
	public Usuario(String usuario, String contrasenya) {
		this.id=contador++;
		this.nombre = usuario;
		this.contrasenya = contrasenya;
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
//	 * @return nombre modificado
//	 */
	public void setNombre(String usuario) {
		this.nombre = usuario;
	}
//	/**
//	 * Devuelve la contrasenya introducida
//	 * @return Contrasenya
//	 */
	public String getContrasenya() {
		return contrasenya;
	}
//	/**
//	 * Permite modificar la contrasenya
//	 * @param contrasenya
//	 * @return contrasenya modificada
//	 */
	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}
//	/**
//	 * Devuelve el id introducido
//	 * @return Id
//	 */
	public long getId() {
		return id;
	}
//	/**
//	 * Metodo que convierte todos los atributos introducidos a un string.
//	 * @return String de los atributos de un usuario
//	 */
	@Override
	public String toString() {
	return ", nombre=" + nombre + ", contrasenya=" + contrasenya + "]";
	
	}
	
	
}
