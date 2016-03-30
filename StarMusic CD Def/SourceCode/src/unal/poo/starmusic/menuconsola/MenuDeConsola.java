package unal.poo.starmusic.menuconsola;
/**
 * @author Sebastián Pérez Salas
 * @author Carlos Alejandro Ruiz Ramírez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Castaño Guzman
 */

import java.io.Serializable;
import java.util.*;

import unal.poo.starmusic.varios.Lectura;

/*Esta clase se encarga de adminsitrar una lista de elementos
 *de tipo OpcionDeMenu, tambien la imprime por consola, y ejecuta
 *el método Ejecutar() correspondiente a la opcion elegida por el usuario
 */

class MenuDeConsola implements Serializable{

	/*
	 * Los objetos M-deshacer y M_rehacer son pilas de datos para almacenarlos
	 * objetos de tipo OpcionDeMenu que el usuario vaya ejecutando.Son estaticos
	 * para que se alamacenen objetos ejecutados en la pila sin importar que
	 * objeto de tipo MenuDeConsola los este implementando.
	 */
	private static Pila_Menu Menu_deshacer = new Pila_Menu();
	private static Pila_Menu Menu_rehacer = new Pila_Menu();

	// Lista que almacena los elementos de tipo OpcionDeMenu que se pueden
	// mostrar en el menu
	private unal.poo.starmusic.varios.Lista Lista = new unal.poo.starmusic.varios.Lista();

	public void addOpcion(OpcionDeMenu op) {
		// Añadimos el elemento a la lista
		Lista.add(op);
	}

	private String cabecera = "";

	public void setCabecera(String cabecera) {
		this.cabecera = cabecera;
	}

	public static void Deshacer() {
		OpcionDeMenu elementocola = Menu_deshacer.obtener_elemento();
		if (elementocola != null) {
			Menu_rehacer.agregar_elemento(elementocola);
			elementocola.deshacer();
		}
		
	}

	public static void Rehacer() {
		OpcionDeMenu elementoejecutar = Menu_rehacer.obtener_elemento();
		if (elementoejecutar != null) {
			Menu_deshacer.agregar_elemento(elementoejecutar);
			elementoejecutar.rehacer();
		}
	}


	public void imprimir() {
		/*
		 * for (int i = 0; i < 40; i++) { System.out.println("\n"); } // Limpia
		 * la pantalla
		 */
		Enumeration<Object> elementos;
		int opcion;
		String respuesta;

		for (;;) {
			int i = 0;
			elementos = Lista.elements();

			System.out.println(cabecera + "\nOpciones:\n-----------");
			while (elementos.hasMoreElements()) {
				System.out.println("\t" + (++i) + ")  "
						+ ((OpcionDeMenu) elementos.nextElement()).getNombre());
			}
			System.out.print("\n");
			if (Menu_deshacer.get_Nelementos() > 0)
				System.out.println("\td) Deshacer");
			if (Menu_rehacer.get_Nelementos() > 0)
				System.out.println("\tr) Rehacer");

			System.out.print("\nIntroduzca una opcion: ");

			// El metodo Leer() lee los valores introducidos por consola y
			// retorna un String
			respuesta = Lectura.Leer();

			if (Menu_deshacer.get_Nelementos() > 0 && respuesta.equals("d")) {
				Deshacer();
			}

			if (Menu_rehacer.get_Nelementos() > 0 && respuesta.equals("r")) {
				Rehacer();

			}

			try {
				opcion = Integer.parseInt(respuesta);
				if (opcion > 0 && opcion <= Lista.size()) {
					OpcionDeMenu temporal = (OpcionDeMenu) Lista
							.get(opcion - 1);
					try {
						temporal.ejecutar();
						if (temporal instanceof deshechar)
							Menu_deshacer.agregar_elemento(temporal);

					} catch (SALIDA salida) {
						break;
					}
				}
			} catch (NumberFormatException e) {
				
			}

		}
	}
}
