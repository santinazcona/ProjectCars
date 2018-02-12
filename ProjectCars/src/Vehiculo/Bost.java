package Vehiculo;

public class Bost {

	protected String nombre;
	protected int x;
	protected int y;
	
	public Bost(String nombre, int x, int y) {
		super();
		this.nombre = nombre;
		this.x = x;
		this.y = y;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
}
