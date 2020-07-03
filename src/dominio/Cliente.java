package dominio;

import java.sql.SQLException;


public class Cliente {
	protected int x=0;
	protected String[] cedula, nombre, apellido, edad;
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
		cedula=new String[x];
		nombre=new String[x];
		apellido=new String[x];
		edad=new String[x];
		try {
			Contenedor.Consulta(query);
			for(int f=0;f<x;f++) {
				if(Contenedor.resultado.next()) {
					cedula[f]=Contenedor.resultado.getString("cedula");
					nombre[f]=Contenedor.resultado.getString("nombre");
					apellido[f]=Contenedor.resultado.getString("apellido");
					edad[f]=Contenedor.resultado.getString("edad");
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
