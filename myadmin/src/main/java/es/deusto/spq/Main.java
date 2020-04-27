package es.deusto.spq;

import java.io.IOException;
import java.net.URI;
import java.awt.EventQueue;

import java.io.IOException;
import java.net.URI;
import es.deusto.spq.app.*;
import es.deusto.spq.data.*;
import es.deusto.spq.data.Articulo.Categoria;



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
		public static boolean main(String[] args) throws IOException {
	    	
				InicioSesion frame = new InicioSesion();
				frame.setVisible(true);
				return true;
			
	       
	    }
	
}
