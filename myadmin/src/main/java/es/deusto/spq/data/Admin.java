package es.deusto.spq.data;

import java.util.List;

import es.deusto.spq.data.Articulo;//Para eliminar/anyadir articulos
import es.deusto.spq.data.Cliente;//Para eliminar usuarios
import es.deusto.spq.data_access.DAO;

public class Admin {
	private String nombre_admin;
	private String email_admin;
	private String contrasenya_admin;
	
	public Admin(String nombre_admin, String email_admin, String contrasenya_admin) {
		super();
		this.nombre_admin = nombre_admin;
		this.email_admin = email_admin;
		this.contrasenya_admin = contrasenya_admin;
	}

	public Admin() {
		super();
		this.nombre_admin = "";
		this.email_admin = "";
		this.contrasenya_admin = "";
	}

	public String getNombre_admin() {
		return nombre_admin;
	}

	public void setNombre_admin(String nombre_admin) {
		this.nombre_admin = nombre_admin;
	}

	public String getEmail_admin() {
		return email_admin;
	}

	public void setEmail_admin(String email_admin) {
		this.email_admin = email_admin;
	}

	public String getContrasenya_admin() {
		return contrasenya_admin;
	}

	public void setContrasenya_admin(String contrasenya_admin) {
		this.contrasenya_admin = contrasenya_admin;
	}
	
	//Eliminar artículo
	public void eliminarArticulo(Articulo articulo) {
		DAO dao = new DAO();
		List<Articulo> articulos = dao.getArticulos();
		if(articulos.contains(articulo)) {
			articulos.remove(articulo);
		}else {
			dao.noExiste();//Devuelve un String diciendo que no existe
		}
	}
	//Anyadir artículo
	public void anyadirArticulo(Articulo articulo) {
		DAO dao = new DAO();
		List<Articulo> articulos = dao.getArticulos();
		if(articulos.contains(articulo)) {
			dao.existe();//Devuelve un String diciendo que ya existe
		}else {
			articulos.add(articulo);
		}
	}
	//Eliminar usuario
	public void eliminarUsuario(Cliente usuario) {
		DAO dao = new DAO();
		List<Cliente> usuarios = dao.getClientes();
		if(usuarios.contains(usuario)) {
			usuarios.remove(usuario);
		}else {
			dao.noExiste();//Devuelve un String diciendo que no existe
		}
	}
	
	
	
	
	
}
