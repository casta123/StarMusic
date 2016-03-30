package unal.poo.starmusic.menuconsola;
/**
 * @author Sebastián Pérez Salas
 * @author Carlos Alejandro Ruiz Ramírez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Castaño Guzman
 */

import unal.poo.starmusic.varios.Lectura;
import unal.poo.starmusic.varios.Lista;
import unal.poo.starmusic.varios.Premio;
import unal.poo.starmusic.varios.Premios;
/*
 * Esta clase crea un nuevo premio, el cual puede ser recibido por una banda
 */
public class MI_nuevo_premio extends OpcionDeMenu implements deshechar{
	
	Lista premioRehacer;
	Lista premioDeshacer;
	
	public MI_nuevo_premio() {
		Nombre = "Nuevo Premio";
	}

	public String getNombre() {
		return Nombre;
	}

	public void ejecutar() {
		premioDeshacer=(Lista)Premios.Lista_Premios.clone();
		
		System.out.println("\n\n--------------------------------\n"
				+ "||   Registrar nuevo Premio   ||\n");

		System.out.println("Datos Necesarios:\n");
		String nombre;
		System.out.print("Ingrese el nombre del premio: ");
		nombre = Lectura.Leer();
		long topeventas;
		
		for (;;) {
			System.out.print("Ingrese el tope de ventas: ");
			try {
				topeventas = Long.valueOf(Lectura.Leer());
				break;
			} catch (NumberFormatException e) {
				System.out.println("Debe introducir un numero\n");
			}
		}
		
		String entidad;
		System.out.print("Ingrese la entidad: ");
		entidad = Lectura.Leer();
		
		Premio premio=new Premio(nombre,topeventas,entidad);
		Premios.Lista_Premios.add(premio);
		System.out.println("\n>>>>El premio " + nombre
				+ " ha sido registrado<<<<");
		
		premioRehacer=(Lista)Premios.Lista_Premios.clone();
	}
	
	public void deshacer() {
		if (this.premioDeshacer != null) {
			Premios.Lista_Premios = premioDeshacer;
			System.out.println(">>>>>Se ha eliminado el premio");
		}
	}
	public void rehacer() {
		if (this.premioRehacer != null) {
			System.out.println(">>>>>Se ha registrado el premio");
			Premios.Lista_Premios = premioRehacer;
		}
	}
	
	MI_nuevo_premio(MI_nuevo_premio o){
		premioDeshacer = o.premioDeshacer;
		premioRehacer = o.premioRehacer;
	}
	
	public OpcionDeMenu clone(){
		return new MI_nuevo_premio(this);
	}

}
