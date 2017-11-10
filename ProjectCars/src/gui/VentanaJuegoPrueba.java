package gui;

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
		
//		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
//		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		setSize(300, 500);
		frame.setResizable(false);
		JPanel pCarretera = new JPanel();
		JPanel pBoton = new JPanel();
		frame.getContentPane().add(pCarretera, BorderLayout.CENTER);
		frame.getContentPane().add(pBoton, BorderLayout.NORTH);
		JButton bPonerCarretera = new JButton("Poner carretera de prueba");
		pBoton.add(bPonerCarretera);
		bPonerCarretera.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e){
				Carretera Carretera = new Carretera();
				
				//TODO No funciona aqui, no entiendo muy bien como va lo de usar Graphics2D
//				Graphics2D g = (Graphics2D) g2;
//				Graphics2D g = new Graphics2D();
//				Carretera.paint(g);
//				JPanel jPanell = new JPanel();
//				jPanell.add(Carretera);
//				jPanell.repaint();
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

