package unal.poo.starmusic.varios;

import java.util.Calendar;
import unal.poo.starmusic.artistas.*;
/**
 * @author Sebastián Pérez Salas
 * @author Carlos Alejandro Ruiz Ramírez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Castaño Guzman
 */
/*
 * Los objetoss de esta clase nos reprentan una cancion
 */
public class Cancion implements ObjetoIO, Clonar{
	/*
	 * El campo id es necesario para asociar las canciones con los albumes, debido
	 * a que una cancion puede pertenecer o no a un album
	 */
	private long id;
	private String Nombre;
	private Artista Compositor;
		
	/*Este atributo nos dice si la cancion pertenece o no a un album,
	*es necesario hacerlo, pues una cancion solo puede pertenecer a un album,
	*por esto, si ya tiene album, el atributo pertenece_album es verdadero.
	*/
	private boolean pertenece_album=false;
	private String Letra;
	Cancion(){
		Nombre="";
		Compositor=null;
		Letra="";
		id=generarId();
	}
	
	private long generarId(){
		Calendar hoy=Calendar.getInstance();
		String valor=""+hoy.get(Calendar.YEAR)+hoy.get(Calendar.HOUR_OF_DAY)+hoy.get(Calendar.SECOND)+(int)(Math.random()*99+1);
		return Long.valueOf(valor);
	}
	
	public long getId(){
		return id;
	}
	//constructor
	public Cancion(String Nombre,Artista Compositor,String Letra){
		this.Nombre=Nombre;
		this.Compositor=Compositor;
		this.Letra=Letra;
	}
	
	//metodos set y get de cancion
	public void setNombre(String Nombre){
		this.Nombre=Nombre;
	}
	public void setCompositor(Artista Compositor){
		this.Compositor=Compositor;
	}
	public void setLetra(String Letra){
		this.Letra=Letra;
	}
	public String getNombre(){
		return Nombre;
	}
	public Artista getCompositor(){
		return Compositor;
	}
	public String getLetra(){
		return Letra;
	}
	public Cancion(Cancion o){
		Compositor = o.Compositor; //No se clona, el artista 
		id = o.id;
		Letra = o.Letra;
		Nombre = o.Nombre;
		pertenece_album = o.pertenece_album;
		
	}
	public Clonar clone(){
		return (Clonar) new Cancion(this);
	}
}
