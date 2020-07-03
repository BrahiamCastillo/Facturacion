package dominio;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import datos.CRUD;

public class Contenedor {
	public static Statement st;
	public static PreparedStatement prepared;
	public static ResultSet resultado;
	
	public static void Insercion(String insert) throws SQLException {
		CRUD.Insert(insert);
		st=CRUD.st;
		
	}
	
	public static void Borrador(String delete) throws SQLException {
		CRUD.Delete(delete);
		prepared=CRUD.prepared;
	}
	
	public static void Actualizacion(String update) throws SQLException {
		CRUD.Update(update);
		prepared=CRUD.prepared;
	}
	
	public static void Consulta(String query) throws SQLException {
		CRUD.Query(query);
		st=CRUD.st;
		resultado=CRUD.resultado;
	}

}
