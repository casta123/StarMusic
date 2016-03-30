package unal.poo.starmusic.menuconsola;

import java.io.Serializable;

import unal.poo.starmusic.varios.ObjetoIO;
/**
 * @author Sebastián Pérez Salas
 * @author Carlos Alejandro Ruiz Ramírez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Castaño Guzman
 */
/*Implementamos la interfaz Cloneable
*para poder utilizar el metodo clone() 
*/
abstract class OpcionDeMenu implements Cloneable,  ObjetoIO, Serializable {

	/*Este metodo lo implementamos desde la supercalse Object
	 * Con el fin de hacer una copia del objeto que llame esta
	 * funcion, necesario para realizar las copias e introducirlas
	 * en las pilas de deshacer y rehacer que se usan en la clase MenuDeConsola
	 */
	
	public OpcionDeMenu clone() {
		try {
			return (OpcionDeMenu) super.clone();
		} catch (CloneNotSupportedException ex) {
			System.out.println(" No se puede duplicar");
		}
		return null;
	}

	protected String Nombre;
	
	/*
	 *Este atributo de tipo MenuDeConsola guarda la cantidad de OpcionesDeMenu que
	 *tiene cada objeto que herede de esta clase, debido a que al cantidad de objetos que
	 *posee varia segun el adminsitrador del sistema.
	 */
	public MenuDeConsola Opciones;

	abstract public void ejecutar()  throws SALIDA;
	abstract public String getNombre();
	

	public OpcionDeMenu(){
		Opciones=new MenuDeConsola();
	}
	public void deshacer(){};
	public void rehacer(){};
}
