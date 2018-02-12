package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JLabelBost extends JLabel{

	public static final int ALTURA_BONUS = 40;
	public static final int ANCHO_BONUS = 40; 
	
	public JLabelBost(){
		try{
			setIcon(new ImageIcon(getClass().getResource("img/MonedaTrebol.png")));
		}catch (Exception e){
			System.err.println("La imagen de moneda no se ha podido encontrar");
			e.printStackTrace();
		}
		setBounds(0, 0, ANCHO_BONUS, ALTURA_BONUS);
	}

	@Override
	public void paintComponent(Graphics g){
		Image img = ((ImageIcon)getIcon()).getImage();
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, 0, 0, ANCHO_BONUS, ALTURA_BONUS, null);
	}
}
