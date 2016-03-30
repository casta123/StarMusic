package unal.poo.starmusic.menuconsola;

import unal.poo.starmusic.varios.Lectura;
import unal.poo.starmusic.varios.InicioSesion;
import unal.poo.starmusic.varios.Usuario;
/**
 * @author Sebastián Pérez Salas
 * @author Carlos Alejandro Ruiz Ramírez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Castaño Guzman
 */
/*
 * Esta clase es un formulario que crea un objeto usuario, que luego
 * sera usado para la autenticacion de la aplicacion 
 */
public class Mi_AgregarUsuario extends OpcionDeMenu implements deshechar {
	Usuario usuario;
	@Override
	public void ejecutar() {
		Usuario usuario = new Usuario();
		System.out.print("Nombre: ");
		usuario.setNombre(Lectura.Leer());
		System.out.print("Contraseña: ");
		usuario.setContrasena(Lectura.Leer());

		for (;;) {

			System.out.println("Rol 0-Final 1-Administrador: ");
			int i = Integer.parseInt(Lectura.Leer());
			if (i == 1 || i == 0) {
				if (i == 1)
					usuario.setAdministrador(true);
				else
					usuario.setAdministrador(false);
				break;
			} else {
				System.out.println("Rol incorrecto");
			}
		}

		InicioSesion sesion = new InicioSesion();
		if (sesion.agregarUsuario(usuario)) {
			this.usuario = usuario;
			System.out.println("Usuario agregado correctamente");
		} else {
			System.err.println("Entrada duplicada");
		}

	}
	public String getNombre() {
		return "Agregar usuario";
	}
	public void deshacer() {
		System.out.println("Tratando de deshacer");
		if(usuario != null){
			InicioSesion sesion = new InicioSesion();
			sesion.eliminarUsuario(usuario);	
			System.out.println("Se ha eliminado el usuario "+usuario.getNombre());
		}
	}
	public void rehacer() {
		if(usuario != null){
			InicioSesion sesion = new InicioSesion();
			sesion.agregarUsuario(usuario);	
			System.out.println("Se ha restablecido el usuario "+usuario.getNombre());

		}

	}
	public Mi_AgregarUsuario() {}

	public Mi_AgregarUsuario(Mi_AgregarUsuario o) {
		
		if(o.usuario != null)
		this.usuario = (Usuario)o.usuario.clone();
		
	}
	public OpcionDeMenu clone(){
		try{
			return (OpcionDeMenu) new Mi_AgregarUsuario(this);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

}
