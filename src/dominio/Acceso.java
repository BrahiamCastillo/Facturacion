package dominio;

import java.sql.SQLException;

public class Acceso {
	protected int x=0;
	protected String[] idusuario, usuario, contraseña;
	
	public Acceso() {
		DataAcess();
	}
	
	public void DataAcess() {
		String query="SELECT * FROM acceso";
		try {
			Contenedor.Consulta(query);
			while(Contenedor.resultado.next()) {
				x=x+1;
			}
			Contenedor.resultado.close();
			Contenedor.st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		idusuario=new String[x];
		usuario=new String[x];
		contraseña=new String[x];
		try {
			Contenedor.Consulta(query);
			for(int f=0;f<x;f++) {
				if(Contenedor.resultado.next()) {
					idusuario[f]=Contenedor.resultado.getString("idusuario");
					usuario[f]=Contenedor.resultado.getString("usuario");
					contraseña[f]=Contenedor.resultado.getString("clave");
				}
			}
			Contenedor.resultado.close();
			Contenedor.st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
