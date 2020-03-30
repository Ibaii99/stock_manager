package es.deusto.spq.clases;

public class Opinion {
	private String texto;
	private int valoracion;
	private int opinion_cliente;
	private int codigo_opinion;
	
	
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
	public int getOpinion_Cliente() {
		return opinion_cliente;
	}
	public void setOpinionCliente(int opinion_cliente) {
		this.opinion_cliente = opinion_cliente;
	}
	public int getID_Opinion() {
		return codigo_opinion;
	}
	public void setCodigo_Opinion(int codigo_opinion) {
		this.codigo_opinion = codigo_opinion;
	}
	public Opinion(String texto, int valoracion, int opinion_cliente, int codigo_opinion) {
		super();
		this.texto = texto;
		this.valoracion = valoracion;
		this.opinion_cliente = opinion_cliente;
		this.codigo_opinion = codigo_opinion;
	}
	

}
