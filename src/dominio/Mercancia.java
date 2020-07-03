package dominio;

import java.sql.SQLException;

public class Mercancia {
	protected int x=0;
	protected String[] idmercancia, mercancia, preciorecolector;
	protected float[] precio;
	public static int contadormercancia;
	
	public Mercancia() {
		ProductData();
	}
	
	public void ProductData() {
		String query="SELECT * FROM mercancia";
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
		contadormercancia=x;
		idmercancia=new String[x];
		mercancia=new String[x];
		preciorecolector=new String[x];
		precio=new float[x];
		try {
			Contenedor.Consulta(query);
			for(int f=0;f<x;f++) {
				if(Contenedor.resultado.next()) {
					idmercancia[f]=Contenedor.resultado.getString("idmercancia");
					mercancia[f]=Contenedor.resultado.getString("mercancia");
					preciorecolector[f]=Contenedor.resultado.getString("precio");
					precio[f]=Float.parseFloat(preciorecolector[f]);
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
