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

    /**
     * @param ID the contrasenya to set
     */
    public void setID(int ID) {
        this.ID_cliente = ID;
    }

    /**
     * @param contrasenya the contrasenya to set
     */
    public void setContrasenya(String contrasenya) {
        this.contrasenya_cliente = contrasenya;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion_cliente = direccion;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.contrasenya_cliente = email;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.contrasenya_cliente = nombre;
    }

    /**
     * @return the ID
     */
    public int getID() {
        return ID_cliente;
    }

    /**
     * @return the contrasenya
     */
    public String getContrasenya() {
        return contrasenya_cliente;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion_cliente;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return contrasenya_cliente;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return contrasenya_cliente;
    }
    
    public void enviarMensajeServicioTecnico(int ID, Vendedor vendedor, String mensaje) {
    	
	}

}
