package es.deusto.spq.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.data.Vendedor;
import es.deusto.spq.data_access.DAO;
import es.deusto.spq.data.Articulo.Categoria;
import es.deusto.spq.data.Articulo;
public class VendedorTest{
	private Vendedor v;
	private Vendedor v1;
	private Vendedor v2;
	private List<Articulo>listaArticulos = new ArrayList<Articulo>();
	private List<Articulo>listaArticulos1 = new ArrayList<Articulo>();
	private Date f1;
	private Articulo a1;
	private Articulo a2;
	private Articulo a3;
	private DAO dao;
	
	
	@Before
	public void insertarDatos() {
		f1 = new Date(120,04,12);
		a1 = new Articulo("manzana",f1, 1.20f, 400, "rica manzana", 1.05f, Categoria.FRUTAS, "");
		a2 = new Articulo("pan",f1, 1.20f, 400, "rica manzana", 1.05f, Categoria.FRUTAS, "");
		a3 = new Articulo();
		v = new Vendedor("Jokin", "Jokin@gmail.com", new ArrayList<Articulo>());
		v1 = new Vendedor();
		v2 = new Vendedor();
		listaArticulos.add(a1);
		listaArticulos.add(a2);
		listaArticulos1.add(a1);
		v.setArticulos(listaArticulos);
		v1.setNombreVendedor("jon");
		v1.setArticulos(listaArticulos1);
		v1.setEmailVendedor("jon@gmail.com");
		v1.setId(1);
		v2.addArticulo(a3);
		dao = new DAO();
	}
	
	 @Test
	 public void testGetNombreVendedor() {
	 	assertNotEquals(v1.getNombreVendedor(), v.getNombreVendedor());
	 }
	 @Test
	 public void testSetNombreVendedor() {
		 assertEquals(v1.getNombreVendedor(), "jon");
	 }
	 
	@Test
	public void testId() {
		assertNotEquals(v.getId(), v1.getId());
	}
	@Test
	public void testSetId() {
		assertEquals(v1.getId(), 1);
	}
	@Test
	public void testGetEmailVendedor() {
		assertNotEquals(v.getEmailVendedor(), v1.getEmailVendedor());
	}
	
	 @Test
	 public void testSetEmailVendedor() {
	 	assertEquals(v1.getEmailVendedor(), "jon@gmail.com");
	 }
	@Test
	public void testGetArticulos() {
		assertNotEquals(v.getArticulos(), v1.getArticulos());
	}
	@Test
	public void testSetArticulos() {
		assertEquals(v1.getArticulos(), listaArticulos1);
	}
	@Test
	public void testAddArticulos() {
		List<Articulo> prueba = new ArrayList<Articulo>();
		prueba.add(a3);
		assertEquals(prueba, v2.getArticulos());
	}
//	@Test
//	public void testRegistrar() {
//		v.registrar();
//	}
	
}
