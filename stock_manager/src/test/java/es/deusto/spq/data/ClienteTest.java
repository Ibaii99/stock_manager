package es.deusto.spq.data;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import es.deusto.spq.data.Cliente;
import es.deusto.spq.data.Articulo.Categoria;
import es.deusto.spq.data.Cesta.Estado;
import es.deusto.spq.data.Articulo;
import es.deusto.spq.data.Cesta;


public class ClienteTest{
	private Cliente c = new Cliente("mikel", "mikel@gmail.com", "Deusto1", "Deusto kalea 1");
	private List<Cesta> cestas = new ArrayList<Cesta>();
	private Date f1 = new Date(120,04,12);
	private Articulo a1 = new Articulo("manzana",f1, 1.20f, 400, "rica manzana", 1.05f, Categoria.FRUTAS, "");
	private Articulo a2 = new Articulo("pan",f1, 1.20f, 400, "rica manzana", 1.05f, Categoria.FRUTAS, "");
	private List<Articulo>listaArticulos = new ArrayList<Articulo>();
	private List<Integer> listaCantidades = new ArrayList<Integer>();
	
	Integer cantidad1 = 400;
	Integer cantidad2 = 500;	
	
	@Before
	public void insertarDatos() {
		listaArticulos.add(a1);
		listaArticulos.add(a2);
		listaCantidades.add(cantidad1);
		listaCantidades.add(cantidad2);		
	}
	
	 @Test
	 public void testNombre() {
	 	assertEquals(c.getNombreCliente(), "mikel");
	 }
	 @Test
	 public void testEmail() {
	 	assertEquals(c.getEmailCliente(), "mikel@gmail.com");
	 }
	 @Test
	 public void testContrasenya() {
	 	assertEquals(c.getContrasenyaCliente(), "Deusto1");
	 }
	 @Test
	 public void testDireccion() {
	 	assertEquals(c.getDireccionCliente(), "Deusto kalea 1");
	 }
	@Test
	public void testId() {
		assertEquals(c.getId(), 0);
	}
	// @Test
	// public void cestas() {
	// 	assertEquals(c.getCestas(), cestas);
	// }
}
