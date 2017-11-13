package gui;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import Vehiculo.Coche;

public class JPanelCoche extends JFrame{

	public Coche co = new Coche("c1", 50, 50);
	private ImageIcon Img;
	
	public JPanelCoche(){
		this.setBounds((int)co.getPosX(), (int)co.getPosY(), 5, 20);
	}
	
	
	public void paint(Graphics grafico) {
	
		Dimension height = getSize();
		Img = new ImageIcon(getClass().getResource("coche1.png")); 
		
		grafico.drawImage(Img.getImage(), (int)co.getPosX(), (int)co.getPosY(), height.width, height.height, null);
	//	setOpacity(0.0f);
//		Img.setOpaque(true);
		super.paint(grafico);
	}
	/*
	public static void main(String[] args){
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
	}*/
}
