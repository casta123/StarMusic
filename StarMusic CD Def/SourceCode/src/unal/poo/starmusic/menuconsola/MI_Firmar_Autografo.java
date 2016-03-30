package unal.poo.starmusic.menuconsola;

import unal.poo.starmusic.artistas.Artista;
import unal.poo.starmusic.artistas.Artistas;
import unal.poo.starmusic.varios.Lectura;
/**
 * @author Sebasti�n P�rez Salas
 * @author Carlos Alejandro Ruiz Ram�rez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Casta�o Guzman
 */
/*
 * Un artista firma un autografo a un fan 
 */
public class MI_Firmar_Autografo extends OpcionDeMenu {
public void ejecutar() throws SALIDA {
	Opciones.setCabecera("\n\n-------------------------------\n" +
	   						 "||    Firma de Autografos    ||\n");
	Artista artista = Artistas.obtener_artista();
	if(artista == null)
		return;
	System.out.print("Ingrese su nombre: ");
	String fan = Lectura.Leer();
	System.out.println(artista.FirmarAutografo(fan));
	}

	public String getNombre() {
		return "Firmar Autografo";
	}

}
