package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dominio.Cliente;
import presentacion.facturas.Factura_Contado;

import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Seleccion_Cliente extends Cliente {

	private JFrame frmSeleccionarCliente;
	public static DefaultTableModel modelocliente;
	private JTable tablacliente;
	private JPanel paneleste;
	private JButton btnAgregar;
	private JPanel panelsur;
	private JLabel lblSeleccioneElFiltro;
	private JComboBox<String> combofiltro;
	private JTextField textfiltro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Seleccion_Cliente window = new Seleccion_Cliente();
					window.frmSeleccionarCliente.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Seleccion_Cliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSeleccionarCliente = new JFrame();
		frmSeleccionarCliente.setIconImage(Toolkit.getDefaultToolkit().getImage(Seleccion_Cliente.class.getResource("/images/comedor.png")));
		frmSeleccionarCliente.setTitle("Seleccionar Cliente");
		frmSeleccionarCliente.setBounds(300, 300, 800, 200);
		frmSeleccionarCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		modelocliente=new DefaultTableModel();
		modelocliente.addColumn("Código");
		modelocliente.addColumn("Cédula");
		modelocliente.addColumn("Nombre");
		modelocliente.addColumn("Apellido");
		modelocliente.addColumn("Dirección");
		modelocliente.addColumn("Teléfono");
		for(int f=0;f<x;f++) {
			String[] fila= { codigo[f], cedula[f], nombre[f], apellido[f], telefono[f], direccion[f]};
			modelocliente.addRow(fila);
		}
		tablacliente = new JTable(modelocliente);
		tablacliente.setShowGrid(false);
		JScrollPane sp=new JScrollPane(tablacliente);
		frmSeleccionarCliente.getContentPane().add(sp, BorderLayout.CENTER);
		
		paneleste = new JPanel();
		frmSeleccionarCliente.getContentPane().add(paneleste, BorderLayout.EAST);
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
				int seleccion=tablacliente.getSelectedRow();
				Factura_Contado.textcodigo.setText((String) tablacliente.getValueAt(seleccion, 0));
				Factura_Contado.textcedula.setText((String) tablacliente.getValueAt(seleccion, 1));
				Factura_Contado.textnombre.setText((String) tablacliente.getValueAt(seleccion, 2));
				Factura_Contado.textapellido.setText((String) tablacliente.getValueAt(seleccion, 3));
				Factura_Contado.textdireccion.setText((String) tablacliente.getValueAt(seleccion, 4));
				Factura_Contado.texttelefono.setText((String) tablacliente.getValueAt(seleccion, 5));
				frmSeleccionarCliente.dispose();
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
		
		panelsur = new JPanel();
		frmSeleccionarCliente.getContentPane().add(panelsur, BorderLayout.SOUTH);
		
		lblSeleccioneElFiltro = new JLabel("Seleccione el filtro:");
		panelsur.add(lblSeleccioneElFiltro);
		
		combofiltro = new JComboBox<String>();
		combofiltro.addItem("");
		combofiltro.addItem("Codigo");
		combofiltro.addItem("Cedula");
		combofiltro.addItem("Nombre");
		panelsur.add(combofiltro);
		
		textfiltro = new JTextField();
		textfiltro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				DefaultTableModel modelonuevo=new DefaultTableModel();
				modelonuevo.addColumn("Código");
				modelonuevo.addColumn("Cédula");
				modelonuevo.addColumn("Nombre");
				modelonuevo.addColumn("Apellido");
				modelonuevo.addColumn("Dirección");
				modelonuevo.addColumn("Teléfono");
				DefaultTableModel modelocodigo=new DefaultTableModel();
				modelocodigo.addColumn("Código");
				modelocodigo.addColumn("Cédula");
				modelocodigo.addColumn("Nombre");
				modelocodigo.addColumn("Apellido");
				modelocodigo.addColumn("Dirección");
				modelocodigo.addColumn("Teléfono");
				DefaultTableModel modelonombre=new DefaultTableModel();
				modelonombre.addColumn("Código");
				modelonombre.addColumn("Cédula");
				modelonombre.addColumn("Nombre");
				modelonombre.addColumn("Apellido");
				modelonombre.addColumn("Dirección");
				modelonombre.addColumn("Teléfono");
				DefaultTableModel modelocedula=new DefaultTableModel();
				modelocedula.addColumn("Código");
				modelocedula.addColumn("Cédula");
				modelocedula.addColumn("Nombre");
				modelocedula.addColumn("Apellido");
				modelocedula.addColumn("Dirección");
				modelocedula.addColumn("Teléfono");
				if(combofiltro.getSelectedItem().equals("Codigo")) {
					for(int f=0;f<x;f++) {
						char[] cadena=codigo[f].toCharArray();
						for(int k=0;k<cadena.length;k++) {
							String cadenaconvertida=String.valueOf(cadena[k]);
							if(cadenaconvertida.equals(textfiltro.getText())) {
								String[] fila= {codigo[f], cedula[f], nombre[f], apellido[f], telefono[f], direccion[f]};
								modelonuevo.addRow(fila);
								tablacliente.setModel(modelonuevo);
							}
						}
						if(codigo[f].equals(textfiltro.getText())) {
							String[] fila= {codigo[f], cedula[f], nombre[f], apellido[f], telefono[f], direccion[f]};
							modelocodigo.addRow(fila);
							tablacliente.setModel(modelocodigo);
						}
					}
				} else if(combofiltro.getSelectedItem().equals("Nombre")) {
					for(int f=0;f<x;f++) {
						char[] cadena=nombre[f].toCharArray();
						for(int k=0;k<cadena.length;k++) {
							String cadenaconvertida=String.valueOf(cadena[k]);
							if(cadenaconvertida.equals(textfiltro.getText())) {
								String[] fila= {codigo[f], cedula[f], nombre[f], apellido[f], telefono[f], direccion[f]};
								modelonuevo.addRow(fila);
								tablacliente.setModel(modelonuevo);
							}
						}
						if(nombre[f].equals(textfiltro.getText())) {
							String[] fila= {codigo[f], cedula[f], nombre[f], apellido[f], telefono[f], direccion[f]};
							modelonombre.addRow(fila);
							tablacliente.setModel(modelonombre);
						}
					}
				} else if(combofiltro.getSelectedItem().equals("Cedula")) {
					for(int f=0;f<x;f++) {
						char[] cadena=cedula[f].toCharArray();
						for(int k=0;k<cadena.length;k++) {
							String cadenaconvertida=String.valueOf(cadena[k]);
							if(cadenaconvertida.equals(textfiltro.getText())) {
								String[] fila= {codigo[f], cedula[f], nombre[f], apellido[f], telefono[f], direccion[f]};
								modelonuevo.addRow(fila);
								tablacliente.setModel(modelonuevo);
							}
						}
						if(cedula[f].equals(textfiltro.getText())) {
							String[] fila= {codigo[f], cedula[f], nombre[f], apellido[f], telefono[f], direccion[f]};
							modelocedula.addRow(fila);
							tablacliente.setModel(modelocedula);
						}
					}
				} else if(textfiltro.getText().equals("")) {
					tablacliente.setModel(modelocliente);
				} 

			}
		});
		panelsur.add(textfiltro);
		textfiltro.setColumns(10);
		
	}

}
