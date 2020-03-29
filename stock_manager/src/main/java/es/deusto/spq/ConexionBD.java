package es.deusto.spq;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
public static Statement usarBD(conn ) {
	try {
		Statement statement = con.createStatement();
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
			stmt.executeUpdate();
		}
	} catch (SQLException e) {
		System.out.println(e);
        e.printStackTrace();
	}
}

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
        e.printStackTrace();
	}
}

public static int teclaSelect( Statement st) {
	String sentSQL = "";
	try {
		sentSQL = "select * from articulo '";
		ResultSet rs = st.executeQuery( sentSQL );
	} catch (SQLException e) {
		System.out.println("Error en la bd");
		e.printStackTrace();
	}
}






}
