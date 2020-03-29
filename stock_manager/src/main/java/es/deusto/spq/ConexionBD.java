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
	
		private static final String dbhost = "jdbc:mysql://localhost:3306/stock_ managerDB";
		private static final String username = "root";
		private static final String password = "1234Clave";
		private Connection conn;
		
		@SuppressWarnings("finally")
		public Connection createNewDBconnection() {
			try  {	
				conn = DriverManager.getConnection(
						dbhost, username, password);	
			} catch (final SQLException e) {
				System.out.println("Cannot create database connection");
				e.printStackTrace();
			} finally {
				return conn;	
			}		
		}	

}
