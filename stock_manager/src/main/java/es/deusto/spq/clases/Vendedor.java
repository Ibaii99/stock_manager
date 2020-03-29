package es.deusto.spq.clases;

public class Vendedor {
	private int ID;
	private String nombre;
	private String email;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Vendedor(int iD, String nombre, String email) {
		super();
		this.ID = iD;
		this.nombre = nombre;
		this.email = email;
	}
	public Vendedor(int iD) {
		super();
		this.ID = iD;
	}
	@Override
	public String toString() {
		return "ID del vendedor=" + ID + ", nombre=" + nombre + ", email=" + email + "]";
	}
	

}
