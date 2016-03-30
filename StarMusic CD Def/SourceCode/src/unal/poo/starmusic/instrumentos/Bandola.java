package unal.poo.starmusic.instrumentos;

import unal.poo.starmusic.varios.Clonar;

/**
 * @author Sebastián Pérez Salas
 * @author Carlos Alejandro Ruiz Ramírez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Castaño Guzman
 */
//Clase Bandola hija de la clase abstracta Intrumento_cuerda
public class Bandola extends Intrumento_cuerda {
	//DEfinicion del metodo emitirSonido  que dede ser definido desde cada intrumento obligatoriamente
	public void emitirSonido(){
		System.out.println("fring fring fring!! ");
	}
	public Bandola(){}

	Bandola(Bandola o){
		descripcion = o.descripcion;
		marca = o.marca;
		referencia = o.referencia;
		valor_unitario = o.valor_unitario;
	}
	public Clonar clone(){
		return new Bandola(this);
	}

}
