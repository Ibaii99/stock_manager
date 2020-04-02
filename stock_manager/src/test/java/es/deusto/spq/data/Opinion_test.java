package es.deusto.spq.data;

import es.deusto.spq.data.Opinion;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import es.deusto.spq.data.Cliente;

public class Opinion_test{
	private Cliente c = new Cliente("jokin", "jokin@gmail.com", "Deusto1", "Deusto kalea 1");
	private Opinion o = new Opinion("me gusta", 8, c);
	
	@Test
	public void testTexto(){
		assertEquals(o.getTexto(), "me gusta");
	}
	@Test
	public void testValoracion() {
		assertEquals(o.getValoracion(), 8);
	}
	@Test
	public void testCliente() {
		assertEquals(o.getCliente(), c);
	}
	@Test
	public void testId() {
		assertEquals(o.getId(), 1);
	}
}
