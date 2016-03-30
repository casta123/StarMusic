package unal.poo.starmusic.menuconsola;

import unal.poo.starmusic.artistas.Artista;
import unal.poo.starmusic.artistas.Artistas;
import unal.poo.starmusic.varios.Lectura;
/**
 * @author Sebastián Pérez Salas
 * @author Carlos Alejandro Ruiz Ramírez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Castaño Guzman
 */
/*
 * Crea un inventario de todos los instrumentos que hay en la aplicacion
 */
public class MI_InventariarInstrumentos extends OpcionDeMenu {
	public MI_InventariarInstrumentos() {
		Nombre = "Inventariar Instrumentos";
	}
	public String getNombre() {
		return Nombre;
	}

	public void ejecutar() {
		Opciones.setCabecera("\n\n--------------------------------\n"
				+ "||   Invetariar Instrumentos   ||\n");
		int numeroInstrumentosTotal = 0;
		for (int i = 0; i < Artistas.Lista_Artistas.size(); i++) {
			if (Artistas.Lista_Artistas.elementAt(i) != null) {
				System.out.println("Nombre del Artista: "
						+ ((Artista) Artistas.Lista_Artistas.elementAt(i))
								.getNombre() + "\n");
				System.out.println("Instrumentos: "
						+ ((Artista) Artistas.Lista_Artistas.elementAt(i))
								.getInstrumentos() + "\n");
				System.out.println("Numero de instrumentos del artista: "
						+ ((Artista) Artistas.Lista_Artistas.elementAt(i))
								.getNumeroInstrumentos() + "\n");

				numeroInstrumentosTotal += ((Artista) Artistas.Lista_Artistas
						.elementAt(i)).getNumeroInstrumentos();
			}
		}

		System.out.println("\n\n \tNumero total de instrumentos: "
				+ numeroInstrumentosTotal);
		Lectura.Leer();
	}
}
