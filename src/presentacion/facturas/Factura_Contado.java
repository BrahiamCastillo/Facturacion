package presentacion.facturas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dominio.Contenedor;
import dominio.Factura_De_Contado;
import presentacion.Acceso_Usuario;
import presentacion.Seleccion_Cliente;
import presentacion.Seleccion_Factura;
import presentacion.Seleccion_Mercancia;

import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;

public class Factura_Contado extends Factura_De_Contado {

	private JFrame frmFacturaContado;
	public static JButton btnGuardar, btnActualizar, btnRemover, btnAgregar;
	public static JTable table;
	public static JLabel lblfecha;
	public static JTextField textitbis;
	public static JTextField textsubtotal;
	public static JTextField texttotal;
	public static DefaultTableModel modelo;
	public static JTextField textfactura, textcodigo, textnombre, textapellido, textcedula, textdireccion, texttelefono;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Factura_Contado window = new Factura_Contado();
					window.frmFacturaContado.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Factura_Contado() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFacturaContado = new JFrame();
		frmFacturaContado.setTitle("Factura Contado");
		frmFacturaContado.setIconImage(Toolkit.getDefaultToolkit().getImage(Factura_Contado.class.getResource("/images/comedor.png")));
		frmFacturaContado.setBounds(150, 100, 1200, 640);
		frmFacturaContado.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		modelo=new DefaultTableModel();
		Border blackline=BorderFactory.createLineBorder(Color.BLACK);
		
		JPanel panelnorte = new JPanel();
		panelnorte.setBorder(blackline);
		frmFacturaContado.getContentPane().add(panelnorte, BorderLayout.NORTH);
		GridBagLayout gbl_panelnorte = new GridBagLayout();
		gbl_panelnorte.columnWidths = new int[]{310, 92, 102, 66, 0};
		gbl_panelnorte.rowHeights = new int[]{25, 0};
		gbl_panelnorte.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelnorte.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelnorte.setLayout(gbl_panelnorte);
		
		btnGuardar = new JButton("");
		btnGuardar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int res=JOptionPane.showConfirmDialog(null, "¿ Desea grabar los datos ?","Confirmación",JOptionPane.YES_NO_CANCEL_OPTION);
				if(JOptionPane.YES_OPTION==res) {
					Date fecha=new Date();
				    String formatofecha = "hh: mm: ss a dd-MMM-yyyy";
					SimpleDateFormat fechaform=new SimpleDateFormat(formatofecha);
					String fechacompleta=fechaform.format(fecha);
					int filatotal=modelo.getRowCount();
					if(filatotal<1) {
						for(int f=0;f<filatotal;f++) {
							JOptionPane.showMessageDialog(null, "Debe llenar la tabla y los clientes","Error",JOptionPane.ERROR_MESSAGE);
						}
					} else {
						for(int f=0;f<filatotal;f++) {
							String insert="INSERT INTO factura_contado(idfactura,codigo,idmercancia,cantidad,subtotal,precioparcial,fecha,itbis,preciototal,idusuario) "
									+"VALUES ('"+textfactura.getText()+"','"+textcodigo.getText()+"','"+modelo.getValueAt(f, 0)+"',"
									+"'"+modelo.getValueAt(f, 2)+"','"+modelo.getValueAt(f, 4)+"','"+textsubtotal.getText()+"','"+fechacompleta+"','"+textitbis.getText()+"',"
									+"'"+texttotal.getText()+"','"+Acceso_Usuario.idingreso+"')";
							
							try {
								Contenedor.Insercion(insert);
								Contenedor.st.close();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					}
						JOptionPane.showMessageDialog(null, "Los datos fueron almacenados con éxito","Afirmación",JOptionPane.INFORMATION_MESSAGE);
						btnGuardar.setEnabled(false);
				
				}
			}
		  }
			
		});
		ImageIcon guardar=new ImageIcon(new ImageIcon("src/images/guardar.png").getImage().getScaledInstance(170, 100, Image.SCALE_DEFAULT));
		btnGuardar.setIcon(guardar);
		GridBagConstraints gbc_btnguardar = new GridBagConstraints();
		gbc_btnguardar.insets = new Insets(4, 4, 4, 4);
		gbc_btnguardar.gridx = 0;
		gbc_btnguardar.gridy = 0;
		gbc_btnguardar.gridheight=1;
		gbc_btnguardar.gridwidth=1;
		gbc_btnguardar.fill=GridBagConstraints.BOTH;
		panelnorte.add(btnGuardar, gbc_btnguardar);
		
		JButton btnImprimir = new JButton("");
		ImageIcon impresion=new ImageIcon(new ImageIcon("src/images/impresion.png").getImage().getScaledInstance(170, 100, Image.SCALE_DEFAULT));
		btnImprimir.setIcon(impresion);
		GridBagConstraints gbc_btnimprimir = new GridBagConstraints();
		gbc_btnimprimir.insets = new Insets(4, 4, 4, 4);
		gbc_btnimprimir.gridx = 1;
		gbc_btnimprimir.gridy = 0;
		gbc_btnimprimir.gridheight=1;
		gbc_btnimprimir.gridwidth=1;
		gbc_btnimprimir.fill=GridBagConstraints.BOTH;
		panelnorte.add(btnImprimir, gbc_btnimprimir);
		
		btnActualizar = new JButton("");
		btnActualizar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Seleccion_Factura.main(null);
			}
			
		});
		ImageIcon actualizar=new ImageIcon(new ImageIcon("src/images/actualizar.png").getImage().getScaledInstance(170, 100, Image.SCALE_DEFAULT));
		btnActualizar.setIcon(actualizar);
		GridBagConstraints gbc_btnActualizar = new GridBagConstraints();
		gbc_btnActualizar.insets = new Insets(4, 4, 4, 4);
		gbc_btnActualizar.gridx = 6;
		gbc_btnActualizar.gridy = 0;
		gbc_btnActualizar.gridheight=1;
		gbc_btnActualizar.gridwidth=1;
		gbc_btnActualizar.fill=GridBagConstraints.BOTH;
		panelnorte.add(btnActualizar, gbc_btnActualizar);
		
		JButton btnSalir = new JButton("");
		btnSalir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int res=JOptionPane.showConfirmDialog(null, "¿ Desea salir de la facturación ?","Confirmación",JOptionPane.YES_NO_CANCEL_OPTION);
				if(JOptionPane.YES_OPTION==res) {
					frmFacturaContado.dispose();
				}
			}
			
		});
		ImageIcon salir=new ImageIcon(new ImageIcon("src/images/exit.png").getImage().getScaledInstance(170, 100, Image.SCALE_DEFAULT));
		btnSalir.setIcon(salir);
		GridBagConstraints gbc_btsalir = new GridBagConstraints();
		gbc_btsalir.insets = new Insets(4, 4, 4, 4);
		gbc_btsalir.gridx = 9;
		gbc_btsalir.gridy = 0;
		gbc_btsalir.gridheight=1;
		gbc_btsalir.gridwidth=1;
		gbc_btsalir.fill=GridBagConstraints.BOTH;
		panelnorte.add(btnSalir, gbc_btsalir);
		
		JPanel panelcentral = new JPanel();
		frmFacturaContado.getContentPane().add(panelcentral, BorderLayout.CENTER);
		GridBagLayout gbl_panelcentral = new GridBagLayout();
		gbl_panelcentral.columnWidths = new int[]{0, 0};
		gbl_panelcentral.rowHeights = new int[]{0, 0, 0};
		gbl_panelcentral.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelcentral.rowWeights = new double[]{0.0, Double.MIN_VALUE, 0.0};
		panelcentral.setLayout(gbl_panelcentral);
		
		lblfecha = new JLabel("");
		GridBagConstraints gbc_lblfecha = new GridBagConstraints();
		gbc_lblfecha.insets = new Insets(5, 5, 5, 5);
		gbc_lblfecha.gridx = 0;
		gbc_lblfecha.gridy = 0;
		gbc_lblfecha.gridwidth=2;
		panelcentral.add(lblfecha, gbc_lblfecha);
		Date fecha=new Date();
	    String formatofecha = "hh: mm: ss a dd-MMM-yyyy";
		SimpleDateFormat fechaform=new SimpleDateFormat(formatofecha);
		String fechacompleta=fechaform.format(fecha);
		lblfecha.setText(fechacompleta);
		
		modelo.addColumn("ID-Mercancía");
		modelo.addColumn("Mercancía");
		modelo.addColumn("Cantidad");
		modelo.addColumn("Precio unitario");
		modelo.addColumn("Precio total");
		table = new JTable(modelo);
		JScrollPane sp=new JScrollPane(table);
		GridBagConstraints gbc_JScrollsp = new GridBagConstraints();
		gbc_JScrollsp.insets = new Insets(5, 5, 5, 5);
		gbc_JScrollsp.gridx = 0;
		gbc_JScrollsp.gridy = 1;
		gbc_JScrollsp.gridheight=2;
		gbc_JScrollsp.gridwidth=2;
		gbc_JScrollsp.fill=GridBagConstraints.BOTH;
		panelcentral.add(sp, gbc_JScrollsp);
		
		JPanel paneleste = new JPanel();
		frmFacturaContado.getContentPane().add(paneleste, BorderLayout.EAST);
		GridBagLayout gbl_paneleste = new GridBagLayout();
		gbl_paneleste.columnWidths = new int[]{0, 0};
		gbl_paneleste.rowHeights = new int[]{0, 0, 0};
		gbl_paneleste.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_paneleste.rowWeights = new double[]{0.0, Double.MIN_VALUE, 0.0};
		paneleste.setLayout(gbl_paneleste);
		
		btnAgregar = new JButton("");
		btnAgregar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Seleccion_Mercancia.main(null);
			}
			
		});
		ImageIcon agregar=new ImageIcon(new ImageIcon("src/images/anadir.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
		btnAgregar.setIcon(agregar);
		GridBagConstraints gbc_btnAgregar = new GridBagConstraints();
		gbc_btnAgregar.insets = new Insets(5, 5, 5, 5);
		gbc_btnAgregar.gridx = 0;
		gbc_btnAgregar.gridy = 0;
		gbc_btnAgregar.gridheight=2;
		gbc_btnAgregar.gridwidth=2;
		gbc_btnAgregar.fill=GridBagConstraints.BOTH;
		paneleste.add(btnAgregar, gbc_btnAgregar);
		
		btnRemover = new JButton("");
		btnRemover.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int seleccion=table.getSelectedRow();
				if(seleccion<0) {
					JOptionPane.showMessageDialog(null, "Debe seleccionar una fila", "Error", JOptionPane.ERROR_MESSAGE);
				}else {
					float preciototal1=Float.parseFloat((String) modelo.getValueAt(seleccion, 4));
					float itbis1=(float) (preciototal1*0.18);
					float subtotal1=preciototal1-itbis1;
					float preciototal=Float.parseFloat(texttotal.getText())-preciototal1-itbis1;
					float itbis=Float.parseFloat(textitbis.getText())-itbis1;
					float subtotal=Float.parseFloat(textsubtotal.getText())-subtotal1-itbis1;
					texttotal.setText(Float.toString(preciototal));
					textitbis.setText(Float.toString(itbis));
					textsubtotal.setText(Float.toString(subtotal));
					modelo.removeRow(seleccion);
				}
			}
			
		});
		ImageIcon eliminar=new ImageIcon(new ImageIcon("src/images/eliminar.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
		btnRemover.setIcon(eliminar);
		GridBagConstraints gbc_btnRemover = new GridBagConstraints();
		gbc_btnRemover.insets = new Insets(5, 5, 5, 5);
		gbc_btnRemover.gridx = 2;
		gbc_btnRemover.gridy = 0;
		gbc_btnRemover.gridheight=2;
		gbc_btnRemover.gridwidth=2;
		gbc_btnRemover.fill=GridBagConstraints.BOTH;
		paneleste.add(btnRemover, gbc_btnRemover);
		
		JPanel panelsur = new JPanel();
		frmFacturaContado.getContentPane().add(panelsur, BorderLayout.SOUTH);
		panelsur.setLayout(new BoxLayout(panelsur, BoxLayout.Y_AXIS));
		
		JSeparator separator = new JSeparator();
		panelsur.add(separator);
		
		JPanel panelcampos = new JPanel();
		panelsur.add(panelcampos);
		
		JPanel panel1 = new JPanel();
		panel1.setBorder(blackline);
		panelcampos.add(panel1);
		
		JLabel lblItbis = new JLabel("ITBIS:");
		panel1.add(lblItbis);
		
		textitbis = new JTextField();
		textitbis.setEnabled(false);
		panel1.add(textitbis);
		textitbis.setColumns(10);
		
		JPanel panel2 = new JPanel();
		panel2.setBorder(blackline);
		panelcampos.add(panel2);
		
		JLabel lblSubtotal = new JLabel("Subtotal:");
		panel2.add(lblSubtotal);
		
		textsubtotal = new JTextField();
		panel2.add(textsubtotal);
		textsubtotal.setColumns(10);
		
		JPanel panel3 = new JPanel();
		panel3.setBorder(blackline);
		panelcampos.add(panel3);
		
		JLabel lblTotal = new JLabel("Total");
		panel3.add(lblTotal);
		
		texttotal = new JTextField();
		panel3.add(texttotal);
		texttotal.setColumns(10);
		
		JPanel paneloeste = new JPanel();
		frmFacturaContado.getContentPane().add(paneloeste, BorderLayout.WEST);
		GridBagLayout gbl_paneloeste = new GridBagLayout();
		gbl_paneloeste.columnWidths = new int[]{0, 0};
		gbl_paneloeste.rowHeights = new int[]{0, 0, 0, 0};
		gbl_paneloeste.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_paneloeste.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE, 0.0};
		paneloeste.setLayout(gbl_paneloeste);
		
		JLabel lblNofactura = new JLabel("No.Factura:");
		GridBagConstraints gbc_lblNofactura = new GridBagConstraints();
		gbc_lblNofactura.insets = new Insets(5, 5, 5, 2);
		gbc_lblNofactura.gridx = 0;
		gbc_lblNofactura.gridy = 0;
		paneloeste.add(lblNofactura, gbc_lblNofactura);
		
		textfactura = new JTextField();
		Random r=new Random();
		int number=r.nextInt(999999998)+1;
		while(number<1000) {
			number=r.nextInt(999999998)+1;
			for(int f=0;f<x;f++) {
				int factura=Integer.parseInt(idfactura[f]);
				while(number==factura) {
					number=r.nextInt(999999998)+1;
				}
			}
		}
		String numero=Integer.toString(number);
		textfactura.setText(numero);
		textfactura.setEnabled(false);
		GridBagConstraints gbc_textfactura = new GridBagConstraints();
		gbc_textfactura.insets = new Insets(5, 5, 5, 4);
		gbc_textfactura.fill = GridBagConstraints.HORIZONTAL;
		gbc_textfactura.gridx = 2;
		gbc_textfactura.gridy = 0;
		paneloeste.add(textfactura, gbc_textfactura);
		textfactura.setColumns(10);
		
		JButton btnlimpiar = new JButton("");
		btnlimpiar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int res=JOptionPane.showConfirmDialog(null, "¿ Desea limpiar los campos del cliente ?","Confirmación",JOptionPane.YES_NO_CANCEL_OPTION);
				if(JOptionPane.YES_OPTION==res) {
					textcodigo.setText("");
					textcedula.setText("");
					textnombre.setText("");
					textapellido.setText("");
					textdireccion.setText("");
					texttelefono.setText("");
				}
			}
			
		});
		btnlimpiar.setIcon(eliminar);
		GridBagConstraints gbc_btnLimpiar = new GridBagConstraints();
		gbc_btnLimpiar.insets = new Insets(5, 5, 5, 4);
		gbc_btnLimpiar.gridx = 0;
		gbc_btnLimpiar.gridy = 1;
		gbc_btnLimpiar.gridheight=2;
		gbc_btnLimpiar.gridwidth=2;
		gbc_btnLimpiar.fill=GridBagConstraints.BOTH;
		paneloeste.add(btnlimpiar, gbc_btnLimpiar);
		
		JButton btnAadir = new JButton("");
		btnAadir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Seleccion_Cliente.main(null);
			}
			
		});
		btnAadir.setIcon(agregar);
		GridBagConstraints gbc_btnAadir = new GridBagConstraints();
		gbc_btnAadir.insets = new Insets(5, 5, 5, 4);
		gbc_btnAadir.gridx = 2;
		gbc_btnAadir.gridy = 1;
		gbc_btnAadir.gridheight=2;
		gbc_btnAadir.gridwidth=2;
		gbc_btnAadir.fill=GridBagConstraints.BOTH;
		paneloeste.add(btnAadir, gbc_btnAadir);
		
		JLabel lblCdigo = new JLabel("Código:");
		GridBagConstraints gbc_lblCdigo = new GridBagConstraints();
		gbc_lblCdigo.insets = new Insets(5, 5, 5, 2);
		gbc_lblCdigo.gridx = 0;
		gbc_lblCdigo.gridy = 3;
		paneloeste.add(lblCdigo, gbc_lblCdigo);
		
		textcodigo = new JTextField();
		GridBagConstraints gbc_codigo = new GridBagConstraints();
		gbc_codigo.insets = new Insets(5, 5, 5, 4);
		gbc_codigo.fill = GridBagConstraints.HORIZONTAL;
		gbc_codigo.gridx = 2;
		gbc_codigo.gridy = 3;
		paneloeste.add(textcodigo, gbc_codigo);
		textfactura.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblnombre = new GridBagConstraints();
		gbc_lblnombre.insets = new Insets(5, 5, 5, 2);
		gbc_lblnombre.gridx = 0;
		gbc_lblnombre.gridy = 4;
		paneloeste.add(lblNombre, gbc_lblnombre);
		
		textnombre = new JTextField();
		GridBagConstraints gbc_textnombre = new GridBagConstraints();
		gbc_textnombre.insets = new Insets(5, 5, 5, 4);
		gbc_textnombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textnombre.gridx = 2;
		gbc_textnombre.gridy = 4;
		paneloeste.add(textnombre, gbc_textnombre);
		textfactura.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido:");
		GridBagConstraints gbc_lblapellido = new GridBagConstraints();
		gbc_lblapellido.insets = new Insets(5, 5, 5, 2);
		gbc_lblapellido.gridx = 0;
		gbc_lblapellido.gridy = 5;
		paneloeste.add(lblApellido, gbc_lblapellido);
		
		textapellido = new JTextField();
		GridBagConstraints gbc_textapellido = new GridBagConstraints();
		gbc_textapellido.insets = new Insets(5, 5, 5, 4);
		gbc_textapellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_textapellido.gridx = 2;
		gbc_textapellido.gridy = 5;
		paneloeste.add(textapellido, gbc_textapellido);
		textfactura.setColumns(10);
		
		JLabel lblCedula = new JLabel("Cédula:");
		GridBagConstraints gbc_lblcedula = new GridBagConstraints();
		gbc_lblcedula.insets = new Insets(5, 5, 5, 2);
		gbc_lblcedula.gridx = 0;
		gbc_lblcedula.gridy = 6;
		paneloeste.add(lblCedula, gbc_lblcedula);
		
		textcedula = new JTextField();
		GridBagConstraints gbc_textcedula = new GridBagConstraints();
		gbc_textcedula.insets = new Insets(5, 5, 5, 4);
		gbc_textcedula.fill = GridBagConstraints.HORIZONTAL;
		gbc_textcedula.gridx = 2;
		gbc_textcedula.gridy = 6;
		paneloeste.add(textcedula, gbc_textcedula);
		textfactura.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Dirección:");
		GridBagConstraints gbc_lbldireccion = new GridBagConstraints();
		gbc_lbldireccion.insets = new Insets(5, 5, 5, 2);
		gbc_lbldireccion.gridx = 0;
		gbc_lbldireccion.gridy = 7;
		paneloeste.add(lblDireccion, gbc_lbldireccion);
		
		textdireccion = new JTextField();
		GridBagConstraints gbc_textdireccion = new GridBagConstraints();
		gbc_textdireccion.insets = new Insets(5, 5, 5, 4);
		gbc_textdireccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_textdireccion.gridx = 2;
		gbc_textdireccion.gridy = 7;
		paneloeste.add(textdireccion, gbc_textdireccion);
		textfactura.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Teléfono:");
		GridBagConstraints gbc_lbltelefono = new GridBagConstraints();
		gbc_lbltelefono.insets = new Insets(5, 5, 5, 2);
		gbc_lbltelefono.gridx = 0;
		gbc_lbltelefono.gridy = 8;
		paneloeste.add(lblTelefono, gbc_lbltelefono);
		
		texttelefono = new JTextField();
		GridBagConstraints gbc_texttelefono = new GridBagConstraints();
		gbc_texttelefono.insets = new Insets(5, 5, 5, 4);
		gbc_texttelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_texttelefono.gridx = 2;
		gbc_texttelefono.gridy = 8;
		paneloeste.add(texttelefono, gbc_texttelefono);
		textfactura.setColumns(10);
		
	}

}
