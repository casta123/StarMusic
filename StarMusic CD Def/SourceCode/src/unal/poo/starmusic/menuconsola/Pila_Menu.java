package unal.poo.starmusic.menuconsola;
/**
 * @author Sebastián Pérez Salas
 * @author Carlos Alejandro Ruiz Ramírez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Castaño Guzman
 */
import java.util.*;

/*
 *Esta clase se encarga de representar una pila de datos, de tipo
 *OpcionDeMenu, con el fin de poderla utilizar para realizar un deshacer y un
 *rehacer de los elementos ejecutados en el menú
 */

public class Pila_Menu {
	private Vector<OpcionDeMenu> pila = new Vector<OpcionDeMenu>();
	private int Num_elementos = 0;

	/*Este metodo copia el objeto OpcionDeMenu que se le pasa como argumento
	 *despues lo agerga a la pila de datos.
	*/
	public void agregar_elemento(OpcionDeMenu opcion) {
		OpcionDeMenu copia=opcion.clone();
		pila.add(copia);
		++Num_elementos;
	}

	//Este metodo obtiene el elemento de la pila, lo elimina y lo retorna para su uso
	public OpcionDeMenu obtener_elemento() {
		if (Num_elementos > 0) {
			OpcionDeMenu temporal = pila.lastElement();
			pila.removeElementAt(--Num_elementos);
			return temporal;
		} else
			return null;
	}
	
	public int get_Nelementos(){
		return Num_elementos;
	}

}
