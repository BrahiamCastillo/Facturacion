package presentacion.facturas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JSeparator;

public class Factura_Contado {

	private JFrame frmFacturaContado;
	private JTable table;
	private JTextField textitbis;
	private JTextField textsubtotal;
	private JTextField texttotal;
	public static DefaultTableModel modelo;
	private JTextField textfactura;

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
		frmFacturaContado.setBounds(100, 100, 870, 300);
		frmFacturaContado.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		modelo=new DefaultTableModel();
		Border blackline=BorderFactory.createLineBorder(Color.BLACK);
		
		JPanel panelnorte = new JPanel();
		panelnorte.setBorder(blackline);
		frmFacturaContado.getContentPane().add(panelnorte, BorderLayout.NORTH);
		panelnorte.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnGuardar = new JButton("Guardar");
		panelnorte.add(btnGuardar);
		
		JButton btnRefrescar = new JButton("Refrescar");
		panelnorte.add(btnRefrescar);
		
		JButton btnSalir = new JButton("Salir");
		panelnorte.add(btnSalir);
		
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
		
		JButton btnAgregar = new JButton("Agregar");
		GridBagConstraints gbc_btnAgregar = new GridBagConstraints();
		gbc_btnAgregar.insets = new Insets(5, 5, 5, 5);
		gbc_btnAgregar.gridx = 0;
		gbc_btnAgregar.gridy = 0;
		gbc_btnAgregar.gridheight=2;
		gbc_btnAgregar.gridwidth=2;
		gbc_btnAgregar.fill=GridBagConstraints.BOTH;
		paneleste.add(btnAgregar, gbc_btnAgregar);
		
		JButton btnRemover = new JButton("Remover");
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
		paneloeste.setLayout(new BoxLayout(paneloeste, BoxLayout.Y_AXIS));
		
		JPanel panelfactura = new JPanel();
		paneloeste.add(panelfactura);
		
		JLabel lblNofactura = new JLabel("No.Factura:");
		panelfactura.add(lblNofactura);
		
		textfactura = new JTextField();
		textfactura.setEnabled(false);
		panelfactura.add(textfactura);
		textfactura.setColumns(10);
		
	}

}
