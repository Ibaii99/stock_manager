package es.deusto.spq.data;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UsuarioTest {
	private Usuario usuario = new Usuario("admin", "admin");
	
	
	@Test
	public void testUsuario() {
		assertEquals(usuario.getNombre(), "admin");
	}
	@Test
	public void testContrasenya() {
		assertEquals(usuario.getContrasenya(), "admin");
	}
	@Test
	public void testId() {
		assertEquals(usuario.getId(), 0);
	}
	
}
