package src.test.java.es.deusto.spq.data;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import src.main.java.es.deusto.spq.data.*;
import src.main.java.es.deusto.spq.data.Articulo.Categoria;

public class ArticuloTest {

	private Articulo articulo = new Articulo("almendras", new Date("18/05/2020"), 1.20f, 100, "ricas almendra", 
			1.05f, Categoria.FRUTOSSECOS, "almendras.com");
	
	@Test
	public void testNombre() {
		assertEquals(articulo.getNombre(), "almendras");
	}
	@Test
	public void testCaducidad() {
		assertEquals(articulo.getCaducidad(), new Date(18/05/2020));
	}
	@Test
	public void testPrecio() {
		assertEquals(articulo.getPrecio(), 1.20f,0);
	}
	@Test
	public void testStock() {
		assertEquals(articulo.getStock(), 100);
	}
	@Test
	public void testDescripcion() {
		assertEquals(articulo.getDescripcion(), "ricas almendras");
	}
	@Test
	public void testOferta() {
		assertEquals(articulo.getOferta(), 1.05f,0);
	}
	@Test
	public void testCategoria() {
		assertEquals(articulo.getCategoria(), Categoria.FRUTOSSECOS);
	}
	@Test
	public void testImagen() {
		assertEquals(articulo.getImageUrl(), "almendras.com");
	}
	@Test
	public void testId() {
		assertEquals(articulo.getId(), 0);
	}
}
