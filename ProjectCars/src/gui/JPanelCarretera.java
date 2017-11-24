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
			setIcon(new ImageIcon(getClass().getResource("img/Carretera-x-1-2.png")));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void paintComponent(Graphics grafico){
		Dimension height = getSize();
	}
	

}
