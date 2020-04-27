package es.deusto.spq.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.data.*;

public class UsuarioTest {
	private Usuario u1;
	private Usuario u2;
	private Usuario u3;
	
	@Before
	public void setUp() {
		u1 = new Usuario("admin", "admin");
		u2 = new Usuario("jokin", "jokin");
		u3 = new Usuario();
		u1.setNombre("mikel");
		u1.setContrasenya("mikel");
	}
	@Test
	public void testGetId() {
		assertNotEquals(u1.getId(), u2.getId());
		assertNotEquals(null, u3.getId());
	}
	@Test
	public void testGetNombre() {
		assertNotEquals(u1.getNombre(), u2.getNombre());
		assertNotEquals(u1.getNombre(), u3.getNombre());
	}
	@Test
	public void testSetNombre() {
		assertEquals(u1.getNombre(), "mikel");
	}
	@Test
	public void testGetContrasenya() {
		assertNotEquals(u1.getContrasenya(),u2.getContrasenya());
		assertEquals(null,u3.getContrasenya());
	}
	@Test
	public void testSetContrasenya() {
		assertEquals(u1.getContrasenya(), "mikel");
	}
	
	
	@Test
	public void testToString() {
		assertEquals(u1.toString(), 
				", nombre=" + u1.getNombre() + ", contrasenya=" + u1.getContrasenya() + "]");
	}
}
