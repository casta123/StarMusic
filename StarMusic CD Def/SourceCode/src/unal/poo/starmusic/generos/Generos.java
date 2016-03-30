package unal.poo.starmusic.generos;

import java.io.IOException;
import java.io.Serializable;
import java.util.Enumeration;

import unal.poo.starmusic.varios.IOArchivo;
import unal.poo.starmusic.varios.Lectura;
import unal.poo.starmusic.varios.Lista;
import unal.poo.starmusic.varios.ObjetoIO;
/**
 * @author Sebasti�n P�rez Salas
 * @author Carlos Alejandro Ruiz Ram�rez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Casta�o Guzman
 */
public class Generos implements Serializable {
	/*
	 * Clase que almacena los generos registrado
	 * Ademas se encarga de la lectura y escritura
	 */
	public static Lista Lista_Generos =new Lista();
	
	public static Genero obtener_genero() {
		System.out.println("\n-------------------\nGeneros registrados:\n");

		if (Lista_Generos.size() > 0) {
			Enumeration enume = Lista_Generos.elements();
			int i = 0;
			while (enume.hasMoreElements()) {
				System.out.println("\t" + (++i) + ") "
						+ ((Genero) enume.nextElement()).getNombre());
			}

			Genero generoelegido;

			for (;;) {
				int index;
				System.out.print("\nSeleccione un genero: ");
				try {
					index = Integer.parseInt(Lectura.Leer());
					if (index > 0 && index <= Lista_Generos.size()) {
						generoelegido = (Genero) Lista_Generos
								.get(index - 1);
						System.out.println("\nEl genero "
								+ generoelegido.getNombre()
								+ " fue seleccionado");
						break;
					}
				} catch (NumberFormatException e) {
				}
			}
			return generoelegido;
			
		} else {
			System.out
			.println("No existen generos, registre generos vuelva a intentarlo");
			return null;
		}

	}
	public void guardarEnDisco() {
		IOArchivo guardar = new IOArchivo("generos.txt");
		for (int i = 0; i < Lista_Generos.size(); i++) {
			try {
				guardar.agregarObjeto((ObjetoIO) Lista_Generos.elementAt(i));
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

	public void leerEnDisco() {
		IOArchivo leer = new IOArchivo("generos.txt");
		leer.leer();
		for (int i = 0; i < leer.getVector().size(); i++) {
			Lista_Generos.add(leer.getVector().elementAt(i));
		}
	}
}
