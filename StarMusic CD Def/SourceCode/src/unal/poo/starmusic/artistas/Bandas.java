package unal.poo.starmusic.artistas;

import java.io.IOException;
import java.io.Serializable;
import java.util.Enumeration;

import unal.poo.starmusic.varios.IOArchivo;
import unal.poo.starmusic.varios.Lectura;
import unal.poo.starmusic.varios.Lista;
import unal.poo.starmusic.varios.ObjetoIO;
/**
 * @author Sebastiï¿½n Pï¿½rez Salas
 * @author Carlos Alejandro Ruiz Ramï¿½rez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Castaï¿½o Guzman
 */
/*
 * La clase bandas nos representa el conjunto de 
 * instancias de artistas, posee una lista estatica
 * y es allí donde se guardan los objetos ademas 
 * tiene los metodos de lectura y escritura
 * para la persistencia los objetos
 */
public class Bandas implements Serializable{
	
	//almacena una lista de premios para su uso y modificacion
	public static Lista Lista_Bandas =new Lista();
	
	public static Banda obtener_banda() {
		System.out.println("Bandas registradas: \n");

		if (Lista_Bandas.size() > 0) {
			Enumeration elementos = (Lista_Bandas).elements();
			int i = 0;

			while (elementos.hasMoreElements()) {
				System.out.println("\t" + (++i) + ") "
						+ ((Banda) elementos.nextElement()).getNombre());
			}

			Banda bandaelegida;
			for (;;) {
				int banda;
				System.out.print("\nSeleccione una banda: ");
				try {
					banda = Integer.parseInt(Lectura.Leer());
					if (banda > 0 && banda <= Lista_Bandas.size()) {
						bandaelegida = (Banda) Lista_Bandas
								.get(banda - 1);
						System.out.println("\nLa banda "
								+ bandaelegida.getNombre()
								+ " fue seleccionada");
						break;
					}
				} catch (NumberFormatException e) {
				}
			}

			return bandaelegida;
		} else {
			System.out
					.println("No existen bandas registradas, registre bandas y vuelva a intentarlo");
			return null;
		}
	}
	public void guardarEnDisco() {
		IOArchivo guardar = new IOArchivo("bandas.txt");
		for (int i = 0; i < Lista_Bandas.size(); i++) {
			try {
				guardar.agregarObjeto((ObjetoIO) Lista_Bandas.elementAt(i));
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		try {
			guardar.guardar();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void leerEnDisco(){
		IOArchivo leer = new IOArchivo("bandas.txt");
		leer.leer();
		for(int i= 0; i < leer.getVector().size(); i++){
			Lista_Bandas.add(leer.getVector().elementAt(i));
		}
	}
}


