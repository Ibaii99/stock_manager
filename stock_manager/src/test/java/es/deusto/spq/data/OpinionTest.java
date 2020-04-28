package es.deusto.spq.data;

import es.deusto.spq.data.Opinion;

//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//import static org.mockito.Mockito.*;

import es.deusto.spq.data_access.DAO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.data.Cliente;

public class OpinionTest{
	private Cliente c;
	private Opinion o;
	private Opinion o1;
	
//	@Mock
//	private DAO dao;
	
	@Before
	public void setUp() {
		c = new Cliente("jokin", "jokin@gmail.com", "Deusto1", "Deusto kalea 1");
		o = new Opinion("me gusta", 8, c);
		o1 = new Opinion();
//		dao = new DAO();
		o.setId(1);
		o.setTexto("oo");
		o.setCliente(c);
		o.setValoracion(9);
	}
	@Test
	public void testGetId() {
		assertNotEquals(o.getId(),o1.getId());
	}
	@Test
	public void testSetId() {
		assertEquals(o.getId(),1);
	}
	@Test
	public void  testGetTexto() {
		assertNotEquals(o.getTexto(), o1.getTexto());
	}

	@Test
	public void testSetTexto() {
		assertEquals(o.getTexto(), "oo");
	}

	@Test
	public void testGetValoracion() {
		assertNotEquals(o.getValoracion(), o1.getValoracion());
	}

	@Test
	public void testSetValoracion() {
		assertEquals(o.getValoracion(), 9);
	}

	@Test
	public void testGetCliente() {
		assertNotEquals(o.getCliente(), o1.getCliente());
	}

	@Test
	public void testSetCliente() {
		assertEquals(o.getCliente(), c);
	}

	@Test
	public void testPublicar() {
		o.publicar();
	
	}
	
	
}
