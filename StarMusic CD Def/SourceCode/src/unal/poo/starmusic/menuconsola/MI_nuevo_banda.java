package unal.poo.starmusic.menuconsola;
/**
 * @author Sebastián Pérez Salas
 * @author Carlos Alejandro Ruiz Ramírez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Castaño Guzman
 */

import unal.poo.starmusic.artistas.Banda;
import unal.poo.starmusic.artistas.Bandas;
import unal.poo.starmusic.varios.Lectura;
import unal.poo.starmusic.varios.Lista;
/*
 * Esta clase crea una nueva banda y la agrega al listado de Bandas 
 */
public class MI_nuevo_banda extends OpcionDeMenu implements deshechar{
	
	Lista bandaRehacer;
	Lista bandaDeshacer;
	
	public MI_nuevo_banda(){
		Nombre = "Registrar nueva banda";
	}

	public String getNombre() {
		return Nombre;
	}

	public void ejecutar() {
		bandaDeshacer = (Lista) Bandas.Lista_Bandas.clone();
		System.out.println("\n\n------------------------------------\n"
							 + "||    Registrar - Nueva banda     ||\n");
		System.out.println("Datos Necesarios:\n");
		String nombre;
		System.out.print("Ingrese el nombre de la banda: ");
		nombre=Lectura.Leer();
		System.out.print("Ingrese el anio de creacion: ");
		short anio;
		try{
			anio=Short.valueOf(Lectura.Leer());
		}catch(NumberFormatException e){anio=0;}
		
		Banda nueva=new Banda(nombre,anio);
		Bandas.Lista_Bandas.add(nueva);
		System.out.println("\n>>>>La banda "+nombre+" ha sido registrada<<<<");
		
		bandaRehacer = (Lista) Bandas.Lista_Bandas.clone();
	}
	
	public void deshacer() {
		if (this.bandaDeshacer != null) {
			Bandas.Lista_Bandas = bandaDeshacer;
			System.out.println(">>>>>Se ha eliminado la banda");
		}
	}
	public void rehacer() {
		if (this.bandaRehacer != null) {
			System.out.println(">>>>>Se ha agregado la banda");
			Bandas.Lista_Bandas = bandaRehacer;
		}
	}
	MI_nuevo_banda(MI_nuevo_banda o){
		bandaDeshacer = o.bandaDeshacer;
		bandaRehacer = o.bandaRehacer;
	}
	
	public OpcionDeMenu clone(){
		return new MI_nuevo_banda(this);
	}
	
}
