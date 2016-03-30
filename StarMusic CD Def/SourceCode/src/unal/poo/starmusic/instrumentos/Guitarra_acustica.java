package unal.poo.starmusic.instrumentos;

import unal.poo.starmusic.varios.Clonar;

/**
 * @author Sebastián Pérez Salas
 * @author Carlos Alejandro Ruiz Ramírez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Castaño Guzman
 */
//Clase Guitarra acustica hija de la clase abstracta Intrumento_cuerda
public class Guitarra_acustica extends Intrumento_cuerda {
	//DEfinicion del metodo emitirSonido  que dede ser definido desde cada intrumento obligatoriamente
	public void emitirSonido(){
		System.out.println("wing wing wing!! ");
	}
	public Guitarra_acustica(){}

	Guitarra_acustica(Guitarra_acustica o){
		descripcion = o.descripcion;
		marca = o.marca;
		referencia = o.referencia;
		valor_unitario = o.valor_unitario;
	}
	public Clonar clone(){
		return new Guitarra_acustica(this);
	}

}
