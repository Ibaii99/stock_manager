package es.deusto.spq.data;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Opinion_test {
	Cliente cliente = new Cliente(1, "jon", "jon@gmail.com", "Deusto1", "Deusto kalea");
	Opinion opinion = new Opinion("me ha gustado", 6, cliente, 1);
	
	@Test
	public void textoTest() {
		assertEquals(opinion.getTexto(), "me ha gustado");
	}
	@Test
	public void valoracionTest() {
		assertEquals(opinion.getValoracion(), 6);
	}
	@Test
	public void id_opinion_clienteTest() {
		assertEquals(opinion.getID_Opinion(), cliente);
	}
	@Test
	public void id_opinionTest() {
		assertEquals(opinion.getID_Opinion(), 1);
	}
	@Test
	public void id_clienteTest() {
		assertEquals(cliente.getID(), 1);
	}
	@Test
	public void nombre_clienteTest() {
		assertEquals(cliente.getNombre(), "jon");
	}
	@Test
	public void email_clienteTest() {
		assertEquals(cliente.getEmail(), "jon@gmail.com");
	}
	@Test 
	public void contrasenya_cliente() {
		assertEquals(cliente.getContrasenya(), "Deusto1");
	}
	@Test
	public void direccion_cliente() {
		assertEquals(cliente.getDireccion(), "Deusto kalea");
	}
}
