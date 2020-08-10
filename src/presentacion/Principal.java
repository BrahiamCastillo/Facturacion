package presentacion;

import java.awt.EventQueue;
import java.util.Date;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;

import java.awt.BorderLayout;
import javax.swing.JPanel;

import presentacion.facturas.Factura_Contado;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Toolkit;

public class Principal {

	public static JFrame frameprincipal;
	private JLabel lblfecha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					@SuppressWarnings("unused")
					Principal window = new Principal();
					Principal.frameprincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
		Acceso_Usuario.main(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameprincipal = new JFrame();
		frameprincipal.setTitle("Mueblería Brahianny");
		frameprincipal.setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/images/comedor.png")));
		frameprincipal.setEnabled(false);
		frameprincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frameprincipal.setBounds(100, 100, 450, 300);
		JMenuBar bar=new JMenuBar();
		frameprincipal.setJMenuBar(bar);
		
		JMenu mnIngresar = new JMenu("Ingresar");
		bar.add(mnIngresar);
		
		JMenuItem mntmAgregarCliente = new JMenuItem("Agregar Cliente");
		mntmAgregarCliente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Agregar_Cliente.main(null);
			}
			
		});
		mnIngresar.add(mntmAgregarCliente);
		
		JMenuItem mntmAgregarMercanca = new JMenuItem("Agregar Mercancía");
		mntmAgregarMercanca.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Agregar_Mercancia.main(null);
			}
			
		});
		mnIngresar.add(mntmAgregarMercanca);
		
		JMenu mnFactura = new JMenu("Factura");
		bar.add(mnFactura);
		
		JMenuItem mntmFacturaDeContado = new JMenuItem("Factura de contado");
		mntmFacturaDeContado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Factura_Contado.main(null);
			}
		});
		mnFactura.add(mntmFacturaDeContado);
		frameprincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frameprincipal.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		lblfecha = new JLabel("");
		Date fecha=new Date();
	    String formatofecha = "hh: mm: ss a dd-MMM-aaaa";
		SimpleDateFormat fechaform=new SimpleDateFormat(formatofecha);
		String fechacompleta=fechaform.format(fecha);
		lblfecha.setText(fechacompleta);
		lblfecha.setBounds(600, 5, 300, 300);
		panel.add(lblfecha);
		
		JLabel lblcomedor = new JLabel("");
		ImageIcon comedor=new ImageIcon(new ImageIcon("src/images/comedor.png").getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT));
		lblcomedor.setIcon(comedor);
		lblcomedor.setBounds(525, 250, 300, 300);
		panel.add(lblcomedor);
			
	}
	
}
