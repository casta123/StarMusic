package unal.poo.starmusic.menuconsola;
/**
 * @author Sebastián Pérez Salas
 * @author Carlos Alejandro Ruiz Ramírez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Castaño Guzman
 */

import java.util.Enumeration;
import unal.poo.starmusic.artistas.Banda;
import unal.poo.starmusic.artistas.Bandas;
import unal.poo.starmusic.varios.Lectura;
import unal.poo.starmusic.varios.Lista;
import unal.poo.starmusic.varios.Premio;
import unal.poo.starmusic.varios.Premios;
/*
 * Esta clase funciona como interfaz de banda, la banda recibe uno de los 
 * premios que existen
 */
public class MI_recibir_premio extends OpcionDeMenu implements deshechar{
	
	Lista bandaRehacer;
	Lista bandaDeshacer;
	
	public MI_recibir_premio() {
		Nombre = "Recibir premio";
	}

	public String getNombre() {
		return Nombre;
	}

	public void ejecutar() {
		bandaDeshacer = (Lista) Bandas.Lista_Bandas.clone();
		System.out.println("\n\n------------------------------------\n"
				+ "||    Bandas - Recibir premio     ||\n");

		Banda bandaelegida = Bandas.obtener_banda();

		if (bandaelegida != null) {
			System.out
			.println("\n-----------------------\nPremios registrados:\n");
			if (Premios.Lista_Premios.size() > 0) {
				int i = 0;
				Enumeration elementos = (Premios.Lista_Premios).elements();
				while (elementos.hasMoreElements()) {
					System.out.println("\t"
							+ (++i)
							+ ")"
							+ ((Premio) elementos.nextElement()).getnombre());
				}
				Premio premioelegido;
				for (;;) {
					int premio;
					System.out.print("\nSeleccione el premio a otorgar: ");
					try {
						premio = Integer.parseInt(Lectura.Leer());
						if (premio > 0
								&& premio <= Premios.Lista_Premios.size()) {
							premioelegido = (Premio) Premios.Lista_Premios.get(premio - 1);
							System.out.println("\nEl premio "
									+ premioelegido.getnombre()
									+ " fue seleccionada");
							break;
						}
					} catch (NumberFormatException e) {
					}
				}
				
				bandaelegida.recibir_premio(premioelegido.getId());

			} else {
				System.out
						.println("No existen premios registrados, registre permios y vuelva a intentarlo");
			}
		}

		System.out.println(">>Proceso completado.");
		
		bandaRehacer = (Lista) Bandas.Lista_Bandas.clone();
	}
	
	public void deshacer() {
		if (this.bandaDeshacer != null) {
			Bandas.Lista_Bandas = bandaDeshacer;
			System.out.println(">>>>>Se ha eliminado el premio recibido");
		}
	}
	public void rehacer() {
		if (this.bandaRehacer != null) {
			System.out.println(">>>>>Se ha otorgado el premio");
			Bandas.Lista_Bandas = bandaRehacer;
		}
	}
	MI_recibir_premio(MI_recibir_premio o){
		bandaDeshacer = o.bandaDeshacer;
		bandaRehacer = o.bandaRehacer;
	}
	
	public OpcionDeMenu clone(){
		return new MI_recibir_premio(this);
	}
}
