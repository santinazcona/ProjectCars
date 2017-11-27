package Vehiculo;

public class Usuario extends Coche {
	private String nombre;
	private String nick;
	private String email;
	private String contraseña;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public Usuario(String nombre, String nick, String email, String contraseña) {
		super();
		this.nombre = nombre;
		this.nick = nick;
		this.email = email;
		this.contraseña = contraseña;
	}

	
	

}
