package unal.poo.starmusic.instrumentos;

import unal.poo.starmusic.varios.Clonar;

/**
 * @author Sebastián Pérez Salas
 * @author Carlos Alejandro Ruiz Ramírez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Castaño Guzman
 */
//Clase Saxofon hija de la clase abstracta Intrumento_viento
public class Saxofon extends Instrumento_viento {
	//DEfinicion del metodo emitirSonido  que dede ser definido desde cada intrumento obligatoriamente.
	public void emitirSonido(){
		System.out.println("fon fon fon!! ");
	}
	public Saxofon(){}

	Saxofon(Saxofon o){
		descripcion = o.descripcion;
		marca = o.marca;
		referencia = o.referencia;
		valor_unitario = o.valor_unitario;
	}
	public Clonar clone(){
		return new Saxofon(this);
	}

}
