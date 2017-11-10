package gui;

import utils.ventanas.ventanaJuego.img.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Color;

public class Carretera extends JFrame {

	private JPanel contentPane;
	private JPanel contentPane2;
	private BufferedImage image;
	private ImageIcon Img;
	
	public Carretera() {
//		this.setSize(300, 400);
		setBounds(0, 0, 700, 900);
		setVisible(true);
		contentPane = new JPanel();
		contentPane2 = new JPanel();
		contentPane.setForeground(Color.LIGHT_GRAY);
		setContentPane(contentPane);
		contentPane2.setBounds(50, 50, 100, 200);
		contentPane.setLayout(null);
		contentPane.add(contentPane2);
		
        setBounds(0,0,800,600);
	}
	/*
	public void paint(Graphics grafico) {
		Dimension height = getSize();
//		try{
//			image = ImageIO.read(new File("/Imagenes/road.jpg"));
//			image = ImageIO.read(getClass().getResource("/Imagenes/road.png"));
//			image = ImageIO.read(new );
//			image = ImageIO.read(new InputStream("/Imagenes/road.png"));
//			image = ImageIO.read(new ImageInputStream("/Imagenes/road.png"));
//			grafico.drawImage(image, 0, 0, height.width, height.height, null);
//		}catch(IOException ex){
//			ex.printStackTrace();
//		}
		//TODO el problema es la carga de imagen
		Img = new ImageIcon(getClass().getResource("road.jpg")); 
		
		grafico.drawImage(Img.getImage(), 0, 0, height.width, height.height, null);
		
		//setOpacity entre [0,1], es un float de nivel de transparencia
		setOpacity(1.0f);
//		Img.setOpaque(true);
		super.paint(grafico);
//		super.paintComponent(grafico);
	}*/
}
