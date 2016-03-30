package unal.poo.starmusic.varios;

import java.io.Serializable;

/**
 * @author Sebastián Pérez Salas
 * @author Carlos Alejandro Ruiz Ramírez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Castaño Guzman
 */
//clase Venta_Album que es hija de la clase ventas
public class Venta_Album extends Ventas implements Serializable{
	//atributo de tipo album
	private Album album;
	//constructor
	public Venta_Album(Album album){
		this.album=album;
		setValor(album.getValor());
	}
	//metodo get de album
	public Album getAlbum(){
		return album;
	}
	
}
