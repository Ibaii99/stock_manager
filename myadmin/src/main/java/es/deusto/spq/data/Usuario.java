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
	
	/**Constructor de un usuario vacio
	 * 
	 */
	public Usuario() {

	}
	
	/**Contructor de un Usuario
	 * @param usuario	nombre con el que vamos a crear el usuario
	 * @param contrasenya	contrasenya con la que se va a crear al usuario
	 */
	public Usuario(String usuario, String contrasenya) {
		this.id=contador++;
		this.nombre = usuario;
		this.contrasenya = contrasenya;
	}
	

	/**Metodo para obtener el nombre de un objeto Usuario
	 * @return	nombre 
	 */
	public String getNombre() {
		return nombre;
	}

	/**Metodo para cambiar el nombre de un Usuario
	 * @param usuario	nombre a cambiar del Usuario
	 */
	public void setNombre(String usuario) {
		this.nombre = usuario;
	}

	
	/**Metodo para obtener la contrasenya de un Usuario
	 * @return	contrasenya
	 */
	public String getContrasenya() {
		return contrasenya;
	}

	/**Metodo para cambiar la contrasenya de un Usuario
	 * @param contrasenya contrasenya a cambiar del Usuario
	 */
	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}

	/**Metodo para cambiar el id de un Usuario
	 * @return id	
	 */
	public long getId() {
		return id;
	}

	/**Metodo para convertir el objeto Usuario a un String
	 * @return	String
	 */
	@Override
	public String toString() {
	return ", nombre=" + nombre + ", contrasenya=" + contrasenya + "]";
	
	}
	
	
}
