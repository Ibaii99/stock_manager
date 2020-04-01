package es.deusto.spq.data;

import java.sql.Date;

import es.deusto.spq.data.Articulo.Categoria;

public class Articulo_test{
	Date f1 = new Date(120,04,12);
	Articulo a1 = new Articulo("manzana",f1, 1.20f, 400, "rica manzana", 1.05f, Categoria.FRUTA);
	
	@Before
	public void inicializarClases() {
		
	}
	
}
