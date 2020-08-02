package presentacion.facturas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import presentacion.Seleccion_Cliente;

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

public class Factura_Contado {

	private JFrame frmFacturaContado;
	private JTable table;
	private JTextField textitbis;
	private JTextField textsubtotal;
	private JTextField texttotal;
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
		frmFacturaContado.setBounds(325, 100, 890, 640);
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
		
		JButton btnGuardar = new JButton("");
		ImageIcon guardar=new ImageIcon(new ImageIcon("src/images/guardar.png").getImage().getScaledInstance(170, 100, Image.SCALE_DEFAULT));
		btnGuardar.setIcon(guardar);
		GridBagConstraints gbc_btnguardar = new GridBagConstraints();
		gbc_btnguardar.insets = new Insets(5, 5, 5, 4);
		gbc_btnguardar.gridx = 0;
		gbc_btnguardar.gridy = 0;
		gbc_btnguardar.gridheight=1;
		gbc_btnguardar.gridwidth=1;
		gbc_btnguardar.fill=GridBagConstraints.BOTH;
		panelnorte.add(btnGuardar, gbc_btnguardar);
		
		JButton btnRefrescar = new JButton("");
		ImageIcon refrescar=new ImageIcon(new ImageIcon("src/images/actualizar.png").getImage().getScaledInstance(170, 100, Image.SCALE_DEFAULT));
		btnRefrescar.setIcon(refrescar);
		GridBagConstraints gbc_btrefrescar = new GridBagConstraints();
		gbc_btrefrescar.insets = new Insets(5, 5, 5, 4);
		gbc_btrefrescar.gridx = 2;
		gbc_btrefrescar.gridy = 0;
		gbc_btrefrescar.gridheight=1;
		gbc_btrefrescar.gridwidth=1;
		gbc_btrefrescar.fill=GridBagConstraints.BOTH;
		panelnorte.add(btnRefrescar, gbc_btrefrescar);
		
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
		gbc_btsalir.insets = new Insets(5, 5, 5, 4);
		gbc_btsalir.gridx = 4;
		gbc_btsalir.gridy = 0;
		gbc_btsalir.gridheight=1;
		gbc_btsalir.gridwidth=1;
		gbc_btsalir.fill=GridBagConstraints.BOTH;
		panelnorte.add(btnSalir, gbc_btsalir);
		
		JPanel panelcentral = new JPanel();
		frmFacturaContado.getContentPane().add(panelcentral, BorderLayout.CENTER);
		
		modelo.addColumn("Mercancía");
		modelo.addColumn("Cantidad");
		modelo.addColumn("Precio unitario");
		modelo.addColumn("Precio total");
		table = new JTable(modelo);
		JScrollPane sp=new JScrollPane(table);
		panelcentral.add(sp);
		
		JPanel paneleste = new JPanel();
		frmFacturaContado.getContentPane().add(paneleste, BorderLayout.EAST);
		GridBagLayout gbl_paneleste = new GridBagLayout();
		gbl_paneleste.columnWidths = new int[]{0, 0};
		gbl_paneleste.rowHeights = new int[]{0, 0, 0};
		gbl_paneleste.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_paneleste.rowWeights = new double[]{0.0, Double.MIN_VALUE, 0.0};
		paneleste.setLayout(gbl_paneleste);
		
		JButton btnAgregar = new JButton("");
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
		
		JButton btnRemover = new JButton("");
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
