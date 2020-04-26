package src.test.java.es.deusto.spq.data;

import src.main.java.es.deusto.spq.data.*;
import src.main.java.es.deusto.spq.data.Articulo.Categoria;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class VendedorTest {
	private Vendedor v1;
	private Vendedor v2;
	private Vendedor v3;
	private List<Articulo> listaArticulos1 = new ArrayList<Articulo>();
	private List<Articulo> listaArticulos2 = new ArrayList<Articulo>();
	private List<Articulo> listaArticulosTest = new ArrayList<Articulo>();
	private Articulo a1;
	private Articulo a2;
	private Articulo a3;
	private Date d1;
	private Date d2;
	
	
	@Before
	public void setUp() {
		d1 = new Date(2020, 04, 15);
		d2 = new Date(2020, 04, 16);
		a1 = new Articulo("coliflor", d1, 1.20f, 400, "rica coliflor", 1.05f,
				Categoria.VERDURAS,"coliflor.com");
		a2 = new Articulo("pan", d2, 1.10f, 200, "rica pan", 1.04f,
				Categoria.FRUTOSSECOS,
				"pan.com");
		a2 = new Articulo("berza", d2, 1.20f, 240, "rica berza", 1.01f,
				Categoria.FRUTOSSECOS,
				"berza.com");
		listaArticulos1.add(a1);
		listaArticulos2.add(a2);
		listaArticulosTest.add(a3);
		v1 = new Vendedor("jokin", "jokin@gmail.com", listaArticulos1);
		v2 = new Vendedor("ander", "ander@gmail.com", listaArticulos2);
		v3 = new Vendedor();
		v1.setId(15);
		v2.setId(1);
		v1.setNombreVendedor("aitor");
		v1.setEmailVendedor("aitor@gmail.com");
		v1.setArticulos(listaArticulosTest);
	}
	
	@Test
	public void testGetId() {
		assertNotEquals(v1.getId(),v2.getId(),v3.getId());
	}
	@Test
	public void testSetId() {
		assertEquals(15, v1.getId());
		assertEquals(1,v2.getId());
		assertEquals(0, v3.getId());
		assertNotEquals(v1.getId(),v2.getId(),v3.getId());
	}
	@Test
	public void testGetNombreVendedor() {
		assertNotEquals(v1.getNombreVendedor(), v2.getNombreVendedor(),v3.getNombreVendedor());
	}
	@Test
	public void testSetNombreVendedor() {
		assertEquals("aitor", v1.getNombreVendedor());
		assertEquals("ander", v2.getNombreVendedor());
		assertEquals(null, v3.getNombreVendedor());
		assertNotEquals(v1.getNombreVendedor(), v2.getNombreVendedor(),v3.getNombreVendedor());
	}
	@Test
	public void testGetEmailVendedor() {
		assertNotEquals(v1.getEmailVendedor(), v2.getEmailVendedor(),v3.getEmailVendedor());
	}
	@Test
	public void testSetEmailVendedor() {
		assertEquals("aitor@gmail.com", v1.getEmailVendedor());
		assertEquals("ander@gmail.com", v2.getEmailVendedor());
		assertEquals(null, v3.getEmailVendedor());
		assertNotEquals(v1.getEmailVendedor(), v2.getEmailVendedor(),v3.getEmailVendedor());
	}
	@Test
	public void testGetArticulos() {
		assertNotEquals(v1.getArticulos(), v2.getArticulos());
		assertNotEquals(v1.getArticulos(), v3.getArticulos());
		assertNotEquals(v2.getArticulos(), v3.getArticulos());
	}
	@Test
	public void testSetArticulos() {
		assertEquals(listaArticulosTest, v1.getArticulos());
		assertEquals(listaArticulos2, v2.getArticulos());
		assertEquals(null, v3.getArticulos());
		assertNotEquals(v1.getArticulos(), v2.getArticulos());
		assertNotEquals(v1.getArticulos(), v3.getArticulos());
		assertNotEquals(v2.getArticulos(), v3.getArticulos());
	}
	@Test
	public void testToString() {
		String prueba = v1.toString();
		assertEquals(prueba, "Nombre=" + v1.getNombreVendedor() + ", email=" + v1.getEmailVendedor() + "]");
		String prueba1 = v2.toString();
		assertEquals(prueba1, "Nombre=" + v2.getNombreVendedor() + ", email=" + v2.getEmailVendedor() + "]");
		String prueba2 = v3.toString();
		assertEquals(prueba2, "Nombre=" + v3.getNombreVendedor() + ", email=" + v3.getEmailVendedor() + "]");
		
	}
	@Test
	public void testHashCode() {
		assertNotEquals(v1.hashCode(), v2.hashCode());
		assertNotEquals(v1.hashCode(), v3.hashCode());
		assertNotEquals(v2.hashCode(),v3.hashCode());
	}
	@Test
	public void testEquals() {
		assertFalse(v1.equals(v2));
		assertFalse(v1.equals(v3));
		assertFalse(v2.equals(v3));
		assertFalse(v2.equals(v1));
		assertFalse(v3.equals(v1));
		assertFalse(v3.equals(v2));
		assertTrue(v1.equals(v1));
		assertTrue(v2.equals(v2));
		assertTrue(v3.equals(v3));
		assertNotSame(v1, v2);
		assertNotSame(v1,v3);
		assertNotSame(v2,v3);
		assertNotSame(v2,v1);
		assertNotSame(v3,v1);
		assertNotSame(v3,v2);
		assertSame(v1, v1);
		assertSame(v2,v2);
		assertSame(v3,v3);
		
		
	}
}
