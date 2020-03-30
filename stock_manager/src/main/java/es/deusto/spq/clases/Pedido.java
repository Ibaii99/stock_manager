package es.deusto.spq.clases;

public class Pedido {
<<<<<<< HEAD
	private int codigo_pedido;
	private Vendedor proveedor_pedido;
	private Articulo articulo_pedido;
=======
	private int codigo_Pedido;
	private String proveedor_Pedido;
	private Articulo articulo_Pedido;
>>>>>>> branch 'master' of https://github.com/Ibaii99/stock_manager.git
	
	public int getCodigo_Pedido() {
		return codigo_Pedido;
	}
	public void setCodigo_Pedido(int codigo_Pedido) {
		this.codigo_Pedido = codigo_Pedido;
	}
<<<<<<< HEAD
	public Vendedor getProveedor_Pedido() {
		return proveedor_pedido;
=======
	public String getProveedor_Pedido() {
		return proveedor_Pedido;
>>>>>>> branch 'master' of https://github.com/Ibaii99/stock_manager.git
	}
<<<<<<< HEAD
	public void setProveedor_Pedido(Vendedor proveedor_Pedido) {
		this.proveedor_pedido = proveedor_Pedido;
=======
	public void setProveedor_Pedido(String proveedor_Pedido) {
		this.proveedor_Pedido = proveedor_Pedido;
>>>>>>> branch 'master' of https://github.com/Ibaii99/stock_manager.git
	}
	public Articulo getArticulo_Pedido() {
		return articulo_Pedido;
	}
	public void setArticulo_Pedido(Articulo articulo_Pedido) {
		this.articulo_Pedido = articulo_Pedido;
	}
	
	public Pedido(int codigo_Pedido, Vendedor proveedor_Pedido, Articulo articulo_Pedido) {
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
