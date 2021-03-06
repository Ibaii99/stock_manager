package es.deusto.spq.data;

import es.deusto.spq.data.Articulo.Categoria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import com.github.javatlacati.contiperf.Required;
import com.github.javatlacati.contiperf.PerfTest;
import com.github.javatlacati.contiperf.junit.ContiPerfRule;
import com.github.javatlacati.contiperf.report.EmptyReportModule;

import es.deusto.spq.data.Articulo;
import es.deusto.spq.data.Vendedor;

@PerfTest(invocations = 5)
@Required(max = 12000, average = 250)
public class ArticuloTest{
	private Articulo a1;
	private Articulo a2;
	private Articulo a3;
	private Articulo a4;
	private Vendedor v1;
	private Vendedor v2;
	private List<Articulo> listaArticulos = new ArrayList<Articulo>();
	private Date d1;
	private Date d2;
	@Rule 
	public ContiPerfRule rule = new ContiPerfRule();
	
	@Before
	public void setUp(){
		d1 = new Date(2020, 04, 15);
		d2 = new Date(2020, 04, 16);
		a1 = new Articulo("coliflor", d1, 1.20f, 400, "rica coliflor", 1.05f,
				Categoria.VERDURAS,"coliflor.com");
		a2 = new Articulo("pan", d2, 1.10f, 200, "rica pan", 1.04f,
				Categoria.FRUTOSSECOS,
				"pan.com");
		a3 = new Articulo();
		a4= new Articulo("coliflor", d2, 1.20f, 400, "rica coliflor", 1.05f,
				Categoria.VERDURAS,"coliflor.com");
		listaArticulos.add(a1);
		listaArticulos.add(a2);
		v1 = new Vendedor("jokin", "jokin@gmail.com", listaArticulos);
		v2 = new Vendedor("jon", "jon@gmail.com", listaArticulos);
		a1.setVendedor(v1);
		a2.setVendedor(v2);
		a1.setId(1);
		a1.setNombre("platano");
		a1.setCaducidad(new Date(15/05/2020));
		a1.setPrecio(2.15f);
		a1.setStock(50);
		a1.setDescripcion("me gusta");
		a1.setOferta(1.88f);
		a1.setCategoria(Categoria.FRUTAS);
		a1.setImageUrl("platano.com");
		a4.setId(1);


	}
	
	@Test
	@PerfTest(invocations = 1000, threads = 20)
    @Required(max = 1200, average = 125)
	public void testGetId() {//Comprobamos que el ID de los articulos sean distintos
		assertNotEquals(a1.getId(), a2.getId(),a3.getId());
		
	}
	@Test
	@PerfTest(invocations = 1000, threads = 20)
    @Required(max = 1200, average = 125)
	public void testSetId() {//Comprobamos que el ID, despues de hacer el set sea igual
		assertEquals(1, a1.getId());
	}
	@Test
	@PerfTest(invocations = 1000, threads = 20)
    @Required(max = 1200, average = 125)
	public void testGetNombre() {
		assertNotEquals(a1.getNombre(),a2.getNombre(),a3.getNombre());
	}
	@Test
	@PerfTest(invocations = 1000, threads = 20)
    @Required(max = 1200, average = 125)
	public void testSetNombre() {
		assertEquals("platano", a1.getNombre());
	}
	@Test
	@PerfTest(invocations = 1000, threads = 20)
    @Required(max = 1200, average = 125)
	public void testGetCaducidad() {
		assertNotEquals(a1.getCaducidad(), a2.getCaducidad());
		assertNotEquals(a2.getCaducidad(), a3.getCaducidad());
	}
	@Test
	@PerfTest(invocations = 1000, threads = 20)
    @Required(max = 1200, average = 125)
	public void testSetCaducidad() {
		assertEquals(new Date(15/05/2020), a1.getCaducidad());
	}
	
	@Test
	@PerfTest(invocations = 1000, threads = 20)
    @Required(max = 1200, average = 125)
	public void testGetPrecio() {
		assertNotEquals(a1.getPrecio(), a2.getPrecio(),a3.getPrecio());
	}
	@Test
	@PerfTest(invocations = 1000, threads = 20)
    @Required(max = 1200, average = 125)
	public void testSetPrecio() {
		assertEquals(2.15f, a1.getPrecio(),0);
	}
	
	@Test
	@PerfTest(invocations = 1000, threads = 20)
    @Required(max = 1200, average = 125)
	public void testGetStock() {
		assertNotEquals(a1.getStock(), a2.getStock(),a3.getStock());
	}
	@Test
	@PerfTest(invocations = 1000, threads = 20)
    @Required(max = 1200, average = 125)
	public void testSetStock() {
		assertEquals(50, a1.getStock());
	}
	
	@Test
	@PerfTest(invocations = 1000, threads = 20)
    @Required(max = 1200, average = 125)
	public void testGetDescripcion() {
		assertNotEquals(a1.getDescripcion(), a2.getDescripcion(),a3.getDescripcion());
	}
	@Test
	@PerfTest(invocations = 1000, threads = 20)
    @Required(max = 1200, average = 125)
	public void testSetDescripcion() {
		assertEquals("me gusta", a1.getDescripcion());
	}
	@Test
	@PerfTest(invocations = 1000, threads = 20)
    @Required(max = 1200, average = 125)
	public void testGetOferta() {
		assertNotEquals(a1.getOferta(), a2.getOferta(),a3.getOferta());
	}
	@Test
	@PerfTest(invocations = 1000, threads = 20)
    @Required(max = 1200, average = 125)
	public void testSetOferta() {
		assertEquals(1.88f, a1.getOferta(),0);
	}
	@Test
	@PerfTest(invocations = 1000, threads = 20)
    @Required(max = 1200, average = 125)
	public void testGetCategoria() {
		assertNotEquals(a1.getCategoria(), a2.getCategoria());
		assertNotEquals(a1.getCategoria(), a3.getCategoria());
	}
	@Test
	@PerfTest(invocations = 1000, threads = 20)
    @Required(max = 1200, average = 125)
	public void testSetCategoria() {
		assertEquals(Categoria.FRUTAS, a1.getCategoria());
	
	}
	@Test
	@PerfTest(invocations = 1000, threads = 20)
    @Required(max = 1200, average = 125)
	public void testGetVendedor() {
		assertNotEquals(a1.getVendedor(), a2.getVendedor());
		assertNotEquals(a1.getVendedor(), a3.getVendedor());
	}
	@Test
	@PerfTest(invocations = 1000, threads = 20)
    @Required(max = 1200, average = 125)
	public void testSetVendedor() {
		assertEquals(v1, a1.getVendedor());
	}
	@Test
	@PerfTest(invocations = 1000, threads = 20)
    @Required(max = 1200, average = 125)
	public void testGetImageUrl() {
		assertNotEquals(a1.getImageUrl(), a2.getImageUrl(),a3.getImageUrl());
	}
	@Test
	@PerfTest(invocations = 1000, threads = 20)
    @Required(max = 1200, average = 125)
	public void testSetImageUrl() {
		assertEquals("platano.com", a1.getImageUrl());
	}
	@Test
	@PerfTest(invocations = 1000, threads = 20)
    @Required(max = 1200, average = 125)
	public void testEquals() {
		assertFalse(a1.equals(a2));		
		assertTrue(a1.equals(a4));
		assertTrue(a1.equals(a1));	
		assertTrue(a2.equals(a2));
		
		
	}
	@Test
	@PerfTest(invocations = 1000, threads = 20)
    @Required(max = 1200, average = 125)
	public void testToString() {
		String prueba = a1.toString();
		assertNotEquals(prueba, a2.toString());
	}
	@Test
	@PerfTest(invocations = 1000, threads = 20)
    @Required(max = 1200, average = 125)
	public void testHashCode() {
		assertNotEquals(a1.hashCode(), a2.hashCode());
		assertNotEquals(a1.hashCode(), a3.hashCode());
		assertNotEquals(a2.hashCode(), a3.hashCode());
	}
	
}
