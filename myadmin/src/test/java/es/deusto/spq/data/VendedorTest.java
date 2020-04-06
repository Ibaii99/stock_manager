package src.test.java.es.deusto.spq.data;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import src.main.java.es.deusto.spq.data.*;
import src.main.java.es.deusto.spq.data.Articulo.Categoria;


public class VendedorTest {
	private List<Articulo> listaArticulos = new ArrayList<>();
	private Articulo articulo = new Articulo("almendras", new Date("18/05/2020"), 1.20f, 100, "ricas almendra", 
			1.05f, Categoria.FRUTOSSECOS, "almendras.com");
	listaArticulos.add(articulo);
	private Vendedor vendedor = new Vendedor("admin", "admin@gmail.com", listaArticulos);
	
	@Test
	public void testNombre() {
		assertEquals(vendedor.getNombreVendedor(), "admin");
	}
	
	@Test
	public void testEmail() {
		assertEquals(vendedor.getEmailVendedor(), "admin@gmail.com");
	}
	
	@Test
	public void testId() {
		assertEquals(vendedor.getId(), 0);
	} 
	
	@Test
	public void testArticulos() {
		assertEquals(vendedor.getArticulos(), listaArticulos);
	}
}
