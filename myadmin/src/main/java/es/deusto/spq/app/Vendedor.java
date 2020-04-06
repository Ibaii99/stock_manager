package src.main.java.es.deusto.spq.app;

import java.io.Serializable;

import java.util.List;


<<<<<<< HEAD
=======


>>>>>>> branch 'master' of https://github.com/Ibaii99/stock_manager.git
public class Vendedor implements Serializable {
	//
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private long id;

	private String nombreVendedor;
	private String emailVendedor;
<<<<<<< HEAD
=======

	
>>>>>>> branch 'master' of https://github.com/Ibaii99/stock_manager.git
	private List<Articulo> articulos;
	
	public Vendedor(){
		
	}
	
	public Vendedor(String nombre, String email, List<Articulo> articulos) {
		this.nombreVendedor = nombre;
		this.emailVendedor = email;
		this.articulos = articulos;
	}

	@Override
	public String toString() {
		return "Nombre=" + nombreVendedor + ", email=" + emailVendedor + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombreVendedor() {
		return nombreVendedor;
	}

	public void setNombreVendedor(String nombreVendedor) {
		this.nombreVendedor = nombreVendedor;
	}

	public String getEmailVendedor() {
		return emailVendedor;
	}

	public void setEmailVendedor(String emailVendedor) {
		this.emailVendedor = emailVendedor;
	}

	public List<Articulo> getArticulos() {
		return articulos;
	}

	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}
//	
//	public void addArticulo(Articulo articulo) {
//		this.articulos.add(articulo);
//		DAO dao = new DAO();
//		dao.store(this);
//	}
//
//	public void registrar() {
//		DAO dao = new DAO();
//		dao.store(this);
//	}

}
