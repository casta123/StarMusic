package unal.poo.starmusic.menuconsola;

import unal.poo.starmusic.artistas.Artista;
import unal.poo.starmusic.artistas.Artistas;
import unal.poo.starmusic.instrumentos.*;
import unal.poo.starmusic.varios.Lectura;
import unal.poo.starmusic.varios.Lista;
/**
 * @author Sebastián Pérez Salas
 * @author Carlos Alejandro Ruiz Ramírez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Castaño Guzman
 */
/*
 * Esta clase compra hace de interfaz para la compra de un instrumento 
 * por parte de un usuario
 */
public class MI_Comprar_Instrumento extends OpcionDeMenu implements deshechar {

	public void ejecutar() throws SALIDA {
		deshacer = (Lista)Artistas.Lista_Artistas.clone();

		Opciones.setCabecera("\n\n----------------------------\n" +
	   	   "||   Acciones - Comprar instrumento   ||\n");

		Artista artista = Artistas.obtener_artista();
		if(artista == null)
			return;
		Instrumento instrumento = new Trombon();
		System.out.print("Marca del Instrumento: ");
		
		String marca = Lectura.Leer();
		System.out.print("Referencia del Instrumento: ");
		String referencia = Lectura.Leer();
		System.out.print("Descripcion del Instrumento: ");
		String descripcion = Lectura.Leer();
		System.out.print("Valor unitario del Instrumento: ");
		float valor = 0;
		try {
			 valor = Integer.parseInt(Lectura.Leer());
		} catch (NumberFormatException e) {
		}

		System.out.println("Categoria de Instrumento");
		System.out.println("[1] Instrumento de percusion");
		System.out.println("[2] Instrumento de cuerda");
		System.out.println("[3] Instrumento de viento");
		int categoria = 0;
		int tipoInstrumento = 0;
		while (categoria < 1 || categoria > 3) {
			System.out.print("Ingrese la opcion: ("+categoria);
			
			categoria = Integer.parseInt(Lectura.Leer());
		}
		if (categoria == 1) {
			System.out.println("Instrumento de Percusion");
			System.out.println("[1] Bateria");
			System.out.println("[2] Piano");
			System.out.println("[3] Tambor");
			System.out.println("[4] Timbal");

		} else if (categoria == 2) {
			System.out.println("Instrumento de cuerda");
			System.out.println("[1] Guitarra electrica");
			System.out.println("[2] Guirarra acustica");
			System.out.println("[3] Arpa");
			System.out.println("[4] Bandola");

		} else {
			System.out.println("Instrumento de viento");
			System.out.println("[1] Flauta");
			System.out.println("[2] Saxofon");
			System.out.println("[3] Trombon");
			System.out.println("[4] Trompeta");

		}
		while (tipoInstrumento < 1 || tipoInstrumento > 4) {
			System.out.print("Ingrese el instrumento:");
			tipoInstrumento = Integer.parseInt(Lectura.Leer());
		}
		if (categoria == 1) {
			if (tipoInstrumento == 1) {
				instrumento = new Bateria();
			} else if (tipoInstrumento == 2) {
				instrumento = new Piano();
			} else if (tipoInstrumento == 3) {
				instrumento = new Tambor();
			} else if (tipoInstrumento == 4) {
				instrumento = new Timbales();
			}
		} else if (categoria == 2) {
			if (tipoInstrumento == 1) {
				instrumento = new Guitarra_electrica();
			} else if (tipoInstrumento == 2) {
				instrumento = new Guitarra_acustica();
			} else if (tipoInstrumento == 3) {
				instrumento = new Arpa();
			} else if (tipoInstrumento == 4) {
				instrumento = new Bandola();
			}
		} else {
			if (tipoInstrumento == 1) {
				instrumento = new Flauta();
			} else if (tipoInstrumento == 2) {
				instrumento = new Saxofon();
			} else if (tipoInstrumento == 3) {
				instrumento = new Trombon();
			} else  {
				instrumento = new Trompeta();
			}
		}
		instrumento.setDescripcion(descripcion);
		instrumento.setMarca(marca);
		instrumento.setReferencia(referencia);
		instrumento.setValor(valor);
		artista.ComprarInstrumento(instrumento);
		rehacer = (Lista)Artistas.Lista_Artistas.clone();

	}
	public String getNombre() {
		return "Comprar Instrumento";
	}
	Lista deshacer;
	Lista rehacer;
	
	public void deshacer() {
		if (this.deshacer != null) {
			Artistas.Lista_Artistas = deshacer;
			System.out
					.println(">>>>>Se han eliminado los cambios en el artista");
		}
	}
	public void rehacer() {
		if (rehacer != null) {
			System.out
					.println(">>>>>Se ha restablecido los cambios en el artista");
			Artistas.Lista_Artistas = rehacer;
		}
	}
	MI_Comprar_Instrumento() {}

	MI_Comprar_Instrumento(MI_Comprar_Instrumento o) {
		deshacer = o.deshacer;
		rehacer = o.rehacer;
	}

	public OpcionDeMenu clone() {
		return new MI_Comprar_Instrumento(this);
	}


}
