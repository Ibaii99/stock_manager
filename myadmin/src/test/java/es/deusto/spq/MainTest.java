package es.deusto.spq;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Rule;
import com.github.javatlacati.contiperf.Required;
import com.github.javatlacati.contiperf.PerfTest;
import com.github.javatlacati.contiperf.junit.ContiPerfRule;
import com.github.javatlacati.contiperf.report.EmptyReportModule;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.*;
@PerfTest(invocations = 5)
@Required(max = 12000, average = 250)
public class MainTest {
	private Main m,m2;
	@Rule 
	public ContiPerfRule rule = new ContiPerfRule();
	@Before
	public void setUp(){
		m = new Main();
		m2 = new Main();
		
	}
	
	@Test
	@PerfTest(invocations = 1000, threads = 20)
    @Required(max = 1200, average = 125)
	public void mainTest() {
		assertNotEquals(m,m2);
	}
	
	@Test
	@PerfTest(invocations = 1000, threads = 20)
    @Required(max = 1200, average = 125)
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
