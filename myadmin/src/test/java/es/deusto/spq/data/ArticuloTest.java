package src.test.java.es.deusto.spq.data;

import src.main.java.es.deusto.spq.data.Articulo.Categoria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import src.main.java.es.deusto.spq.data.*;

public class ArticuloTest{
	private Articulo a1;
	private Articulo a2;
	private Vendedor v1;
	private Vendedor v2;
	private List<Articulo> listaArticulos = new ArrayList<Articulo>();
	
	@Before
	public void setUp() {
		a1 = new Articulo("coliflor", new Date(23/04/2020), 1.20f, 400, "rica coliflor", 1.05f,
				Categoria.FRUTAS,
				"https://gastronomiaycia.republica.com/wp-content/uploads/2013/04/quitar_manchas_coliflor.jpg");
		a2 = new Articulo("pan", new Date(22/04/2020), 1.10f, 200, "rica pan", 1.04f,
				Categoria.FRUTOSSECOS,
				"https://s1.eestatic.com/2015/03/24/cocinillas/Cocinillas_20507999_115826466_1024x576.jpg");
		listaArticulos.add(a1);
		listaArticulos.add(a2);
		v1 = new Vendedor("jokin", "jokin@gmail.com", listaArticulos);
		v2 = new Vendedor("jon", "jon@gmail.com", listaArticulos);
		a1.setVendedor(v1);
		a2.setVendedor(v2);
		
		
	}
	
	@Test
	public void testGetId() {//Comprobamos que el ID de los articulos sean distintos
		assertNotEquals(a1.getId(), a2.getId());
	}
	@Test
	public void testSetId() {//Comprobamos que el ID, despues de hacer el set sea igual
		a1.setId(a2.getId());
		assertEquals(a1.getId(), a2.getId());
	}
	@Test
	public void testGetNombre() {
		assertNotEquals(a1.getNombre(),a2.getNombre());
	}
	@Test
	public void testSetNombre() {
		a2.setNombre(a1.getNombre());
		assertEquals(a1.getNombre(), a2.getNombre());
	}
	@Test
	public void testGetCaducidad() {
		assertNotEquals(a1.getCaducidad(), a2.getCaducidad());
	}
	@Test
	public void testSetCaducidad() {
		a1.setCaducidad(a2.getCaducidad());
		assertEquals(a1.getCaducidad(), a2.getCaducidad());
	}
	@Test
	public void testGetPrecio() {
		assertNotEquals(a1.getPrecio(), a2.getPrecio());
	}
	@Test
	public void testSetPrecio() {
		a2.setPrecio(a1.getPrecio());
		assertEquals(a1.getPrecio(), a2.getPrecio(),0);
	}
	@Test
	public void testGetStock() {
		assertNotEquals(a1.getStock(), a2.getStock());
	}
	@Test
	public void testSetStock() {
		a1.setStock(a2.getStock());
		assertEquals(a1.getStock(), a2.getStock());
	}
	@Test
	public void testGetDescripcion() {
		assertNotEquals(a1.getDescripcion(), a2.getDescripcion());
	}
	@Test
	public void testSetDescripcion() {
		a2.setDescripcion(a1.getDescripcion());
		assertEquals(a1.getDescripcion(), a2.getDescripcion());
	}
	@Test
	public void testGetOferta() {
		assertNotEquals(a1.getOferta(), a2.getOferta());
	}
	@Test
	public void testSetOferta() {
		a1.setPrecio(a2.getOferta());
		assertEquals(a1.getOferta(), a2.getOferta(),0);
	}
	@Test
	public void testGetCategoria() {
		assertNotEquals(a1.getCategoria(), a2.getCategoria());
	}
	@Test
	public void testSetCategoria() {
		a2.setCategoria(a1.getCategoria());
		assertEquals(a1.getCategoria(), a2.getCategoria());
	}
	@Test
	public void testGetVendedor() {
	
		assertNotEquals(a1.getVendedor(), a2.getVendedor());
	}
	@Test
	public void testSetVendedor() {
		a1.setVendedor(a2.getVendedor());
		assertEquals(a1.getVendedor(), a2.getVendedor());
		
	}
	@Test
	public void testGetImageUrl() {
		assertNotEquals(a1.getImageUrl(), a2.getImageUrl());
	}
	@Test
	public void testSetImageUrl() {
		a2.setImageUrl(a1.getImageUrl());
		assertEquals(a1.getImageUrl(), a2.getImageUrl());
	}
	@Test
	public void testGetImage() {
		assertNotEquals(a1.getImage(), a2.getImage());
	}
	@Test
	public void testSetImage() throws IOException {
		a1.setImage(a2.getImage().toString());
		assertEquals(a1.getImage(), a2.getImage());
	}
	
	
}
