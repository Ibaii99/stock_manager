package es.deusto.spq.data;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class UsuarioTest {
	private Usuario usuario;
	@Before
	public void setUp() {

		usuario = new Usuario("admin", "root");

	}
	@Test
	public void testGetNombre() {
		assertEquals(usuario.getNombre(), "admin");
	}
	@Test
	public void testSetNombre() {
		usuario.setNombre("popeye");
		assertEquals(usuario.getNombre(), "popeye");
	}
	@Test
	public void testGetContrasenya() {
		assertEquals(usuario.getContrasenya(), "root");
	}
	@Test
	public void testSetContrasenya() {
		usuario.setContrasenya("marino");
		assertEquals(usuario.getContrasenya(), "marino");
	}
	@Test
	public void testGetId() {
		assertEquals(usuario.getId(), 0);
	}
	@Test
	public void testSetId() {
		usuario.setId(50);
		assertEquals(usuario.getId(), 50);
	}

}
