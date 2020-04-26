package src.test.java.es.deusto.spq.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import src.main.java.es.deusto.spq.data.*;

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

	@Test
	public void testHashCode() {
		assertNotEquals(u1.hashCode(),u2.hashCode());
		assertNotEquals(u2.hashCode(),u1.hashCode());
		assertNotEquals(u2.hashCode(),u3.hashCode());
		assertNotEquals(u1.hashCode(),u3.hashCode());
		assertNotEquals(u3.hashCode(),u2.hashCode());
		assertNotEquals(u3.hashCode(),u1.hashCode());
	}
	
	@Test
	public void testEquals() {
		assertFalse(u1.equals(u2));
		assertFalse(u1.equals(u3));
		assertFalse(u2.equals(u1));
		assertFalse(u2.equals(u3));
		assertFalse(u3.equals(u1));
		assertFalse(u3.equals(u2));
		assertTrue(u1.equals(u1));
		assertTrue(u2.equals(u2));
		assertTrue(u3.equals(u3));
		assertFalse(u1.getNombre().equals(u2.getNombre()));
		assertFalse(u1.getNombre().equals(u3.getNombre()));
		assertFalse(u2.getNombre().equals(u1.getNombre()));
		assertFalse(u2.getNombre().equals(u3.getNombre()));
		assertTrue(u3.getNombre()==null);
		assertFalse(u1.getContrasenya().equals(u2.getContrasenya()));
		assertFalse(u1.getContrasenya().equals(u3.getContrasenya()));
		assertFalse(u2.getContrasenya().equals(u1.getContrasenya()));
		assertFalse(u2.getContrasenya().equals(u3.getContrasenya()));
		assertTrue(u3.getContrasenya()==null);
		assertFalse(u1.getId() == u2.getId());
		assertFalse(u1.getId() == u3.getId());
		assertFalse(u2.getId() == u1.getId());
		assertFalse(u2.getId()== u3.getId());
//		assertTrue(u3.getId()==null);
		
		

	}
}
