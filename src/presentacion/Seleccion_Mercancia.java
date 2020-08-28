package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dominio.Mercancia;
import presentacion.facturas.Factura_Contado;

import java.awt.BorderLayout;
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

public class Seleccion_Mercancia extends Mercancia {

	private JFrame frmSeleccionarMercancia;
	private JTable tablamercancia;
	private DefaultTableModel modelomercancia;
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
					Seleccion_Mercancia window = new Seleccion_Mercancia();
					window.frmSeleccionarMercancia.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Seleccion_Mercancia() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSeleccionarMercancia = new JFrame();
		frmSeleccionarMercancia.getContentPane().setBackground(Color.LIGHT_GRAY);
		
		modelomercancia=new DefaultTableModel();
		modelomercancia.addColumn("ID-Mercancía");
		modelomercancia.addColumn("Mercancía");
		modelomercancia.addColumn("Precio unitario");
		for(int f=0;f<x;f++) {
			String[] fila= {idmercancia[f], mercancia[f], preciorecolector[f]};
			modelomercancia.addRow(fila);
		}
		tablamercancia = new JTable(modelomercancia);
		tablamercancia.setShowGrid(false);
		JScrollPane sp=new JScrollPane(tablamercancia);
		frmSeleccionarMercancia.getContentPane().add(sp, BorderLayout.CENTER);
		
		paneleste = new JPanel();
		frmSeleccionarMercancia.getContentPane().add(paneleste, BorderLayout.EAST);
		GridBagLayout gbl_paneleste = new GridBagLayout();
		gbl_paneleste.columnWidths = new int[]{0, 0};
		gbl_paneleste.rowHeights = new int[]{0, 0};
		gbl_paneleste.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_paneleste.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		paneleste.setLayout(gbl_paneleste);
		
		btnAgregar = new JButton("");
		btnAgregar.addActionListener(new ActionListener() {

			private float contador;

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int seleccion=tablamercancia.getSelectedRow();
				if(seleccion<0) {
					JOptionPane.showMessageDialog(null, "Debe seleccionar una fila","Error",JOptionPane.ERROR_MESSAGE);
				} else {
					String cantidadcadena=JOptionPane.showInputDialog("Introduzca la cantidad de la mercancía");
					float cantidad=Float.parseFloat(cantidadcadena);
					String cantidadseleccion=(String) tablamercancia.getValueAt(seleccion, 2);
					float preciocalculado=Float.parseFloat(cantidadseleccion)*cantidad;
					String preciototal=Float.toString(preciocalculado);
					String idmercancia=(String) tablamercancia.getValueAt(seleccion, 0);
					String mercancia=(String) tablamercancia.getValueAt(seleccion, 1);
					String[] nuevafila= {idmercancia, mercancia, cantidadcadena, cantidadseleccion, preciototal};
					Factura_Contado.modelo.addRow(nuevafila);
					int filaprecio=Factura_Contado.modelo.getRowCount();
					float[] subtotal=new float[filaprecio];
					contador = 0;
					for(int f=0;f<filaprecio;f++) {
						subtotal[f]=Float.parseFloat((String) Factura_Contado.modelo.getValueAt(f, 4));
						contador+=subtotal[f];
						Factura_Contado.textsubtotal.setText(Float.toString(contador));
						float itbis=(float) (contador*0.18);
						Factura_Contado.textitbis.setText(Float.toString(itbis));
						Float totalidad=contador+itbis;
						Factura_Contado.texttotal.setText(Float.toString(totalidad));
						frmSeleccionarMercancia.dispose();
					}
			 }
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
		frmSeleccionarMercancia.getContentPane().add(panelsur, BorderLayout.SOUTH);
		
		lblSeleccioneElFiltro = new JLabel("Seleccione el filtro:");
		panelsur.add(lblSeleccioneElFiltro);
		
		combofiltro = new JComboBox<String>();
		combofiltro.addItem("");
		combofiltro.addItem("ID-Mercancia");
		combofiltro.addItem("Mercancia");
		panelsur.add(combofiltro);
		
		textfiltro = new JTextField();
		textfiltro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				DefaultTableModel modelonuevo=new DefaultTableModel();
				modelonuevo.addColumn("ID-Mercancia");
				modelonuevo.addColumn("Mercancia");
				modelonuevo.addColumn("Precio unitario");
				DefaultTableModel modelocodigo=new DefaultTableModel();
				modelocodigo.addColumn("ID-Mercancia");
				modelocodigo.addColumn("Mercancia");
				modelocodigo.addColumn("Precio unitario");
				DefaultTableModel modelonombre=new DefaultTableModel();
				modelonombre.addColumn("ID-Mercancia");
				modelonombre.addColumn("Mercancia");
				modelonombre.addColumn("Precio unitario");
				if(combofiltro.getSelectedItem().equals("ID-Mercancia")) {
					for(int f=0;f<x;f++) {
						char[] cadena=idmercancia[f].toCharArray();
						for(int k=0;k<cadena.length;k++) {
							String cadenaconvertida=String.valueOf(cadena[k]);
							if(cadenaconvertida.equals(textfiltro.getText())) {
								String[] fila= {idmercancia[f], mercancia[f], preciorecolector[f]};
								modelonuevo.addRow(fila);
								tablamercancia.setModel(modelonuevo);
							}
						}
						if(idmercancia[f].equals(textfiltro.getText())) {
							String[] fila= {idmercancia[f], mercancia[f], preciorecolector[f]};
							modelocodigo.addRow(fila);
							tablamercancia.setModel(modelocodigo);
						}
					}
				} else if(combofiltro.getSelectedItem().equals("Mercancia")) {
					for(int f=0;f<x;f++) {
						char[] cadena=mercancia[f].toCharArray();
						for(int k=0;k<cadena.length;k++) {
							String cadenaconvertida=String.valueOf(cadena[k]);
							if(cadenaconvertida.equals(textfiltro.getText())) {
								String[] fila= {idmercancia[f], mercancia[f], preciorecolector[f]};
								modelonuevo.addRow(fila);
								tablamercancia.setModel(modelonuevo);
							}
						}
						if(mercancia[f].equals(textfiltro.getText())) {
							String[] fila= {idmercancia[f], mercancia[f], preciorecolector[f]};
							modelonombre.addRow(fila);
							tablamercancia.setModel(modelonombre);
						}
					}
				} else if(textfiltro.getText().equals("")) {
					tablamercancia.setModel(modelomercancia);
				}
			}
		});
		panelsur.add(textfiltro);
		textfiltro.setColumns(10);
		frmSeleccionarMercancia.setForeground(Color.GRAY);
		frmSeleccionarMercancia.setIconImage(Toolkit.getDefaultToolkit().getImage(Seleccion_Mercancia.class.getResource("/images/comedor.png")));
		frmSeleccionarMercancia.setTitle("Seleccionar Mercancia");
		frmSeleccionarMercancia.setBounds(300, 300, 800, 200);
		frmSeleccionarMercancia.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

}
