package unal.poo.starmusic.menuconsola;

import unal.poo.starmusic.generos.Genero;
import unal.poo.starmusic.generos.Generos;
import unal.poo.starmusic.varios.Lectura;
/**
 * @author Sebastián Pérez Salas
 * @author Carlos Alejandro Ruiz Ramírez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Castaño Guzman
 */
/*
 * Esta clase crea un nuevo genero que luego puede ser agrgado a la 
 * a los artistas o a las bandas
 */
public class MI_registrar_genero extends OpcionDeMenu{
	public MI_registrar_genero() {
		Nombre = "Registrar Generos";
	}

	public String getNombre() {
		return Nombre;
	}

	public void ejecutar() {
		System.out.println("\n\n----------------------------------\n"
							 + "||   Registrar - Nuevo Generos  ||");
		for(;;){
			System.out.println("\n\nDatos necesarios:\n");
			String nombre;
			String descripcion;
			System.out.print("Ingrese el nombre del genero: ");
			nombre=Lectura.Leer();
			System.out.print("Ingrese la descripcion del genero: ");
			descripcion=Lectura.Leer();
			Generos.Lista_Generos.add(new Genero(nombre,descripcion));
			System.out.println(">>>El genero "+nombre+" ha sido registrado");
			
			System.out.println("\nDesea registrar mas generos (y/n): ");
			descripcion=Lectura.Leer();
			if(descripcion.equals("y")){}
			else break;
		}
	}
}
