package unal.poo.starmusic.menuconsola;

import java.io.IOException;

import unal.poo.starmusic.varios.InicioSesion;
/**
 * @author Sebasti�n P�rez Salas
 * @author Carlos Alejandro Ruiz Ram�rez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Casta�o Guzman
 */
/*
 * Crea una lista de los usuario que existen en la aplicacion
 */
public class MI_ListarUsuarios extends OpcionDeMenu {

	public void ejecutar() {
		unal.poo.starmusic.varios.InicioSesion sesion = new InicioSesion();
		System.out.println("Nombre  Contase�a  \n" + sesion.listado() + "Presione cualquier tecla para continuar");
		try{
			System.in.read();
		}catch(IOException e){}
	}

	public String getNombre() {
		return "Listar Usuarios";
	}

}
