package src.test.java.es.deusto.spq.data;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import src.main.java.es.deusto.spq.data.*;


public class UsuarioTest {
	private Usuario usuario = new Usuario("admin", "admin");
	
	
	@Test
	public void getNombre() {
		assertEquals(usuario.getNombre(), "admin");
	}
	@Test
	public void getContrasenya() {
		assertEquals(usuario.getContrasenya(), "admin");
	}
	@Test
	public void getId() {
		assertEquals(usuario.getId(), 0);
	}
}
