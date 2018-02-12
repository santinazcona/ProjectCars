package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;

import Vehiculo.Coche;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	public static Coche co = new Coche("c1", widthX * 0.45, 400);

	public static boolean finalizar = true;
	public static boolean[] mov = { 
			false,  //w
			false,  //a
			false,  //s
			false,  //d
			false,  //e || "espacio" esta aun sin uso, pero para recordar hacer algo
			false   //p para pausar 
	};
	public static boolean[] hab = {
			false,	//sprint
			false	//inmortal
	};
	public static int[] vel = {
			0, //Para x dom = [-3, 3]
			0  //Para y dom = [-3, 3]
	};
	public static int sprint = 0;
	public static int contHab = 0; //TODO
	public static long time_start, time_pausa, time_end;

	public static void invocar(/*JFrame frame*/) {
		Thread t = new Thread(new Runnable() {
			public void run() {
				try {
					time_start = System.currentTimeMillis();
					JCarreteraP2 jCarreteraP2 = new JCarreteraP2();
					JPanelCarretera jPC = new JPanelCarretera();
					JLabelCoche c1 = new JLabelCoche();
					JLabelOtrosCoches c2 = new JLabelOtrosCoches();
					JLabel jbost = new JLabel();
					JTextField bost = new JTextField("");
					bost.setEditable(false);
					jbost.add(bost);
					jbost.setBackground(Color.WHITE);
					jbost.setBounds(0, 0, 70, 15);
					jCarreteraP2.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					//Panel de pausa TODO
					JPanel pausa = new JPanel();
//					JPopupMenu pausa = new JPopupMenu();
					pausa.setBounds(130, 130, 252, 252);
					
					//Botones pausa;
					JButton cont = new JButton("CONTINUAR"); //TOOD //Deberia llamarse bCont
					cont.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							jPC.remove(c1);
							mov[5] = false;
							jPC.add(c1);
							movimientoCoche(jCarreteraP2, c1);
						}
					});
					JButton sal = new JButton("SALIR");
					sal.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0){
							mov[5] = false;
							finalizar = false;
							jCarreteraP2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//							frame.setDefaultCloseOperation( JCarreteraP2.EXIT_ON_CLOSE );
//							frame.setDefaultCloseOperation( JCarreteraP2.DISPOSE_ON_CLOSE );
//							frame.dispose();
						}
					});
					pausa.add(cont);
					pausa.add(sal);
					cont.setBounds(66, 35, 120, 20);
					sal.setBounds(90, 75, 72, 20);
//					jCarreteraP2.getContentPane().add(pausa);
//					jCarreteraP2.add(pausa);
//					pausa.setBounds(120, 120, 272, 272);				
//					pausa.setVisible(mov[5]);
					jCarreteraP2.getContentPane().add(jPC);
					jPC.add(jbost);
					jPC.add(pausa);
					movimientoCoche(jCarreteraP2, c1);
					jPC.add(c1);
					jPC.add(c2);
					pausa.remove(cont);
					pausa.remove(sal);
					pausa.setBackground(Color.WHITE);
					pausa.setOpaque(mov[5]);
					c1.setLocation((int) (widthX * 0.45), 400);
					// invocarOtrosCoche(); //no dibuja, porque no se añaden al
					// panel
//					movimientoCoche(jCarreteraP2, c1);
					
					do{ //TODO
//					while (true) {
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
						if(hab[0]){
							if(contHab<25){
								contHab++;
								if(mov[2]){
									sprint = 1;
								}else{
									sprint = -1;
								}
							}else{
								contHab = 0;
								hab[0] = false;
							}
							jPC.bajarCarretera(1-sprint);
						}
						if(hab[1]){
							if(contHab<30){
								contHab++;
							}else{
								contHab = 0;
								hab[1] = false;
							}
							jPC.bajarCarretera(1);
						}else{
							//hacer hit
						}
						jPC.bajarCarretera(1);
						
						jPC.repaint();
						if((mov[0] || mov[2]) || (mov[1] || mov[3])){
							movimineto();
							c1.setLocation(c1.getX()+vel[0], c1.getY()+vel[1]+sprint);

							if(c1.getY() < heighY*0.05)
								c1.setLocation(c1.getX(), (int) (heighY*0.05));
							if(c1.getY() > heighY*0.9)
								c1.setLocation(c1.getX(), (int) (heighY*0.9));
							if(c1.getX() < widthX*0.268)
								c1.setLocation((int) (widthX*0.268), c1.getY());
							if(c1.getX() > widthX*0.629)
								c1.setLocation((int) (widthX*0.629), c1.getY());
							
						}
						if(mov[4]){	
							//Aun hay que hacer el metodo para que las habilidades
							mov[4] = false;
						}
						if(mov[5]){ //TODO
							time_end = System.currentTimeMillis();
							time_pausa = time_pausa + (time_end-time_start);
							pausa.setOpaque(mov[5]);
							pausa.add(cont); pausa.setEnabled(true);
							pausa.add(sal); pausa.setEnabled(true);
							while(mov[5]){
								//crear una nueva ventana desde aqui, con lo que el hilo que ejecuta el juego se parará
								//Que muestre algo para visualizar la pausa
								try {
									Thread.sleep(20);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
//							jPC.remove(pausa);
							pausa.setOpaque(mov[5]);
//							cont.setOpaque(mov[5]);
//							cont.setEnabled(mov[5]);
							pausa.remove(cont);
							pausa.remove(sal);
							c1.setOpaque(true);
							time_start = System.currentTimeMillis();
						}
						try {
							Thread.sleep(20);
						} catch (Exception e) {
							e.printStackTrace();
						}
//					}
					}while(finalizar); //TODO
					time_pausa = time_pausa + (time_end - time_start);
					jCarreteraP2.dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

			private void movimientoCoche(JCarreteraP2 jCarreteraP2, JLabelCoche c1) {
				//Movimiento horizontal TODO
				jCarreteraP2.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent j) {
						switch(j.getKeyChar()){
							case 'w':
//								if (c1.getLocation().getY() < heighY * 0.07) {
//									System.out.println(c1.getY());
//									c1.setLocation(c1.getX(), c1.getY() + 1);
//									System.out.println(c1.getY());
//								}
								// if(co.getPosY()<heighY*0.07)
								// co.setPosY(-hY*0.05);
								if(c1.getY() > heighY*0.05){
									mov[0] = true;
//									if(vel[1] > 0){
//										vel[1] = 0;
//									}
//									if(vel[1] > -3)
//										vel[1]--;
								}else mov[0] = false;
								break;
							case 's':
//								if (c1.getY() < heighY * 0.9)
//									c1.setLocation(c1.getX(), c1.getY() - 1);
								// if(co.getPosY()<heighY*0.8)
								// co.setPosY(hY*0.05);
								if(c1.getY() < heighY*0.9){
									mov[2] = true;
//									if(vel[1] < 0)
//										vel[1] = 0;
//									if(vel[1] < 3)
//										vel[1]++;
								}else mov[2] = false;
								break;
								default:
									break;
						}
						switch(j.getKeyCode()){
						case KeyEvent.VK_UP:
//							if (c1.getY() < heighY * 0.07)
//								c1.setLocation(c1.getX(), c1.getY());
							// co.setPosY(-hY*0.05);
							if(c1.getY() > heighY*0.05){
								mov[0] = true;
								if(vel[1] > 0){
									vel[1] = 0;
								}
								if(vel[1] > -3)
									vel[1]--;
							}else mov[0] = false;
							break;
						case KeyEvent.VK_DOWN:
//							if (c1.getY() < heighY * 0.8)
//								c1.setLocation(c1.getX(), c1.getY() + 1);
							// if(co.getPosY()<heighY*0.8)
							// co.setPosY(hY*0.05);
							if(c1.getY() < heighY*0.9){
								mov[2] = true;
								if(vel[1] < 0)
									vel[1] = 0;
								if(vel[1] < 3)
									vel[1]++;
							}else mov[2] = false;
							break;
						default:
							break;
						}
					}
					@Override
					public void keyReleased(KeyEvent j) {
						switch(j.getKeyChar()){
						case 'w':
							mov[0] = false;
							vel[1]=0;
							break;
						case 's':
							mov[2] = false;
							vel[1]=0;
							break;
							default:
								break;
						}
						switch(j.getKeyCode()){
						case KeyEvent.VK_UP:
							mov[0] = false;
							vel[1]=0;
							break;
						case KeyEvent.VK_DOWN:
							mov[2] = false;
							vel[1]=0;
							break;
							default:
								break;
						}
					}
				});
				//Movimiento lateral TODO
				jCarreteraP2.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent k) {
						switch (k.getKeyChar()) {
						case 'a':
//							if (c1.getX() > widthX * 0.31)
//								c1.setLocation(c1.getX() - 1, c1.getY());

							// if(co.getPosX()> widthX*0.31) {
							// if(co.getPosX()> widthX*0.45)
							// co.setPosX(widthX*0.45);
							// else
							// co.setPosX(widthX*0.31);
							// }
							if(c1.getX() > widthX*0.268){
								mov[1] = true;
//								if(vel[0] > 0)
//									vel[0] = 0;
//								if(vel[0] > -3)
//									vel[0]--;
							}else mov[1] = false;
							break;
						case 'd':
//							if (c1.getX() < widthX * 0.63)
//								c1.setLocation(c1.getX() + 1, c1.getY());

							// if(co.getPosX()<widthX*0.63){
							// if(co.getPosX()<widthX*0.45)
							// co.setPosX(widthX*0.45);
							// else
							// co.setPosX(widthX*0.63);
							// }
							if(c1.getX() < widthX*0.629){
									mov[3] = true;
//								if(vel[0] < 0)
//									vel[0] = 0;
//								if(vel[0] < 3)
//									vel[0]++;
							}else mov[3] = false;
							break;
						default:
							break;
						}
						switch (k.getKeyCode()) {
						case KeyEvent.VK_LEFT:
//							if (c1.getX() > widthX * 0.31)
//								c1.setLocation(c1.getX() - 1, c1.getY());
							// if(co.getPosX()> widthX*0.31) {
							// if(co.getPosX()> widthX*0.45)
							// co.setPosX(widthX*0.45);
							// else
							// co.setPosX(widthX*0.31);
							// }
							if(c1.getX() > widthX*0.268){
								mov[1] = true;
								if(vel[0] > 0)
									vel[0] = 0;
								if(vel[0] > -3)
									vel[0]--;
							}else mov[1] = false;
							break;
						case KeyEvent.VK_RIGHT:
//							if (c1.getX() < widthX * 0.63)
//								c1.setLocation(c1.getX(), c1.getY());
							// if(co.getPosX()<widthX*0.63){
							// if(co.getPosX()<widthX*0.45)
							// co.setPosX(widthX*0.45);
							// else
							// co.setPosX(widthX*0.63);
							// }
							if(c1.getX() < widthX*0.629){
								mov[3] = true;
								if(vel[0] < 0)
									vel[0] = 0;
								if(vel[0] < 3)
									vel[0]++;
							}else mov[3] = false;
							break;
						default:
							break;
						}
					}
					@Override
					public void keyReleased(KeyEvent j) {
						switch(j.getKeyChar()){
						case 'a':
							mov[1] = false;
							vel[0]=0;
							break;
						case 'd':
							mov[3] = false;
							vel[0]=0;
							break;
							default:
								break;
						}
						switch(j.getKeyCode()){
						case KeyEvent.VK_LEFT:
							mov[1] = false;
							vel[0]=0;
							break;
						case KeyEvent.VK_RIGHT:
							mov[3] = false;
							vel[0]=0;
							break;
							default:
								break;
						}
					}
				});
				//Teclas de acción TODO
				jCarreteraP2.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent p) {
						switch (p.getKeyChar()) {
						case 'e':
							hab[0] = true;
							mov[4] = true;
							break;
						case ' ':
							mov[4] = true;
							break;
						case 'p':
							if(mov[5])
								mov[5] = false;
							else
								mov[5] = true;
						default:
							break;
						}
					}
				});
			}
		});

		t.start();
	}

	public static void movimineto(){
		if(mov[0] && vel[1] > -3){
			if(vel[1] > 0)
				vel[1] = 0;
			vel[1]--;
		}
		if(mov[2] && vel[1] < 3){
			if(vel[1] < 0)
				vel[1] = 0;
			vel[1]++;
		}								
		if(mov[1] && vel[0] > -3){
			if(vel[0] > 0)
				vel[0] = 0;
			vel[0]--;
		}
		if(mov[3] && vel[0] < 3){
			if(vel[0] < 0)
				vel[0] = 0;
			vel[0]++;
		}
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
		// breakJPanel pausa = new JPanel();
		//Botones pausa;
//		JButton cont = new JButton("CONTINUAR");
		//TODO
//		JPanel pausa = new JPanel();
//		pausa.setBounds(120, 120, 272, 272);
//		
//		JButton cont = new JButton("CONTINUAR");
//		cont.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//				mov[5] = true;
//			}
//		});
//		JButton sal = new JButton("SALIR");
//		sal.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent arg0){
//				seguir = false;
//			}
//		});
//		pausa.add(cont);
//		pausa.add(sal);
//		jPC.add(pausa);
//		
//		pausa.setVisible(mov[5]);
		
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
