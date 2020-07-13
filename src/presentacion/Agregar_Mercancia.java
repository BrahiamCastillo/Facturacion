package presentacion;

import java.awt.EventQueue;
import dominio.Contenedor;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.Border;

import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

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
		frmAgregarMercancia.setTitle("Agregar Mercancia");
		frmAgregarMercancia.setBounds(100, 100, 450, 300);
		frmAgregarMercancia.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel lblAgregarNuevaMercanca = new JLabel("Agregar nueva mercancía:");
		frmAgregarMercancia.getContentPane().add(lblAgregarNuevaMercanca, BorderLayout.NORTH);
		
		ImageIcon guardar=new ImageIcon(new ImageIcon("src/images/guardar.png").getImage().getScaledInstance(18, 18, Image.SCALE_DEFAULT));
		
		JPanel panel = new JPanel();
		Border blackline=BorderFactory.createLineBorder(Color.BLACK);
		panel.setBorder(blackline);
		frmAgregarMercancia.getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.insets = new Insets(0, 0, 5, 5);
		gbc_separator.fill=GridBagConstraints.HORIZONTAL;
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 0;
		panel.add(separator, gbc_separator);
		
		JLabel lblNombreDeLa = new JLabel("Nombre de la mercancía:");
		GridBagConstraints gbc_lblNombreDeLa = new GridBagConstraints();
		gbc_lblNombreDeLa.anchor = GridBagConstraints.EAST;
		gbc_lblNombreDeLa.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreDeLa.gridx = 1;
		gbc_lblNombreDeLa.gridy = 2;
		panel.add(lblNombreDeLa, gbc_lblNombreDeLa);
		
		textmercancia = new JTextField();
		GridBagConstraints gbc_textmercancia = new GridBagConstraints();
		gbc_textmercancia.insets = new Insets(0, 0, 5, 0);
		gbc_textmercancia.fill = GridBagConstraints.HORIZONTAL;
		gbc_textmercancia.gridx = 2;
		gbc_textmercancia.gridy = 2;
		panel.add(textmercancia, gbc_textmercancia);
		textmercancia.setColumns(10);
		
		JLabel lblPrecioDeLa = new JLabel("Precio de la mercancía:");
		GridBagConstraints gbc_lblPrecioDeLa = new GridBagConstraints();
		gbc_lblPrecioDeLa.anchor = GridBagConstraints.EAST;
		gbc_lblPrecioDeLa.insets = new Insets(0, 0, 0, 5);
		gbc_lblPrecioDeLa.gridx = 1;
		gbc_lblPrecioDeLa.gridy = 3;
		panel.add(lblPrecioDeLa, gbc_lblPrecioDeLa);
		
		textprecio = new JTextField();
		GridBagConstraints gbc_textprecio = new GridBagConstraints();
		gbc_textprecio.fill = GridBagConstraints.HORIZONTAL;
		gbc_textprecio.gridx = 2;
		gbc_textprecio.gridy = 3;
		panel.add(textprecio, gbc_textprecio);
		textprecio.setColumns(10);
		
		JPanel panel1 = new JPanel();
		panel.setBorder(blackline);
		frmAgregarMercancia.getContentPane().add(panel1, BorderLayout.SOUTH);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setIcon(guardar);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double preciomercancia=Double.parseDouble(textprecio.getText());
				String insert="INSERT INTO mercancia(mercancia,precio,idusuario) VALUES ('"+textmercancia.getText()+"','"+preciomercancia+"','"+Acceso_Usuario.idingreso+"')";
				try {
					Contenedor.Insercion(insert);
					Contenedor.st.close();
					JOptionPane.showMessageDialog(null, "La mercancía ha sido agregada exitosamente.");
					textmercancia.setText("");
					textprecio.setText("");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel1.add(btnAgregar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmAgregarMercancia.dispose();
			}
		});
		panel1.add(btnSalir);
	}

}
