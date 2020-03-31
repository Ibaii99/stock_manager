package es.deusto.spq.data;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Opinion_test {
	Cliente cliente = new Cliente("jon", "mikel@gmail.com", "Deusto1", "Deusto kalea");
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
	 public void id_clienteTest() {
	 	assertEquals(cliente.getEmail_cliente(), "mikel@gmail.com");
	 }
	
	
	
}
