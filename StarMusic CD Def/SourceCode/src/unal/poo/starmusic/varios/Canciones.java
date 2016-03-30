package unal.poo.starmusic.varios;

import java.io.IOException;
import java.io.Serializable;
/**
 * @author Sebastián Pérez Salas
 * @author Carlos Alejandro Ruiz Ramírez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Castaño Guzman
 */
/*
 * Esta clase nos almacena, guarda y lee las canciones que existen en la
 * aplicacion 
 */
public class Canciones implements Serializable{
	//almavena una lista de canciones para su uso y modificacion
	public static Lista Lista_Canciones =new Lista();
	public void guardarEnDisco() {
		IOArchivo guardar = new IOArchivo("canciones.txt");
		for (int i = 0; i < Lista_Canciones.size(); i++) {
			try {
				guardar.agregarObjeto((ObjetoIO) Lista_Canciones.elementAt(i));
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
		IOArchivo leer = new IOArchivo("canciones.txt");
		leer.leer();
		for(int i= 0; i < leer.getVector().size(); i++){
			Lista_Canciones.add(leer.getVector().elementAt(i));
		}
	}	
	
}
