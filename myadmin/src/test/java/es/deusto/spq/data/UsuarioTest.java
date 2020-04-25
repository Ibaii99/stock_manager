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
		u1.setNombre("ander");
		u1.setContrasenya("ander");
	}
	@Test
	public void testGetId() {
		assertNotEquals(u1.getId(), u2.getId());
	}
	@Test
	public void testGetNombre() {
		assertNotEquals(u1.getNombre(), u2.getNombre());
	}
	@Test
	public void testSetNombre() {
		assertEquals(u1.getNombre(), "ander");
	}
	@Test
	public void testGetContrasenya() {
		assertNotEquals(u1.getContrasenya(),u2.getContrasenya());
	}
	@Test
	public void testSetContrasenya() {
		assertEquals(u1.getContrasenya(), "ander");
	}
}
