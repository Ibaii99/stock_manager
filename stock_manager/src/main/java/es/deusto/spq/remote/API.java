package es.deusto.spq.remote;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import org.apache.log4j.Logger;

import javax.json.JsonObject;
import javax.json.bind.annotation.JsonbTransient;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.DELETE;
import javax.ws.rs.core.MediaType;


import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.core.JsonParser;

import es.deusto.spq.data.Articulo;
import es.deusto.spq.data.Cesta;
import es.deusto.spq.data.Cesta.Estado;
import es.deusto.spq.data.Cliente;
import es.deusto.spq.data.Usuario;
import es.deusto.spq.data.Opinion;
import es.deusto.spq.data.Vendedor;
import es.deusto.spq.data.Articulo.Categoria;
import es.deusto.spq.data_access.DAO;




/**
 * Root resource (exposed at "api" path)
 */

@Path("api")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class API {
	//
	/**
	 * Method handling HTTP GET requests. The returned object will be sent to the
	 * client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */

	private final static Logger LOGGER = Logger.getLogger(API.class);

	@POST
	@Path("logIn")
	public String logIn(JsonObject json) {
		LOGGER.debug("ha entrado en logIn");
		String nombre = new Cliente().loggin(get_from_json(json, "email"), get_from_json(json, "password"));
		LOGGER.info(nombre);
		LOGGER.info("se ha completado logIn");
		return "{ \"nombre\": \""+nombre + "\" }";
	}

	@POST
	@Path("register")
	public String register(JsonObject json) {
		LOGGER.debug("ha entrado en register");
		Cliente cliente = new Cliente(get_from_json(json, "name"), get_from_json(json, "email"), get_from_json(json, "password"), 
		get_from_json(json, "address"));
		cliente.registrarme();
		LOGGER.info("se ha completado register");
		return "{ \"nombre\": \""+cliente.getNombreCliente() + "\" }";
	}

	@POST
	@Path("eliminarArticulo")
	public String eliminarArticulo(JsonObject json) {
		LOGGER.debug("ha entrado en eliminarArticulo");
		DAO dao = new DAO();
		long id = Long.parseLong(get_from_json(json, "id"));
		Articulo a = dao.getArticulo(id);
		dao.delete(a);
		LOGGER.info("se ha completado eliminarArticulo");
        return "Articulo Eliminado";
	}	
	
	@POST
	@Path("ingresarArticulo")
	public String ingresarArticulo(JsonObject json) {
		LOGGER.debug("ha entrado en ingresarArticulo");
		DAO dao = new DAO();
		String nombre = get_from_json(json, "nombre");
		String cad = get_from_json(json, "caducidad");
		String[] cadu = cad.split("-");
		int year = Integer.parseInt(cadu[0]);
		int mes = Integer.parseInt(cadu[1]);
		char[] diaChar = cad.toCharArray();
		String diaString = ""+diaChar[8]+diaChar[9];
		int dia = Integer.parseInt(diaString);
		dia++;
		Calendar fecha = Calendar.getInstance();
//		fecha.set(year, mes, dia);
		fecha.set(Calendar.YEAR, year);
		fecha.set(Calendar.MONTH, mes);
		fecha.set(Calendar.DAY_OF_MONTH, dia);
		Date caducidad = fecha.getTime();
		Float precio = Float.parseFloat(get_from_json(json, "precio"));
		int stock = Integer.parseInt(get_from_json(json, "stock"));
		String descripcion = get_from_json(json, "descripcion");
		Float oferta = Float.parseFloat(get_from_json(json, "oferta")); 
		Categoria categoria =  Categoria.valueOf(get_from_json(json, "categoria")); 
		String urlImage = get_from_json(json, "imageUrl");
		Articulo c = new Articulo(nombre, caducidad, precio, stock, descripcion, oferta, categoria, urlImage);
		dao.store(c);
		LOGGER.info("se ha completado ingresarArticulo");
		return "Creado";
	}


	/*
		{
		"nombre": "Manzana",
		"caducidad": "02/03/2021",
		"precio": "0.46",
		"stock": "120",
		"descripcion" : "Manzana Ibiza",
		"oferta" : "0.23",
		"categoria" : "FRUTAS",
		"image_url": ""
		}
	*/ 
	
	/**
	 * @param json
	 * @return
	 */
	/*
	@POST
	@Path("actualizarArticulo")
	public String actualizarArticulo(JsonObject json) {
		DAO dao = new DAO();
		
	}
	*/
	@POST
	@Path("getCliente")
	public Cliente getCliente(JsonObject json) {
		LOGGER.debug("ha entrado en getCliente");
		Cliente c = new DAO().getCliente(get_from_json(json, "email"), get_from_json(json, "password"));
		LOGGER.info("se ha completado getCliente");
		return c;
	}

	@POST
	@Path("getCarrito")
	public Cesta getCarrito(JsonObject json) {
		LOGGER.debug("ha entrado en getCarrito");
		Cliente c = new DAO().getCliente(get_from_json(json, "email"), get_from_json(json, "password"));
		LOGGER.info("se ha completado getCarrito");
		return c.getCarrito();
	}
	
	@POST
	@Path("getFavoritos")
	public Cesta getFavoritos(JsonObject json) {
		LOGGER.debug("ha entrado en getFavoritos");
		Cliente c = new DAO().getCliente(get_from_json(json, "email"), get_from_json(json, "password"));
		LOGGER.info("se ha completado getFavoritos");
		return c.getFavoritos();
	}
	
	@POST
	@Path("addCarrito")//por ID
	public void anyadirCarrito(JsonObject json) {
		LOGGER.debug("ha entrado en anyadirCarrito");
		DAO db = new DAO();
		Articulo a = db.getArticulo( Long.parseLong(get_from_json(json, "id_articulo")));
		Cliente c = db.getCliente(get_from_json(json, "email"), get_from_json(json, "password"));
		c.getCarrito().addCesta(a, Integer.parseInt(get_from_json(json,"cantidad")));
		LOGGER.info("se ha completado addCarrito");
	}

	@POST
	@Path("modifyCarrito")//por ID
	public void modifyCarrito(JsonObject json) {
		LOGGER.debug("ha entrado en modifyCarrito");
		DAO db = new DAO();
		Articulo a = db.getArticulo( Long.parseLong(get_from_json(json, "id_articulo")));
		Cliente c = db.getCliente(get_from_json(json, "email"), get_from_json(json, "password"));
		c.getCarrito().modifyCesta(a, Integer.parseInt(get_from_json(json,"cantidad")));
		LOGGER.info("se ha completado modifyCarrito");
	}
	
	@POST
	@Path("tamanyoCarrito")//por ID
	public String tamanyoCarrito(JsonObject json) {
		LOGGER.debug("ha entrado en tamanyoCarrito");
		DAO db = new DAO();
		Cliente c = db.getCliente(get_from_json(json, "email"), get_from_json(json, "password"));
		LOGGER.info("se ha completado tamanyoCarrito");
		return "{ \"tamanyo\": \""+c.getCarrito().getArticulos().size() + "\" }";
	}

	@POST
	@Path("vaciarCarrito")//por ID
	public void VaciarCarrito(JsonObject json) {
		LOGGER.debug("ha entrado en VaciarCarrito");
		DAO db = new DAO();
		Cliente c = db.getCliente(get_from_json(json, "email"), get_from_json(json, "password"));
		c.getCarrito().vaciarCesta();
		LOGGER.info("se ha completado vaciarCarrito");
	}

	@POST
	@Path("addFavoritos")//por ID
	public void anyadirFavoritos(JsonObject json) {
		LOGGER.debug("ha entrado en anyadirFavoritos");
		DAO db = new DAO();
		Articulo a = db.getArticulo( Long.parseLong(get_from_json(json, "id_articulo")));
		Cliente c = db.getCliente(get_from_json(json, "email"), get_from_json(json, "password"));
		c.getFavoritos().addCesta(a, 1);
		LOGGER.info("se ha completado addFavoritos");
	}
	
	@POST
	@Path("modifyFavoritos")//por ID
	public void modifyFavoritos(JsonObject json) {
		LOGGER.debug("ha entrado en modifyFavoritos");
		DAO db = new DAO();
		Articulo a = db.getArticulo( Long.parseLong(get_from_json(json, "id_articulo")));
		Cliente c = db.getCliente(get_from_json(json, "email"), get_from_json(json, "password"));
		c.getFavoritos().modifyCesta(a, 1);
		LOGGER.info("se ha completado modifyFavoritos");
	}

	@POST
	@Path("tamanyoFavoritos")//por ID
	public int tamanyoFavoritos(JsonObject json) {
		LOGGER.debug("ha entrado en tamanyoFavoritos");
		DAO db = new DAO();
		Cliente c = db.getCliente(get_from_json(json, "email"), get_from_json(json, "password"));
		LOGGER.info("se ha completado tamanyoFavoritos");
		return c.getCarrito().getArticulos().size();
	}
	
	@POST
	@Path("vaciarFavoritos")//por ID
	public void VaciarFavoritos(JsonObject json) {
		LOGGER.debug("ha entrado en VaciarFavoritos");
		DAO db = new DAO();
		Cliente c = db.getCliente(get_from_json(json, "email"), get_from_json(json, "password"));
		c.getCarrito().vaciarCesta();
		LOGGER.info("se ha completado vaciarFavoritos");
	}

	@GET
	@Path("getArticulos")
	public List<Articulo> getArticulos() {
		LOGGER.debug("ha entrado en getArticulos");
		DAO db = new DAO();
		LOGGER.info("se ha completado getArticulos");
		return db.getArticulos();
	}
		
	@POST
	@Path("getArticulo")//por ID
	public Articulo getArticulos(JsonObject json) {
		LOGGER.debug("ha entrado en getArticulo");
		long l = Long.parseLong(get_from_json(json, "ID"));
		Articulo a = new DAO().getArticulo(l);
		LOGGER.info("se ha completado getArticulo");
		return a;
	}

	@POST
    @Path("removeCarrito")//por ID
    public void removeCarrito(JsonObject json) {
		LOGGER.debug("ha entrado en removeCarrito");
        DAO db = new DAO();
        Articulo a = db.getArticulo( Long.parseLong(get_from_json(json, "id_articulo")));
        Cliente c = db.getCliente(get_from_json(json, "email"), get_from_json(json, "password"));
		c.getCarrito().removeArticuloCesta(a);
		LOGGER.info("se ha completado removeCarrito");
	}
	
	@POST
    @Path("carritoToPedido")//por ID
    public void carritoToPedido(JsonObject json) {
		LOGGER.debug("ha entrado en carritoToPedido");
        DAO db = new DAO();
        Cliente c = db.getCliente(get_from_json(json, "email"), get_from_json(json, "password"));
		c.carritoToPedido();
		LOGGER.info("se ha completado carritoToPedido");
    }

	@POST
    @Path("carritoPrecio")//por ID
    public String carritoPrecio(JsonObject json) {
		LOGGER.debug("ha entrado en carritoPrecio");
        DAO db = new DAO();
		Cliente c = db.getCliente(get_from_json(json, "email"), get_from_json(json, "password"));
		LOGGER.info("se ha completado carritoPrecio");
        return "{ \"precio\": \""+ c.getCarrito().getRecibo() + "\" }";
	}
	
	//Conseguir administradores
//	@POST
//	@Path("get_admin")
//	public Admin get_admin(JsonObject json) {
//		System.out.println("Usuario: " + get_from_json(json, "usuario") + " Pass: "+  get_from_json(json, "password"));
//		Admin a = new DAO().getAdmin(get_from_json(json, "usuario"), get_from_json(json, "password"));
//		a.toString();
//		return a;
//	}

	@GET
	@Path("getCestas")
	public List<Cesta> getCestas() {
		LOGGER.debug("ha entrado en getCestas");
		DAO db = new DAO();
		LOGGER.info("se ha completado getCestas");
		return db.getCestas();
	}

	@POST
	@Path("getCesta")//por ID
	public Cesta getCesta(JsonObject json) {
		LOGGER.debug("ha entrado en getCesta");
		long l = Long.parseLong(get_from_json(json, "ID"));
		Cesta a = new DAO().getCesta(l);
		LOGGER.info("se ha completado getCesta");
		return a;
	}

	@GET
	@Path("getUsuarios")
	public List<Usuario> getUsuarios() {
		LOGGER.debug("ha entrado en getUsuarios");
		DAO db = new DAO();
		LOGGER.info("se ha completado getUsuarios");
		return db.getUsuarios();
	}
	
	@GET
	@Path("getUsuario")
	public Usuario getUsuario(JsonObject json) {
		LOGGER.debug("ha entrado en getUsuario");
		Usuario u = new DAO().getUsuario(get_from_json(json, "nombre"), get_from_json(json, "contrasenya"));
		u.toString();
		LOGGER.info("se ha completado getUsuario");
		return u;
	}
	/*
	@GET
	@Path("getOpiniones")
	public List<Opinion> getOpiniones() {
		System.out.println("Mandando todos los cestas");
		DAO db = new DAO();
		return db.getOpiniones();
	}

	@POST
	@Path("get_Opinion")//por ID
	public Opinion getOpinion(JsonObject json) {
		System.out.println("Mandando la cesta");
		long l = Long.parseLong(get_from_json(json, "ID"));
		Opinion a = new DAO().getOpinion(l);
		return a;
	}

	@POST
	@Path("nuevaOpinion")
	public Opinion nuevaOpinion(JsonObject json) {

		String txt = get_from_json(json, "txt");
		int valoracion = Integer.parseInt(get_from_json(json, "valoracion"));
		long idCliente = Long.parseLong(get_from_json(json, "idCliente"));

		Opinion o = null ;//new DAO().nuevaOpinion(txt, valoracion, idCliente);

		return o;
	}

	@GET
	@Path("getVendedores")
	public List<Vendedor> getVendedores() {
		System.out.println("Mandando todos los cestas");
		DAO db = new DAO();
		return db.getVendedores();
	}

	@POST
	@Path("getVendedor")//por ID
	public Vendedor getVendedor(JsonObject json) {
		System.out.println("Mandando la cesta");
		Vendedor a = new DAO().getVendedor(get_from_json(json, "email"));
		return a;
	}

	@POST
	@Path("nuevoVendedor")
	public String nuevoVendedor(JsonObject json) {

		Vendedor vendedor = new Vendedor(get_from_json(json, "name"), get_from_json(json, "email"), new ArrayList<Articulo>());
		vendedor.registrar();

		return "{ \"nombre\": \""+vendedor.getNombreVendedor() + "\" }";
	}
	*/
	@GET
	@Path("meter_datos")
	public String api_meter_datos() {
		LOGGER.debug("ha entrado en api_meter_datos");
		DAO db = new DAO();
		String respuesta = db.meter_datos();
		LOGGER.info("se ha completado api_meter_datos");
		return respuesta;
	}
	
	/**
	 * @param json Json fuente
	 * @param attribute Atributo a obtener del json
	 * @return Devuelve el valor
	 */
	private String get_from_json(JsonObject json, String attribute) {
		return json.get(attribute).toString().replace("\"", "");
	}
	


    
}