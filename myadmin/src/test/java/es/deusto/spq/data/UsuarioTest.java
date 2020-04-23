package src.test.java.es.deusto.spq.data;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import src.main.java.es.deusto.spq.data.*;


public class UsuarioTest {
	private Usuario usuario;
	
	
	@Before
	public void setUp() {
		usuario = new Usuario("admin", "admin");
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
