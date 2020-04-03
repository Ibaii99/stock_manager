package es.deusto.spq.data;

import es.deusto.spq.data.Admin;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Admin_test {
	private Admin admin = new Admin("unai", "unai@gmail.com", "Unai1");
	
	@Test
	public void nombreTest() {
		assertEquals(admin.getNombre_admin(), "unai");
	}
	@Test
	public void emailTest() {
		assertEquals(admin.getEmail_admin(), "unai@gmail.com");
	}
	@Test
	public void contrasenyaTest() {
		assertEquals(admin.getContrasenya_admin(), "Unai1");
	}
}
