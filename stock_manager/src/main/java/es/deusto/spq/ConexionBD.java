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


public class ConexionBD {
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

	public class DBconnection {
		private static String dbhost = "jdbc:mysql://localhost:3306/stock_managerDB";
		private static String username = "root";
		private static String password = "1234Clave";
		private static Connection conn;
		
		@SuppressWarnings("finally")
		public static Connection createNewDBconnection() {
			try  {	
				conn = DriverManager.getConnection(
						dbhost, username, password);	
			} catch (SQLException e) {
				System.out.println("Cannot create database connection");
				e.printStackTrace();
			} finally {
				return conn;	
			}		
		}
	}
	

}
