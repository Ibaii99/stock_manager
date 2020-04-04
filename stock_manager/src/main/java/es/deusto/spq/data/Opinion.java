package es.deusto.spq.data;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(detachable = "true")
public class Opinion implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT, primaryKey="true")
    private long id;
	private String texto;
	private int valoracion;
	private Cliente cliente;

	public Opinion(){

	}

	public Opinion(String texto, int valoracion, Cliente cliente) {
		this.texto = texto;
		this.valoracion = valoracion;
		this.cliente = cliente;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public int getValoracion() {
		return valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	
	
}
