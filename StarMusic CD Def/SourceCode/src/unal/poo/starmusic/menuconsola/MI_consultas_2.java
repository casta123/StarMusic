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
/*
 * Nos crea una lista de Artistas y bandas que pertenecen a StarMusic
 */
public class MI_consultas_2 extends OpcionDeMenu{
	public MI_consultas_2(){
		Nombre="Consultar el numero total de artistas y bandas";
	}
	
	public String getNombre(){
		return Nombre;
	}
	
	public void ejecutar(){
		Opciones.setCabecera("\n\n-------------------------------------\n" +
						   		 "| Numero total de artistas y bandas |\n");
		
		System.out.println("A) Numero de artistas: "+Artistas.Lista_Artistas.size());
		Enumeration enume=Artistas.Lista_Artistas.elements();
		int i=0;
		while(enume.hasMoreElements()){
			System.out.println("\t"
					+ (++i)
					+ ")"
					+ ((Artista) enume.nextElement())
							.getNombreArtistico());
		}
		
		System.out.println("B) Numero de bandas: "+Bandas.Lista_Bandas.size());
		enume=Bandas.Lista_Bandas.elements();
		i=0;
		while(enume.hasMoreElements()){
			System.out.println("\t"
					+ (++i)
					+ ")"
					+ ((Banda) enume.nextElement())
							.getNombre());
		}
		
	}
}
