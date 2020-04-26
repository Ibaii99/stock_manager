package src.main.java.es.deusto.spq.data;

import java.io.Serializable;

import java.util.List;
public class Vendedor{
	
    private long id;

	private String nombreVendedor;
	private String emailVendedor;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((articulos == null) ? 0 : articulos.hashCode());
		result = prime * result + ((emailVendedor == null) ? 0 : emailVendedor.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nombreVendedor == null) ? 0 : nombreVendedor.hashCode());
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
		Vendedor other = (Vendedor) obj;
		if (articulos == null) {
			if (other.articulos != null)
				return false;
		} else if (!articulos.equals(other.articulos))
			return false;
		if (emailVendedor == null) {
			if (other.emailVendedor != null)
				return false;
		} else if (!emailVendedor.equals(other.emailVendedor))
			return false;
		if (id != other.id)
			return false;
		if (nombreVendedor == null) {
			if (other.nombreVendedor != null)
				return false;
		} else if (!nombreVendedor.equals(other.nombreVendedor))
			return false;
		return true;
	}




}
