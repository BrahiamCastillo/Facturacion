package datos;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class Conexion {
	private static String username="root";
	private static String password="password";
	private static String driver="com.mysql.jdbc.Driver";
	private static String database="jdbc:mysql://localhost:3306/cliente";
	private static Connection conector;
	
	public static Connection Connected() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conector=(Connection) DriverManager.getConnection(database,username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conector;
	}

}
