package es.deusto.spq.data;

import static org.junit.Assert.assertEquals;

import java.sql.Date;

import org.junit.Test;

public class Oferta_test {
	static Date fechaC = new Date(System.currentTimeMillis());
	private static Articulo articulo1= new Articulo("manzana", fechaC , 1.20f, 50, "verde", 0.85f, "fruta");
	private static Oferta oferta = new Oferta("3x2",articulo1);
	
	@Test
	public void testgetIDOferta() {
		assertEquals(oferta.getCodigo_oferta(), 1);
	}
	@Test
	public void testgetNombreOferta() {
		assertEquals(oferta.getNombre_Oferta(), "3x2");
	}
	@Test
	public void testgetArticulo() {
		assertEquals(oferta.getArticulo_oferta(), articulo1);
	}
	// @Test
	// public void testgetIDArticulo() {
	// 	assertEquals(articulo1.getID(), 1);
	// }
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
