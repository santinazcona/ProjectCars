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

public class JCarretera extends //JPanel { 
	JFrame {
	//JPanel {

	private JFrame contentPane;
	private JPanel contentP;
	private JPanel contentP2;
	private BufferedImage image;
	private ImageIcon Img;
	private ImageIcon Img1;
	private static int widthX = 512;
	private static int heighY = 512;
	private static double hY = (double) (heighY);
//	public static Coche co = new Coche("c1", widthX*0.31, 400);
	public static Coche co = new Coche("c1", widthX*0.31, 400);

/*
	//Tamaño(proporciones) carretera en 512x512
	//primer carril: 	de 142 a 215 pos de coche 159 = width*0.31
	//segundo carril: 	de 215 a 294 pos de coche 232 = width*0.45
	//tercer carril: 	de 294 a 369 pos de coche 321 = width*0.63
*/

	public JCarretera() {
//		this.setSize(300, 400);
		//setBounds(0, 0, 700, 900);
		invocarCoche();
		setBounds(200,0, widthX, heighY);
		setVisible(true);
		contentPane = new JFrame();
		contentPane.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent k) {
				switch( k.getKeyChar() ){
					case 'w':
						if(co.getPosY()<heighY*0.07)
							co.setPosY(-hY*0.05);
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
						if(co.getPosY()<heighY*0.8)
							co.setPosY(hY*0.05);
						break;
					case 'd':
						if(co.getPosX()<widthX*0.63){
							if(co.getPosX()<widthX*0.45)
								co.setPosX(widthX*0.45);
							else
								co.setPosX(widthX*0.63);
						}
						break;
					default:
						break;
				}
				switch( k.getKeyCode() ){
					case KeyEvent.VK_UP:
						if(co.getPosY()<heighY*0.07)
							co.setPosY(-hY*0.05);
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
						if(co.getPosY()<heighY*0.8)
							co.setPosY(hY*0.05);
						break;
					case KeyEvent.VK_RIGHT:
						if(co.getPosX()<widthX*0.63){
							if(co.getPosX()<widthX*0.45)
								co.setPosX(widthX*0.45);
							else
								co.setPosX(widthX*0.63);
						}
						break;
					default:
						break;
				}
			}
		});
		//contentPane2 = new JPanel();
		//Color para hacer pruebas de transparencia
		//contentPane.setForeground(Color.LIGHT_GRAY);
		//setContentPane(contentPane);
		//contentPane2.setBounds(50, 50, 100, 200);
		contentPane.setLayout(null);
		//contentPane.add(contentPane2);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       
	}
	
	public static void invocar(){
		Thread t = new Thread( new Runnable() {
			public void run() {
				try {
					JCarretera jCarretera = new JCarretera();
					while(true){
						jCarretera.repaint();
						try{
							Thread.sleep(20);
						}catch(Exception e){
							e.printStackTrace();
						}
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		t.start();
	}
	public static void invocarCoche(){
		Thread t2 = new Thread( new Runnable() {
			public void run() {
				try {
					JLabelCoche jCoche = new JLabelCoche();
					while(true){
						jCoche.repaint();
						try{
							Thread.sleep(20);
						}catch(Exception e){
							e.printStackTrace();
						}
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		t2.start();
	}
	private int alt=-512;
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
		//TODO he puesto a dormir el hilo para intentar mover el coche, pero es bastante tonto porque se duerme el mismo hilo
		// que se encarga de mover el coche...
		try{
//			Thread.sleep(200);
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			Img = new ImageIcon(getClass().getResource("img/Carretera-x-1-2.png")); 
			
			grafico.drawImage(Img.getImage(), 0, alt, height.width, height.height, null);
			alt=alt+1;
			
			Img1 = new ImageIcon(getClass().getResource("img/coche1.png")); 
			
			grafico.drawImage(Img1.getImage(), (int)co.getPosX(), (int)co.getPosY(), 40, 70, null);
		}catch (Exception ex){
			ex.printStackTrace();
		}
			
		//setOpacity entre [0,1], es un float de nivel de transparencia
//		if(getOpacity() != 0.0f)
//			setOpacity(0.0f);
//		Img.setOpaque(true);
//		super.paint(grafico);
//		super.paintComponent(grafico);
	}
}
