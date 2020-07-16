package dominio;

import java.sql.SQLException;

public class Cliente {
	protected int x=0;
	protected String[] codigo, cedula, nombre, apellido, telefono;
	public static int contadorcliente;
	
	public Cliente() {
		DataClient();
	}
	
	public void DataClient() {
		String query="SELECT * FROM persona";
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
		contadorcliente=x;
		codigo=new String[x];
		cedula=new String[x];
		nombre=new String[x];
		apellido=new String[x];
		telefono=new String[x];
		try {
			Contenedor.Consulta(query);
			for(int f=0;f<x;f++) {
				if(Contenedor.resultado.next()) {
					codigo[f]=Contenedor.resultado.getString("codigo");
					cedula[f]=Contenedor.resultado.getString("cedula");
					nombre[f]=Contenedor.resultado.getString("nombre");
					apellido[f]=Contenedor.resultado.getString("apellido");
					telefono[f]=Contenedor.resultado.getString("telefono");
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
