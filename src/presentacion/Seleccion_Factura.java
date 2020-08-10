package presentacion;

import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dominio.Contenedor;
import dominio.Factura_De_Contado;
import dominio.ICompletivo_Cliente;
import dominio.ICompletivo_Mercancia;
import presentacion.facturas.Factura_Contado;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridBagConstraints;

public class Seleccion_Factura extends Factura_De_Contado implements ICompletivo_Cliente, ICompletivo_Mercancia {

	private JFrame frmSeleccionarFactura;
	private JTable tablafactura;
	private DefaultTableModel modelofactura;
	private String[] campocedula, camponombre, campoapellido, campodireccion, campotelefono,
	campoclientecodigo;
	private String codigolocal, cedulalocal;
	private JPanel paneleste;
	private JButton btnAgregar;
	private int contadorcliente=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Seleccion_Factura window = new Seleccion_Factura();
					window.frmSeleccionarFactura.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Seleccion_Factura() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSeleccionarFactura = new JFrame();
		frmSeleccionarFactura.setTitle("Seleccionar Factura");
		frmSeleccionarFactura.setBounds(300, 300, 800, 200);
		frmSeleccionarFactura.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		modelofactura=new DefaultTableModel();
		modelofactura.addColumn("ID factura");
		modelofactura.addColumn("Cédula");
		codigolocal=codigo[0];
		Completivo();
		tablafactura = new JTable(modelofactura);
		JScrollPane jp=new JScrollPane(tablafactura);
		frmSeleccionarFactura.getContentPane().add(jp, BorderLayout.CENTER);
		
		paneleste = new JPanel();
		frmSeleccionarFactura.getContentPane().add(paneleste, BorderLayout.EAST);
		GridBagLayout gbl_paneleste = new GridBagLayout();
		gbl_paneleste.columnWidths = new int[]{0, 0};
		gbl_paneleste.rowHeights = new int[]{0, 0};
		gbl_paneleste.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_paneleste.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		paneleste.setLayout(gbl_paneleste);
		
		btnAgregar = new JButton("");
		btnAgregar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				CompletivoMercancia();	
			}
			
		});
		ImageIcon agregar=new ImageIcon(new ImageIcon("src/images/anadir.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
		btnAgregar.setIcon(agregar);
		GridBagConstraints gbc_btnAgregar = new GridBagConstraints();
		gbc_btnAgregar.insets=new Insets(5,5,5,5);
		gbc_btnAgregar.gridx = 0;
		gbc_btnAgregar.gridy = 0;
		gbc_btnAgregar.gridheight=2;
		gbc_btnAgregar.gridwidth=2;
		gbc_btnAgregar.fill=GridBagConstraints.BOTH;
		paneleste.add(btnAgregar, gbc_btnAgregar);
	}

	@Override
	public void Completivo() {
		String[] codigoc, cedulac, nombrec, apellidoc, telefonoc, direccionc;
		int y=0;
		// TODO Auto-generated method stub
		String query="SELECT * FROM persona";
		try {
			Contenedor.Consulta(query);
			while(Contenedor.resultado.next()) {
				y=y+1;
			}
			Contenedor.resultado.close();
			Contenedor.st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		contadorcliente=y;
		codigoc=new String[y];
		cedulac=new String[y];
		nombrec=new String[y];
		apellidoc=new String[y];
		telefonoc=new String[y];
		direccionc=new String[y];
		try {
			Contenedor.Consulta(query);
			for(int f=0;f<y;f++) {
				if(Contenedor.resultado.next()) {
					codigoc[f]=Contenedor.resultado.getString("codigo");
					cedulac[f]=Contenedor.resultado.getString("cedula");
					nombrec[f]=Contenedor.resultado.getString("nombre");
					apellidoc[f]=Contenedor.resultado.getString("apellido");
					telefonoc[f]=Contenedor.resultado.getString("telefono");
					direccionc[f]=Contenedor.resultado.getString("direccion");
				}
			}
			Contenedor.resultado.close();
			Contenedor.st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int f=0;f<y;f++) {
			if(codigolocal.equals(codigo[f])) {
				cedulalocal=cedulac[f];
		}
		
	  }
		String[] fila= {idfactura[0],cedulalocal};
		modelofactura.addRow(fila);
		campoclientecodigo=new String[y];
		campocedula=new String[y];
		camponombre=new String[y];
		campoapellido=new String[y];
		campodireccion=new String[y];
		campotelefono=new String[y];
		
		for(int f=1;f<x;f++) {
			for(int k=0;k<y;k++) {
				campoclientecodigo[k]=codigoc[k];
				campocedula[k]=cedulac[k];
				camponombre[k]=nombrec[k];
				campoapellido[k]=apellidoc[k];
				campodireccion[k]=direccionc[k];
				campotelefono[k]=telefonoc[k];
				if(codigo[f].equals(codigoc[k]) && idfactura[f].compareTo(idfactura[f-1])!=0) {
					String[] filam= {idfactura[f],cedulac[k]};
					modelofactura.addRow(filam);
				}
				
		    }
		
	 }
  }

	@Override
	public void CompletivoMercancia() {
		// TODO Auto-generated method stub
		String[] idmercanciam, mercanciam, preciorecolectorm;
		Double[] preciom;
		int y = 0;
		String query="SELECT * FROM mercancia";
		try {
			Contenedor.Consulta(query);
			while(Contenedor.resultado.next()) {
				y=y+1;
			}
			Contenedor.resultado.close();
			Contenedor.st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		idmercanciam=new String[y];
		mercanciam=new String[y];
		preciorecolectorm=new String[y];
		preciom=new Double[y];
		try {
			Contenedor.Consulta(query);
			for(int f=0;f<y;f++) {
				if(Contenedor.resultado.next()) {
					idmercanciam[f]=Contenedor.resultado.getString("idmercancia");
					mercanciam[f]=Contenedor.resultado.getString("mercancia");
					preciorecolectorm[f]=Contenedor.resultado.getString("precio");
					preciom[f]=(Double) Double.parseDouble(preciorecolectorm[f]);
				}
			}
			Contenedor.resultado.close();
			Contenedor.st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int seleccion=tablafactura.getSelectedRow();
		if(seleccion<0) {
			JOptionPane.showMessageDialog(null, "Debe seleccionar una fila", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			Factura_Contado.textfactura.setText((String) modelofactura.getValueAt(seleccion, 0));
			Factura_Contado.textcedula.setText((String) modelofactura.getValueAt(seleccion, 1));
		}
		for(int k=0;k<x;k++) {
			for(int f=0;f<y;f++) {
				if(idfactura[k].equals(modelofactura.getValueAt(seleccion, 0)) && idmercancia[k].equals(idmercanciam[f])) {
					String[] filamerca= {idmercancia[k],mercanciam[f],cantidad[k],preciorecolectorm[f],subtotal[k]};
					Factura_Contado.modelo.addRow(filamerca);
					Factura_Contado.textitbis.setText(itbis[k]);
					Factura_Contado.textsubtotal.setText(precioparcial[k]);
					Factura_Contado.texttotal.setText(preciototal[k]);
				}
				for(int c=0;c<contadorcliente;c++) {
					if(campocedula[c].equals(modelofactura.getValueAt(seleccion, 1))) {
						Factura_Contado.textcodigo.setText(campoclientecodigo[c]);
						Factura_Contado.textnombre.setText(camponombre[c]);
						Factura_Contado.textapellido.setText(campoapellido[c]);
						Factura_Contado.textdireccion.setText(campodireccion[c]);
						Factura_Contado.texttelefono.setText(campotelefono[c]);

					}
				}
			}
		}
		Factura_Contado.btnGuardar.setEnabled(false);
		Factura_Contado.btnActualizar.setEnabled(false);
		frmSeleccionarFactura.dispose();
	}

}
