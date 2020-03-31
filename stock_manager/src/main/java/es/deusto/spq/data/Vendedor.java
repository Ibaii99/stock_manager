package es.deusto.spq.data;

import java.io.Serializable;
import java.util.List;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(detachable = "true")
public class Vendedor implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PrimaryKey
    private long id;
	private String nombre_vendedor;
	private String email_vendedor;
	
	@Persistent(mappedBy = "vendedor")
	@Join
	private List<Articulo> articulos;
	
	public Vendedor(){
		
	}
	
	public Vendedor(String nombre, String email) {
		this.nombre_vendedor = nombre;
		this.email_vendedor = email;
	}

	public String getNombre() {
		return nombre_vendedor;
	}

	public void setNombre(String nombre) {
		this.nombre_vendedor = nombre;
	}

	public String getEmail() {
		return email_vendedor;
	}

	public void setEmail(String email) {
		this.email_vendedor = email;
	}

	@Override
	public String toString() {
		return "Nombre=" + nombre_vendedor + ", email=" + email_vendedor + "]";
	}
	

}
