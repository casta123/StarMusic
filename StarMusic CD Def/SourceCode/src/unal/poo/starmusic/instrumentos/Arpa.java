package unal.poo.starmusic.instrumentos;

import unal.poo.starmusic.varios.Clonar;

/**
 * @author Sebastián Pérez Salas
 * @author Carlos Alejandro Ruiz Ramírez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Castaño Guzman
 */
//Clase Arpa hija de la clase abstracta Intrumento_cuerda
public class Arpa extends Intrumento_cuerda {
	//DEfinicion del metodo emitirSonido  que dede ser definido desde cada intrumento obligatoriamente
	public void emitirSonido(){
		System.out.println("fing fing fing!! ");
	}
	public Arpa(){}

	Arpa(Arpa o){
		descripcion = o.descripcion;
		marca = o.marca;
		referencia = o.referencia;
		valor_unitario = o.valor_unitario;
	}
	public Clonar clone(){
		return new Arpa(this);
	}
}
