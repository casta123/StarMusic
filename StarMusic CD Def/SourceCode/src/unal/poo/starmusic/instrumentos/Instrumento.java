package unal.poo.starmusic.instrumentos;
/**
 * @author Sebastián Pérez Salas
 * @author Carlos Alejandro Ruiz Ramírez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Castaño Guzman
 */

import java.io.Serializable;

import unal.poo.starmusic.varios.Clonar;
/*
 * Clase abstracta Instrumentos
 * La clase representa cada instrumento que puede ser instanciable
 * esta clase actua como un padre, contiene la informacion sobre la
 * marca, la descripcion y el valor unitario
 */
public abstract class Instrumento implements Serializable, Clonar {
//Atributo
	protected String marca;
	protected String referencia;
	protected String descripcion;
	protected float valor_unitario;
	
//Construcyor por defecto
	Instrumento() {
		marca = "";
		referencia = "";
		descripcion = "";
		valor_unitario = 0;
	}
	Instrumento(String marca, String referencia, String descripcion,
			float valor_unitario) {
		this.marca = marca;
		this.referencia = referencia;
		this.descripcion = descripcion;
		this.valor_unitario = valor_unitario;
	}


//Metodos Set y Get
	public String getMarca() {
		return marca;
	}
	public String getReferencia() {
		return referencia;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public float getValor() {
		return valor_unitario;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public void setValor(float valor_unitario) {
		this.valor_unitario = valor_unitario;
	}
	
	public String toString(){
		return ("Marca: "+marca+" - Referencia: " + referencia+" - Descripcion: " + descripcion+" - Valor: " + valor_unitario);
	}
//Metodos abtractos setDescripcion y emitirSonido que deben ser definidos obligatoriamenye por sus subclase
	abstract public void setDescripcion(String descripcion);
	public abstract void emitirSonido();
	public abstract Clonar clone();
	
	
	
}
