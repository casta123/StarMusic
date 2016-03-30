package unal.poo.starmusic.menuconsola;

import java.util.Enumeration;

import unal.poo.starmusic.artistas.Banda;
import unal.poo.starmusic.artistas.Bandas;
import unal.poo.starmusic.varios.Concierto;
/**
 * @author Sebastián Pérez Salas
 * @author Carlos Alejandro Ruiz Ramírez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Castaño Guzman
 */
/*
 * Los objetos de esta clase tienen la facultad de revisar las bandas
 * y obtiene el valor total de ventas por concepto de conciertos 
 */
public class MI_calc_ganancia_conciertos extends OpcionDeMenu{
	public MI_calc_ganancia_conciertos() {
		Nombre = "Calcular ganancia por conciertos";
	}

	public String getNombre() {
		return Nombre;
	}

	public void ejecutar() {
		Opciones.setCabecera("\n\n-------------------------------------------\n" +
				   		   	     "||   Calcular - Ganancia por concierto   ||\n");
	
		float total=0;
		
		Enumeration enum1=Bandas.Lista_Bandas.elements();
		while(enum1.hasMoreElements()){
			Banda bandatemporal=(Banda)enum1.nextElement();
			System.out.println("Banda: "+bandatemporal.getNombre());
			Enumeration enum2=bandatemporal.getConciertos().elements();
			float acumulado=0;
			while(enum2.hasMoreElements()){
				Concierto conciertotemporal=(Concierto)enum2.nextElement();
				System.out.println("\tConcierto: "+conciertotemporal.getNombre());
				acumulado+=(conciertotemporal.getNumParticipantes()*conciertotemporal.getValorEntrada());
				System.out.println("\t\tValor recaudado: "+acumulado);
			}
			total+=acumulado;
		}
		
		System.out.println(">>>>La ganancia total por conciertos es: "+total);
	}
}
