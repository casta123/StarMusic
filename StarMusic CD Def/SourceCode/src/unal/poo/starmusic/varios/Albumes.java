package unal.poo.starmusic.varios;

import java.io.Serializable;
import java.util.Enumeration;

import unal.poo.starmusic.artistas.Banda;
import unal.poo.starmusic.artistas.Bandas;
/**
 * @author Sebastián Pérez Salas
 * @author Carlos Alejandro Ruiz Ramírez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Castaño Guzman
 */
/*
 * En esta clase se agrupan solo metodos estaticos de interaccion con los albumes y
 * las bandas
 */
public class Albumes {
	
	
	
	public static void adicionar_a_album(Cancion cancion, Banda banda) {
		if (banda != null) {
			System.out
					.println("\n-----------------------\nAlbumes de la banda:\n");
			Enumeration enume = banda.getAlbumes().elements();
			int i = 0;
			while (enume.hasMoreElements()) {
				System.out.println("\t" + (++i) + ")"
						+ ((Album) enume.nextElement()).getNombre());
			}

			Album albumelegido;
			for (;;) {
				int index;
				System.out
						.print("\nSeleccione el album para guardar la cancion: ");
				try {
					index = Integer.parseInt(Lectura.Leer());
					if (index > 0 && index <= banda.getAlbumes().size()) {
						albumelegido = (Album) banda.getAlbumes()
								.get(index - 1);
						System.out.println("\nEl album "
								+ albumelegido.getNombre()
								+ " fue seleccionada");
						break;
					}
				} catch (NumberFormatException e) {
				}
			}
			albumelegido.AgregarCancion(cancion.getId());
			System.out.println("La cancion " + cancion.getNombre()
					+ " fue añadida al album " + albumelegido.getNombre());

		} else {
			banda = Bandas.obtener_banda();
			adicionar_a_album(cancion, banda);
		}
	}
	
	
	public static Album obtener_album(Banda Banda) {
		System.out.println("Albunes registradas: \n");

		if (Banda.getAlbumes().size() > 0) {
			Enumeration elementos = (Banda.getAlbumes()).elements();
			int i = 0;

			while (elementos.hasMoreElements()) {
				System.out.println("\t" + (++i) + ") "
						+ ((Album) elementos.nextElement()).getNombre());
			}

			Album albumelegido;
			for (;;) {
				int album;
				System.out.print("\nSeleccione un album: ");
				try {
					album = Integer.parseInt(Lectura.Leer());
					if (album > 0 && album <= Banda.getAlbumes().size()) {
						albumelegido = (Album) Banda.getAlbumes()
								.get(album - 1);
						System.out.println("\nEl album : "
								+ albumelegido.getNombre()
								+ " fue seleccionada");

						break;
					}
				} catch (NumberFormatException e) {
				}
			}
			return albumelegido;
		} else {
			System.out
					.println("No existen albumes registrados, registre albumes en la banda y vuelva a intentarlo");
			return null;
		}
	}
}
