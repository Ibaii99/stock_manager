package es.deusto.spq.clases;

public class Pedido {
	private int codigo_Pedido;
	private String proveedor_Pedido;
	private String articulo_Pedido;
	public int getCodigo_Pedido() {
		return codigo_Pedido;
	}
	public void setCodigo_Pedido(int codigo_Pedido) {
		this.codigo_Pedido = codigo_Pedido;
	}
	public String getProveedor_Pedido() {
		return proveedor_Pedido;
	}
	public void setProveedor_Pedido(String proveedor_Pedido) {
		this.proveedor_Pedido = proveedor_Pedido;
	}
	public String getArticulo_Pedido() {
		return articulo_Pedido;
	}
	public void setArticulo_Pedido(String articulo_Pedido) {
		this.articulo_Pedido = articulo_Pedido;
	}
	
	public Pedido(int codigo_Pedido, String proveedor_Pedido, String articulo_Pedido) {
		super();
		this.codigo_Pedido = codigo_Pedido;
		this.proveedor_Pedido = proveedor_Pedido;
		this.articulo_Pedido = articulo_Pedido;
	}
	@Override
	public String toString() {
		return "Codigo del Pedido= " + codigo_Pedido + ", se ha pedido al proveedor= " + proveedor_Pedido
				+ ", se le ha pedido este articulo= " + articulo_Pedido + "]";
	}
	
	

}