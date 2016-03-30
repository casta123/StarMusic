package unal.poo.starmusic.varios;

import java.io.Serializable;

/**
 * @author Sebastián Pérez Salas
 * @author Carlos Alejandro Ruiz Ramírez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Castaño Guzman
 */
//Clase ventas que va a servir de clase padre para vanta de boletas y venta de albunes
public class Ventas implements Serializable{
	//atributo valor
	private float valor;
	// matodos set y get de valor	
	public void setValor(float valor){
		this.valor=valor;
	}
	public float getValor(){
		return valor;
	}
}
