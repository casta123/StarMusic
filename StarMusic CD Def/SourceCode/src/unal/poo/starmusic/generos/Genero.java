package unal.poo.starmusic.generos;

import java.util.Enumeration;

import unal.poo.starmusic.varios.Clonar;
import unal.poo.starmusic.varios.Lectura;
import unal.poo.starmusic.varios.Lista;
import unal.poo.starmusic.varios.ObjetoIO;

/**
 * @author Sebastián Pérez Salas
 * @author Carlos Alejandro Ruiz Ramírez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Castaño Guzman
 */
/*
 * Clase genero:
 * Representa cada genero que se le puede asignar a un artista o a una banda
 */

public class Genero implements ObjetoIO, Clonar{
	private String nombre;
	private String descripcion;
	private int id;
	public Genero(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	
	
	public Genero() {
		this.nombre = "";
		this.descripcion = "";
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre() {
		return this.nombre;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDescripcion() {
		return this.descripcion;
	}
	public int getId(){
		return this.id;
	}
	public void setId(int id){
		this.id = id;
	}
	public Genero(Genero o){
		descripcion = o.descripcion;
		id = o.id;
		nombre = o.nombre;
	}
	public Clonar clone(){
		return (Clonar) new Genero(this); 
	}
	
	
}
