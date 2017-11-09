package gui;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Vehiculo.Ventana;

import java.awt.BorderLayout;

import javax.swing.JButton;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;


public class VentanaJuegoPrueba extends JPanel{

// Ventana extends javax.swing.JPanel	 {


	private JFrame frame;

	public VentanaJuegoPrueba() {
		initialize();
	}
	private void jButtonActionPerformed(ActionEvent e){
		Carretera Carretera = new Carretera();
		JPanel jPanell = new JPanel();
		jPanell.add(Carretera);
		jPanell.repaint();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJuegoPrueba window = new VentanaJuegoPrueba();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


}

