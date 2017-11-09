package Vehiculo;

public class Coche {
	
	protected String name;
	protected double posX;
	protected double posY;
	
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
	

}
