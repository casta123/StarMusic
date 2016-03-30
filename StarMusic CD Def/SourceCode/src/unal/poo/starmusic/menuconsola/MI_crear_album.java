package unal.poo.starmusic.menuconsola;
/**
 * @author Sebastián Pérez Salas
 * @author Carlos Alejandro Ruiz Ramírez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Castaño Guzman
 */
import unal.poo.starmusic.artistas.Artistas;
import unal.poo.starmusic.artistas.Banda;
import unal.poo.starmusic.artistas.Bandas;
import unal.poo.starmusic.varios.Album;
import unal.poo.starmusic.varios.Lectura;
import unal.poo.starmusic.varios.Lista;
/*
 * Esta opcion crea un nuevo album y se le asocia a un artista que pertenece
 * a una banda
 */
public class MI_crear_album extends OpcionDeMenu implements deshechar {
	public MI_crear_album() {
		Nombre = "Crear nuevo album";
	}

	public String getNombre() {
		return Nombre;
	}

	public void ejecutar() {
		deshacer = (Lista)Bandas.Lista_Bandas.clone();

		Opciones.setCabecera("\n\n-----------------------------------\n"
				+ "||     Albumes - Crear album      ||\n");

		Banda bandaelegida = Bandas.obtener_banda();

		if (bandaelegida != null) {
			System.out
					.println("\n-----------------------\nDatos para el album:\n");

			String nombre;
			short anio;
			float valor;
			String prueba;
			System.out.print("Ingrese el nombre del album: ");
			nombre = Lectura.Leer();
			System.out.print("Ingrese el año de creacion: ");
			prueba = Lectura.Leer();

			try {
				anio = Short.valueOf(prueba);
			} catch (NumberFormatException e) {
				anio = 0;
			}

			System.out.print("Ingrese el valor del album: ");
			prueba = Lectura.Leer();

			try {
				valor = Float.valueOf(prueba);
			} catch (NumberFormatException e) {
				valor = 0;
			}

			bandaelegida.crear_Album(new Album(nombre, anio, bandaelegida,
					valor));
			System.out.println("\nEl album " + nombre + " ha sido creado");

		}
		System.out.println(">>>Proceso completado");
		rehacer = (Lista)Bandas.Lista_Bandas.clone();
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

	MI_crear_album(MI_crear_album o) {
		deshacer = o.deshacer;
		rehacer = o.rehacer;
	}

	public OpcionDeMenu clone() {
		return new MI_crear_album(this);
	}

}
