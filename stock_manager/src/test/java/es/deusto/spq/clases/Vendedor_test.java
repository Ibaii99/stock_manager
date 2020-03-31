package es.deusto.spq.clases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Vendedor_test {
	Vendedor vendedor = new Vendedor(1, "jon", "jon@gmail.com");
	@Test
	public void testgetIDVendedor() {
		assertEquals(vendedor.getID(), 1);
	}
	@Test
	public void testgetNombreVendedor() {
		assertEquals(vendedor.getNombre(), "Jon");
	}
	@Test
	public void testgetEmailVendedor() {
		assertEquals(vendedor.getEmail(), "jon@gmail.com");
	}
	
}