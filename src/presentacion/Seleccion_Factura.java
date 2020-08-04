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
	private String[] campoidfactura, campocodigo, campocedula, camponombre, campoapellido, campodireccion, campotelefono, 
	campoidmercancia, campomercancia, campoprecio;
	private String codigolocal, cedulalocal;
	private JPanel paneleste;
	private JButton btnAgregar;

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
		campoidfactura=new String[x];
		campocedula=new String[x];
		campocodigo=new String[x];
		campoidmercancia=new String[x];
		campoprecio=new String[x];
		campomercancia=new String[x];
		for(int f=1;f<x;f++) {
			if(idfactura[f].compareTo(idfactura[f-1])!=0) {
				campocodigo[f]=codigo[f];
			}
		}
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
		String[] codigo, cedula, nombre, apellido, telefono, direccion;
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
		codigo=new String[y];
		cedula=new String[y];
		nombre=new String[y];
		apellido=new String[y];
		telefono=new String[y];
		direccion=new String[y];
		try {
			Contenedor.Consulta(query);
			for(int f=0;f<y;f++) {
				if(Contenedor.resultado.next()) {
					codigo[f]=Contenedor.resultado.getString("codigo");
					cedula[f]=Contenedor.resultado.getString("cedula");
					nombre[f]=Contenedor.resultado.getString("nombre");
					apellido[f]=Contenedor.resultado.getString("apellido");
					telefono[f]=Contenedor.resultado.getString("telefono");
					direccion[f]=Contenedor.resultado.getString("direccion");
				}
			}
			Contenedor.resultado.close();
			Contenedor.st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		camponombre=new String[y];
		campoapellido=new String[y];
		campodireccion=new String[y];
		campotelefono=new String[y];
		for(int f=0;f<y;f++) {
			if(codigolocal.equals(codigo[f])) {
				cedulalocal=cedula[f];
		}
		
	  }
		String[] fila= {idfactura[0],cedulalocal};
		modelofactura.addRow(fila);
		for(int f=1;f<x;f++) {
			for(int k=0;k<y;k++) {
				if(codigo[k].equals(campocodigo[f])) {
					campocodigo[f]=codigo[k];
					campocedula[f]=cedula[k];
					camponombre[k]=nombre[k];
					campoapellido[k]=apellido[k];
					campodireccion[k]=direccion[k];
					campotelefono[k]=telefono[k];
				}
				if(idfactura[f].compareTo(idfactura[f-1])!=0) {
					campoidfactura[f]=idfactura[f];
					String[] filaparcial= {campoidfactura[f],campocedula[f]};
					modelofactura.addRow(filaparcial);
				}
			}
		}
  }

	@Override
	public void CompletivoMercancia() {
		// TODO Auto-generated method stub
		String[] idmercancia, mercancia, preciorecolector;
		Double[] precio;
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
		idmercancia=new String[y];
		mercancia=new String[y];
		preciorecolector=new String[y];
		precio=new Double[y];
		try {
			Contenedor.Consulta(query);
			for(int f=0;f<y;f++) {
				if(Contenedor.resultado.next()) {
					idmercancia[f]=Contenedor.resultado.getString("idmercancia");
					mercancia[f]=Contenedor.resultado.getString("mercancia");
					preciorecolector[f]=Contenedor.resultado.getString("precio");
					precio[f]=(Double) Double.parseDouble(preciorecolector[f]);
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
			for(int f=0;f<x;f++) {
				for(int k=0;k<y;k++) {
					if(idfactura[f].equals(modelofactura.getValueAt(seleccion, 0)) && codigo[f].equals(campocodigo[k])) {
						campoidmercancia[f]=idmercancia[f];
					}
				}
			}
			for(int f=0;f<x;f++) {
				for(int k=0;k<y;k++) {
					if(idmercancia[k].equals(campoidmercancia[f])) {
						campomercancia[k]=mercancia[k];
						campoprecio[k]=preciorecolector[k];
						String[] fila= {campoidmercancia[f],campomercancia[f],cantidad[f],campoprecio[f],subtotal[f]};
						Factura_Contado.modelo.addRow(fila);
						Factura_Contado.textcodigo.setText(codigo[f]);
						Factura_Contado.textnombre.setText(camponombre[f]);
						Factura_Contado.textapellido.setText(campoapellido[f]);
						Factura_Contado.texttelefono.setText(campotelefono[f]);
						Factura_Contado.textdireccion.setText(campodireccion[f]);
						Factura_Contado.textitbis.setText(itbis[f]);
						Factura_Contado.textsubtotal.setText(subtotal[f]);
						Factura_Contado.texttotal.setText(preciototal[f]);
						Factura_Contado.btnGuardar.setEnabled(false);
						frmSeleccionarFactura.dispose();
					}
				}
			}
			
		}
		
		
	}

}
