package es.deusto.spq.data;

import java.io.Serializable;
import java.util.List;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(detachable = "true")
public class Cliente implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PrimaryKey
    private long id;
    private String email_cliente;
    private String nombre_cliente;
    private String contrasenya_cliente;
    private String direccion_cliente;

    @Persistent(mappedBy = "cliente")
	@Join
    private List<Cesta> cestas; 
    
    public Cliente(){
        
    }

    public Cliente(String _nombre, String _email, String _contrasenya, String _direccion) {
        this.contrasenya_cliente = _contrasenya;
        this.email_cliente = _email;
        this.nombre_cliente = _nombre;
        this.direccion_cliente = _direccion;
    }

   
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail_cliente() {
		return email_cliente;
	}

	public void setEmail_cliente(String email_cliente) {
		this.email_cliente = email_cliente;
	}

	public String getNombre_cliente() {
		return nombre_cliente;
	}

	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}

	public String getContrasenya_cliente() {
		return contrasenya_cliente;
	}

	public void setContrasenya_cliente(String contrasenya_cliente) {
		this.contrasenya_cliente = contrasenya_cliente;
	}

	public String getDireccion_cliente() {
		return direccion_cliente;
	}

	public void setDireccion_cliente(String direccion_cliente) {
		this.direccion_cliente = direccion_cliente;
	}

	public List<Cesta> getCestas() {
		return cestas;
	}

	public void setCestas(List<Cesta> cestas) {
		this.cestas = cestas;
	}

	public void enviarMensajeServicioTecnico(int ID, Vendedor vendedor, String mensaje) {
    	
	}

	

}
