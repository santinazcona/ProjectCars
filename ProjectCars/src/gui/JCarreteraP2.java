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
import java.awt.FlowLayout;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class JCarreteraP2 extends JFrame{


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
					JPanelCarretera jPC = new JPanelCarretera();
					JLabelCoche c1 = new JLabelCoche();
					JLabelOtrosCoches c2 = new JLabelOtrosCoches();
					jCarreteraP2.add(jPC);
					jPC.add(c1);
					jPC.add(c2);
//					invocarOtrosCoche(); //no dibuja, porque no se añaden al panel
					while(true){
						System.out.println( "En bucle invocar");
//						c1.setLocation(c1.getX()+1, c1.getY()+1);
//						c2.setLocation(c2.getX()+2, c2.getY()+2);
//						jPC.repaint();
////						jCarreteraP2.repaint(); //repaint(x, y, width, height); (position x , position y, width, height)
//						try{
//							Thread.sleep(20);
//						}catch(Exception e){
//							e.printStackTrace();
//						}
						
					
						jCarreteraP2.addKeyListener(new KeyAdapter() {
							@Override
							public void keyPressed(KeyEvent k) {
								switch( k.getKeyChar() ){
									case 'w':
										if(c1.getLocation().getY()<heighY*0.07){
											System.out.println(c1.getY());
											c1.setLocation(c1.getX(), c1.getY()+1);
											System.out.println(c1.getY());
										}
	//									if(co.getPosY()<heighY*0.07)
	//										co.setPosY(-hY*0.05);
										break;
									case 'e':
										break;
									case 'a':
										if(c1.getX() > widthX*0.31) 
											c1.setLocation(c1.getX()-1, c1.getY());
											
	//									if(co.getPosX()> widthX*0.31) {
	//										if(co.getPosX()> widthX*0.45)
	//											co.setPosX(widthX*0.45);
	//										else
	//											co.setPosX(widthX*0.31);
	//									}
										break;
									case 's':
										if(c1.getY() < heighY*0.9)
											c1.setLocation(c1.getX(), c1.getY()-1);
	//									if(co.getPosY()<heighY*0.8)
	//										co.setPosY(hY*0.05);
										break;
									case 'd':
										if(c1.getX() < widthX*0.63)
											c1.setLocation(c1.getX()+1, c1.getY());
											
	//									if(co.getPosX()<widthX*0.63){
	//										if(co.getPosX()<widthX*0.45)
	//											co.setPosX(widthX*0.45);
	//										else
	//											co.setPosX(widthX*0.63);
	//									}
										break;
									default:
										break;
								}
								switch( k.getKeyCode() ){
									case KeyEvent.VK_UP:
										if(c1.getY()<heighY*0.07)
											c1.setLocation(c1.getX(), c1.getY());
//											co.setPosY(-hY*0.05);
										break;
									case KeyEvent.VK_LEFT:
										if(c1.getX() > widthX*0.31)
											c1.setLocation(c1.getX()-1, c1.getY());
//										if(co.getPosX()> widthX*0.31) {
//											if(co.getPosX()> widthX*0.45)
//												co.setPosX(widthX*0.45);
//											else
//												co.setPosX(widthX*0.31);
//										}
										break;
									case KeyEvent.VK_DOWN:
										if(c1.getY() < heighY*0.8)
											c1.setLocation(c1.getX(), c1.getY()+1);
//										if(co.getPosY()<heighY*0.8)
//											co.setPosY(hY*0.05);
										break;
									case KeyEvent.VK_RIGHT:
										if(c1.getX()<widthX*0.63)
											c1.setLocation(c1.getX(), c1.getY());
//										if(co.getPosX()<widthX*0.63){
//											if(co.getPosX()<widthX*0.45)
//												co.setPosX(widthX*0.45);
//											else
//												co.setPosX(widthX*0.63);
//										}
										break;
									default:
										break;
								}
								jPC.repaint();
							}
						});
						jPC.bajarCarretera( 1 );
						jPC.repaint();
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
						System.out.println( "En bucle invocarCoche");
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
	public static void invocarOtrosCoche(){
		Thread t3 = new Thread( new Runnable() {
			public void run() {
				try {
					JLabelCoche jOtrosCoche = new JLabelCoche();
					while(true){
						System.out.println( "En bucle invocarOtrosCoche");
						jOtrosCoche.repaint();
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
		t3.start();
		invocarOtrosCoche();
	}
	public JCarreteraP2() {
//		this.setSize(300, 400);
		//setBounds(0, 0, 700, 900);
		//invocarCoche();
		setBounds(200,0, widthX, heighY);
		setVisible(true);
		setResizable(false);
		setTitle("Carretera");
		contentPane = new JFrame();
		JPanelCarretera jPC = new JPanelCarretera();
		jPC.setBounds(0, 0, 512, 512);
		contentPane.getContentPane().add(jPC);
		jPC.setBorder(new EmptyBorder(0, 0, 0, 0));
		FlowLayout flowLayout = (FlowLayout) jPC.getLayout();
		flowLayout.setAlignOnBaseline(true);
		flowLayout.setAlignment(FlowLayout.LEADING);
		flowLayout.setVgap(250);
		flowLayout.setHgap(250);
//		contentPane.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyPressed(KeyEvent k) {
//				switch( k.getKeyChar() ){
//					case 'w':
//						if(co.getPosY()<heighY*0.07)
//							co.setPosY(-hY*0.05);
//						break;
//					case 'e':
//						break;
//					case 'a':
//						if(co.getPosX()> widthX*0.31) {
//							if(co.getPosX()> widthX*0.45)
//								co.setPosX(widthX*0.45);
//							else
//								co.setPosX(widthX*0.31);
//						}
//						break;
//					case 's':
//						if(co.getPosY()<heighY*0.8)
//							co.setPosY(hY*0.05);
//						break;
//					case 'd':
//						if(co.getPosX()<widthX*0.63){
//							if(co.getPosX()<widthX*0.45)
//								co.setPosX(widthX*0.45);
//							else
//								co.setPosX(widthX*0.63);
//						}
//						break;
//					default:
//						break;
//				}
//				switch( k.getKeyCode() ){
//					case KeyEvent.VK_UP:
//						if(co.getPosY()<heighY*0.07)
//							co.setPosY(-hY*0.05);
//						break;
//					case KeyEvent.VK_LEFT:
//						if(co.getPosX()> widthX*0.31) {
//							if(co.getPosX()> widthX*0.45)
//								co.setPosX(widthX*0.45);
//							else
//								co.setPosX(widthX*0.31);
//						}
//						break;
//					case KeyEvent.VK_DOWN:
//						if(co.getPosY()<heighY*0.8)
//							co.setPosY(hY*0.05);
//						break;
//					case KeyEvent.VK_RIGHT:
//						if(co.getPosX()<widthX*0.63){
//							if(co.getPosX()<widthX*0.45)
//								co.setPosX(widthX*0.45);
//							else
//								co.setPosX(widthX*0.63);
//						}
//						break;
//					default:
//						break;
//				}
//			}
//		});
		//contentPane2 = new JPanel();
		//setContentPane(contentPane);
		//contentPane2.setBounds(50, 50, 100, 200);
		contentPane.getContentPane().setLayout(null);
		//contentPane.add(contentPane2);
//		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       
	}
	private int y=-528;
	
	//TODO
	//En un JFRame no se puede usar paintComponente
	//EL JFrame tiene pait para dibujar los paneles
	/*
	@Override
	public void paintComponent(Graphics g3){
		Image img= ((ImageIcon)getIcon()).getImage(); //"img/Carretera-x-1-2.png"
		Graphics2D g4 = (Graphics2D) g3;
		g4.drawImage(img, 0, y, 512, 1056, null);
		y = y+ 1;
	}
	*/
	
//	@Override
//	public void paintComponent(Graphics g){
//		Image img = ((ImageIcon)getIcon()).getImage();
//		Graphics2D g2 = (Graphics2D) g;
//		g2.drawImage(img, 0, 0, ANCHO_COCHE, ALTURA_COCHE, null);
//	}
}
