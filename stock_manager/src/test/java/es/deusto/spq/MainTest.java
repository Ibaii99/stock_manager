package es.deusto.spq;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.*;

public class MainTest{
	private Main m;
	private Main m1;
	
	
	@Before
	public void setUp() {
		m = new Main();
		m1 = new Main();
		
		
	}
	@Test
	public void testMain() {
//		assertNotEquals(m, m1);
//		String[] arg= {};
//		try {
//			assertTrue(m.main(arg));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	@Test
	public void testStartServer() {
		
	}
	
}
