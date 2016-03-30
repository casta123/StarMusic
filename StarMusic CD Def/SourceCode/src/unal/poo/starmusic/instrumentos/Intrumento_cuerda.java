package unal.poo.starmusic.instrumentos;
/**
 * @author Sebastián Pérez Salas
 * @author Carlos Alejandro Ruiz Ramírez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Castaño Guzman
 */
//Clase abstracta Instrumento_viento hija de la clase abstracta Instrumentos 
abstract public class Intrumento_cuerda extends Instrumento {
	//Contructor por defecto	
	Intrumento_cuerda(){
		super();
		this.descripcion="Instrumento de cuerda ";
	}
	Intrumento_cuerda(String marca,String referencia,String descripcion,float valor_unitario){
		super(marca,referencia,"Instrumento de cuerda "+descripcion,valor_unitario);
	}
	//definicion del metodo abstracto setDescripcion que lo que hacees que siempre que se revise la descripcion del instrumento diga primero que clase de instrumnto es.
	public void setDescripcion(String descripcion){
		this.descripcion="Instrumento de cuerda "+descripcion;
	}
}
