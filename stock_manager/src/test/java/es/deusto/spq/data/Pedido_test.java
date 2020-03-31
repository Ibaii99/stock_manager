package es.deusto.spq.data;

import static org.junit.Assert.assertEquals;

import java.sql.Date;

import org.junit.Test;

public class Pedido_test {
	static Date fechaC = new Date(System.currentTimeMillis());
	private static Articulo articulo1= new Articulo("manzana", fechaC , 1.20f, 50, "verde", 0.85f, "fruta");
	private static Vendedor vendedor1 = new Vendedor("Jon", "jon@gmail.com");
	private static Pedido pedido1 = new Pedido(vendedor1, articulo1);
	
	@Test
	public void testgetIDPedido() {
		assertEquals(pedido1.getCodigo_Pedido(), 1);
	}
	@Test
	public void testgetProveedor() {
		assertEquals(pedido1.getProveedor_Pedido(), vendedor1);
	}
	@Test
	public void testgetArticulo() {
		assertEquals(pedido1.getArticulo_Pedido(), articulo1);
	}
	
	@Test
	public void testgetIDVendedor() {
		assertEquals(vendedor1.getID(), 1);
	}
	@Test
	public void testgetNombreVendedor() {
		assertEquals(vendedor1.getNombre(), "Jon");
	}
	@Test
	public void testgetEmailVendedor() {
		assertEquals(vendedor1.getEmail(), "jon@gmail.com");
	}
	
	
	
//	@Test
//	public void testgetIDArticulo() {
//		assertEquals(articulo1.getID(), 1);
//	}
	@Test
	public void testgetNombre() {
		assertEquals(articulo1.getNombre(), "manzana");
	}
	@Test
	public void testgetCaducidad() {
		long millis =  System.currentTimeMillis();
		assertEquals(articulo1.getCaducidad(), millis);
	}
	@Test
	public void testgetPrecio() {
		assertEquals(articulo1.getPrecio(), 1.20f,0);
	}
	@Test
	public void testgetStock() {
		assertEquals(articulo1.getStock(), 50);
	}
	@Test 
	public void testgetDescripcion() {
		assertEquals(articulo1.getDescripcion(), "verde");
	}
	@Test
	public void testgetOferta() {
		assertEquals(articulo1.getOferta(), 0.85f,0);
	}
	@Test
	public void testgetCategoria() {
		assertEquals(articulo1.getCategoria(), "fruta");
	}
}
