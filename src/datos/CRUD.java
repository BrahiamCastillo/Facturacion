
package datos;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class CRUD {
	public static Statement st;
	public static PreparedStatement prepared;
	public static ResultSet resultado;
	
	public static void Insert(String insert) throws SQLException {
		st=(Statement) Conexion.Connected().createStatement();
		if(st.executeUpdate(insert)>1) {
			JOptionPane.showMessageDialog(null, "El ingreso ha sido exitoso.");
		}
	}
	
	public static void Delete(String delete) throws SQLException {
		prepared=(PreparedStatement) Conexion.Connected().prepareStatement(delete);
		prepared.execute();
	}
	
	public static void Update(String update) throws SQLException {
		prepared=(PreparedStatement) Conexion.Connected().prepareStatement(update);
		prepared.executeUpdate();
	}
	
	public static void Query(String query) throws SQLException {
		st=(Statement) Conexion.Connected().createStatement();
		resultado=st.executeQuery(query);
	}

}
