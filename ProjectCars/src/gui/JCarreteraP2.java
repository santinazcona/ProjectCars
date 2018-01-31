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

public class JCarreteraP2 extends JFrame {

	private JFrame contentPane;
	private JPanel contentP;
	private JPanel contentP2;
	private BufferedImage image;
	private ImageIcon Img;
	private ImageIcon Img1;
	private static int widthX = 512;
	private static int heighY = 512;
	private static double hY = (double) (heighY);
	// public static Coche co = new Coche("c1", widthX*0.31, 400);
	public static Coche co = new Coche("c1", widthX * 0.31, 400);

	public static boolean[] mov = { 
			false,  //w
			false,  //a
			false,  //s
			false,  //d
			false,  //e || "espacio" esta aun sin uso, pero para recordar hacer algo
			false   //p para pausar 
	};
	public static int[] vel = {
			0, //Para x dom = [-3, 3]
			0  //Para y dom = [-3, 3]
	};

	public static void invocar() {
		Thread t = new Thread(new Runnable() {
			public void run() {
				try {
					JCarreteraP2 jCarreteraP2 = new JCarreteraP2();
					JPanelCarretera jPC = new JPanelCarretera();
					JLabelCoche c1 = new JLabelCoche();
					JLabelOtrosCoches c2 = new JLabelOtrosCoches();
					jCarreteraP2.add(jPC);
					jPC.add(c1);
					jPC.add(c2);
					c1.setLocation((int) (widthX * 0.45), 400);
					// invocarOtrosCoche(); //no dibuja, porque no se añaden al
					// panel
					jCarreteraP2.addKeyListener(new KeyAdapter() {
						@Override
						public void keyPressed(KeyEvent k) {
							switch (k.getKeyChar()) {
							case 'w':
//								if (c1.getLocation().getY() < heighY * 0.07) {
//									System.out.println(c1.getY());
//									c1.setLocation(c1.getX(), c1.getY() + 1);
//									System.out.println(c1.getY());
//								}
								// if(co.getPosY()<heighY*0.07)
								// co.setPosY(-hY*0.05);
								if(c1.getY() > heighY*0.05)
									mov[0] = true;
								if(vel[1] > 0){
									vel[1] = 0;
								}
								if(vel[1] > -3)
									vel[1]--;
								break;
							case 'a':
//								if (c1.getX() > widthX * 0.31)
//									c1.setLocation(c1.getX() - 1, c1.getY());

								// if(co.getPosX()> widthX*0.31) {
								// if(co.getPosX()> widthX*0.45)
								// co.setPosX(widthX*0.45);
								// else
								// co.setPosX(widthX*0.31);
								// }
								if(c1.getX() > widthX*0.268)
									mov[1] = true;
								if(vel[0] > 0){
									vel[0] = 0;
								}
								if(vel[0] > -3)
									vel[0]--;
								break;
							case 's':
//								if (c1.getY() < heighY * 0.9)
//									c1.setLocation(c1.getX(), c1.getY() - 1);
								// if(co.getPosY()<heighY*0.8)
								// co.setPosY(hY*0.05);
								if(c1.getY() < heighY*0.9)
									mov[2] = true;
								if(vel[1] < 0){
									vel[1] = 0;
								}
								if(vel[1] < 3)
									vel[1]++;
								break;
							case 'd':
//								if (c1.getX() < widthX * 0.63)
//									c1.setLocation(c1.getX() + 1, c1.getY());

								// if(co.getPosX()<widthX*0.63){
								// if(co.getPosX()<widthX*0.45)
								// co.setPosX(widthX*0.45);
								// else
								// co.setPosX(widthX*0.63);
								// }
								if(c1.getX() < widthX*0.629)
									mov[3] = true;
								if(vel[0] < 0){
									vel[0] = 0;
								}
								if(vel[0] < 3)
									vel[0]++;
								break;
							case 'e':
								mov[4] = true;
								break;
							case ' ':
								mov[4] = true;
								break;
							case 'p':
								mov[5] = true;
							default:
								break;
							}
							switch (k.getKeyCode()) {
							case KeyEvent.VK_UP:
//								if (c1.getY() < heighY * 0.07)
//									c1.setLocation(c1.getX(), c1.getY());
								// co.setPosY(-hY*0.05);
								mov[0] = true;
								break;
							case KeyEvent.VK_LEFT:
//								if (c1.getX() > widthX * 0.31)
//									c1.setLocation(c1.getX() - 1, c1.getY());
								// if(co.getPosX()> widthX*0.31) {
								// if(co.getPosX()> widthX*0.45)
								// co.setPosX(widthX*0.45);
								// else
								// co.setPosX(widthX*0.31);
								// }
								mov[1] = true;
								break;
							case KeyEvent.VK_DOWN:
//								if (c1.getY() < heighY * 0.8)
//									c1.setLocation(c1.getX(), c1.getY() + 1);
								// if(co.getPosY()<heighY*0.8)
								// co.setPosY(hY*0.05);
								mov[2] = true;
								break;
							case KeyEvent.VK_RIGHT:
//								if (c1.getX() < widthX * 0.63)
//									c1.setLocation(c1.getX(), c1.getY());
								// if(co.getPosX()<widthX*0.63){
								// if(co.getPosX()<widthX*0.45)
								// co.setPosX(widthX*0.45);
								// else
								// co.setPosX(widthX*0.63);
								// }
								mov[3] = true;
								break;
							default:
								break;
							}
							jPC.repaint();
						}
					});

					while (true) {
						System.out.println("En bucle invocar");
						// c1.setLocation(c1.getX()+1, c1.getY()+1);
						// c2.setLocation(c2.getX()+2, c2.getY()+2);
						// jPC.repaint();
						//// jCarreteraP2.repaint(); //repaint(x, y, width,
						// height); (position x , position y, width, height)
						// try{
						// Thread.sleep(20);
						// }catch(Exception e){
						// e.printStackTrace();
						// }
						
						jPC.bajarCarretera(1);
						jPC.repaint();
						
						if(mov[0]){	
							c1.setLocation(c1.getX(), c1.getY()+vel[1]);
							mov[0] = false;
						}
						if(mov[1]){	
							c1.setLocation(c1.getX()+vel[0], c1.getY());
							mov[1] = false;
						}
						if(mov[2]){	
							c1.setLocation(c1.getX(), c1.getY()+vel[1]);
							mov[2] = false;
							System.out.println(c1.getX());
						}
						if(mov[3]){	
							c1.setLocation(c1.getX()+vel[0], c1.getY());
							mov[3] = false;
						}
						if(mov[4]){	
							//Aun hay que hacer el metodo para que las habilidades
							mov[4] = false;
						}
						if(mov[5]){
							//crear una nueva ventana desde aqui, con lo que el hilo que ejecuta el juego se parará
							mov[5] = false;
						}
//						mov[1] = false;
//						mov[2] = false;
//						mov[3] = false;
//						mov[4] = false;
//						mov[5] = false;
						try {
							Thread.sleep(20);
						} catch (Exception e) {
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

	public static void invocarCoche() {
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					JLabelCoche jCoche = new JLabelCoche();
					while (true) {
						System.out.println("En bucle invocarCoche");
						jCoche.repaint();
						try {
							Thread.sleep(20);
						} catch (Exception e) {
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

	public static void invocarOtrosCoche() {
		Thread t3 = new Thread(new Runnable() {
			public void run() {
				try {
					JLabelCoche jOtrosCoche = new JLabelCoche();
					while (true) {
						System.out.println("En bucle invocarOtrosCoche");
						jOtrosCoche.repaint();
						try {
							Thread.sleep(20);
						} catch (Exception e) {
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
		// this.setSize(300, 400);
		// setBounds(0, 0, 700, 900);
		// invocarCoche();
		setBounds(200, 0, widthX, heighY);
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
		// contentPane.addKeyListener(new KeyAdapter() {
		// @Override
		// public void keyPressed(KeyEvent k) {
		// switch( k.getKeyChar() ){
		// case 'w':
		// if(co.getPosY()<heighY*0.07)
		// co.setPosY(-hY*0.05);
		// break;
		// case 'e':
		// break;
		// case 'a':
		// if(co.getPosX()> widthX*0.31) {
		// if(co.getPosX()> widthX*0.45)
		// co.setPosX(widthX*0.45);
		// else
		// co.setPosX(widthX*0.31);
		// }
		// break;
		// case 's':
		// if(co.getPosY()<heighY*0.8)
		// co.setPosY(hY*0.05);
		// break;
		// case 'd':
		// if(co.getPosX()<widthX*0.63){
		// if(co.getPosX()<widthX*0.45)
		// co.setPosX(widthX*0.45);
		// else
		// co.setPosX(widthX*0.63);
		// }
		// break;
		// default:
		// break;
		// }
		// switch( k.getKeyCode() ){
		// case KeyEvent.VK_UP:
		// if(co.getPosY()<heighY*0.07)
		// co.setPosY(-hY*0.05);
		// break;
		// case KeyEvent.VK_LEFT:
		// if(co.getPosX()> widthX*0.31) {
		// if(co.getPosX()> widthX*0.45)
		// co.setPosX(widthX*0.45);
		// else
		// co.setPosX(widthX*0.31);
		// }
		// break;
		// case KeyEvent.VK_DOWN:
		// if(co.getPosY()<heighY*0.8)
		// co.setPosY(hY*0.05);
		// break;
		// case KeyEvent.VK_RIGHT:
		// if(co.getPosX()<widthX*0.63){
		// if(co.getPosX()<widthX*0.45)
		// co.setPosX(widthX*0.45);
		// else
		// co.setPosX(widthX*0.63);
		// }
		// break;
		// default:
		// break;
		// }
		// }
		// });
		// contentPane2 = new JPanel();
		// setContentPane(contentPane);
		// contentPane2.setBounds(50, 50, 100, 200);
		contentPane.getContentPane().setLayout(null);
		// contentPane.add(contentPane2);
		// this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

	private int y = -528;

	// TODO
	// En un JFRame no se puede usar paintComponente
	// EL JFrame tiene pait para dibujar los paneles
	/*
	 * @Override public void paintComponent(Graphics g3){ Image img=
	 * ((ImageIcon)getIcon()).getImage(); //"img/Carretera-x-1-2.png" Graphics2D
	 * g4 = (Graphics2D) g3; g4.drawImage(img, 0, y, 512, 1056, null); y = y+ 1;
	 * }
	 */

	// @Override
	// public void paintComponent(Graphics g){
	// Image img = ((ImageIcon)getIcon()).getImage();
	// Graphics2D g2 = (Graphics2D) g;
	// g2.drawImage(img, 0, 0, ANCHO_COCHE, ALTURA_COCHE, null);
	// }
}
