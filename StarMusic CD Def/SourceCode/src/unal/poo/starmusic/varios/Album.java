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
 * Esta clase representa cada album que puede ser creado
 */
public class Album implements ObjetoIO{
	private String Nombre;
	private Lista Canciones =new Lista();
	private Lista ventas=new Lista();
	private short Anio;
	private float Valor;
	
	public Album(){
		Calendar hoy=Calendar.getInstance();
		Anio=(short)hoy.get(Calendar.YEAR);
		Nombre = "";
		Canciones = null;
		Valor=0;
	}
	
	public Album (String Nombre, short Anio, Banda banda, float valor){
		if(Anio==0){
			Calendar hoy=Calendar.getInstance();
			Anio=(short)hoy.get(Calendar.YEAR);
		}else this.Anio=Anio;
		this.Valor=valor;
		this.Nombre = Nombre;
		this.Anio = Anio;
	}
	
	
	public void setNombre(String Nombre){
		this.Nombre = Nombre;
	}
	
	public void setAnio(short Anio){
		this.Anio = Anio;
	}
	
	public void setValor(float Valor){
		this.Valor=Valor;
	}
	
	public String getNombre(){
		return Nombre;
	}
	
	public short getAnio(){
		return Anio;
	}
	
	public float getValor(){
		return Valor;
	}
	
	public Lista getventas(){
		return ventas;
	}
	
	public void AgregarCancion(Long cancion){
		if(!Canciones.contains(cancion)) Canciones.add(cancion);
		else System.out.println("La cancion ya pertenece al album");
	}
	
	public void AgregarVenta(Ventas venta){
		ventas.add(venta);
	}
	
}