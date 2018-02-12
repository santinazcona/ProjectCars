package gui;

import Vehiculo.Coche;
//import Vehiculo.Ventana.Carretera;

import java.awt.*;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import BaseDeDatos.BD;

import javax.swing.JButton;


import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;


public class VentanaJuegoPrueba extends JFrame{//JPanel{

	private boolean evitarRepetir=true;

	private JFrame frame = new JFrame();
	
	public VentanaJuegoPrueba() {
		
		frame.setBounds(450, 200, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(100, 15));
		frame.setVisible(true);
		frame.setTitle("Ventana menu juego");
//		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
//		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		setSize(300, 500);
		frame.setResizable(false);
		JPanel pCarretera = new JPanel();
		JPanel pBoton = new JPanel();
		frame.getContentPane().add(pCarretera, BorderLayout.CENTER);
		frame.getContentPane().add(pBoton, BorderLayout.NORTH);
		JButton bPonerCarretera = new JButton("Jugar");
		JButton bScore = new JButton("Score");
		JButton salir = new JButton("Salir");
		pBoton.add(bPonerCarretera);
		pBoton.add(bScore);
		pBoton.add(salir);
		bScore.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e2){
				JScore js = new JScore();
			}
		});
		salir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e1){
				frame.setVisible(false);
				
				frame.dispose();
			}
		});
		bPonerCarretera.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e2){
				JCarreteraP2.invocar(/*frame*/);
				bPonerCarretera.setEnabled(false);
			}
		});
		JPanel jScore = new JPanel();
		frame.getContentPane().add(jScore, BorderLayout.CENTER);
		jScore.setBounds(0, 0, 450, 300);
		jScore.setLayout(null);
		JLabel lblNick = new JLabel("Nick:");
		lblNick.setBounds(140, 120, 46, 20);
		jScore.add(lblNick);
		JTextField jField = new JTextField("");
		jField.setBounds(180, 120, 94, 23);
		jScore.add(jField);
		JButton bAceptar = new JButton("Aceptar");
		bAceptar.setBounds(180, 189, 90, 23);
		jScore.add(bAceptar);
		bAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e2){
				if(evitarRepetir && (!jField.getText().isEmpty() && !jField.getText().contains(" "))){
					score(jField.getText());
					evitarRepetir = false;
				}
			}
		});
		
		
	}
	
	public void score(String j){
		BD bd = new BD();
		bd.conectar();
		bd.Sentencia();
		bd.insertarScore(j, (int) (JCarreteraP2.time_pausa));
		bd.closeSentencia();
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					VentanaInicio w = new VentanaInicio();
					VentanaJuegoPrueba window = new VentanaJuegoPrueba();
//					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

