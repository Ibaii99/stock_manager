package src.test.java.es.deusto.spq.data;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import src.main.java.es.deusto.spq.data.*;


public class UsuarioTest {
	private Usuario u1;
	private Usuario u2;
	
	
	@Before
	public void setUp() {
		u1 = new Usuario("admin", "admin");
		u2 = new Usuario("jokin", "jokin");
	}
	
	@Test
	public void getNombre() {
		Usuario actual = new Usuario("admin", "admin");
		assertEquals(usuario.getNombre(), actual.getNombre());
	}
	@Test
	public void getContrasenya() {
		Usuario actual = new Usuario("admin", "admin");
		assertEquals(usuario.getContrasenya(), actual.getContrasenya());
	}
}
