package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JLabelOtrosCoches extends JLabel{

	public static final int ALTURA_COCHE = 70;
	public static final int ANCHO_COCHE = 40; 
	
	public JLabelOtrosCoches(){
		try{
			switch((int) (Math.random()*4)){
			case 0:
				setIcon(new ImageIcon(getClass().getResource("img/coche2.png")));
				break;
			case 1:
				setIcon(new ImageIcon(getClass().getResource("img/coche3.png")));
				break;
			case 2:
				setIcon(new ImageIcon(getClass().getResource("img/coche4.png")));
				break;
				default:
					break;
			}
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
		g2.rotate(Math.PI/2);
		g2.drawImage(img, 0, 0, ANCHO_COCHE, ALTURA_COCHE, null);
	}
}
