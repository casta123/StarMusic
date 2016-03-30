package unal.poo.starmusic.varios;
/**
 * @author Sebasti�n P�rez Salas
 * @author Carlos Alejandro Ruiz Ram�rez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Casta�o Guzman
 */
import java.io.Serializable;

public class Usuario implements Serializable, ObjetoIO, Cloneable, Clonar {
	private boolean administrador;
	private String nombre;
	private String contrasena;

	public boolean isAdministrador() {
		return administrador;
	}
	public void setAdministrador(boolean value) {
		this.administrador = value;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getNombre() {
		return nombre;
	}
	public boolean isContrasenaOk(String contrasena) {
		return this.contrasena.equals(contrasena);
	}
	public String getContrasena() {
		return contrasena;
	}
	
	public Usuario(){}
	//Constructor copia
	public Usuario(Usuario o){
		this.administrador = o.administrador;
		this.contrasena = o.contrasena;
		this.nombre = o.nombre;
	}
	public Usuario clone() {
		try {
			return new Usuario(this);
		} catch (Exception e) {
			return null;
		}
	}
}
