package unal.poo.starmusic.menuconsola;

import unal.poo.starmusic.artistas.Artista;
import unal.poo.starmusic.artistas.Artistas;
import unal.poo.starmusic.varios.Album;
import unal.poo.starmusic.varios.Albumes;
import unal.poo.starmusic.varios.Cancion;
import unal.poo.starmusic.varios.Lectura;
import unal.poo.starmusic.varios.Lista;
/**
 * @author Sebastián Pérez Salas
 * @author Carlos Alejandro Ruiz Ramírez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Castaño Guzman
 */
/*
 *Este formulario crea una nueva cancion, la cual se le asocia a un
 *artista
 */

public class MI_art_componer_cancion extends OpcionDeMenu implements deshechar{

	public MI_art_componer_cancion() {
		Nombre = "Artistas";
	}

	public String getNombre() {
		return Nombre;
	}

	public void ejecutar() {
		deshacer = (Lista)Artistas.Lista_Artistas.clone();

		Opciones.setCabecera("\n\n-------------------------------------\n"
				+ "||   Artistas - Componer cancion   ||\n");

		System.out.println("Seleccione un artista que componga la cancion\n");
		Artista artistaelegido = Artistas.obtener_artista();
		if (artistaelegido != null) {
			System.out.println("\n\n---------------------------------\n"
					+ "| Datos necesarios de la cancion:\n");
			String nombre;
			String letras;
			System.out.print("Ingrese el nombre de la cancion: ");
			nombre = Lectura.Leer();
			System.out.print("Ingrese la letra de la cancion: ");
			letras = Lectura.Leer();

			Cancion creada = artistaelegido.ComponerCancion(nombre, letras);
			String res;
			System.out.print("\nDesea adicionar la cancion a un album(y/n): ");
			res = Lectura.Leer();

			if (res.equals("y")) {
				Albumes.adicionar_a_album(creada, null);
			}

		}
		rehacer = (Lista)Artistas.Lista_Artistas.clone();

	}
	Lista deshacer;
	Lista rehacer;
	
	public void deshacer() {
		if (this.deshacer != null) {
			Artistas.Lista_Artistas = deshacer;
			System.out
					.println(">>>>>Se han eliminado los cambios en el artista");
		}
	}
	public void rehacer() {
		if (rehacer != null) {
			System.out
					.println(">>>>>Se ha restablecido los cambios en el artista");
			Artistas.Lista_Artistas = rehacer;
		}
	}

	MI_art_componer_cancion(MI_art_componer_cancion o) {
		deshacer = o.deshacer;
		rehacer = o.rehacer;
	}

	public OpcionDeMenu clone() {
		return new MI_art_componer_cancion(this);
	}

}
