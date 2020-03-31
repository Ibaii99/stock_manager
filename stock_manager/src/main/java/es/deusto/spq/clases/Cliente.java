package es.deusto.spq.clases;

public class Cliente {
    private int ID_cliente;
    

	private String nombre_cliente;
    private String email_cliente;
    private String contrasenya_cliente;
    private String direccion_cliente;

    public Cliente(int ID, String _nombre, String _email, String _contrasenya, String _direccion) {
        this.ID_cliente = ID;
        this.contrasenya_cliente = _contrasenya;
        this.contrasenya_cliente = _email;
        this.contrasenya_cliente = _nombre;
        this.direccion_cliente = _direccion;
    }
	public int getID_cliente() {
		return ID_cliente;
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
 
	public void setID_cliente(int iD_cliente) {
		ID_cliente = iD_cliente;
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

	public void enviarMensajeServicioTecnico(int ID, Vendedor vendedor, String mensaje) {
    	
	}

}
