package src.main.java.es.deusto.spq.data;

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
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String usuario) {
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

	@Override
	public String toString() {
	return ", nombre=" + nombre + ", contrasenya=" + contrasenya + "]";
	}
	
	
}
