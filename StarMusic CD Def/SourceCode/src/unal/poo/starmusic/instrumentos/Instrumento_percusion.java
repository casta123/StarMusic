package unal.poo.starmusic.instrumentos;
/**
 * @author Sebasti�n P�rez Salas
 * @author Carlos Alejandro Ruiz Ram�rez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Casta�o Guzman
 */
//Clase abstracta Instrumento_percusion hija de la clase abstracta Instrumentos 
abstract public class Instrumento_percusion extends Instrumento  {
	//Contructor por defecto
	Instrumento_percusion(){
		super();
		this.descripcion="Instrumento de percusion ";
	}
	Instrumento_percusion(String marca,String referencia,String descripcion,float valor_unitario){
		super(marca,referencia,"Instrumento de percusion "+descripcion,valor_unitario);
	}	
	//definicion del metodo abstracto setDescripcion que lo que hacees que siempre que se revise la descripcion del instrumento diga primero que clase de instrumnto es.
	public void setDescripcion(String descripcion){
		this.descripcion="Instrumento de Percusion "+descripcion;
	}
}
