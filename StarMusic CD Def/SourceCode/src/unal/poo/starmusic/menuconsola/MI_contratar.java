package unal.poo.starmusic.menuconsola;
/**
 * @author Sebastián Pérez Salas
 * @author Carlos Alejandro Ruiz Ramírez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Castaño Guzman
 */
import unal.poo.starmusic.artistas.Artista;
import unal.poo.starmusic.artistas.Artistas;
import unal.poo.starmusic.artistas.Banda;
import unal.poo.starmusic.artistas.Bandas;
/*
 * Esta opcion de menu tiene la funcionalidad de Contratar un artista para una
 * banda
 */

public class MI_contratar extends OpcionDeMenu {

	public MI_contratar() {
		Nombre = "Contratar Artista";
	}

	public String getNombre() {
		return Nombre;
	}

	public void ejecutar() {
		Opciones.setCabecera("\n\n------------------------------------\n"
				+ "||  Bandas - Contratar artista    ||\n");
		
		Banda bandaelegida=Bandas.obtener_banda();
		if(bandaelegida!=null){
			Artista artistaelegido=Artistas.obtener_artista();
			if(artistaelegido!=null){
				bandaelegida.contratarArtista(artistaelegido.getId());
			}
		}
		
		System.out.println(">>Proceso completado.");
	}
}
