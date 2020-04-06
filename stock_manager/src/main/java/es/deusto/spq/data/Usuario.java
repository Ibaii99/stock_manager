package es.deusto.spq.data;

import java.io.Serializable;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.Unique;


@PersistenceCapable(detachable = "true")
public class Usuario implements Serializable {
	//
	
	@Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT, primaryKey="true")
	private long id;
	@Unique
	private String nombre;
	private String contrasenya;
	private static final long serialVersionUID = 1L;
	
	public Usuario() {

	}
	
	public Usuario(String usuario, String contrasenya) {
		this.nombre = usuario;
		this.contrasenya = contrasenya;
	}
	
	
	public String getUser() {
		return nombre;
	}
	public void setUsuario(String usuario) {
		this.nombre = usuario;
	}
	public String getContrasenya() {
		return contrasenya;
	}
	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}

	public long getId() {
		return id;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	
}