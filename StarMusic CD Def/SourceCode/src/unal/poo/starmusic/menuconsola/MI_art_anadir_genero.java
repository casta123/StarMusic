package unal.poo.starmusic.menuconsola;

import unal.poo.starmusic.artistas.Artista;
import unal.poo.starmusic.artistas.Artistas;
import unal.poo.starmusic.artistas.Bandas;
import unal.poo.starmusic.generos.Genero;
import unal.poo.starmusic.generos.Generos;
import unal.poo.starmusic.varios.Clonar;
import unal.poo.starmusic.varios.Lectura;
import unal.poo.starmusic.varios.Lista;
/**
 * @author Sebastián Pérez Salas
 * @author Carlos Alejandro Ruiz Ramírez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Castaño Guzman
 */
/*
 * Esta clase nos actua de interfaz con el genero de un artista, permite
 * asociar un nuevo genero al artista 
 */

public class MI_art_anadir_genero extends OpcionDeMenu	implements	deshechar {
	public MI_art_anadir_genero() {
		Nombre = "Asociar generos al artista";
	}

	public String getNombre() {
		return Nombre;
	}

	public void ejecutar() {
		deshacer = (Lista)Artistas.Lista_Artistas.clone();
		Opciones.setCabecera("\n\n---------------------------------\n"
				+ "||   Artista - Asociar generos   ||\n\nDatos necesarios:\n");
		Artista artistaelegido = Artistas.obtener_artista();
		if (artistaelegido != null) {
			for (;;) {
				Genero generoelegido = Generos.obtener_genero();
				if (generoelegido != null) {
					artistaelegido.AgregarGenero(generoelegido);

					String res;
					System.out.print("\nDesea añadir mas generos (y/n): ");
					res = Lectura.Leer();

					if (res.equals("y")) {
					} else
						break;
				} else
					break;
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

	MI_art_anadir_genero(MI_art_anadir_genero o) {
		deshacer = o.deshacer;
		rehacer = o.rehacer;
	}

	public OpcionDeMenu clone() {
		return new MI_art_anadir_genero(this);
	}

}
