package unal.poo.starmusic.instrumentos;

import unal.poo.starmusic.varios.Clonar;

/**
 * @author Sebastián Pérez Salas
 * @author Carlos Alejandro Ruiz Ramírez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Castaño Guzman
 */
//Clase Trompeta hija de la clase abstracta Intrumento_viento
public class Trompeta extends Instrumento_viento {
	//DEfinicion del metodo emitirSonido  que dede ser definido desde cada intrumento obligatoriamente.
	public void emitirSonido(){
		System.out.println("fa fa fa!! ");
	}
	public Trompeta(){}

	Trompeta(Trompeta o){
		descripcion = o.descripcion;
		marca = o.marca;
		referencia = o.referencia;
		valor_unitario = o.valor_unitario;
	}
	public Clonar clone(){
		return new Trompeta(this);
	}

}
