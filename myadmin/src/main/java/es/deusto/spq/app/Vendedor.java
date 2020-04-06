package src.main.java.es.deusto.spq.app;

import java.io.Serializable;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Unique;



@PersistenceCapable(detachable = "true")
public class Vendedor implements Serializable {
	//
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT, primaryKey="true")
    private long id;
	private String nombreVendedor;
	@Unique
	private String emailVendedor;
	
	@Persistent(mappedBy = "vendedor")
	@Join
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
