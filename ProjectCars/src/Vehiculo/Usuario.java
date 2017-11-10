package Vehiculo;

public class Usuario extends Coche {
	private String nombre;
	private String nick;
	private String constraseña;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getConstraseña() {
		return constraseña;
	}
	public void setConstraseña(String constraseña) {
		this.constraseña = constraseña;
	}
	public Usuario(String nombre, String nick, String constraseña) {
		super();
		this.nombre = nombre;
		this.nick = nick;
		this.constraseña = constraseña;
	}
	

}
