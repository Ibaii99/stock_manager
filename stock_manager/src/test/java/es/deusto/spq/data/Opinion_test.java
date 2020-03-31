package es.deusto.spq.data;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Opinion_test {
	Cliente cliente = new Cliente("jon", "jon@gmail.com", "Deusto1", "Deusto kalea");
	Opinion opinion = new Opinion("me ha gustado", 6, cliente);
	
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
<<<<<<< HEAD
	@Test
	public void id_clienteTest() {
		assertEquals(cliente.getID_cliente(), 1);
	}
=======
	// @Test
	// public void id_clienteTest() {
	// 	assertEquals(cliente.getID(), 1);
	// }
>>>>>>> branch 'master' of https://github.com/Ibaii99/stock_manager.git
	@Test
	public void nombre_clienteTest() {
		assertEquals(cliente.getNombre_cliente(), "jon");
	}
	@Test
	public void email_clienteTest() {
		assertEquals(cliente.getEmail_cliente(), "jon@gmail.com");
	}
	@Test 
	public void contrasenya_cliente() {
		assertEquals(cliente.getContrasenya_cliente(), "Deusto1");
	}
	@Test
	public void direccion_cliente() {
		assertEquals(cliente.getDireccion_cliente(), "Deusto kalea");
	}
}
