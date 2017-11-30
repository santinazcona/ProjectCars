package gui;

import Vehiculo.Coche;
//import Vehiculo.Ventana.Carretera;

import java.awt.*;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;


import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;


public class VentanaJuegoPrueba extends JFrame{//JPanel{

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
		JButton bPonerCarretera = new JButton("Poner carretera de prueba");
		JButton bPonerOtraCarretera = new JButton("Poner otra carretera pueba");
		pBoton.add(bPonerCarretera);
		pBoton.add(bPonerOtraCarretera);
		bPonerCarretera.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e1){
//				EventQueue.invokeLater(new Runnable() {
//					public void run() {
//						try {
//							JCarretera JCarretera = new JCarretera();
//						} catch (Exception e1) {
//							e1.printStackTrace();
//						}
//					}
//				});
				JCarretera.invocar();
//				JPanelCoche c1 = new JPanelCoche();
//				JCarretera.add(c1);
				
//				Carretera();
				
				//TODO No funciona aqui, no entiendo muy bien como va lo de usar Graphics2D
//				Graphics2D g = (Graphics2D) g2;
//				Graphics2D g = new Graphics2D();
//				Carretera.paint(g);
//				JPanel jPanell = new JPanel();
//				jPanell.add(Carretera);
//				jPanell.repaint();
			}
		});
		bPonerOtraCarretera.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e2){
				JCarreteraP2.invocar();
			}
		});
//		private void jButtonActionPerformed(ActionEvent e){
//			Carretera Carretera = new Carretera();
//			JPanel jPanell = new JPanel();
//			jPanell.add(Carretera);
//			jPanell.repaint();
//		}
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJuegoPrueba window = new VentanaJuegoPrueba();
//					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


}

