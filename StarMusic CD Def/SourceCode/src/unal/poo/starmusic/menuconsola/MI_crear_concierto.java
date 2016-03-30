package unal.poo.starmusic.menuconsola;
/**
 * @author Sebastián Pérez Salas
 * @author Carlos Alejandro Ruiz Ramírez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Castaño Guzman
 */
/*
 * Esta opcion de menu le agrga un nuevo concierto a una banda
 */
import unal.poo.starmusic.artistas.Artistas;
import unal.poo.starmusic.artistas.Banda;
import unal.poo.starmusic.artistas.Bandas;
import unal.poo.starmusic.varios.Concierto;
import unal.poo.starmusic.varios.Lectura;
import unal.poo.starmusic.varios.Lista;

public class MI_crear_concierto extends OpcionDeMenu implements deshechar {
	public MI_crear_concierto() {
		Nombre = "Crear nuevo concierto";
	}

	public String getNombre() {
		return Nombre;
	}

	public void ejecutar() {
		deshacer = (Lista)Bandas.Lista_Bandas.clone();
		Opciones.setCabecera("\n\n-----------------------------------\n"
				+ "||   Bandas - Crear concierto    ||\n");

		Banda bandaelegida = Bandas.obtener_banda();

		if (bandaelegida != null) {
			System.out
					.println("\n-----------------------\nDatos para el concierto:\n");

			String nombre;
			float entrada;
			String lugar;
			System.out.print("Ingrese el nombre del concierto: ");
			nombre = Lectura.Leer();
			System.out.print("Ingrese el lugar del concierto: ");
			lugar = Lectura.Leer();

			for (;;) {
				System.out.print("Ingrese el valor de la entrada: ");
				try {
					entrada = Float.valueOf(Lectura.Leer());
					break;
				} catch (NumberFormatException e) {
					System.out.println("Ingrese un valor valido");
				}
			}

			bandaelegida
					.crear_Concierto(new Concierto(nombre, lugar, entrada));
			System.out.println("\nEl concierto " + nombre + " ha sido creado");

		}

		rehacer = (Lista)Bandas.Lista_Bandas.clone();
	}
	Lista deshacer;
	Lista rehacer;
	
	public void deshacer() {
		if (this.deshacer != null) {
			Bandas.Lista_Bandas = deshacer;
			System.out
					.println(">>>>>Se han eliminado los cambios en la banda");
		}
	}
	public void rehacer() {
		if (rehacer != null) {
			System.out
					.println(">>>>>Se ha restablecido los cambios en la banda");
			Bandas.Lista_Bandas = rehacer;
		}
	}

	MI_crear_concierto(MI_crear_concierto o) {
		deshacer = o.deshacer;
		rehacer = o.rehacer;
	}

	public OpcionDeMenu clone() {
		return new MI_crear_concierto(this);
	}

}
