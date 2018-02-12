package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import BaseDeDatos.BD;

	public class VentanaInicio extends JFrame implements ActionListener {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private JPanel contentPane, panelCentro, panelIzquierda,panelDerecha, panelNorte;
		private JTextField txtNick,txtNombre;
		private JPasswordField psContrase�a;
		private JButton btnAtras, btnAceptar, btnEmpezarCarrera;
		private JLabel lblCuentaDeUsuario,lblContrase�a,lblNombre;

		public VentanaInicio(/*JFrame va*/) {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 506, 352);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);

			panelCentro = new JPanel();
			panelCentro.setBounds(5, 5, 459, 24);
			contentPane.add(panelCentro);

			panelNorte = new JPanel();
			panelCentro.add(panelNorte);
			panelNorte.setLayout(new BorderLayout(0, 0));

			btnAceptar = new JButton("ACEPTAR");
			btnAceptar.addActionListener(this);
			btnAceptar.setBounds(100, 269, 137, 23);
			contentPane.add(btnAceptar);

			btnAtras = new JButton("ATRAS");
			btnAtras.setBounds(249, 269, 137, 23);
			contentPane.add(btnAtras);
			btnAtras.addActionListener(this);
			
			btnEmpezarCarrera = new JButton("Empezar Carrera");
			btnEmpezarCarrera.addActionListener(this);
			btnEmpezarCarrera.setBounds(100, 269, 137, 23);
			contentPane.add(btnEmpezarCarrera);

			panelIzquierda = new JPanel();
			panelIzquierda.setBounds(5, 40, 219, 216);
			contentPane.add(panelIzquierda);
			panelIzquierda.setLayout(null);


			lblCuentaDeUsuario = new JLabel("Usuario");
			lblCuentaDeUsuario.setBounds(21, 0, 164, 14);
			panelIzquierda.add(lblCuentaDeUsuario);
			
			lblNombre = new JLabel("Nombre : ");
			lblNombre.setBounds(21, 40, 59, 14);
			panelIzquierda.add(lblNombre);
						
			txtNombre = new JTextField();
			txtNombre.setBounds(76, 37, 115, 20);
			panelIzquierda.add(txtNombre);
			txtNombre.setColumns(10);

			panelDerecha = new JPanel();
			panelDerecha.setBounds(236, 40, 228, 216);
			contentPane.add(panelDerecha);
			panelDerecha.setLayout(null);
			
			lblContrase�a = new JLabel("Contrase\u00F1a : ");
			lblContrase�a.setBounds(10, 40, 78, 14);
			panelDerecha.add(lblContrase�a);
			lblContrase�a.setHorizontalAlignment(SwingConstants.LEFT);
						
			psContrase�a = new JPasswordField();
			psContrase�a.setBounds(85, 37, 110, 20);
			panelDerecha.add(psContrase�a);

			this.setVisible(true);
		}
		public void campoVacio()
		{
			txtNick.setText("");
			txtNombre.setText("");
			psContrase�a.setText("");
			
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}

			
			
		


}
