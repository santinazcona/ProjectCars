package Vehiculo;

public class Usuario extends Coche {
	private String nombre;
	private String nick;
	private String contrase�a;
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
	public String getContrase�a() {
		return contrase�a;
	}
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	public Usuario(String nombre, String nick, String contrase�a) {
		super();
		this.nombre = nombre;
		this.nick = nick;
		this.contrase�a = contrase�a;
	}
	

}
