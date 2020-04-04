package es.deusto.spq.data;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.data.Vendedor;
import es.deusto.spq.data.Articulo.Categoria;
import es.deusto.spq.data.Articulo;
public class Vendedor_test{
	private Vendedor v = new Vendedor("Jokin", "Jokin@gmail.com");
	private List<Articulo>listaArticulos = new ArrayList<Articulo>();
	private Date f1 = new Date(120,04,12);
	private Articulo a1 = new Articulo("manzana",f1, 1.20f, 400, "rica manzana", 1.05f, Categoria.FRUTAS);
	private Articulo a2 = new Articulo("pan",f1, 1.20f, 400, "rica manzana", 1.05f, Categoria.FRUTAS);
	
	
	
	@Before
	public void insertarDatos() {
		listaArticulos.add(a1);
		listaArticulos.add(a2);
		v.setArticulos(listaArticulos);
	}
	
	@Test
	public void testNombre() {
		assertEquals(v.getNombre_vendedor(), "Jokin");
	}
	@Test
	public void testId() {
		assertEquals(v.getId(), 0);
	}
	@Test
	public void testEmail() {
		assertEquals(v.getEmail_vendedor(), "Jokin@gmail.com");
	}
	@Test
	public void testArticulos() {
		assertEquals(v.getArticulos(), listaArticulos);
	}
}
