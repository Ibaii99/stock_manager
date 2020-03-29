package es.deusto.spq.clases;

public class Opinion {
	private String texto;
	private int valoracion;
	private int ID_Cliente;
	private int ID_Opinion;
	
	
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
	public int getID_Cliente() {
		return ID_Cliente;
	}
	public void setID_Cliente(int iD_Cliente) {
		ID_Cliente = iD_Cliente;
	}
	public int getID_Opinion() {
		return ID_Opinion;
	}
	public void setID_Opinion(int iD_Opinion) {
		ID_Opinion = iD_Opinion;
	}
	public Opinion(String texto, int valoracion, int iD_Cliente, int iD_Opinion) {
		super();
		this.texto = texto;
		this.valoracion = valoracion;
		ID_Cliente = iD_Cliente;
		ID_Opinion = iD_Opinion;
	}
	

}
