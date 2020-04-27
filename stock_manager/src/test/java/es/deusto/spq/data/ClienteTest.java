package es.deusto.spq.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import es.deusto.spq.data.Cliente;
import es.deusto.spq.data.Articulo.Categoria;
import es.deusto.spq.data.Cesta.Estado;
import es.deusto.spq.data.Articulo;
import es.deusto.spq.data.Cesta;


public class ClienteTest{
	private Cliente c = new Cliente("mikel", "mikel@gmail.com", "Deusto1", "Deusto kalea 1");
	private List<Cesta> cestas = new ArrayList<Cesta>();
	private Date f1 = new Date(120,04,12);
	private Articulo a1 = new Articulo("manzana",f1, 1.20f, 400, "rica manzana", 1.05f, Categoria.FRUTAS, "");
	private Articulo a2 = new Articulo("pan",f1, 1.20f, 400, "rica manzana", 1.05f, Categoria.FRUTAS, "");
	private List<Articulo>listaArticulos = new ArrayList<Articulo>();
	private List<Integer> listaCantidades = new ArrayList<Integer>();
	private List<Articulo>listaFavoritos = new ArrayList<Articulo>();
	Integer cantidad1 = 400;
	Integer cantidad2 = 500;	
	private Cesta carrito = new Cesta();
	private ArrayList<Cesta> pedidos = new ArrayList<>();
	
	@Before
	public void setUp() {
		listaArticulos.add(a1);
		listaArticulos.add(a2);
		listaCantidades.add(cantidad1);
		listaCantidades.add(cantidad2);
		listaFavoritos.add(a2);	
		carrito.setArticulos(listaArticulos);
		carrito.setCantidades(listaCantidades);
	}
	
	 @Test
	 public void testNombre() {
		 assertEquals(c.getNombreCliente(), "mikel");
		 c.setNombreCliente("popeye");
		 assertEquals(c.getNombreCliente(), "popeye");

	 }
	 @Test
	 public void testEmail() {
		 assertEquals(c.getEmailCliente(), "mikel@gmail.com");
		 c.setEmailCliente("correo@gmail.com");
		 assertEquals(c.getEmailCliente(), "correo@gmail.com");
	 }
	 @Test
	 public void testContrasenya() {
		 assertEquals(c.getContrasenyaCliente(), "Deusto1");
		 c.setContrasenyaCliente("password");
		 assertEquals(c.getContrasenyaCliente(), "password");
	 }
	 @Test
	 public void testDireccion() {
		assertEquals(c.getDireccionCliente(), "Deusto kalea 1");
		c.setDireccionCliente("Arantzasu");
		assertEquals(c.getDireccionCliente(), "Arantzasu");
	 }
	@Test
	public void testId() {
		assertEquals(c.getId(), 0);
		c.setId(10);
		assertEquals(c.getId(), 10);
	}
	
	@Test
	public void testFavoritos() {
		assertEquals(c.getFavoritos().getArticulos().size(), 0);

		c.setFavoritos(new Cesta());
		c.getFavoritos().setArticulos(listaFavoritos);

		assertEquals(c.getFavoritos().getArticulos().size(), 1);
	}
	@Test
	public void testPedido() {

		assertEquals(c.getPedidos().size(), 0);

		c.carritoToPedido();

		assertNotEquals(c.getPedidos().size(), 0);

		c.setPedidos(pedidos);

		assertEquals(c.getPedidos().size(), 0);

	}
	@Test
	public void testLogging() {

		assertNull(c.loggin("este va a ", "va a dar mal"));

		assertNotNull(c.loggin("pepe@gmail.com", "1234"));
	}

	@Test
	public void testRegistro() {
		
		c.registro(c.getEmailCliente(),c.getNombreCliente(), c.getContrasenyaCliente(), c.getDireccionCliente());

	}

	@Test
	public void testRegistrarme() {
		
		c.registrarme();
		
	}

}
