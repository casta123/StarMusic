package unal.poo.starmusic.varios;
/**
 * @author Sebastián Pérez Salas
 * @author Carlos Alejandro Ruiz Ramírez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Castaño Guzman
 */
import java.io.IOException;
import java.io.Serializable;

public class Premios implements Serializable{
	
	//almacena una lista de premios para su uso y modificacion
	public static Lista Lista_Premios =new Lista();
	
	public void guardarEnDisco() {
		IOArchivo guardar = new IOArchivo("premios.txt");
		for (int i = 0; i < Lista_Premios.size(); i++) {
			try {
				guardar.agregarObjeto((ObjetoIO) Lista_Premios.elementAt(i));
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
		IOArchivo leer = new IOArchivo("premios.txt");
		leer.leer();
		for(int i= 0; i < leer.getVector().size(); i++){
			Lista_Premios.add(leer.getVector().elementAt(i));
		}
	}

}
