package src.test.java.es.deusto.spq.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.Before;

import src.main.java.es.deusto.spq.data.*;
import src.main.java.es.deusto.spq.data.Articulo.Categoria;


public class VendedorTest {
	private List<Articulo> listaArticulos;
	private Articulo articulo;
	private Vendedor vendedor;
	
	@Before
	public void inicializarClase() {
		listaArticulos = new ArrayList<>();
		articulo = new Articulo("almendras", new Date("18/05/2020"), 1.20f, 100, "ricas almendras", 
				1.05f, Categoria.FRUTOSSECOS, "almendras.com");
		listaArticulos.add(articulo);
		vendedor = new Vendedor("admin", "admin@gmail.com", listaArticulos);
	}
	
	@Test
	public void testNombre() {
		Vendedor actual = new Vendedor("admin", "admin@gmail.com", listaArticulos);
		assertEquals(vendedor.getNombreVendedor(), actual.getNombreVendedor());
	}
	
	@Test
	public void testEmail() {
		Vendedor actual = new Vendedor("admin", "admin@gmail.com", listaArticulos);
		assertEquals(vendedor.getEmailVendedor(), actual.getEmailVendedor());
	}
	
	@Test
	public void testArticulos() {
		Articulo articuloActual = new Articulo("almendras", new Date("18/05/2020"), 1.20f, 100, "ricas almendras", 
				1.05f, Categoria.FRUTOSSECOS, "almendras.com");
		List<Articulo>listaActual = new ArrayList<>();
		listaActual.add(articuloActual);
		Vendedor actual = new Vendedor("admin", "admin@gmail.com", listaActual);
		assertNotEquals(vendedor.getArticulos(), actual.getArticulos());
	}
}
