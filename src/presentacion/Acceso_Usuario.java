package presentacion;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.border.Border;

import dominio.Acceso;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Acceso_Usuario extends Acceso {

	private JFrame frmAccesoUsuario;
	private JTextField textusuario;
	private JPasswordField passwordclave;
	public static String idingreso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Acceso_Usuario window = new Acceso_Usuario();
					window.frmAccesoUsuario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Acceso_Usuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAccesoUsuario = new JFrame();
		frmAccesoUsuario.setIconImage(Toolkit.getDefaultToolkit().getImage(Acceso_Usuario.class.getResource("/images/comedor.png")));
		frmAccesoUsuario.setResizable(false);
		frmAccesoUsuario.setForeground(Color.DARK_GRAY);
		frmAccesoUsuario.setBackground(Color.DARK_GRAY);
		frmAccesoUsuario.setTitle("Acceso Usuario");
		frmAccesoUsuario.setBounds(550, 300, 352, 189);
		frmAccesoUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblreservado = new JLabel("                              Brahianny's Mueblería.");
		lblreservado.setFont(new Font("Dyuthi", Font.BOLD, 12));
		lblreservado.setForeground(Color.RED);
		frmAccesoUsuario.getContentPane().add(lblreservado, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		Border blackline=BorderFactory.createLineBorder(Color.BLACK);
		frmAccesoUsuario.getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setBorder(blackline);
		panel.setLayout(gbl_panel);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.anchor = GridBagConstraints.EAST;
		gbc_lblUsuario.gridx = 0;
		gbc_lblUsuario.gridy = 0;
		panel.add(lblUsuario, gbc_lblUsuario);
		
		textusuario = new JTextField();
		GridBagConstraints gbc_textusuario = new GridBagConstraints();
		gbc_textusuario.insets = new Insets(0, 0, 5, 0);
		gbc_textusuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_textusuario.gridx = 1;
		gbc_textusuario.gridy = 0;
		panel.add(textusuario, gbc_textusuario);
		textusuario.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contraseña:");
		GridBagConstraints gbc_lblContrasea = new GridBagConstraints();
		gbc_lblContrasea.anchor = GridBagConstraints.EAST;
		gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasea.gridx = 0;
		gbc_lblContrasea.gridy = 1;
		panel.add(lblContrasea, gbc_lblContrasea);
		
		passwordclave = new JPasswordField();
		GridBagConstraints gbc_passwordclave = new GridBagConstraints();
		gbc_passwordclave.insets = new Insets(0, 0, 5, 0);
		gbc_passwordclave.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordclave.gridx = 1;
		gbc_passwordclave.gridy = 1;
		panel.add(passwordclave, gbc_passwordclave);
		
		JLabel lblcomedor = new JLabel("");
		GridBagConstraints gbc_lblcomedor = new GridBagConstraints();
		gbc_lblcomedor.anchor=GridBagConstraints.WEST;
		gbc_lblcomedor.gridx = 1;
		gbc_lblcomedor.gridy = 2;
		ImageIcon comedor=new ImageIcon(new ImageIcon("src/images/comedor.png").getImage().getScaledInstance(150, 50, Image.SCALE_DEFAULT));
		lblcomedor.setIcon(comedor);
		panel.add(lblcomedor, gbc_lblcomedor);
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.LIGHT_GRAY);
		frmAccesoUsuario.getContentPane().add(panel1, BorderLayout.SOUTH);
		panel1.setBorder(blackline);
		
		JButton btnIngresar = new JButton("Ingresar");
		ImageIcon user=new ImageIcon(new ImageIcon("src/images/usuario.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		btnIngresar.setIcon(user);
		btnIngresar.addActionListener(new ActionListener() {
			private String usuariolocal;
			private String clavelocal;

			public void actionPerformed(ActionEvent arg0) {
				char[] arrayclave=passwordclave.getPassword();
				String clave=new String(arrayclave);
				for(int f=0;f<x;f++) {
					if(textusuario.getText().equals(usuario[f]) && clave.equals(contraseña[f])) {
						usuariolocal=usuario[f];
						clavelocal=contraseña[f];
						idingreso=idusuario[f];
						JOptionPane.showMessageDialog(null, "Credenciales correctas.","Información",JOptionPane.INFORMATION_MESSAGE);
					}
				}
				
				if(textusuario.getText().equals(usuariolocal) && clavelocal.equals(clave)) {
					Principal.frameprincipal.setEnabled(true);
					frmAccesoUsuario.dispose();
				}else if(textusuario.getText().equals("") || clave.equals("")) {
					JOptionPane.showMessageDialog(null, "Llene los espacios en blanco.","Información",JOptionPane.ERROR_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "Datos incorrectos.","Información",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		panel1.add(btnIngresar);
		
		JButton btnSalir = new JButton("Salir");
		ImageIcon salir=new ImageIcon(new ImageIcon("src/images/exit.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		btnSalir.setIcon(salir);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmAccesoUsuario.dispose();
				Principal.frameprincipal.dispose();
			}
		});
		panel1.add(btnSalir);
	}

}
