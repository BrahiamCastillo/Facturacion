package presentacion;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

import dominio.Contenedor;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.Toolkit;

public class Agregar_Mercancia {

	private JFrame frmAgregarMercancia;
	private JTextField textmercancia;
	private JTextField textprecio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Agregar_Mercancia window = new Agregar_Mercancia();
					window.frmAgregarMercancia.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Agregar_Mercancia() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAgregarMercancia = new JFrame();
		frmAgregarMercancia.setIconImage(Toolkit.getDefaultToolkit().getImage(Agregar_Mercancia.class.getResource("/images/comedor.png")));
		frmAgregarMercancia.setResizable(false);
		frmAgregarMercancia.setTitle("Agregar Mercancia");
		frmAgregarMercancia.setBounds(550, 200, 470, 250);
		frmAgregarMercancia.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmAgregarMercancia.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		Border blackline=BorderFactory.createLineBorder(Color.BLACK);
		panel.setBorder(blackline);
		JLabel lblreservado = new JLabel("    Brahianny's Mueblería.");
		lblreservado.setFont(new Font("Dyuthi", Font.BOLD, 12));
		lblreservado.setForeground(Color.RED);
		panel.add(lblreservado);
		
		JPanel panelizquierdo = new JPanel();
		frmAgregarMercancia.getContentPane().add(panelizquierdo, BorderLayout.WEST);
		
		JLabel lblComedor = new JLabel();
		ImageIcon comedor=new ImageIcon(new ImageIcon("src/images/comedor.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
		lblComedor.setIcon(comedor);
		panelizquierdo.add(lblComedor);
		
		JPanel panelcentral = new JPanel();
		frmAgregarMercancia.getContentPane().add(panelcentral, BorderLayout.CENTER);
		panelcentral.setBorder(blackline);
		panelcentral.setBackground(Color.GRAY);
		panelcentral.setLayout(new BoxLayout(panelcentral, BoxLayout.Y_AXIS));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.gray);
		panelcentral.add(panel_1);
		
		JLabel lblMercanca = new JLabel("Mercancía:");
		panel_1.add(lblMercanca);
		
		textmercancia = new JTextField();
		panel_1.add(textmercancia);
		textmercancia.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.gray);
		panelcentral.add(panel_2);
		
		JLabel lblPrecio = new JLabel("Precio:");
		panel_2.add(lblPrecio);
		
		textprecio = new JTextField();
		panel_2.add(textprecio);
		textprecio.setColumns(10);
		
		JPanel panelinferior = new JPanel();
		panelinferior.setBackground(Color.gray);
		frmAgregarMercancia.getContentPane().add(panelinferior, BorderLayout.SOUTH);
		GridBagLayout gbl_panelinferior = new GridBagLayout();
		gbl_panelinferior.columnWidths = new int[]{0, 0};
		gbl_panelinferior.rowHeights = new int[]{0, 0, 0};
		gbl_panelinferior.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelinferior.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelinferior.setLayout(gbl_panelinferior);
		
		ImageIcon guardar=new ImageIcon(new ImageIcon("src/images/guardar.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		ImageIcon salir=new ImageIcon(new ImageIcon("src/images/exit.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(textmercancia.getText().equals("") || textprecio.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "¡Llene los espacios en blanco!","Notificación",JOptionPane.ERROR_MESSAGE);
				} else {
					int res=JOptionPane.showConfirmDialog(null, "¿ Desea ingresar los datos ?","Confirmación",JOptionPane.YES_NO_CANCEL_OPTION);
					if(JOptionPane.YES_OPTION==res) {
						try {
							Double preciodef=Double.parseDouble(textprecio.getText());
							String insert="INSERT INTO mercancia(mercancia,precio,idusuario) VALUES ('"+textmercancia.getText()+"','"+preciodef+"','"+Acceso_Usuario.idingreso+"')";
							Contenedor.Insercion(insert);
							Contenedor.st.close();
							JOptionPane.showMessageDialog(null, "¡Datos ingresados!","Notificación",JOptionPane.INFORMATION_MESSAGE);
							textmercancia.setText("");
							textprecio.setText("");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch(Exception e2) {
							JOptionPane.showMessageDialog(null, "Introduzca un valor numérico en el precio","Error",JOptionPane.ERROR_MESSAGE);
						}

					} else if(JOptionPane.CANCEL_OPTION==res) {
						textmercancia.setText("");
						textprecio.setText("");
					}
				}
			}
			
		});
		btnGuardar.setIcon(guardar);
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.insets = new Insets(5, 5, 5, 5);
		gbc_btnGuardar.fill=GridBagConstraints.BOTH;
		gbc_btnGuardar.gridx = 0;
		gbc_btnGuardar.gridy = 0;
		gbc_btnGuardar.gridheight=2;
		gbc_btnGuardar.gridwidth=2;
		gbc_btnGuardar.weighty=1.0;
		gbc_btnGuardar.weightx=1.0;
		panelinferior.add(btnGuardar, gbc_btnGuardar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				frmAgregarMercancia.dispose();
			}
			
		});
		btnSalir.setIcon(salir);
		GridBagConstraints gbc_btnSalir = new GridBagConstraints();
		gbc_btnSalir.insets = new Insets(5, 5, 5, 5);
		gbc_btnSalir.fill=GridBagConstraints.BOTH;
		gbc_btnSalir.gridx = 2;
		gbc_btnSalir.gridy = 0;
		gbc_btnSalir.gridheight=2;
		gbc_btnSalir.gridwidth=2;
		gbc_btnSalir.weighty=1.0;
		gbc_btnSalir.weightx=1.0;
		panelinferior.add(btnSalir, gbc_btnSalir);
		
		JPanel panelderecho = new JPanel();
		frmAgregarMercancia.getContentPane().add(panelderecho, BorderLayout.EAST);
		
		JLabel lblImage = new JLabel();
		lblImage.setIcon(comedor);
		panelderecho.add(lblImage);
	}
}
