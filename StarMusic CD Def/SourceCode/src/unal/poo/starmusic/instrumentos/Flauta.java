package unal.poo.starmusic.instrumentos;

import unal.poo.starmusic.varios.Clonar;

/**
 * @author Sebasti�n P�rez Salas
 * @author Carlos Alejandro Ruiz Ram�rez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Casta�o Guzman
 */
//Clase Flauta hija de la clase abstracta Intrumento_viento
public class Flauta extends Instrumento_viento {
	//DEfinicion del metodo emitirSonido  que dede ser definido desde cada intrumento obligatoriamente.
	public void emitirSonido(){
		System.out.println("fon fon fon!! ");
	}
	public Flauta(){}

	Flauta(Flauta o){
		descripcion = o.descripcion;
		marca = o.marca;
		referencia = o.referencia;
		valor_unitario = o.valor_unitario;
	}
	public Clonar clone(){
		return new Flauta(this);
	}

}
