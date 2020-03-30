package es.deusto.spq.clases;

public class Opinion {
	private String texto;
	private int valoracion;
	private Cliente id_cliente;
	private int codigo_opinion;
	//Comentario
	
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
	public Cliente getId_cliente() {
		return id_cliente;
	}
	public void setOpinionCliente(Cliente id_cliente) {
		this.id_cliente = id_cliente;
	}
	public int getID_Opinion() {
		return codigo_opinion;
	}
	public void setCodigo_Opinion(int codigo_opinion) {
		this.codigo_opinion = codigo_opinion;
	}
	public Opinion(String texto, int valoracion, Cliente id_cliente, int codigo_opinion) {
		super();
		this.texto = texto;
		this.valoracion = valoracion;
		this.id_cliente = id_cliente;
		this.codigo_opinion = codigo_opinion;
	}
	

}
