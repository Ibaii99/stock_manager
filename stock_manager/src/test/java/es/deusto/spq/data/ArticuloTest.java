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
	public void testGetNombre() {
		Articulo actual = new Articulo("manzana",new Date(18/05/2020), 1.20f, 400, "rica manzana", 1.05f, Categoria.FRUTAS, "");
		assertEquals(a1.getNombre(), actual.getNombre());
	}
	@Test
	public void testGetFecha() {
		Articulo actual = new Articulo("manzana",new Date(18/05/2020), 1.20f, 400, "rica manzana", 1.05f, Categoria.FRUTAS, "");
		assertEquals(a1.getCaducidad(), actual.getCaducidad());
	}
	@Test
	public void testGetPrecio() {
		Articulo actual = new Articulo("manzana",new Date(18/05/2020), 1.20f, 400, "rica manzana", 1.05f, Categoria.FRUTAS, "");
		assertEquals(a1.getPrecio(), actual.getPrecio(),0);
	}
	@Test
	public void testGetStock() {
		Articulo actual = new Articulo("manzana",new Date(18/05/2020), 1.20f, 400, "rica manzana", 1.05f, Categoria.FRUTAS, "");
		assertEquals(a1.getStock(), actual.getStock());
	}
	@Test
	public void testGetDescripcion() {
		Articulo actual = new Articulo("manzana",new Date(18/05/2020), 1.20f, 400, "rica manzana", 1.05f, Categoria.FRUTAS, "");
		assertEquals(a1.getDescripcion(), actual.getDescripcion());
	}
	@Test
	public void testGetOferta() {
		Articulo actual = new Articulo("manzana",new Date(18/05/2020), 1.20f, 400, "rica manzana", 1.05f, Categoria.FRUTAS, "");
		assertEquals(a1.getOferta(), actual.getOferta(),0);
	}
	@Test
	public void testGetCategoria() {
		Articulo actual = new Articulo("manzana",new Date(18/05/2020), 1.20f, 400, "rica manzana", 1.05f, Categoria.FRUTAS, "");
		assertEquals(a1.getCategoria(), actual.getCategoria());
	}
	@Test
	public void testGetImageUrl() {
		Articulo actual = new Articulo("manzana",new Date(18/05/2020), 1.20f, 400, "rica manzana", 1.05f, Categoria.FRUTAS, "");
		assertEquals(a1.getImageUrl(), actual.getImageUrl());
	}
	@Test 
	public void testEquals() {
		Articulo actual = new Articulo("Platano",new Date(18/05/2020), 1.20f, 400, "rica manzana", 1.05f, Categoria.FRUTAS, "");
		Articulo actual2 = new Articulo("manzana",new Date(18/05/2020), 1.20f, 400, "rica manzana", 1.05f, Categoria.FRUTAS, "");
		assertFalse(a1.equals(actual));	
		assertTrue(a1.equals(actual2));	
	}
	
	@Test
	public void testtoString() {
		Articulo actual = new Articulo("manzana",new Date(18/05/2020), 1.20f, 400, "rica manzana", 1.05f, Categoria.FRUTAS, "");
		assertEquals(a1.toString(), actual.toString());
	}

}
