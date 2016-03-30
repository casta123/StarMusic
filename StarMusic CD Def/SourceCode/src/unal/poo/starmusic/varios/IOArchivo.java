/**
 * 
 */
package unal.poo.starmusic.varios;
import java.util.*;
import java.io.*;
/**
 * @author Sebastián Pérez Salas
 * @author Carlos Alejandro Ruiz Ramírez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Castaño Guzman
 */
/*
 * Esta clase lee y escribe un listado de objetos en el directorio especificado,
 * para luego ser capturados por la clase que se encarga de la administracion de
 * estos objetos
 */
public class IOArchivo {
	protected String directorioArchivo = "./archivo.txt";
	protected Vector<ObjetoIO> resultado;
	public IOArchivo(String directorioArchivo) {
		this.directorioArchivo = directorioArchivo;
		resultado = new Vector<ObjetoIO>();

	}
	public IOArchivo() {
		resultado = new Vector<ObjetoIO>();
	}
	public void setDirectorioArchivo(String directorioArchivo) {
		this.directorioArchivo = directorioArchivo;
	}
	public void leer() {

		try {
			ObjectInputStream escritor = new ObjectInputStream(
					new FileInputStream((this.directorioArchivo)));
			for (;;) {
				ObjetoIO objetoLeido = (ObjetoIO) escritor.readObject();
				resultado.add(objetoLeido);
			}
		} catch (EOFException e) {
			return;
		} catch (ClassNotFoundException e) {
			System.out.println("Clase no encontrada!!!!" + e);
			return;
		} catch (IOException e) {
			System.out.println(e);
		}

	}
	public void guardar() throws IOException {
		ObjectOutputStream escritor = new ObjectOutputStream(
				new FileOutputStream((this.directorioArchivo)));
		Enumeration<ObjetoIO> elementos = resultado.elements();
		while (elementos.hasMoreElements()) {
			ObjetoIO auxiliar = elementos.nextElement();
			if (auxiliar != null)
			try{
				escritor.writeObject(auxiliar);
			}catch(Exception e){
				e.printStackTrace();
				System.out.print("Clase que genera: "+auxiliar.getClass() + "\n");
			}
			}
		escritor.close();

	}
	public void agregarObjeto(ObjetoIO objeto) {
		resultado.add(objeto);
	}
	public Vector getVector() {
		return this.resultado;
	}

}
