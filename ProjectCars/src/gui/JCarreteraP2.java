package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Vehiculo.Coche;

public class JCarreteraP2 extends JPanel{


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
	
	
	public static void invocar(){
		Thread t = new Thread( new Runnable() {
			public void run() {
				try {
					JCarreteraP2 jCarreteraP2 = new JCarreteraP2();
					while(true){
						jCarreteraP2.repaint();
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
	
	public JCarreteraP2() {
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
		//setContentPane(contentPane);
		//contentPane2.setBounds(50, 50, 100, 200);
		contentPane.setLayout(null);
		//contentPane.add(contentPane2);
//		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       
	}
	private int y=-528;
	@Override
	public void paintComponent(Graphics g3){
		Image img= ((ImageIcon)getIcon()).getImage();
		Graphics2D g4 = (Graphics2D) g;
		g4.drawImage(img, 0, y, 512, 1056, null);
		y = y+ 1;
	}
	
//	@Override
//	public void paintComponent(Graphics g){
//		Image img = ((ImageIcon)getIcon()).getImage();
//		Graphics2D g2 = (Graphics2D) g;
//		g2.drawImage(img, 0, 0, ANCHO_COCHE, ALTURA_COCHE, null);
//	}
}
