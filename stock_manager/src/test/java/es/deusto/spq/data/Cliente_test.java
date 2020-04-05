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


public class Cliente_test{
	//Creamos distintas cestas, con distintos articulos dentro del mismo cliente
	private Cliente c = new Cliente("mikel@gmail.com", "mikel", "Deusto1", "Deusto kalea 1");
	private List<Cesta> cestas = new ArrayList<Cesta>();
	private Date f1 = new Date(120,04,12);
	private Articulo a1 = new Articulo("manzana",f1, 1.20f, 400, "rica manzana", 1.05f, Categoria.FRUTAS, "");
	private Articulo a2 = new Articulo("pan",f1, 1.20f, 400, "rica manzana", 1.05f, Categoria.FRUTAS, "");
	private List<Articulo>listaArticulos = new ArrayList<Articulo>();
	private List<Integer> listaCantidades = new ArrayList<Integer>();
	
	Integer cantidad1 = 400;
	Integer cantidad2 = 500;
	
	private Cesta cesta1 = new Cesta(1, c, listaArticulos, listaCantidades, Estado.ACTUAL);
	private Cesta cesta2 = new Cesta(2, c, listaArticulos, listaCantidades, Estado.ACTUAL);
	
	
	@Before
	public void insertarDatos() {
		listaArticulos.add(a1);
		listaArticulos.add(a2);
		listaCantidades.add(cantidad1);
		listaCantidades.add(cantidad2);
		cestas.add(cesta1);
		cestas.add(cesta2);
		c.setCestas(cestas);
		
	}
	
	@Test
	public void testNombre() {
		assertEquals(c.getNombre_cliente(), "mikel");
	}
	@Test
	public void testEmail() {
		assertEquals(c.getEmail_cliente(), "mikel@gmail.com");
	}
	@Test
	public void testContrasenya() {
		assertEquals(c.getContrasenya_cliente(), "Deusto1");
	}
	@Test
	public void testDireccion() {
		assertEquals(c.getDireccion_cliente(), "Deusto kalea 1");
	}
	@Test
	public void testId() {
		assertEquals(c.getId(), 0);
	}
	@Test
	public void cestas() {
		assertEquals(c.getCestas(), cestas);
	}
}
