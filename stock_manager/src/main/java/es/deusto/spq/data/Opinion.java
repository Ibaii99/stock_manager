package es.deusto.spq.data;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import es.deusto.spq.data_access.DAO;

@PersistenceCapable(detachable = "true")
public class Opinion implements Serializable {

	//
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT, primaryKey="true")
    private long id;
	private String texto;
	private int valoracion;
	private Cliente cliente;

	/**Metodo para crear un objeto Opinion vacio
	 * 
	 */
	public Opinion(){

	}

	/**Constructor de un objeto Opinion
	 * @param texto	texto asociado a la Opinion escrito por el Cliente
	 * @param valoracion	valoracion asociada a la Opinion valorada por el Cliente
	 * @param cliente	Cliente que desea opinar
	 */
	public Opinion(String texto, int valoracion, Cliente cliente) {
		this.texto = texto;
		this.valoracion = valoracion;
		this.cliente = cliente;
	}

	/**Metodo para obtener la id de una Opinion
	 * @return	deuelve un objeto long con el id de la Opinion
	 */
	public long getId() {
		return id;
	}

	/**Metodo para cmabiar la id de un Opinion
	 * @param id	id a cambiar en la Opinion
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**Metodo para obtener el texto de una Opinion
	 * @return	deuelve un objeto String con eltexto asociado a la Opinion
	 */
	public String getTexto() {
		return texto;
	}

	/**Metodo para camiar el texto asociado a una Opinion
	 * @param texto	texto a cambiar de la Opinion
	 */
	public void setTexto(String texto) {
		this.texto = texto;
	}

	/**Metodo para optener la valoracin de una Opinion
	 * @return deuelve un objeto int con el valor de la caloracion
	 */
	public int getValoracion() {
		return valoracion;
	}

	/**Metodo para cambiar la valoracion de una Opinion
	 * @param valoracion	valoracion a cambiar de la Opinion
	 */
	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}

	/**Metodo para obtener el cliente que ha realizado la Opinion
	 * @return	devuelve un objeto Cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**Metodo para cambair el Cliente que ha realizado la Opinion
	 * @param cliente	cliente a cambiar de la Opinion
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**Metodo para almacenar la Opinion en la BBDD
	 * 
	 */
	public void publicar() {
		DAO dao = new DAO();
		dao.store(this);
	}
	
}
