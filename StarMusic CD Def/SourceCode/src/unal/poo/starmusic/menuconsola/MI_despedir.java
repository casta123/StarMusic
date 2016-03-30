package unal.poo.starmusic.menuconsola;
/**
 * @author Sebastián Pérez Salas
 * @author Carlos Alejandro Ruiz Ramírez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Castaño Guzman
 */
/*
 * Esta opcion de menu despide un artista de una banda especifica
 */
import java.util.Enumeration;
import unal.poo.starmusic.artistas.Artista;
import unal.poo.starmusic.artistas.Artistas;
import unal.poo.starmusic.artistas.Banda;
import unal.poo.starmusic.artistas.Bandas;
import unal.poo.starmusic.varios.Lectura;
import unal.poo.starmusic.varios.Lista;

public class MI_despedir extends OpcionDeMenu implements deshechar {
	public MI_despedir() {
		Nombre = "Despedir Artista";
	}

	public String getNombre() {
		return Nombre;
	}

	public void ejecutar() {
		deshacer = (Lista)Bandas.Lista_Bandas.clone();

		Opciones.setCabecera("\n\n-----------------------------------\n"
				+ "||  Bandas - Despedir artista    ||\n");
		
		Banda bandaelegida=Bandas.obtener_banda();
		
			
		if(bandaelegida!=null){
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
					boolean elegido=false;
					System.out.print("\nSeleccione el artista a despedir: ");
					try {
						pocision = Integer.parseInt(Lectura.Leer());
						if (pocision > 0
								&& pocision <= bandaelegida.getArtistas()
										.size()) {
							
							idelegido = (Long) bandaelegida.getArtistas().get(
									pocision-1);

							Enumeration listatemporal = Artistas.Lista_Artistas
									.elements();

							while (listatemporal.hasMoreElements()) {
								artistaelegido = (Artista) listatemporal
										.nextElement();
								if (artistaelegido.getId().equals(idelegido)) {
									System.out.println("El artista "
											+ artistaelegido.getNombreArtistico()
											+ " fue seleccionado");
									bandaelegida.despedirArtista(artistaelegido.getId());
									elegido = true;
									break;
								}
							}

							if (!elegido) {
								System.out.println("El artista no identificado fue seleccionado");
								bandaelegida.despedirArtista(idelegido);
								break;
							}else break;

						}
					} catch (NumberFormatException e) {
					}
				}
			} else {
				System.out
						.println("No existen artistas registrados, registre artistas en la banda y vuelva a intentarlo");
			}
		}
		
		System.out.println(">>>Proceso completado");
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

	MI_despedir(MI_despedir o) {
		deshacer = o.deshacer;
		rehacer = o.rehacer;
	}

	public OpcionDeMenu clone() {
		return new MI_despedir(this);
	}
}
