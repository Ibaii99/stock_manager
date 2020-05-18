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
	
	/**Metodo para crear un objeto Usuario vacio
	 * 
	 */
	public Usuario() {

	}
	
	/**Contructor de un Usaurio
	 * @param usuario	nombre con el que vamos a crear el usuario
	 * @param contrasenya	contrasenya con la que se va a crear al usuario
	 */
	public Usuario(String usuario, String contrasenya) {
		this.id=contador++;
		this.nombre = usuario;
		this.contrasenya = contrasenya;
	}
	

	/**Metodo para obtener el nombre de un objeto Usuario
	 * @return	devuelve un objeto String con el nombre del Usuario
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
	 * @return	devuelve un objeto String con la contrasneya del Usuario
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
	 * @param id	id a cambiar del Usuario
	 */
	public long getId() {
		return id;
	}

	/**Metodo para convertir el objeto Usuario a un String
	 * @return	devuelve un objeto String con la informacion del Usuario que queremos convertir
	 */
	@Override
	public String toString() {
	return ", nombre=" + nombre + ", contrasenya=" + contrasenya + "]";
	
	}
	
	
}
