package es.deusto.spq;


public class Usuario {
    private String nombre;
    private String email;
    private String contrasenya;
    private String direccion;

    public Usuario(){

    }
    
    public Usuario(String _nombre, String _email, String _contrasenya, String _direccion){
        this.contrasenya = _contrasenya;
        this.email = _email;
        this.nombre = _nombre;
        this.direccion = _direccion;
    }


    /**
     * @param contrasenya the contrasenya to set
     */
    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }
    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * @return the contrasenya
     */
    public String getContrasenya() {
        return contrasenya;
    }
    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }
    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }
    

}
