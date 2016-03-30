package unal.poo.starmusic.menuconsola;
/**
 * @author Sebastián Pérez Salas
 * @author Carlos Alejandro Ruiz Ramírez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Castaño Guzman
 */
import java.util.Enumeration;

import unal.poo.starmusic.artistas.Artista;
import unal.poo.starmusic.artistas.Artistas;
import unal.poo.starmusic.instrumentos.Arpa;
import unal.poo.starmusic.instrumentos.Bandola;
import unal.poo.starmusic.instrumentos.Bateria;
import unal.poo.starmusic.instrumentos.Flauta;
import unal.poo.starmusic.instrumentos.Guitarra_acustica;
import unal.poo.starmusic.instrumentos.Guitarra_electrica;
import unal.poo.starmusic.instrumentos.Instrumento;
import unal.poo.starmusic.instrumentos.Piano;
import unal.poo.starmusic.instrumentos.Saxofon;
import unal.poo.starmusic.instrumentos.Tambor;
import unal.poo.starmusic.instrumentos.Timbales;
import unal.poo.starmusic.instrumentos.Trombon;
import unal.poo.starmusic.instrumentos.Trompeta;
import unal.poo.starmusic.varios.Lectura;
/*
 * Esta opcion de menu recorre los artistas y determina cuales estan asociados
 * a un instrumento
 */

public class MI_consultas_6 extends OpcionDeMenu {
	public MI_consultas_6(){
		Nombre = "Consultar los artistas asociadas a un instrumento";
	}

	public String getNombre() {
		return Nombre;
	}
	
	
	public void ejecutar() {
		Opciones.setCabecera("\n\n-------------------------------\n"
				+ "| Artistas asociados a instrumento |\n");

		System.out.println("Categoria de Instrumento");
		System.out.println("[1] Instrumento de percusion");
		System.out.println("[2] Instrumento de cuerda");
		System.out.println("[3] Instrumento de viento");
		int categoria = 0;
		int tipoInstrumento = 0;
		while (categoria < 1 || categoria > 3) {
			System.out.print("Ingrese la opcion: "+categoria);
			
			categoria = Integer.parseInt(Lectura.Leer());
		}
		if (categoria == 1) {
			System.out.println("Instrumento de Percusion");
			System.out.println("\t[1] Bateria");
			System.out.println("\t[2] Piano");
			System.out.println("\t[3] Tambor");
			System.out.println("\t[4] Timbal");

		} else if (categoria == 2) {
			System.out.println("Instrumento de cuerda");
			System.out.println("\t[1] Guitarra electrica");
			System.out.println("\t[2] Guirarra acustica");
			System.out.println("\t[3] Arpa");
			System.out.println("\t[4] Bandola");

		} else {
			System.out.println("Instrumento de viento");
			System.out.println("\t[1] Flauta");
			System.out.println("\t[2] Saxofon");
			System.out.println("\t[3] Trombon");
			System.out.println("\t[4] Trompeta");

		}
		while (tipoInstrumento < 1 || tipoInstrumento > 4) {
			System.out.print("Ingrese el instrumento:");
			tipoInstrumento = Integer.parseInt(Lectura.Leer());
		}
		
		
		if (categoria == 1) {
			if (tipoInstrumento == 1) {
				System.out.println("Artistas con el instrumento Bateria: ");
				Enumeration enum1=Artistas.Lista_Artistas.elements();
				int i=0;
				while(enum1.hasMoreElements()){
					Artista temporal=(Artista)enum1.nextElement();
					Enumeration enum2=temporal.getListaInstrumentos().elements();
					i=0;
					while(enum2.hasMoreElements()){
						if((Instrumento)enum2.nextElement() instanceof Bateria){
							System.out.println("\t"+(++i)+") "+temporal.getNombreArtistico());
						}
					}
				}
			} else if (tipoInstrumento == 2) {
				System.out.println("Artistas con el instrumento Piano: ");
				Enumeration enum1=Artistas.Lista_Artistas.elements();
				int i=0;
				while(enum1.hasMoreElements()){
					Artista temporal=(Artista)enum1.nextElement();
					Enumeration enum2=temporal.getListaInstrumentos().elements();
					i=0;
					while(enum2.hasMoreElements()){
						if((Instrumento)enum2.nextElement() instanceof Piano){
							System.out.println("\t"+(++i)+") "+temporal.getNombreArtistico());
						}
					}
				}
			} else if (tipoInstrumento == 3) {
				System.out.println("Artistas con el instrumento Tambor: ");
				Enumeration enum1=Artistas.Lista_Artistas.elements();
				int i=0;
				while(enum1.hasMoreElements()){
					Artista temporal=(Artista)enum1.nextElement();
					Enumeration enum2=temporal.getListaInstrumentos().elements();
					i=0;
					while(enum2.hasMoreElements()){
						if((Instrumento)enum2.nextElement() instanceof Tambor){
							System.out.println("\t"+(++i)+") "+temporal.getNombreArtistico());
						}
					}
				}
				
			} else if (tipoInstrumento == 4) {
				System.out.println("Artistas con el instrumento Timbales: ");
				Enumeration enum1=Artistas.Lista_Artistas.elements();
				int i=0;
				while(enum1.hasMoreElements()){
					Artista temporal=(Artista)enum1.nextElement();
					Enumeration enum2=temporal.getListaInstrumentos().elements();
					i=0;
					while(enum2.hasMoreElements()){
						if((Instrumento)enum2.nextElement() instanceof Timbales){
							System.out.println("\t"+(++i)+") "+temporal.getNombreArtistico());
						}
					}
				}
			}
		} else if (categoria == 2) {
			if (tipoInstrumento == 1) {
				System.out.println("Artistas con el instrumento Guitarra electrica: ");
				Enumeration enum1=Artistas.Lista_Artistas.elements();
				int i=0;
				while(enum1.hasMoreElements()){
					Artista temporal=(Artista)enum1.nextElement();
					Enumeration enum2=temporal.getListaInstrumentos().elements();
					i=0;
					while(enum2.hasMoreElements()){
						if((Instrumento)enum2.nextElement() instanceof Guitarra_electrica){
							System.out.println("\t"+(++i)+") "+temporal.getNombreArtistico());
						}
					}
				}
			} else if (tipoInstrumento == 2) {
				System.out.println("Artistas con el instrumento Guitarra acustica: ");
				Enumeration enum1=Artistas.Lista_Artistas.elements();
				int i=0;
				while(enum1.hasMoreElements()){
					Artista temporal=(Artista)enum1.nextElement();
					Enumeration enum2=temporal.getListaInstrumentos().elements();
					i=0;
					while(enum2.hasMoreElements()){
						if((Instrumento)enum2.nextElement() instanceof Guitarra_acustica){
							System.out.println("\t"+(++i)+") "+temporal.getNombreArtistico());
						}
					}
				}
		
			} else if (tipoInstrumento == 3) {
				System.out.println("Artistas con el instrumento Arpa: ");
				Enumeration enum1=Artistas.Lista_Artistas.elements();
				int i=0;
				while(enum1.hasMoreElements()){
					Artista temporal=(Artista)enum1.nextElement();
					Enumeration enum2=temporal.getListaInstrumentos().elements();
					i=0;
					while(enum2.hasMoreElements()){
						if((Instrumento)enum2.nextElement() instanceof Arpa){
							System.out.println("\t"+(++i)+") "+temporal.getNombreArtistico());
						}
					}
				}
		
			} else if (tipoInstrumento == 4) {
				System.out.println("Artistas con el instrumento Bandola: ");
				Enumeration enum1=Artistas.Lista_Artistas.elements();
				int i=0;
				while(enum1.hasMoreElements()){
					Artista temporal=(Artista)enum1.nextElement();
					Enumeration enum2=temporal.getListaInstrumentos().elements();
					i=0;
					while(enum2.hasMoreElements()){
						if((Instrumento)enum2.nextElement() instanceof Bandola){
							System.out.println("\t"+(++i)+") "+temporal.getNombreArtistico());
						}
					}
				}
			
			}
		} else {
			if (tipoInstrumento == 1) {
				System.out.println("Artistas con el instrumento Flauta: ");
				Enumeration enum1=Artistas.Lista_Artistas.elements();
				int i=0;
				while(enum1.hasMoreElements()){
					Artista temporal=(Artista)enum1.nextElement();
					Enumeration enum2=temporal.getListaInstrumentos().elements();
					i=0;
					while(enum2.hasMoreElements()){
						if((Instrumento)enum2.nextElement() instanceof Flauta){
							System.out.println("\t"+(++i)+") "+temporal.getNombreArtistico());
						}
					}
				}
			
			} else if (tipoInstrumento == 2) {
				System.out.println("Artistas con el instrumento Saxofon: ");
				Enumeration enum1=Artistas.Lista_Artistas.elements();
				int i=0;
				while(enum1.hasMoreElements()){
					Artista temporal=(Artista)enum1.nextElement();
					Enumeration enum2=temporal.getListaInstrumentos().elements();
					i=0;
					while(enum2.hasMoreElements()){
						if((Instrumento)enum2.nextElement() instanceof Saxofon){
							System.out.println("\t"+(++i)+") "+temporal.getNombreArtistico());
						}
					}
				}
			
			} else if (tipoInstrumento == 3) {
				System.out.println("Artistas con el instrumento Trombon: ");
				Enumeration enum1=Artistas.Lista_Artistas.elements();
				int i=0;
				while(enum1.hasMoreElements()){
					Artista temporal=(Artista)enum1.nextElement();
					Enumeration enum2=temporal.getListaInstrumentos().elements();
					i=0;
					while(enum2.hasMoreElements()){
						if((Instrumento)enum2.nextElement() instanceof Trombon){
							System.out.println("\t"+(++i)+") "+temporal.getNombreArtistico());
						}
					}
				}
				
			} else  {
				System.out.println("Artistas con el instrumento Trompeta: ");
				Enumeration enum1=Artistas.Lista_Artistas.elements();
				int i=0;
				while(enum1.hasMoreElements()){
					Artista temporal=(Artista)enum1.nextElement();
					Enumeration enum2=temporal.getListaInstrumentos().elements();
					i=0;
					while(enum2.hasMoreElements()){
						if((Instrumento)enum2.nextElement() instanceof Trompeta){
							System.out.println("\t"+(++i)+") "+temporal.getNombreArtistico());
						}
					}
				}
			
			}
		}
	}
}
