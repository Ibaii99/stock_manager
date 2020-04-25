package src.test.java.es.deusto.spq.data;

import src.main.java.es.deusto.spq.data.*;
import src.main.java.es.deusto.spq.data.Articulo.Categoria;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class VendedorTest {
	private Vendedor v1;
	private Vendedor v2;
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
		v1.setId(1);
		v1.setNombreVendedor("aitor");
		v1.setEmailVendedor("aitor@gmail.com");
		v1.setArticulos(listaArticulosTest);
	}
	
	@Test
	public void testGetId() {
		assertNotEquals(v1.getId(),v2.getId());
	}
	@Test
	public void testSetId() {
		assertEquals(1, v1.getId());
	}
	@Test
	public void testGetNombreVendedor() {
		assertNotEquals(v1.getNombreVendedor(), v2.getNombreVendedor());
	}
	@Test
	public void testSetNombreVendedor() {
		assertEquals("aitor", v1.getNombreVendedor());
	}
	@Test
	public void testGetEmailVendedor() {
		assertNotEquals(v1.getEmailVendedor(), v2.getEmailVendedor());
	}
	@Test
	public void testSetEmailVendedor() {
		assertEquals("aitor@gmail.com", v1.getEmailVendedor());
	}
	@Test
	public void testGetArticulos() {
		assertNotEquals(v1.getArticulos(), v2.getArticulos());
	}
	@Test
	public void testSetArticulos() {
		assertEquals(listaArticulosTest, v1.getArticulos());
	}
	@Test
	public void testToString() {
		
	}
}
