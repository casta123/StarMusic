package unal.poo.starmusic.menuconsola;

/**
 * @author Sebastián Pérez Salas
 * @author Carlos Alejandro Ruiz Ramírez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Castaño Guzman
 */

import unal.poo.starmusic.artistas.Artista;
import unal.poo.starmusic.artistas.Artistas;
import unal.poo.starmusic.varios.Lectura;
import unal.poo.starmusic.varios.Lista;
import unal.poo.starmusic.varios.Premios;
/*
 * Esta clase crea un nuevo artista que luego es agrgado a la 
 * lista de artistas
 */
public class MI_nuevo_artista extends OpcionDeMenu implements deshechar{
	
	Lista artistaRehacer;
	Lista artistaDeshacer;
	
	public MI_nuevo_artista() {
		Nombre = "Registrar nuevo Artista";
	}

	public String getNombre() {
		return Nombre;
	}

	public void ejecutar() {
		artistaDeshacer=(Lista)Artistas.Lista_Artistas.clone();
		
		System.out.println("\n\n--------------------------------\n" +
	   	   				       "||   Registrar nuevo Artista   ||\n\nDatos necesarios:\n");
		String nombre;
		String nartistico;
		String biografia;
		System.out.print("Ingrese el nombre del artista: ");
		nombre=Lectura.Leer();
		System.out.print("Ingrese el nombre artistico del artista: ");
		nartistico=Lectura.Leer();
		System.out.print("Ingrese la biografia del artista: ");
		biografia=Lectura.Leer();
		
		Artista nartista=new Artista(nombre,nartistico,biografia);
		Artistas.Lista_Artistas.add(nartista);
		System.out.println("\n>>>>El artista "+nartistico+" ha sido registrado<<<<");
		
		artistaRehacer=(Lista)Artistas.Lista_Artistas.clone();
	}
	
	public void deshacer() {
		if (this.artistaDeshacer != null) {
			Artistas.Lista_Artistas = artistaDeshacer;
			System.out.println(">>>>>Se ha eliminado el artista");
		}
	}
	public void rehacer() {
		if (this.artistaRehacer != null) {
			System.out.println(">>>>>Se ha registrado el artista");
			Artistas.Lista_Artistas = artistaRehacer;
		}
	}
	
	MI_nuevo_artista(MI_nuevo_artista o){
		artistaDeshacer = o.artistaDeshacer;
		artistaRehacer = o.artistaRehacer;
	}
	
	public OpcionDeMenu clone(){
		return new MI_nuevo_artista(this);
	}
	
}
