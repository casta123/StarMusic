package unal.poo.starmusic.menuconsola;
/**
 * @author Sebastián Pérez Salas
 * @author Carlos Alejandro Ruiz Ramírez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Castaño Guzman
 */
import java.util.Enumeration;

import unal.poo.starmusic.artistas.Bandas;
import unal.poo.starmusic.varios.Album;
import unal.poo.starmusic.varios.Albumes;
import unal.poo.starmusic.varios.Cancion;
import unal.poo.starmusic.varios.Canciones;
import unal.poo.starmusic.varios.Clonar;
import unal.poo.starmusic.varios.Lectura;
import unal.poo.starmusic.varios.Lista;
/*
 * Esta clase nos actua de interfaz con el album de una banda, agregandonos una cancion al
 * album de una banda
 */
public class MI_agregar_cancion extends OpcionDeMenu implements deshechar {
	Lista bandaRehacer;
	Lista bandaDeshacer;

	public MI_agregar_cancion() {
		Nombre = "Agregar canciones";
	}

	public String getNombre() {
		return Nombre;
	}

	public void ejecutar() {
		bandaDeshacer = (Lista) Bandas.Lista_Bandas.clone();
		Opciones.setCabecera("\n\n-------------------------------------\n"
				+ "||   Albumes - Agregar canciones   ||\n");

		for (;;) {
			System.out
					.println("\n-----------------------\nCanciones registrados:\n");
			if (Canciones.Lista_Canciones.size() > 0) {
				int i = 0;
				Enumeration elementos = (Canciones.Lista_Canciones).elements();
				while (elementos.hasMoreElements()) {
					System.out.println("\t" + (++i) + ")"
							+ ((Cancion) elementos.nextElement()).getNombre());
				}
				Cancion cancionelegida;

				for (;;) {
					int index;
					System.out.print("\nSeleccione la cancion: ");
					try {
						index = Integer.parseInt(Lectura.Leer());
						if (index > 0
								&& index <= Canciones.Lista_Canciones.size()) {
							cancionelegida = (Cancion) Canciones.Lista_Canciones
									.get(index - 1);
							System.out.println("\nLa cancion "
									+ cancionelegida.getNombre()
									+ " fue seleccionada");
							break;
						}
					} catch (NumberFormatException e) {
					}
				}

				Albumes.adicionar_a_album(cancionelegida, null);
				this.bandaRehacer = (Lista)Bandas.Lista_Bandas.clone();

				System.out.print("\nDesea adicionar mas canciones (y/n): ");
				String res = Lectura.Leer();

				if (res.equals("y")) {
				} else
					break;

			} else {
				System.out
						.println("No existen canciones registrados, registre canciones y vuelva a intentarlo");
				break;
			}
		}
	}
	public void deshacer() {
		if (this.bandaDeshacer != null) {
			Bandas.Lista_Bandas = bandaDeshacer;
			System.out.println(">>>>>Se ha eliminado la cancion");
		}
	}
	public void rehacer() {
		if (this.bandaRehacer != null) {
			System.out.println(">>>>>Se ha agregado la cancion");
			Bandas.Lista_Bandas = bandaRehacer;
		}
	}
	MI_agregar_cancion(MI_agregar_cancion o){
		bandaDeshacer = o.bandaDeshacer;
		bandaRehacer = o.bandaRehacer;
	}
	
	public OpcionDeMenu clone(){
		return new MI_agregar_cancion(this);
	}

}
