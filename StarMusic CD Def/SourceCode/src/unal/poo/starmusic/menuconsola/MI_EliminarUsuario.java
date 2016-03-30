package unal.poo.starmusic.menuconsola;

import unal.poo.starmusic.varios.InicioSesion;
import unal.poo.starmusic.varios.Lectura;
import unal.poo.starmusic.varios.Usuario;
/**
 * @author Sebastián Pérez Salas
 * @author Carlos Alejandro Ruiz Ramírez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Castaño Guzman
 */
/*
 * Esta opcion de menu elimina un usuario de la aplicacion
 */
public class MI_EliminarUsuario extends OpcionDeMenu implements deshechar  {
Usuario usuario;
	
	public void ejecutar() {
		unal.poo.starmusic.varios.InicioSesion sesion = new InicioSesion();
		System.out.print("Nombre  Contaseña  \n" + sesion.listado() + "Nombre de usuario a eliminar: ");
		Usuario usuarioAMorir = new Usuario(); 
			usuarioAMorir.setNombre(Lectura.Leer());
			if(sesion.existeUsuario(usuarioAMorir)){
				usuario = sesion.eliminarUsuario(usuarioAMorir);
			}else{
				System.err.println("Usuario no encontrado");
			}
	}

	
	public String getNombre() {
		return "Eliminar Usuario";
	}

	public void deshacer() {
		if (this.usuario != null) {
			InicioSesion sesion = new InicioSesion();
			sesion.agregarUsuario(usuario);
			System.out
					.println(">>>>>El usuario ha sido restablecido");
		}
	}
	public void rehacer() {
		if (usuario != null) {
			InicioSesion sesion = new InicioSesion();
			sesion.eliminarUsuario(usuario);
			
			System.out
					.println(">>>>>El usuario ha sido eliminado");
		}
	}

	MI_EliminarUsuario(MI_EliminarUsuario o) {
		usuario = o.usuario;
	}
	MI_EliminarUsuario(){
		
	}

	public OpcionDeMenu clone() {
		return new MI_EliminarUsuario(this);
	}


}
