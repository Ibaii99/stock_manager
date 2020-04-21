package es.deusto.spq.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.data.Articulo.Categoria;
import es.deusto.spq.data.Articulo;
public class ArticuloTest{
	private Articulo a1;
	
	@Before 
	public void setUp() {
		a1 = new Articulo("manzana",new Date(18/05/2020), 1.20f, 400, "rica manzana", 1.05f, Categoria.FRUTAS, "");
		
	}
	
	@Test
	public void testNombre() {
		Articulo actual = new Articulo("manzana",new Date(18/05/2020), 1.20f, 400, "rica manzana", 1.05f, Categoria.FRUTAS, "");
		assertEquals(a1.getNombre(), actual.getNombre());
	}
	@Test
	public void testFecha() {
		Articulo actual = new Articulo("manzana",new Date(18/05/2020), 1.20f, 400, "rica manzana", 1.05f, Categoria.FRUTAS, "");
		assertEquals(a1.getCaducidad(), actual.getCaducidad());
	}
	@Test
	public void testPrecio() {
		Articulo actual = new Articulo("manzana",new Date(18/05/2020), 1.20f, 400, "rica manzana", 1.05f, Categoria.FRUTAS, "");
		assertEquals(a1.getPrecio(), actual.getPrecio(),0);
	}
	@Test
	public void testStock() {
		Articulo actual = new Articulo("manzana",new Date(18/05/2020), 1.20f, 400, "rica manzana", 1.05f, Categoria.FRUTAS, "");
		assertEquals(a1.getStock(), actual.getStock());
	}
	@Test
	public void testDescripcion() {
		Articulo actual = new Articulo("manzana",new Date(18/05/2020), 1.20f, 400, "rica manzana", 1.05f, Categoria.FRUTAS, "");
		assertEquals(a1.getDescripcion(), actual.getDescripcion());
	}
	@Test
	public void testOferta() {
		Articulo actual = new Articulo("manzana",new Date(18/05/2020), 1.20f, 400, "rica manzana", 1.05f, Categoria.FRUTAS, "");
		assertEquals(a1.getOferta(), actual.getOferta(),0);
	}
	@Test
	public void testCategoria() {
		Articulo actual = new Articulo("manzana",new Date(18/05/2020), 1.20f, 400, "rica manzana", 1.05f, Categoria.FRUTAS, "");
		assertEquals(a1.getCategoria(), actual.getCategoria());
	}
	@Test
	public void testImage() {
		Articulo actual = new Articulo("manzana",new Date(18/05/2020), 1.20f, 400, "rica manzana", 1.05f, Categoria.FRUTAS, "");
		assertEquals(a1.getImageUrl(), actual.getImageUrl());
	}
	@Test 
	public void testEquals() {
		Articulo actual = new Articulo("manzana",new Date(18/05/2020), 1.20f, 400, "rica manzana", 1.05f, Categoria.FRUTAS, "");
		assertFalse(a1.equals(actual));	
	}
	
}
