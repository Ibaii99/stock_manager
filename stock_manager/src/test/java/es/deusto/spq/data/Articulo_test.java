package es.deusto.spq.data;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import es.deusto.spq.data.Articulo.Categoria;
import es.deusto.spq.data.Articulo;
public class Articulo_test{
	private Date f1 = new Date(120, 04, 12);
	private Articulo a1 = new Articulo("manzana",f1, 1.20f, 400, "rica manzana", 1.05f, Categoria.FRUTAS);
	
	
	@Test
	public void testNombre() {
		assertEquals(a1.getNombre(), "manzana");
	}
	@Test
	public void testFecha() {
		assertEquals(a1.getCaducidad(), new Date(120,04,12));
	}
	@Test
	public void testPrecio() {
		assertEquals(a1.getPrecio(), 1.20f,0);
	}
	@Test
	public void testStock() {
		assertEquals(a1.getStock(), 400);
	}
	@Test
	public void testDescripcion() {
		assertEquals(a1.getDescripcion(), "rica manzana");
	}
	@Test
	public void testOferta() {
		assertEquals(a1.getOferta(), 1.05f,0);
	}
	@Test
	public void testCategoria() {
		assertEquals(a1.getCategoria(), Categoria.FRUTAS);
	}
}
