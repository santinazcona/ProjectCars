package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JLabelCoche extends JLabel{
	
	public static final int ALTURA_COCHE = 70;
	public static final int ANCHO_COCHE = 40; 
	
	public JLabelCoche(){
		try{
			setIcon(new ImageIcon(getClass().getResource("img/coche1.png")));
		}catch (Exception e){
			System.err.println("La imagen del coche no se ha podido encontrar");
			e.printStackTrace();
		}
		setBounds(0, 0, ANCHO_COCHE, ALTURA_COCHE);
	}

	@Override
	public void paintComponent(Graphics g){
		Image img = ((ImageIcon)getIcon()).getImage();
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, 0, 0, ANCHO_COCHE, ALTURA_COCHE, null);
	}

	public static int getAlturaCoche() {
		return ALTURA_COCHE;
	}

	public static int getAnchoCoche() {
		return ANCHO_COCHE;
	}
	
}
