package src.main.java.es.deusto.spq;

import java.io.IOException;
import java.net.URI;
import java.awt.EventQueue;

import java.io.IOException;
import java.net.URI;
import src.main.java.es.deusto.spq.app.*;



/**
 * Hello world!
 *
 */
public class Main 
{

//
//	    /**
//	     * Main method.
//	     * @param args
//	     * @throws IOException
//	     */
	    @SuppressWarnings("deprecation")
		public static void main(String[] args) throws IOException {
	    	try {
				InicioSesion frame = new InicioSesion();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
	       
	    }
	
}
