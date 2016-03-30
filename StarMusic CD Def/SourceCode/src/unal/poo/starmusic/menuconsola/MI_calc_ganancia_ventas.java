package unal.poo.starmusic.menuconsola;

import java.util.Enumeration;

import unal.poo.starmusic.artistas.Banda;
import unal.poo.starmusic.artistas.Bandas;
import unal.poo.starmusic.varios.Album;
import unal.poo.starmusic.varios.Ventas;
/**
 * @author Sebastián Pérez Salas
 * @author Carlos Alejandro Ruiz Ramírez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Castaño Guzman
 */
/*
 * Los objetos instancias de esta clase tienen la facultad de revisar las bandas
 * y obtiene el valor total de albumes vendidos
 */
public class MI_calc_ganancia_ventas extends OpcionDeMenu {
	public MI_calc_ganancia_ventas() {
		Nombre = "Calcular ganancia por ventas";
	}

	public String getNombre() {
		return Nombre;
	}

	public void ejecutar() {
		Opciones.setCabecera("\n\n---------------------------------------\n" +
				   		   	     "||   Calcular - Ganancia por ventas   ||\n");
	
		float total=0;
		
		Enumeration enum1=Bandas.Lista_Bandas.elements();
		while(enum1.hasMoreElements()){
			Banda bandatemporal=(Banda)enum1.nextElement();
			System.out.println("Banda: "+bandatemporal.getNombre());
			Enumeration enum2=bandatemporal.getAlbumes().elements();
			while(enum2.hasMoreElements()){
				Album albumtemporal=(Album)enum2.nextElement();
				System.out.println("\tAlbum: "+albumtemporal.getNombre());
				Enumeration enum3=albumtemporal.getventas().elements();
				float acumulado=0;
				int totalventas=0;
				while(enum3.hasMoreElements()){
					acumulado+=((Ventas)enum3.nextElement()).getValor();
					++totalventas;
				}
				System.out.println("\t\tNumero de ventas: "+totalventas+" - por valor: "+acumulado);
				total+=acumulado;
			}
		}
		
		System.out.println(">>>>La ganancia total por ventas es: "+total);
	}
}
