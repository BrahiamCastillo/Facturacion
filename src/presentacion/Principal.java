package presentacion;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Principal {

	public static JFrame frameprincipal;

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
		frameprincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frameprincipal.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblcomedor = new JLabel("");
		ImageIcon comedor=new ImageIcon(new ImageIcon("src/images/comedor.png").getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT));
		lblcomedor.setIcon(comedor);
		lblcomedor.setBounds(525, 250, 300, 300);
		panel.add(lblcomedor);
	}
}
