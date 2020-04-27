package es.deusto.spq;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.*;
public class MainTest {
	private Main m,m2;
	
	@Before
	public void setUp(){
		m = new Main();
		m2 = new Main();
		
	}
	
	@Test
	public void mainTest() {
		assertNotEquals(m,m2);
	}
	
	@Test
	public void mainTest2() {
		String[] arg= {};
		try {
			assertTrue(m.main(arg));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			assertTrue(m2.main(arg));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			assertEquals(m.main(arg), m2.main(arg));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
