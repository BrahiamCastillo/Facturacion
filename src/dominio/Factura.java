package dominio;

import java.sql.SQLException;

public class Factura {
	protected int x=0;
	protected String[] idfactura, codigo, idmercancia, cantidad;
	public static int contadorfactura;
	
	public Factura() {
		DataFactura();
	}
	
	public void DataFactura() {
		String query="SELECT * FROM factura";
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
		contadorfactura=x;
		idfactura=new String[x];
		codigo=new String[x];
		idmercancia=new String[x];
		cantidad=new String[x];
		try {
			Contenedor.Consulta(query);
			for(int f=0;f<x;f++) {
				if(Contenedor.resultado.next()) {
					idfactura[f]=Contenedor.resultado.getString("idfactura");
					codigo[f]=Contenedor.resultado.getString("codigo");
					idmercancia[f]=Contenedor.resultado.getString("idmercancia");
					cantidad[f]=Contenedor.resultado.getString("cantidad");
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
