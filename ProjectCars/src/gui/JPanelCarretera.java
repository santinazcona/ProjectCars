package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class JPanelCarretera extends JPanel{
	/*
	 * JCarreteraP2 es un JFrame donde meter el JLabel de tu coche
	 * dos JPanel de la carretera y su generacion de coches en ella
	 */
	
	private JPanel contentP;
	private ImageIcon Img;
	private static int widthX = 512;
	private static int heighY = 1056;
	public static final int ALTURA_CARRETERA = 1056;
	public static final int ANCHO_CARRETERA = 512;
	
	public JPanelCarretera(){
		this.setSize(512,1056);
		try{
			//setIcon(new ImageIcon(getClass().getResource("img/Carretera-x-1-2.png")));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private int altura= 1056-520;
	
	public void bajarCarretera( int numPixels ) {
		altura += numPixels;
	}
	public void paintComponent(Graphics grafico){
		Dimension height = getSize();
		try{
			ImageIcon Img = new ImageIcon(getClass().getResource("img/Carretera-x-1-2.png"));
			grafico.drawImage(Img.getImage(), 0, altura, height.width, height.height, null);
			if(altura>= 0)// && altura <= 600)
				grafico.drawImage(Img.getImage(), 0, altura-1048, height.width, height.height, null);
			if(altura > 512)
				altura = 500-1056; //-544
		}catch(Exception e){
			e.printStackTrace();
		}
		setOpaque(false);
		super.paintComponent(grafico);
	}
	

}
