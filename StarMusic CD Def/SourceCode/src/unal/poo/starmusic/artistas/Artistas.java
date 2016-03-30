package unal.poo.starmusic.artistas;

import java.io.IOException;
import java.util.Enumeration;

import unal.poo.starmusic.varios.IOArchivo;
import unal.poo.starmusic.varios.Lectura;
import unal.poo.starmusic.varios.Lista;
import unal.poo.starmusic.varios.ObjetoIO;
/**
 * @author Sebastiï¿½n Pï¿½rez Salas
 * @author Carlos Alejandro Ruiz Ramï¿½rez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Castaï¿½o Guzman
 */
/*
 * La clase artistas nos representa el conjunto de 
 * instancias de artistas, posee una lista estatica
 * y es allí donde se guardan los objetos,
 * ademas tiene los metodos de lectura y escritura
 * para la persistencia los objetos
 */
public class Artistas {
	
	// almacena una lista de artistas para su uso y modificacion
	public static Lista Lista_Artistas = new Lista();
	
	
	public static Artista obtener_artista() {
		System.out
				.println("\n-----------------------\nArtistas registrados:\n");
		if (Lista_Artistas.size() > 0) {
			int i = 0;
			Enumeration elementos = (Lista_Artistas).elements();
			while (elementos.hasMoreElements()) {
				System.out.println("\t"
						+ (++i)
						+ ")"
						+ ((Artista) elementos.nextElement())
								.getNombreArtistico());
			}
			Artista artistaelegido;
			for (;;) {
				int artista;
				System.out.print("\nSeleccione el artista: ");
				try {
					artista = Integer.parseInt(Lectura.Leer());
					if (artista > 0 && artista <= Lista_Artistas.size()) {
						artistaelegido = (Artista) Lista_Artistas
								.get(artista - 1);
						System.out.println("\nEl artista "
								+ artistaelegido.getNombreArtistico()
								+ " fue seleccionada");
						break;
					}
				} catch (NumberFormatException e) {
				}
			}
			return artistaelegido;
		} else {
			System.out
					.println("No existen artistas registrados, registre artistas y vuelva a intentarlo");
			return null;
		}
	}
	public void guardarEnDisco() {
		IOArchivo guardar = new IOArchivo("artistas.txt");
		for (int i = 0; i < Lista_Artistas.size(); i++) {
			try {
				guardar.agregarObjeto((ObjetoIO) Lista_Artistas.elementAt(i));
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		try {
			guardar.guardar();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void leerEnDisco(){
		IOArchivo leer = new IOArchivo("artistas.txt");
		leer.leer();
		for(int i= 0; i < leer.getVector().size(); i++){
			Lista_Artistas.add(leer.getVector().elementAt(i));
		}
	}
	
	
}
