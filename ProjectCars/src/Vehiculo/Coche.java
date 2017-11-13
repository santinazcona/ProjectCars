package Vehiculo;

import java.util.Vector;

public class Coche {
	
	protected String name;
	protected double posX;
	protected double posY;
	protected static Vector maxvelocidad = new Vector (0,100);
	protected static Vector minvelocidad = new Vector (0,10);
	protected static Vector aceleracion = new Vector();
	protected Boolean posicion; 
	
	// Constructor vacio
	public Coche(){
		name = "";
		posX = 0;
		posY = 0;
	}
	// Constructor base 1
	public Coche(String name, double posX, double posY){
		this.name = name;
		this.posX = posX;
		this.posY = posY;
		//this.aceleracion.set(0, 0);
	}
	
	public void movimiento(){
		
		
	}
	
	//Getters and Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPosX() {
		return posX;
	}
	public void setPosX(double posX) {
		this.posX = posX;
	}
	public double getPosY() {
		return posY;
	}
	public void setPosY(double posY) {
		this.posY = posY;
	}
//	public void setAcel(double x, double y){
//		this.posX = x;
//		this.posY = y;
//	}
	

}
