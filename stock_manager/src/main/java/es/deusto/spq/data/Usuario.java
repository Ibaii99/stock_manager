package es.deusto.spq.data;

import java.io.Serializable;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Unique;

@PersistenceCapable(detachable = "true")
public class Usuario implements Serializable {
	@Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT, primaryKey="true")
	private long id;
	private String usuario;
	private String contrasenya;
	
	public String getUser() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasenya() {
		return contrasenya;
	}
	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}
	public Usuario(String usuario, String contrasenya) {
		super();
		this.usuario = usuario;
		this.contrasenya = contrasenya;
	}
	
	
}
