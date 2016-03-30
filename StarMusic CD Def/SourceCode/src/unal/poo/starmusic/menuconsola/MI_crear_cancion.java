package unal.poo.starmusic.menuconsola;
/**
 * @author Sebastián Pérez Salas
 * @author Carlos Alejandro Ruiz Ramírez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Castaño Guzman
 */
import java.util.Enumeration;

import unal.poo.starmusic.artistas.Artista;
import unal.poo.starmusic.artistas.Artistas;
import unal.poo.starmusic.artistas.Banda;
import unal.poo.starmusic.artistas.Bandas;
import unal.poo.starmusic.varios.Albumes;
import unal.poo.starmusic.varios.Cancion;
import unal.poo.starmusic.varios.Lectura;
import unal.poo.starmusic.varios.Lista;
/*
 * Esta opcion de menu crea una nueva cancion apartir de un artista perteneciente a 
 * una banda
 */
public class MI_crear_cancion extends OpcionDeMenu implements deshechar {
	public MI_crear_cancion() {
		Nombre = "Crear cancion";
	}

	public String getNombre() {
		return Nombre;
	}

	public void ejecutar() {
		deshacer = (Lista)Artistas.Lista_Artistas.clone();

		Opciones.setCabecera("\n\n--------------------------------\n"
				+ "||  Bandas - Crear cancion    ||\n");

		Banda bandaelegida = Bandas.obtener_banda();

		if (bandaelegida != null) {
			System.out
					.println("\n-----------------------\nArtistas de la banda:\n");

			if (bandaelegida.getArtistas().size() > 0) {
				Enumeration elementos = bandaelegida.getArtistas().elements();
				int i = 0;
				while (elementos.hasMoreElements()) {
					Long actual;
					Artista candidato;
					boolean elegido = false;
					actual = (Long) elementos.nextElement();
					Enumeration listatemporal = Artistas.Lista_Artistas
							.elements();

					while (listatemporal.hasMoreElements()) {
						candidato = (Artista) listatemporal.nextElement();
						if (candidato.getId().equals(actual)) {
							System.out.println("\t" + (++i) + ")"
									+ candidato.getNombreArtistico());
							elegido = true;
							break;
						}
					}

					if (!elegido) {
						System.out.println("\t" + (++i) + ") Elemento con id: "
								+ actual + " no fue identificado como artista");
					}

				}

				Artista artistaelegido;
				for (;;) {
					int pocision;
					Long idelegido;
					boolean elegido = false;
					System.out.print("\nSeleccione un artista que componga la cancion: ");
					try {
						pocision = Integer.parseInt(Lectura.Leer());
						if (pocision > 0
								&& pocision <= bandaelegida.getArtistas()
										.size()) {

							idelegido = (Long) bandaelegida.getArtistas().get(
									pocision - 1);

							Enumeration listatemporal = Artistas.Lista_Artistas
									.elements();

							while (listatemporal.hasMoreElements()) {
								artistaelegido = (Artista) listatemporal
										.nextElement();
								if (artistaelegido.getId().equals(idelegido)) {
									System.out.println("El artista "
											+ artistaelegido
													.getNombreArtistico()
											+ " fue seleccionado");

									System.out
											.println("\n\n---------------------------------\n"
													+ "| Datos necesarios de la cancion:\n");
									String nombre;
									String letras;
									System.out
											.print("Ingrese el nombre de la cancion: ");
									nombre = Lectura.Leer();
									System.out
											.print("Ingrese la letra de la cancion: ");
									letras = Lectura.Leer();
									
									Cancion creada=artistaelegido.ComponerCancion(nombre, letras);
									String res;
									System.out.print("\nDesea adicionar la cancion a un album(y/n): ");
									res=Lectura.Leer();
									
									if(res.equals("y")){
										Albumes.adicionar_a_album(creada, bandaelegida);
									}

									elegido = true;
									break;
								}
							}

							if (!elegido) {
								System.out
										.println("No es posible componer cancion con este artista(No identificado)");
								break;
							} else
								break;

						}
					} catch (NumberFormatException e) {
					}
				}
			} else {
				System.out
						.println("No existen artistas registrados, registre artistas en la banda y vuelva a intentarlo");
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

	MI_crear_cancion(MI_crear_cancion o) {
		deshacer = o.deshacer;
		rehacer = o.rehacer;
	}

	public OpcionDeMenu clone() {
		return new MI_crear_cancion(this);
	}

}
