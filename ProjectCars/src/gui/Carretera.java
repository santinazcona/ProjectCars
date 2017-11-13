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

import Vehiculo.Coche;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Carretera extends JFrame {

	private JFrame contentPane;
//	private JPanel contentPane2;
	private BufferedImage image;
	private ImageIcon Img;
	private ImageIcon Img1;
	private static int widthX = 512;
	private static int heighY = 512;
	public static Coche co = new Coche("c1", widthX*0.31, 400);

/*
	//Tamaño(proporciones) carretera en 512x512
	//primer carril: 	de 142 a 215 pos de coche 159 = width*0.31
	//segundo carril: 	de 215 a 294 pos de coche 232 = width*0.45
	//tercer carril: 	de 294 a 369 pos de coche 321 = width*0.63
*/

	public Carretera() {
//		this.setSize(300, 400);
		//setBounds(0, 0, 700, 900);
		setBounds(200,0, widthX, heighY);
		setVisible(true);
		contentPane = new JFrame();
		contentPane.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent k) {
				switch( k.getKeyChar() ){
					case 'w':
						break;
					case 'e':
						break;
					case 'a':
						if(co.getPosX()> widthX*0.31) {
							if(co.getPosX()> widthX*0.45)
								co.setPosX(widthX*0.45);
							else
								co.setPosX(widthX*0.31);
						}
						break;
					case 's':
						break;
					case 'd':
						if(co.getPosX()<widthX*0.63){
							if(co.getPosX()<widthX*0.45)
								co.setPosX(widthX*0.45);
							else
								co.setPosX(widthX*0.63);
						}
					default:
						break;
				}
				switch( k.getKeyCode() ){
					case KeyEvent.VK_UP:
						break;
					case KeyEvent.VK_LEFT:
						if(co.getPosX()> widthX*0.31) {
							if(co.getPosX()> widthX*0.45)
								co.setPosX(widthX*0.45);
							else
								co.setPosX(widthX*0.31);
						}
						break;
					case KeyEvent.VK_DOWN:
						break;
					case KeyEvent.VK_RIGHT:
						if(co.getPosX()<widthX*0.63){
							if(co.getPosX()<widthX*0.45)
								co.setPosX(widthX*0.45);
							else
								co.setPosX(widthX*0.63);
						}
					default:
						break;
				}
			}
		});
		//contentPane2 = new JPanel();
		//Color para hacer pruebas de transparencia
		contentPane.setForeground(Color.LIGHT_GRAY);
		setContentPane(contentPane);
		//contentPane2.setBounds(50, 50, 100, 200);
		contentPane.setLayout(null);
		//contentPane.add(contentPane2);
		
		
       
	}
	
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
		Img = new ImageIcon(getClass().getResource("road.png")); 
		
		grafico.drawImage(Img.getImage(), 0, 0, height.width, height.height, null);
		
		Img1 = new ImageIcon(getClass().getResource("coche1.png")); 
		
		grafico.drawImage(Img1.getImage(), (int)co.getPosX(), (int)co.getPosY(), 40, 70, null);
		
		//setOpacity entre [0,1], es un float de nivel de transparencia
		if(getOpacity() != 0.0f)
			setOpacity(0.0f);
//		Img.setOpaque(true);
		super.paint(grafico);
//		super.paintComponent(grafico);
	}
}
