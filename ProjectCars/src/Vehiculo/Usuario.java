package Vehiculo;

public class Usuario extends Coche {
	private String nombre;
	private String nick;
	private String constrase�a;
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
	public String getConstrase�a() {
		return constrase�a;
	}
	public void setConstrase�a(String constrase�a) {
		this.constrase�a = constrase�a;
	}
	public Usuario(String nombre, String nick, String constrase�a) {
		super();
		this.nombre = nombre;
		this.nick = nick;
		this.constrase�a = constrase�a;
	}
	

}
