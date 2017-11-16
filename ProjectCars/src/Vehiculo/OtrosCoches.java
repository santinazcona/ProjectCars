package Vehiculo;

public class OtrosCoches extends Coche{
	
	private int id;
	
	public OtrosCoches(int id, double posX, double posY){
		this.id = id;
		this.posX = posX;
		this.posY = posY;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public double getPosX(){
		return posX;
	}
	
	public double getPosY(){
		return posY;
	}
	
	public void setPosY(int posY){
		this.posY = posY;
	}

}
