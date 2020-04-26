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
	
	 @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contrasenya == null) ? 0 : contrasenya.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (contrasenya == null) {
			if (other.contrasenya != null)
				return false;
		} else if (!contrasenya.equals(other.contrasenya))
			return false;
		if (id != other.id)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	
}
