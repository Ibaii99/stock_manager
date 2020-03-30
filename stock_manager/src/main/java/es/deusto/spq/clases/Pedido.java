package es.deusto.spq.clases;

public class Pedido {
	private int codigo_pedido;
	private String proveedor_pedido;
	private Articulo articulo_pedido;
	
	public int getCodigo_Pedido() {
		return codigo_pedido;
	}
	public void setCodigo_Pedido(int codigo_Pedido) {
		this.codigo_pedido = codigo_Pedido;
	}
	public String getProveedor_Pedido() {
		return proveedor_pedido;
	}
	public void setProveedor_Pedido(String proveedor_Pedido) {
		this.proveedor_pedido = proveedor_Pedido;
	}
	public Articulo getArticulo_Pedido() {
		return articulo_pedido;
	}
	public void setArticulo_Pedido(Articulo articulo_Pedido) {
		this.articulo_pedido = articulo_Pedido;
	}
	
	public Pedido(int codigo_Pedido, String proveedor_Pedido, Articulo articulo_Pedido) {
		super();
		this.codigo_pedido = codigo_Pedido;
		this.proveedor_pedido = proveedor_Pedido;
		this.articulo_pedido = articulo_Pedido;
	}
	@Override
	public String toString() {
		return "Codigo del Pedido= " + codigo_pedido + ", se ha pedido al proveedor= " + proveedor_pedido
				+ ", se le ha pedido este articulo= " + articulo_pedido + "]";
	}
	
	

}
