package es.deusto.spq.data_access;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.apache.log4j.Logger;

//import es.deusto.spq.data.Admin;
import es.deusto.spq.data.Articulo;
import es.deusto.spq.data.Articulo.Categoria;
import es.deusto.spq.data.Cesta;
import es.deusto.spq.data.Cesta.Estado;
import es.deusto.spq.data.Cliente;
import es.deusto.spq.data.Opinion;
import es.deusto.spq.data.Usuario;
//import es.deusto.spq.data.Usuario;
import es.deusto.spq.data.Vendedor;

public class DAO {
	// JDO

	private PersistenceManagerFactory pmf;
	private PersistenceManager pm;
	static final Logger logger = Logger.getLogger(DAO.class);

	
	/**Constructor de la clase DAO para poder generar conexion a la BBDD
	 * 
	 */
	public DAO() {
		logger.debug("Dao class initialized");

		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		pm = pmf.getPersistenceManager();

		logger.info("Conexion created");
	}

	/**Metodo para guardar Objetos Serializables en nuestra BBDD
	 * @param u Objeto a guardar
	 */
	public void store(Object u) {
		logger.debug("Store method access");
		Transaction tx = this.pm.currentTransaction();
		try {
			tx.begin();
			logger.info("   * Storing an object: " + u);
			pm.makePersistent(u);
			tx.commit();
		} catch (Exception ex) {
			logger.error("   $ Error storing an object: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

		}

		logger.info("Object stored");
	}

	/**Metodo para eliminar un objeto Articulo de la BBDD
	 * @param u Articulo que deseamos eliminar
	 */
	public void delete(Articulo u) {


		Transaction tm = pm.currentTransaction();
		
		try {
			logger.debug("Delete method access");
			Query q = pm.newQuery("SQL", "SELECT * FROM ARTICULO WHERE ID = " + u.getId());
			q.setClass(Articulo.class);
			q.setUnique(true);
			Articulo product = (Articulo) q.execute();
			tm.begin();
			pm.deletePersistent(product);
			tm.commit();
			logger.info("Articulo deleted");
			} catch ( Exception ex) {
				System.out.println("   $ Error deleting an object: " + ex.getMessage());
			} finally {
				if (tm != null && tm.isActive()) {
					tm.rollback();
				}

			}
			
		}

	// GET de lista de articulos

	/**Metodo para obtener la lista de todos los objetos almacenados en la BBDD
	 * @return	devuelve un List Articulo con todos los articlos almacenados en la BBDD
	 */
	public List<Articulo> getArticulos() {
		logger.debug("Get Articulos method access");
		List<Articulo> ret = new ArrayList<Articulo>();
		Transaction tx = pm.currentTransaction();
		try {
			logger.info("   * Retrieving an Extent for Articulos.");
			tx.begin();
			Extent<Articulo> extent = pm.getExtent(Articulo.class, true);
			for (Articulo product : extent) {
				ret.add(product);
			}
			tx.commit();
		} catch (Exception ex) {
			logger.error("   $ Error retrieving an usuario: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		logger.info("Articulos found");
		return ret;
	}

	// GET de un articulo
	
	/**Metodo para obtener un solo Articulo de la BBDD
	 * @param idArticulo idArticulo unico e identificativo de cada Articulo
	 * @return	devuelve un objeto de tipo Articulo
	 */
	public Articulo getArticulo(long idArticulo) {
		logger.debug("Get Articulo method access");
		ArrayList<Articulo> articulos = (ArrayList<Articulo>) this.getArticulos();

		for (Articulo a : articulos) {
			if (idArticulo == a.getId()) {
				logger.info("Articulo found");
				return a;
			}
		}
		logger.warn("Articulo not found");
		return null;
	}

	/**Metodo para obtener la lista completa de todos los clientes almacenados en la BBDD
	 * @return	devuelve un List Cliente con todos los objetos de la BBDD
	 */
	public List<Cliente> getClientes() {
		logger.debug("Get Clientes method access");
		List<Cliente> ret = new ArrayList<Cliente>();
		Transaction tx = pm.currentTransaction();
		try {
			logger.info("   * Retrieving an Extent for Cliente.");
			tx.begin();
			Extent<Cliente> extent = pm.getExtent(Cliente.class, true);
			for (Cliente product : extent) {
				ret.add(product);
			}
			tx.commit();
		} catch (Exception ex) {
			logger.error("   $ Error retrieving an usuario: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		logger.info("Clientes found");
		return ret;
	}

	// GET de un cliente
	/**Metodo para obtener un Cliente en concreto de la BBDD
	 * @param email	email del Cliente que queremos obtener
	 * @param contrasenya	contrasenya del Cliente a obtener
	 * @return	devuelve un objeto de tipo Cliente
	 */
	public Cliente getCliente(String email, String contrasenya) {
		logger.debug("Get Cliente method access");
		Cliente c = null;
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		clientes = (ArrayList<Cliente>) this.getClientes();
		for (int i = 0; i < clientes.size(); i++) {
			c = clientes.get(i);
			if (email.equals(c.getEmailCliente()) && contrasenya.equals(c.getContrasenyaCliente())) {
				logger.info("Cliente found.");
				return c;
			}
		}
		logger.warn("Cliente not found");
		return null;
	}

	// GET de una lista de usuarios

	/**Metodo para obtener la lista completa de los Usuarios almacenados en la BBDD
	 * @return devuelve un List Usuario con todos los Usuarios almacenados
	 */
	public List<Usuario> getUsuarios() {
		logger.debug("Get Usuarios method access");
		List<Usuario> ret = new ArrayList<Usuario>();
		Transaction tx = pm.currentTransaction();
		try {
			logger.info("   * Retrieving an Extent for Usuario.");
			tx.begin();
			Extent<Usuario> extent = pm.getExtent(Usuario.class, true);
			for (Usuario product : extent) {
				ret.add(product);
			}
			tx.commit();
		} catch (Exception ex) {
			logger.error("   $ Error retrieving an usuario: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		logger.info("Usuarios found");

		return ret;
	}

	// GET de un usuario
	/**Metodo para obtener un Usuario en concreto almacenado en la BBDD
	 * @param nombre	nombre del Usuario a obtener
	 * @param contrasenya	contrasenya del Usuario a obtener
	 * @return	devuelve un objeto de tipo Usuario
	 */
	public Usuario getUsuario(String nombre, String contrasenya) {
		logger.debug("Get Usuario method access");
		Usuario u = null;
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios = (ArrayList<Usuario>) this.getUsuarios();
		for (int i = 0; i < usuarios.size(); i++) {
			u = usuarios.get(i);
			if (nombre.equals(u.getNombre()) && contrasenya.equals(u.getContrasenya())) {
				logger.info("Usuario found");
				return u;
			}
		}
		logger.warn("Usuario not found");
		return null;
	}

	// GET de una lista de cestas
	/**Metodo para obtener la lista completa de todas las Cestas almacenadas en la BBDD
	 * @return	devueve un List Cesta con todas las Cestas almacenadas
	 */
	public List<Cesta> getCestas() {
		logger.debug("Get Cestas method access");
		List<Cesta> ret = new ArrayList<Cesta>();
		Transaction tx = pm.currentTransaction();
		try {
			logger.info("   * Retrieving an Extent for Cestas.");
			tx.begin();
			Extent<Cesta> extent = pm.getExtent(Cesta.class, true);
			for (Cesta cesta : extent) {
				ret.add(cesta);
				cesta.getArticulos().toString();
			}
			tx.commit();
		} catch (Exception ex) {
			logger.error("   $ Error retrieving an usuario: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		logger.info("Cestas found");

		return ret;
	}

	// GET de una cesta
	/**Metodo para obtener una Cesta en concreto almacenada en la BBDD
	 * @param idCesta	id unico e identifcativo de la Cesta que queremos obtener
	 * @return	devuelve un Objeto de tipo Cesta
	 */
	public Cesta getCesta(long idCesta) {
		logger.debug("Get Cesta method access");
		Cesta c = null;
		ArrayList<Cesta> cestas = (ArrayList<Cesta>) this.getCestas();
		for (int i = 0; i < cestas.size(); i++) {
			c = cestas.get(i);
			if (idCesta == c.getId()) {
				logger.info("Cesta found");
				return c;
			}
		}
		logger.warn("Cesta not found");
		return c;
	}

	// Metodo para modificar cestas
	/**Metodo para modificar la cantidad de un Articulo que se encuentra en una Cesta
	 * @param idCesta	id de la Cesta que queremos modificar la cantidad de uno de sus Articulos
	 * @param idArticulo	id del Articulo al que le queremos aumentar o decrementar cantidad
	 * @param cantidad	cantidad a aumentar o decrementar
	 * @return Devuelve la cesta modificada
	 */
	public Cesta modifyCesta(long idCesta, long idArticulo, int cantidad) {
		logger.debug("Modify Cesta method access");
		Cesta c = getCesta(idCesta);
		Articulo a = getArticulo(idArticulo);
		c.modifyCesta(a, cantidad);
		logger.info("Cesta modified");
		return c;
	}

	// Metodo para vaciar cestas
	/**	Metodo para vaciar por completo una Cesta
	 * @param idCesta	id de la Cesta a vaciar
	 * @return	devuelve un Objeto de tipo Cesta sin nigun Aaticulo en ella
	 */
	public Cesta cleanCesta(long idCesta) {
		logger.debug("Clean Cesta method access");
		Cesta c = getCesta(idCesta);
		c.vaciarCesta();
		logger.warn("Cesta cleaned");
		return c;
	}
	/*
	 * // GET de una lista de opiniones public List<Opinion> getOpiniones() {
	 * List<Opinion> ret = new ArrayList<Opinion>(); Transaction tx =
	 * pm.currentTransaction(); try {
	 * System.out.println("   * Retrieving an Extent for Opiniones."); tx.begin();
	 * Extent<Opinion> extent = pm.getExtent(Opinion.class, true); for ( Opinion
	 * product : extent) { ret.add(product); } tx.commit(); } catch ( Exception ex)
	 * { System.out.println("   $ Error retrieving an usuario: " + ex.getMessage());
	 * } finally { if (tx != null && tx.isActive()) { tx.rollback(); } } return ret;
	 * }
	 * 
	 * // GET de una opinion public Opinion getOpinion( long id) { Opinion c = null;
	 * ArrayList<Opinion> Opiniones = (ArrayList<Opinion>) this.getOpiniones(); for
	 * (Opinion opinion : Opiniones) { if (id == opinion.getId()) { c = opinion;
	 * return c; } } return c; }
	 * 
	 * // GET de una lista de vendedores public List<Vendedor> getVendedores() {
	 * List<Vendedor> ret = new ArrayList<Vendedor>(); Transaction tx =
	 * pm.currentTransaction(); try {
	 * System.out.println("   * Retrieving an Extent for Vendedores."); tx.begin();
	 * Extent<Vendedor> extent = pm.getExtent(Vendedor.class, true); for ( Vendedor
	 * product : extent) { ret.add(product); } tx.commit(); } catch ( Exception ex)
	 * { System.out.println("   $ Error retrieving an usuario: " + ex.getMessage());
	 * } finally { if (tx != null && tx.isActive()) { tx.rollback(); } } return ret;
	 * }
	 * 
	 * // GET de un vendedor public Vendedor getVendedor( String email) { Vendedor v
	 * = null; ArrayList<Vendedor> vendedores = (ArrayList<Vendedor>)
	 * this.getVendedores(); for (int i = 0; i < vendedores.size(); i++) { v =
	 * vendedores.get(i); if (email == (v.getEmailVendedor())) { return v; } }
	 * return v; }
	 */

	// Meter para introducir datos a la Base de Datos
	/**Metodo para guardar valores predefinidos en la BBDD
	 * @return devuelve un objeto String para indicarnos que los objetos se han guardado correctamente
	 */
	@SuppressWarnings("deprecation")
	public String meter_datos() {
		logger.debug("Meter Datos method access");
		Cliente a = new Cliente("pepe", "pepe@gmail.com", "1234", "Barakaldo");
		Cliente b = new Cliente("luis", "luis@gmail.com", "1234", "Universidad Deusto");
		Cliente c = new Cliente("mani", "mani@gmail.com", "1234", "Bilbao");
		Cliente d = new Cliente("sandra", "sandra@gmail.com", "1234", "Universidad");
		Cliente e = new Cliente("Ane", "ane@gmail.com", "1234", "DeustoTech");
		Cliente mikel = new Cliente("mikel", "mikel@gmail.com", "1234", "Barakaldo");
		Cliente jokin = new Cliente("jokin", "jokin@gmail.com", "1234", "Universidad Deusto");
		Cliente ibai = new Cliente("ibai", "ibai@gmail.com", "1234", "Bilbao");
		Cliente izai = new Cliente("izaia", "izai@gmail.com", "1234", "Universidad");
		Cliente unai = new Cliente("Unai", "unai@gmail.com", "1234", "DeustoTech");
		Vendedor f = new Vendedor("MikelVendedor", "mikelVendedor@gmail.com");
		Vendedor g = new Vendedor("JokinVendedor", "jokinVendedor@gmail.com");
		Vendedor h = new Vendedor("IbaiVendedor", "ibailVendedor@gmail.com");
		Vendedor i = new Vendedor("IzaiVendedor", "izaiVendedor@gmail.com");
		Vendedor j = new Vendedor("UnaiVendedor", "unaiVendedor@gmail.com");
		Cliente c1 = new Cliente("jokin", "jokin@gmail.com", "hola", "Deusto kalea 1");

		Cliente c2 = new Cliente("aitor", "aitor@gmail.com", "hola", "Deusto kalea 1");

		Articulo manzana = new Articulo("manzana", new Date(120, 4, 19), 1.20f, 90, "rica manzana", 0.95f,
				Categoria.FRUTAS, "https://i.pinimg.com/originals/63/64/fb/6364fbeede3157aac881ed9c088d9c26.png");
		Articulo lechuga = new Articulo("lechuga", new Date(120, 4, 11), 1.20f, 60, "rica lechuga", 0.95f,
				Categoria.VERDURAS,
				"https://www.frutasramirez.com/wp-content/uploads/2015/09/distribucionlechuga-iceberg-frutas-ramirez.jpg");
		Articulo fresa = new Articulo("pimiento", new Date(121, 3, 21), 1.20f, 400, "rico pimiento", 0.95f,
				Categoria.VERDURAS,
				"https://sgfm.elcorteingles.es/SGFM/dctm/MEDIA03/201811/26/00118107400048____2__600x600.jpg");
		Articulo calabaza = new Articulo("Calabaza", new Date(121, 3, 21), 1.20f, 400, "rica calabza", 0.95f,
				Categoria.VERDURAS,
				"https://bonduelle.es/media/zoo/images/calabaza_bd186bc04231bf6c392b16a57a50b431.jpg");
		Articulo pimiento = new Articulo("fresa", new Date(121, 3, 21), 1.20f, 400, "rica fresa", 0.95f,
				Categoria.VERDURAS,
				"https://ecocosas.com/wp-content/uploads/2012/10/img_cuales_son_los_beneficios_de_las_fresas_7561_orig.jpg");
		Articulo a1 = new Articulo("coliflor", new Date(121, 3, 21), 1.20f, 400, "rica coliflor", 1.05f,
				Categoria.FRUTAS,
				"https://gastronomiaycia.republica.com/wp-content/uploads/2013/04/quitar_manchas_coliflor.jpg");
		Articulo a2 = new Articulo("pan", new Date(121, 3, 21), 1.20f, 400, "rica pan", 1.05f, Categoria.FRUTOSSECOS,
				"https://s1.eestatic.com/2015/03/24/cocinillas/Cocinillas_20507999_115826466_1024x576.jpg");
		Articulo a3 = new Articulo("agua", new Date(121, 3, 21), 1.20f, 400, "rica agua", 1.05f, Categoria.ZUMOS,
				"https://a2.soysuper.com/6691b3f472af6f9f7624ada9eea52250.1500.0.0.0.wmark.f4d7e9d0.jpg");
		Articulo a4 = new Articulo("Mandarina", new Date(121, 3, 21), 1.20f, 400, "rica mandarina", 1.05f,
				Categoria.FRUTAS,
				"https://static.eldiariomontanes.es/www/pre2017/multimedia/noticias/201610/15/media/cortadas/webmandarina-kQ6G-U203574520628HAH-575x323@Diario%20Montanes.jpg");

		/*
		 * manzana.setImage("src/main/java/imagenes/lechuga.png");
		 * lechuga.setImage("src/main/java/imagenes/lechuga.png");
		 * fresa.setImage("src/main/java/imagenes/lechuga.png");
		 * calabaza.setImage("src/main/java/imagenes/lechuga.png");
		 * pimiento.setImage("src/main/java/imagenes/lechuga.png");
		 * a1.setImage("src/main/java/imagenes/lechuga.png");
		 * a2.setImage("src/main/java/imagenes/lechuga.png");
		 * a3.setImage("src/main/java/imagenes/lechuga.png");
		 * a4.setImage("src/main/java/imagenes/lechuga.png");
		 */
		ArrayList<Cesta> listaCestas = new ArrayList<Cesta>();
		Integer cantidad1 = 400;
		Integer cantidad2 = 500;
		Integer cantidad3 = 300;
		Integer cantidad4 = 600;
		Opinion k = new Opinion("Me ha encantado la lechuga", 7, mikel);
		Opinion l = new Opinion("No me ha gusatdo el pimiento", 1, jokin);
		Opinion m = new Opinion("No estaba buena del todo la calabaza pero estaba fresca", 6, ibai);
		Opinion n = new Opinion("No estaban fresca del todo las fresas pero estaban buenas", 5, izai);
		Opinion o = new Opinion("Habeis hecho un excelente trabajo", 10, unai);
		Usuario mikelAdmin = new Usuario("mikel", "mikel");
		Usuario ibaiAdmin = new Usuario("ibai", "ibai");
		Usuario jokinAdmin = new Usuario("jokin", "jokin");
		Usuario izaiAdmin = new Usuario("izai", "izai");
		Usuario unaiAdmin = new Usuario("unai", "unai");
		Usuario admin = new Usuario("admin", "admin");
		Usuario lauraAdmin = new Usuario("laura", "laura");
		Usuario sofiaAdmin = new Usuario("sofia", "sofia");
		Usuario luciaAdmin = new Usuario("lucia", "lucia");
		Usuario henarAdmin = new Usuario("henar", "henar");

		ArrayList<Articulo> listaArticulos = new ArrayList<Articulo>();

		listaArticulos.add(a1);
		listaArticulos.add(a2);
		listaArticulos.add(a3);
		listaArticulos.add(a4);
		listaArticulos.add(lechuga);
		listaArticulos.add(pimiento);
		listaArticulos.add(fresa);
		listaArticulos.add(calabaza);
		listaArticulos.add(manzana);
		store(a1);
		store(a2);
		store(a3);
		store(a4);
		store(lechuga);
		store(pimiento);
		store(fresa);
		store(calabaza);
		store(manzana);

		ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
		listaUsuarios.add(mikelAdmin);
		listaUsuarios.add(ibaiAdmin);
		listaUsuarios.add(jokinAdmin);
		listaUsuarios.add(izaiAdmin);
		listaUsuarios.add(unaiAdmin);
		listaUsuarios.add(admin);
		listaUsuarios.add(lauraAdmin);
		listaUsuarios.add(sofiaAdmin);
		listaUsuarios.add(luciaAdmin);
		listaUsuarios.add(henarAdmin);
		store(mikelAdmin);
		store(ibaiAdmin);
		store(jokinAdmin);
		store(izaiAdmin);
		store(unaiAdmin);
		store(admin);
		store(lauraAdmin);
		store(sofiaAdmin);
		store(luciaAdmin);
		store(henarAdmin);

		ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();

		listaClientes.add(a);
		listaClientes.add(b);
		listaClientes.add(c);
		listaClientes.add(d);
		listaClientes.add(e);
		listaClientes.add(mikel);
		listaClientes.add(jokin);
		listaClientes.add(ibai);
		listaClientes.add(izai);
		listaClientes.add(unai);
		store(a);
		store(b);
		store(c);
		store(d);
		store(e);
		store(mikel);
		store(jokin);
		store(ibai);
		store(izai);
		store(unai);

		List<Articulo> listaArticulos1 = new ArrayList<Articulo>();
		List<Articulo> listaArticulos2 = new ArrayList<Articulo>();
		List<Integer> listaCantidades1 = new ArrayList<Integer>();
		List<Integer> listaCantidades2 = new ArrayList<Integer>();
		listaArticulos1.add(a1);
		listaArticulos1.add(a2);
		listaArticulos2.add(a3);
		listaArticulos2.add(a4);
		listaCantidades1.add(cantidad1);
		listaCantidades1.add(cantidad2);
		listaCantidades2.add(cantidad3);
		listaCantidades2.add(cantidad4);

		Cesta aa = new Cesta(listaArticulos1, listaCantidades1, Estado.ACTUAL);
		Cesta bb = new Cesta(listaArticulos2, listaCantidades2, Estado.ACTUAL);
		jokin.setCarrito(aa);
		jokin.setFavoritos(bb);
		store(jokin);
		store(aa);
		store(bb);

		ArrayList<Opinion> listaOpiniones = new ArrayList<Opinion>();
		ArrayList<Vendedor> listaVendedores = new ArrayList<Vendedor>();
		listaVendedores.add(f);
		listaVendedores.add(g);
		listaVendedores.add(h);
		listaVendedores.add(i);
		listaVendedores.add(j);
		store(f);
		store(g);
		store(h);
		store(i);
		store(j);

		listaOpiniones.add(k);
		listaOpiniones.add(l);
		listaOpiniones.add(m);
		listaOpiniones.add(n);
		listaOpiniones.add(o);
		store(k);
		store(l);
		store(m);
		store(n);
		store(o);
		logger.info("Todos los usuarios de prueba anyadidos");
		return "Todos los datos han sido anyadidos bien";

	}

	// No cerrar la conexion hasta cerrar el programa
	/**Metodo para desconectarnos de la conexion con la BBDD
	 * 
	 */
	public void closeConection() {
		logger.debug("Close conexion method access");
		pmf.close();
		logger.warn("Database closed");
	}

}