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





// Root resource (exposed at "api" path)
@Path("api")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class API {
	//
	/**
	 * Method handling HTTP GET requests. The returned object will be sent to the
	 * client as "text/plain" media type.
	 *
	 * String that will be returned as a text/plain response.
	 */

	private final static Logger LOGGER = Logger.getLogger(API.class);

	/** Este metodo sirve para logearse en el sistema
	 * @param 	json Recibe un json con el email y la contrasenya
	 * @return devuelve un json crudo con el nombre
	 */
	@POST
	@Path("logIn")
	public String logIn(JsonObject json) {
		LOGGER.debug("ha entrado en logIn");
		String nombre = new Cliente().loggin(get_from_json(json, "email"), get_from_json(json, "password"));
		LOGGER.info(nombre);
		LOGGER.info("se ha completado logIn");
		return "{ \"nombre\": \""+nombre + "\" }";
	}

	/** Este metodo sirve para registrarse en el sistema
	 * @param 	json Recibe un json con el email, la contrasenya y el nombre
	 * @return devuelve un json crudo con el nombre
	 */
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

	/** Este metodo sirve para eliminar un Articulo del sistema
	 * @param 	json Recibe un json con el id
	 * @return devuelve un json crudo con un texto de verificacion
	 */
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
	
	/** Este metodo sirve para ingresar un Articulo en el sistema
	 * @param 	json Recibe un json con el nombre, fecha de caducidad, precio, cantidad en el stock, descripcion, precio en oferta, categoria y la url de la imangen
	 * @return devuelve un json crudo con un texto de verificacion
	 */
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

	/** Este metodo sirve para obtener un cliente del sistema
	 * @param 	json Recibe un json con el email y la contrasenya
	 * @return devuelve un json crudo con el cliente
	 */
	@POST
	@Path("getCliente")
	public Cliente getCliente(JsonObject json) {
		LOGGER.debug("ha entrado en getCliente");
		Cliente c = new DAO().getCliente(get_from_json(json, "email"), get_from_json(json, "password"));
		LOGGER.info("se ha completado getCliente");
		return c;
	}
	
	/** Este metodo sirve para obtener el carrito del cliente del sistema
	 * @param 	json Recibe un json con el email y la contrasenya
	 * @return devuelve un json crudo con el carrito
	 */
	@POST
	@Path("getCarrito")
	public Cesta getCarrito(JsonObject json) {
		LOGGER.debug("ha entrado en getCarrito");
		Cliente c = new DAO().getCliente(get_from_json(json, "email"), get_from_json(json, "password"));
		LOGGER.info("se ha completado getCarrito");
		return c.getCarrito();
	}
	
	/** Este metodo sirve para obtener la cesta de favoritos del cliente del sistema
	 * @param 	json Recibe un json con el email y la contrasenya
	 * @return devuelve un json crudo con la cesta de favoritos
	 */
	@POST
	@Path("getFavoritos")
	public Cesta getFavoritos(JsonObject json) {
		LOGGER.debug("ha entrado en getFavoritos");
		Cliente c = new DAO().getCliente(get_from_json(json, "email"), get_from_json(json, "password"));
		LOGGER.info("se ha completado getFavoritos");
		return c.getFavoritos();
	}
	/** Este metodo sirve para meter un articulo en el carrito del cliente del sistema
	 * @param 	json Recibe un json con el email, la contrasenya, el id del articulo y la cantidad
	 */
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
	/** Este metodo sirve para modificar el carrito del cliente del sistema
	 * @param 	json Recibe un json con el email, la contrasenya, el id del articulo y la cantidad
	 */
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
	/** Este metodo sirve para obtener el tamaño del carrito del cliente del sistema
	 * @param 	json Recibe un json con el email y la contrasenya
	 * @return devuelve un json crudo con Tamaño de la cesta
	 * */
	@POST
	@Path("tamanyoCarrito")//por ID
	public String tamanyoCarrito(JsonObject json) {
		LOGGER.debug("ha entrado en tamanyoCarrito");
		DAO db = new DAO();
		Cliente c = db.getCliente(get_from_json(json, "email"), get_from_json(json, "password"));
		LOGGER.info("se ha completado tamanyoCarrito");
		return "{ \"tamanyo\": \""+c.getCarrito().getArticulos().size() + "\" }";
	}
	/** Este metodo sirve para vaciar el carrito del cliente del sistema
	 * @param 	json Recibe un json con el email y la contrasenya-
	 */
	@POST
	@Path("vaciarCarrito")//por ID
	public void VaciarCarrito(JsonObject json) {
		LOGGER.debug("ha entrado en VaciarCarrito");
		DAO db = new DAO();
		Cliente c = db.getCliente(get_from_json(json, "email"), get_from_json(json, "password"));
		c.getCarrito().vaciarCesta();
		LOGGER.info("se ha completado vaciarCarrito");
	}
	/** Este metodo sirve para añadir un articulo a la cesta de favoritos del cliente del sistema
	 * @param 	json Recibe un json con el email, la contrasenya y el id del articulo
	 */
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
	/** Este metodo sirve para modificar la cesta de favoritos del cliente del sistema
	 * @param 	json Recibe un json con el email, la contrasenya y el id del articulo
	 */
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

	/** Este metodo sirve para obtener el tamaño de la cesta de favoritos del cliente del sistema
	 * @param 	json Recibe un json con el email y la contrasenya
	 * @return devuelve un json crudo con el tamaño de la cesta de favoritos
	 */
	@POST
	@Path("tamanyoFavoritos")//por ID
	public int tamanyoFavoritos(JsonObject json) {
		LOGGER.debug("ha entrado en tamanyoFavoritos");
		DAO db = new DAO();
		Cliente c = db.getCliente(get_from_json(json, "email"), get_from_json(json, "password"));
		LOGGER.info("se ha completado tamanyoFavoritos");
		return c.getCarrito().getArticulos().size();
	}
	
	/** Este metodo sirve para vaciar la cesta de favoritos del cliente del sistema
	 * @param 	json Recibe un json con el email y la contrasenya
	 */
	@POST
	@Path("vaciarFavoritos")//por ID
	public void VaciarFavoritos(JsonObject json) {
		LOGGER.debug("ha entrado en VaciarFavoritos");
		DAO db = new DAO();
		Cliente c = db.getCliente(get_from_json(json, "email"), get_from_json(json, "password"));
		c.getCarrito().vaciarCesta();
		LOGGER.info("se ha completado vaciarFavoritos");
	}

	/** Este metodo sirve para obtener todos los articulos del sistema
	 * @return devuelve una lista de Articulos
	 */
	@GET
	@Path("getArticulos")
	public List<Articulo> getArticulos() {
		LOGGER.debug("ha entrado en getArticulos");
		DAO db = new DAO();
		LOGGER.info("se ha completado getArticulos");
		return db.getArticulos();
	}

	/** Este metodo sirve para obtener un articulo del sistema
	 * @param 	json Recibe un json con el id
	 * @return devuelve un json crudo con el articulo
	 */
	@POST
	@Path("getArticulo")//por ID
	public Articulo getArticulos(JsonObject json) {
		LOGGER.debug("ha entrado en getArticulo");
		long l = Long.parseLong(get_from_json(json, "ID"));
		Articulo a = new DAO().getArticulo(l);
		LOGGER.info("se ha completado getArticulo");
		return a;
	}

	/** Este metodo sirve para remober un articulo del carrito del cliente del sistema
	 * @param 	json Recibe un json con el email y la contraseña del cliente y el id del articulo
	 */
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
	
	/** Este metodo sirve para pasar el carrito actual a Pedidos para saber que ya ha sido comprado
	 * @param 	json Recibe un json con el email y la contraseña
	 */
	@POST
    @Path("carritoToPedido")//por ID
    public void carritoToPedido(JsonObject json) {
		LOGGER.debug("ha entrado en carritoToPedido");
        DAO db = new DAO();
        Cliente c = db.getCliente(get_from_json(json, "email"), get_from_json(json, "password"));
		c.carritoToPedido();
		LOGGER.info("se ha completado carritoToPedido");
	}
	
	/** Este metodo sirve para obtener el precio del carrito al completo
	 * @param 	json Recibe un json con el email y contraseña 
	 * @return devuelve un json crudo con el precio del carrito
	 */
	@POST
    @Path("carritoPrecio")//por ID
    public String carritoPrecio(JsonObject json) {
		LOGGER.debug("ha entrado en carritoPrecio");
        DAO db = new DAO();
		Cliente c = db.getCliente(get_from_json(json, "email"), get_from_json(json, "password"));
		LOGGER.info("se ha completado carritoPrecio");
        return "{ \"precio\": \""+ c.getCarrito().getRecibo() + "\" }";
	}
	
	/** Este metodo sirve para obtener todas las cestas del sistema
	* @return devuelve un json crudo con todas las cestas
	 */
	@GET
	@Path("getCestas")
	public List<Cesta> getCestas() {
		LOGGER.debug("ha entrado en getCestas");
		DAO db = new DAO();
		LOGGER.info("se ha completado getCestas");
		return db.getCestas();
	}

	/** Este metodo sirve para obtener una cesta del sistema
	 * @param 	json Recibe un json con el id
	 * @return devuelve un json crudo con la cesta
	 */
	@POST
	@Path("getCesta")//por ID
	public Cesta getCesta(JsonObject json) {
		LOGGER.debug("ha entrado en getCesta");
		long l = Long.parseLong(get_from_json(json, "ID"));
		Cesta a = new DAO().getCesta(l);
		LOGGER.info("se ha completado getCesta");
		return a;
	}

	/** Este metodo sirve para obtener todos los usuarios del sistema
	* @return devuelve un json crudo con todos los usuarios 
	 */
	@GET
	@Path("getUsuarios")
	public List<Usuario> getUsuarios() {
		LOGGER.debug("ha entrado en getUsuarios");
		DAO db = new DAO();
		LOGGER.info("se ha completado getUsuarios");
		return db.getUsuarios();
	}

	/** Este metodo sirve para obtener un usuario del sistema
	 * @param 	json Recibe un json con el nombre y contraseña
	 * @return devuelve un json crudo con el usuario
	 */
	@GET
	@Path("getUsuario")
	public Usuario getUsuario(JsonObject json) {
		LOGGER.debug("ha entrado en getUsuario");
		Usuario u = new DAO().getUsuario(get_from_json(json, "nombre"), get_from_json(json, "contrasenya"));
		u.toString();
		LOGGER.info("se ha completado getUsuario");
		return u;
	}

	/** Este metodo sirve para introducir unos datos basicos al sistema
	 *
	 */
	@GET
	@Path("meter_datos")
	public void api_meter_datos() {
		LOGGER.debug("ha entrado en api_meter_datos");
		DAO db = new DAO();
		db.meter_datos();
		LOGGER.info("se ha completado api_meter_datos");
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