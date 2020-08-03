package dominio;

import java.sql.SQLException;

public class Factura_De_Contado {
	protected int x=0;
	protected String[] idfactura, codigo, idmercancia, cantidad, subtotal, fecha, itbis, preciototal;
	public static int contadorfactura;
	
	public Factura_De_Contado() {
		DataFactura();
	}
	
	public void DataFactura() {
		String query="SELECT * FROM factura_contado";
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
		subtotal=new String[x];
		fecha=new String[x];
		itbis=new String[x];
		preciototal=new String[x];
		try {
			Contenedor.Consulta(query);
			for(int f=0;f<x;f++) {
				if(Contenedor.resultado.next()) {
					idfactura[f]=Contenedor.resultado.getString("idfactura");
					codigo[f]=Contenedor.resultado.getString("codigo");
					idmercancia[f]=Contenedor.resultado.getString("idmercancia");
					cantidad[f]=Contenedor.resultado.getString("cantidad");
					subtotal[f]=Contenedor.resultado.getString("subtotal");
					fecha[f]=Contenedor.resultado.getString("fecha");
					itbis[f]=Contenedor.resultado.getString("itbis");
					preciototal[f]=Contenedor.resultado.getString("preciototal");
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
