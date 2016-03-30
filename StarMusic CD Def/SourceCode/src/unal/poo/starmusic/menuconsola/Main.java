package unal.poo.starmusic.menuconsola;

import unal.poo.starmusic.artistas.Artistas;
import unal.poo.starmusic.artistas.Bandas;
import unal.poo.starmusic.generos.Generos;
import unal.poo.starmusic.varios.Canciones;
import unal.poo.starmusic.varios.InicioSesion;
import unal.poo.starmusic.varios.Premios;
/**
 * @author Sebasti�n P�rez Salas
 * @author Carlos Alejandro Ruiz Ram�rez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Casta�o Guzman
 */

public class Main {
	public static void main(String[] args){

		InicioSesion sesion = new InicioSesion();
		Generos generos = new Generos();
		Artistas artistas= new Artistas();
		Bandas bandas = new Bandas();
		Canciones canciones = new Canciones();
		Premios premios = new Premios();
		MenuPrincipal menuPrincipal = new MenuPrincipal();
		
		sesion.formularioEntrada();
		generos.leerEnDisco();
		artistas.leerEnDisco();
		bandas.leerEnDisco();
		canciones.leerEnDisco();
		premios.leerEnDisco();
		
		menuPrincipal.cargarOpcionesMenu();
		menuPrincipal.getMenu(sesion.esAdministrador()).ejecutar();
		sesion.guardarUsuarios();
		menuPrincipal.guardarOpcionesMenu();
		
		premios.guardarEnDisco();
		canciones.guardarEnDisco();
		generos.guardarEnDisco();
		artistas.guardarEnDisco();
		bandas.guardarEnDisco();

	}

}
