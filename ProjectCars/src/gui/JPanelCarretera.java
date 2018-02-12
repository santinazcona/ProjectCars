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
	public static final int ALTURA_CARRETERA = 1056; // 1056-(4*70) = 776; 776/4 = 194
	public static final int ANCHO_CARRETERA = 512;
	
	public JPanelCarretera(){
		this.setSize(512,1066);
		try{
			//setIcon(new ImageIcon(getClass().getResource("img/Carretera-x-1-2.png")));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private int altura= 1056-516;
	
	public void bajarCarretera( int numPixels ) {
		altura += numPixels+2;
	}
	public void paintComponent(Graphics grafico){
		Dimension height = getSize();
		try{
			ImageIcon Img = new ImageIcon(getClass().getResource("img/Carretera-x-1-2.png"));
			grafico.drawImage(Img.getImage(), 0, altura, height.width, height.height, null);
			if(altura>= 0){// && altura <= 600)
				grafico.drawImage(Img.getImage(), 0, altura-1052, height.width, height.height, null);
//				llamada();
			}
			if(altura > 512){
				altura = 512-1056; //-544
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		setOpaque(false);
		super.paintComponent(grafico);
	}
	
	public boolean[][][] invoC = new boolean[3][4][2];
	// (int) (512*0.31) = 158
	// (int) (512*0.45) = 230
	// (int) (512*0.63) = 322
	//A la hora de crear donde pueden salir los coches
	public static int[] posiIniCX  = {158, 230, 322 };
	public static int[] posiIniCY = { 0, 264, 528, 792 };

	
	public void interprete(){
		for(int i=0; i < 3; i++){
			for(int j=0; j < 4; j++){
//				System.out.println(posiIniCX[i]+", "+ posiIniCY[j]);
				if(invoC[i][j][0]){
					JLabelOtrosCoches coches = new JLabelOtrosCoches();
					coches.setLocation(posiIniCX[i], posiIniCY[j]);
				}else if(invoC[i][j][1]){
					JLabelBost bost = new JLabelBost();
					bost.setLocation(posiIniCX[i], posiIniCY[j]);
					seleccionarHab((int) (Math.random()*2));
				}
			}
		}
	}

	//Llamada
	public void llamada(){
		comoSalen((int) (Math.random()*8), 0);
	}
	
	//Como pueden salir los coches, si sale la 7º opcion, que sea un bost
	//Hecho de forma recursiva
	public void comoSalen(int i, int j){
		boolean[] lineaC = new boolean[3];
		boolean hab = false;
		if(j<4)
			switch(i){
			case 0: // 000
				lineaC[0] = false;
				lineaC[1] = false;
				lineaC[2] = false;
				comoSalen((int) (Math.random()*8), j+1);
				break;
			case 1: // 001
				lineaC[0] = false;
				lineaC[1] = false;
				lineaC[2] = true;
				comoSalen((int) (Math.random()*8), j+1);
				break;
			case 2: // 010
				lineaC[0] = false;
				lineaC[1] = true;
				lineaC[2] = false;
				comoSalen((int) (Math.random()*8), j+1);
				break;
			case 3: // 011
				lineaC[0] = false;
				lineaC[1] = true;
				lineaC[2] = true;
				comoSalen((int) (Math.random()*8), j+1);
				break;
			case 4: // 100
				lineaC[0] = true;
				lineaC[1] = false;
				lineaC[2] = false;
				comoSalen((int) (Math.random()*8), j+1);
				break;
			case 5: // 101
				lineaC[0] = true;
				lineaC[1] = false;
				lineaC[2] = true;
				comoSalen((int) (Math.random()*8), j+1);
				break;
			case 6: // 110
				lineaC[0] = true;
				lineaC[1] = true;
				lineaC[2] = false;
				comoSalen((int) (Math.random()*8), j+1);
				break;
			case 7: // 111
				comoSalen((int) (Math.random()*8), j+1);
				hab = true;
				break;
				default:
					break;
			}
		if(hab){
			boolean[] b = comoSalenHab((int) (Math.random()*4), j);
			invoC[0][j][1] = b[0];
			invoC[1][j][1] = b[1];
			invoC[2][j][1] = b[2];
		}else{
			invoC[0][j][0] = lineaC[0];
			invoC[1][j][0] = lineaC[1];
			invoC[2][j][0] = lineaC[2];
		}
		interprete();
	}
	//TODO
	public boolean[] comoSalenHab(int i, int j){
		boolean[] lineaC = new boolean[3];
		if(j<4)
			switch(i){
			case 0: // 000
				lineaC[0] = false;
				lineaC[1] = false;
				lineaC[2] = false;
				break;
			case 1: // 001
				lineaC[0] = false;
				lineaC[1] = false;
				lineaC[2] = true;
				break;
			case 2: // 010
				lineaC[0] = false;
				lineaC[1] = true;
				lineaC[2] = false;
				break;
			case 3: // 100
				lineaC[0] = true;
				lineaC[1] = false;
				lineaC[2] = false;
				break;
				default:
					break;
			}
		return lineaC;
	}

//	public boolean[] hab = new boolean[2];
	public boolean[] seleccionarHab(int i){
		boolean[] hab = new boolean[2];
		switch(i){
			case 0:
				hab[0] = true;
				hab[1] = false;
				break;
			case 1:
				hab[0] = false;
				hab[1] = true;
				break;
		}
		return hab;
	}
	
	//Array de 3 posiciones en horizontal y x en vertical
	//Interpretador de como ha de pintarse
	// 3 opciones, que salga una fial de coche, que salga un bloque de dos filas, o que salga un bloque de 3 filas, con un random
	//que salga el bloque de 3 que sea un 15%%, de 2 un 35%, y de 1 50%

}
