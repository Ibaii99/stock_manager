package es.deusto.spq;

import java.sql.Connection;
import es.deusto.spq.clases.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.logging.*;

import es.deusto.spq.clases.Articulo;
import es.deusto.spq.clases.Cesta;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
private String dbhost = "jdbc:mysql://localhost/stock_managerDB";
private String username = "root";
private String password = "1234Clave";
private static String bd = "stock_managerDB";
private Connection conn = null;

@SuppressWarnings("finally")
public Connection createNewDBconnection() {
	try  {	
		Class.forName("com.mysql.jdbc.Connection");
		conn = (Connection)DriverManager.getConnection(dbhost, username, password);	
		if(conn != null) {
			System.out.println("Conexion a base de datos " + dbhost +"....OK");
		}
	} catch (SQLException e) {
		System.out.println("Cannot create database connection");
		e.printStackTrace();
	} finally {
		return conn;	
	}		
}





/** Devuelve statement para usar la base de datos
 * @param con	Conexi�n ya creada y abierta a la base de datos
 * @return	sentencia de trabajo si se crea correctamente, null si hay cualquier error
 */
public static Statement usarBD(Connection conn ) {
	try {
		Statement statement = conn.createStatement();
		statement.setQueryTimeout(20); 
		return statement;
	} catch (SQLException e) {
		System.out.println("Cannot create database connection");
		e.printStackTrace();
		return null;
	}
}
public void insertArticulo(List<Articulo> articulos){
	String insertSQL = "INSERT INTO articulo VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
	try (PreparedStatement stmt = conn.prepareStatement(insertSQL)) {
		for (Articulo articulo : articulos) {
			stmt.setInt(1, articulo.getID());
			stmt.setString(2, articulo.getNombre());
			stmt.setDate(3, articulo.getCaducidad());
			stmt.setFloat(4, articulo.getPrecio());
			stmt.setInt(5, articulo.getStock());
			stmt.setString(6, articulo.getDescripcion());
			stmt.setFloat(7, articulo.getOferta());
			stmt.setString(8, articulo.getCategoria());
			stmt.executeUpdate();
		}
	} catch (SQLException e) {
		System.out.println(e);
        e.printStackTrace();
	}
}

<<<<<<< HEAD
public static ArrayList<Articulo> teclaSelectArticulo( Statement st) {
	String sentSQL = "";
	ArrayList<Articulo> articulos = new ArrayList();
=======
public void insertCesta(Cesta cesta){
	String insertSQL = "INSERT INTO cesta_compra VALUES(?, ?, ?)";
	try (PreparedStatement stmt = conn.prepareStatement(insertSQL)) {

		for (Map.Entry<Articulo, Integer> entry : cesta.getArticulos().entrySet()) {
			r += entry.getKey().getPrecio()*entry.getValue();

			for (Articulo articulo : cesta.getArticulos()) {
				stmt.setInt(1, articulo.getID());
				stmt.executeUpdate();
			}

		 }

		
	} catch (SQLException e) {
		System.out.println(e);
		System.out.println("Cannot create database connection");

		e.printStackTrace();
		return null;

        e.printStackTrace();

	}
}get.

public static int teclaSelectArticulo( Statement st) {
	String sentSQL = "";
>>>>>>> d977665afb968fdfbdf66f3835a84f5cf3dcfb0c
	try {
		sentSQL = "select * from articulo '";
		ResultSet rs = st.executeQuery( sentSQL );
		while(rs.next()) {
<<<<<<< HEAD
			int id = rs.getInt("ID");
		String nombre_Articulo = rs.getString("nombre");
		Date caducidad = rs.getDate("caducidad");
		float precio = rs.getFloat("precio");
		int stock = rs.getInt("stock");
		String descripcion = rs.getString("descripcion");
		float oferta = rs.getFloat("oferta");
		String categoria = rs.getString("categoria");		
		Articulo articulo = new Articulo(id,nombre_Articulo,caducidad,
		precio,stock,descripcion,oferta,categoria);
		articulos.add(articulo);
=======
			Date caducidad = rs.getDate("caducidad");
			...
			Articulo a = new Articulo(...);
>>>>>>> d977665afb968fdfbdf66f3835a84f5cf3dcfb0c
		}
	} catch (SQLException e) {
		System.out.println("Error en la bd");
		e.printStackTrace();
	}
<<<<<<< HEAD
	return articulos;
=======
	return rs;
>>>>>>> d977665afb968fdfbdf66f3835a84f5cf3dcfb0c
}

public void insertOferta(List<Oferta> ofertas){
	String insertSQL = "INSERT INTO oferta VALUES(?, ?, ?)";
	try (PreparedStatement stmt = conn.prepareStatement(insertSQL)) {
		for (Oferta oferta : ofertas) {
			stmt.setInt(1, oferta.getCodigo());
			stmt.setString(2, oferta.getNombre());
			stmt.setInt(3, oferta.getArticulo().getID());
			stmt.setString(4, oferta.getArticulo().getNombre());
			stmt.setDate(5, oferta.getArticulo().getCaducidad());
			stmt.setFloat(6, oferta.getArticulo().getPrecio());
			stmt.setInt(7, oferta.getArticulo().getStock());
			stmt.setString(8, oferta.getArticulo().getDescripcion());
			stmt.setFloat(9, oferta.getArticulo().getOferta());
			stmt.setString(10, oferta.getArticulo().getCategoria());
			
			stmt.executeUpdate();
		}
	} catch (SQLException e) {
		System.out.println("Cannot create database connection");
        e.printStackTrace();
	}
}

public static ArrayList<Oferta> teclaSelectOferta(Statement st) {
	String sentSQL = "";
	ArrayList<Oferta> ofertas = new ArrayList();
	try {
		sentSQL = "select * from oferta '";
		ResultSet rs = st.executeQuery( sentSQL );
		while(rs.next()) {
			int codigo = rs.getInt("codigo");
			String nombre = rs.getString("nombre"); 
		    int id = rs.getInt("ID");
		    String nombre_Articulo = rs.getString("nombre");
		    Date caducidad = rs.getDate("caducidad");
		    float precio = rs.getFloat("precio");
		    int stock = rs.getInt("stock");
		    String descripcion = rs.getString("descripcion");
		    float oferta = rs.getFloat("oferta");
		    String categoria = rs.getString("categoria");		
			Articulo articulo = new Articulo(id,nombre_Articulo,caducidad,
					precio,stock,descripcion,oferta,categoria);
			Oferta ofertaNew = new Oferta(codigo, nombre, articulo);
			ofertas.add(ofertaNew);
		}
		
	} catch (SQLException e) {
		System.out.println("Error en la bd");
		e.printStackTrace();

	}
	return ofertas;
}

public void insertPedido(List<Pedido> pedidos){
	String insertSQL = "INSERT INTO pedido VALUES(?, ?, ?)";
	try (PreparedStatement stmt = conn.prepareStatement(insertSQL)) {
		for (Pedido pedido : pedidos) {
			stmt.setInt(1, pedido.getCodigo_Pedido());
			stmt.setString(2, pedido.getProveedor_Pedido());
			stmt.setInt(3, pedido.getArticulo_Pedido().getID());
			stmt.setString(4, pedido.getArticulo_Pedido().getNombre());
			stmt.setDate(5, pedido.getArticulo_Pedido().getCaducidad());
			stmt.setFloat(6, pedido.getArticulo_Pedido().getPrecio());
			stmt.setInt(7, pedido.getArticulo_Pedido().getStock());
			stmt.setString(8, pedido.getArticulo_Pedido().getDescripcion());
			stmt.setFloat(9, pedido.getArticulo_Pedido().getOferta());
			stmt.setString(10, pedido.getArticulo_Pedido().getCategoria());
			stmt.executeUpdate();
		}
	} catch (SQLException e) {
		System.out.println("Cannot create database connection");
        e.printStackTrace();
	}
}

public static ArrayList<Pedido> teclaSelectPedido(Statement st) {
	String sentSQL = "";
	ArrayList<Pedido> pedidos = new ArrayList();
	try {
		sentSQL = "select * from pedido '";
		ResultSet rs = st.executeQuery( sentSQL );
		while(rs.next()) {
			int codigo_Pedido = rs.getInt("codigo_Pedido");
			String proveedorPedido = rs.getString("proveedor_Pedido");
			  int id = rs.getInt("ID");
			    String nombre_Articulo = rs.getString("nombre");
			    Date caducidad = rs.getDate("caducidad");
			    float precio = rs.getFloat("precio");
			    int stock = rs.getInt("stock");
			    String descripcion = rs.getString("descripcion");
			    float oferta = rs.getFloat("oferta");
			    String categoria = rs.getString("categoria");		
				Articulo articulo = new Articulo(id,nombre_Articulo,caducidad,
						precio,stock,descripcion,oferta,categoria);
			Pedido pedido = new Pedido(codigo_Pedido, proveedorPedido, articulo);
			pedidos.add(pedido);
		}
		
	} catch (SQLException e) {
		System.out.println("Error en la bd");
		e.printStackTrace();
	}
	return pedidos;
}

}
