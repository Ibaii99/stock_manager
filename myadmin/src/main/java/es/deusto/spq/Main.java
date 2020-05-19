package es.deusto.spq;

import java.io.IOException;
import java.net.URI;
import java.awt.EventQueue;

import java.io.IOException;
import java.net.URI;
import es.deusto.spq.app.*;
import es.deusto.spq.data.*;
import es.deusto.spq.data.Articulo.Categoria;


public class Main 
{


	    /**
	     * Metodo del main
	     * @param args ningun parametro es necesario
	     * @throws IOException si hay algun error
	     * @return true
	     */
	    @SuppressWarnings("deprecation")
		public static boolean main(String[] args) throws IOException {
	    	
				InicioSesion frame = new InicioSesion();
				frame.setVisible(true);
				return true;
			
	       
	    }
	
}
