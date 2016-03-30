package unal.poo.starmusic.instrumentos;

import unal.poo.starmusic.varios.Clonar;

/**
 * @author Sebastián Pérez Salas
 * @author Carlos Alejandro Ruiz Ramírez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Castaño Guzman
 */
//Clase Piano hija de la clase Instrumento_percusion
public class Piano extends Instrumento_percusion{
	//DEfinicion del metodo emitirSonido  que dede ser definido desde cada intrumento obligatoriamente.
	public void emitirSonido(){
		System.out.println("Pin Pin Pin!! ");
	}
	public Piano(){}

	Piano(Piano o){
		descripcion = o.descripcion;
		marca = o.marca;
		referencia = o.referencia;
		valor_unitario = o.valor_unitario;
	}
	public Clonar clone(){
		return new Piano(this);
	}

}
