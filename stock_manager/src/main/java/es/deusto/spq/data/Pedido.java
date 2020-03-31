package es.deusto.spq.data;

public class Pedido {

	private int codigo_pedido;
	private Vendedor proveedor_pedido;
	private Articulo articulo_pedido;
	
	public Pedido(){
		
	}

	public Pedido(int codigo_Pedido, Vendedor proveedor_Pedido, Articulo articulo_Pedido) {
		super();
		this.codigo_pedido = codigo_Pedido;
		this.proveedor_pedido = proveedor_Pedido;
		this.articulo_pedido = articulo_Pedido;
	}

	public int getCodigo_Pedido() {
		return codigo_pedido;
	}
	public void setCodigo_Pedido(int codigo_Pedido) {
		this.codigo_pedido = codigo_Pedido;
	}
	public Vendedor getProveedor_Pedido() {
		return proveedor_pedido;
	}
	public void setProveedor_Pedido(Vendedor proveedor_Pedido) {
		this.proveedor_pedido = proveedor_Pedido;
	}
	public Articulo getArticulo_Pedido() {
		return articulo_pedido;
	}
	public void setArticulo_Pedido(Articulo articulo_Pedido) {
		this.articulo_pedido = articulo_Pedido;
	}
	

	@Override
	public String toString() {
		return "Codigo del Pedido= " + codigo_pedido + ", se ha pedido al proveedor= " + proveedor_pedido
				+ ", se le ha pedido este articulo= " + articulo_pedido + "]";
	}
	
	

}
