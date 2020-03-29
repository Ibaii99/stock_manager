package es.deusto.spq;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.*;
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


}
