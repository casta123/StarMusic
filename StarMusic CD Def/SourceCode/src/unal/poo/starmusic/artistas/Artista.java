package unal.poo.starmusic.artistas;

import java.io.Serializable;
import java.util.Calendar;
import unal.poo.starmusic.instrumentos.*;
import unal.poo.starmusic.varios.*;
import unal.poo.starmusic.generos.*;

/**
 * @author Sebasti�n P�rez Salas
 * @author Carlos Alejandro Ruiz Ram�rez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Casta�o Guzman
 */
/*
 * Clase Artista:
 * Esta clase nos representa los artistas,Posee un listado de 
 * generosAsociados e Instrumentos que nos permitir guardar 
 * todos los objetos 
 */
public class Artista implements ObjetoIO, Clonar {
	private long id;
	private String Nombre;
	private String NombreArtistico;
	private String Biografia;
	private Lista generosAsociados = new Lista();
	private Lista Instrumentos = new Lista();

	// Constructores**********************************

	public Artista() {
		Nombre = "";
		NombreArtistico = "";
		id = generarId();
		generosAsociados = null;
		Instrumentos = null;

	}

	public Artista(String Nombre, String NombreArtistico, String biografia) {
		this.Nombre = Nombre;
		this.NombreArtistico = NombreArtistico;
		this.Biografia = biografia;
		id = generarId();
	}

	// Metodos ****************************************

	private long generarId() {
		Calendar hoy = Calendar.getInstance();
		String valor = "" + hoy.get(Calendar.YEAR)
				+ hoy.get(Calendar.HOUR_OF_DAY) + hoy.get(Calendar.SECOND)
				+ (int) (Math.random() * 99 + 1);
		return Long.valueOf(valor);
	}

	public Long getId() {
		return id;
	}

	// ...para ingresar datos***************

	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}

	public void setNombreArtistico(String Nombre) {
		this.Nombre = NombreArtistico;
	}

	/*
	 * Agrega un genero asociado al artista siempre y cuando este no halla sido
	 * asociado con anteriorida al artista
	 */
	public void AgregarGenero(Genero genero) {
		for (int i = 0; i < generosAsociados.size(); i++) {
			if (generosAsociados.get(i).equals(genero)) {
				return;
			}
		}
		generosAsociados.add(genero);
	}

	/**************************************/

	// ...para obtener datos de la clase artista****

	public String getNombre() {
		return Nombre;
	}

	public String getNombreArtistico() {
		return NombreArtistico;
	}

	// Obtener una cadena con la lista de generos asociados al artista
	public String ImprimirGeneros() {
		String GenerosAsociados = "";

		for (int i = 0; i < generosAsociados.size(); i++) {
			GenerosAsociados += ("\n" + generosAsociados.get(i));
		}
		return GenerosAsociados;
	}

	public Lista getGenerosAsociados() {
		return generosAsociados;
	}

	// obtener la lista de instrumentos del alrtista
	public Lista getListaInstrumentos() {
		return Instrumentos;
	}

	// Obtener una cadena con la lista de instrumentos que tiene el artista
	public String getInstrumentos() {
		String instrumentos = "";
		for (int i = 0; i < Instrumentos.size(); i++) {
			instrumentos += ("\n" + Instrumentos.get(i));
		}
		return instrumentos;
	}

	public int getNumeroInstrumentos() {
		return Instrumentos.size();
	}

	public void ComprarInstrumento(Instrumento instrumento) {
		Instrumentos.add(instrumento);
	}

	/*
	 * Metodo que permite a un artista componer una cancion, recibe como datos
	 * de entrada el nombre de la cancion y la letra y lo guarda en las listas
	 * de canciones
	 */
	public Cancion ComponerCancion(String nombre, String letra) {
		Cancion NuevaCancion = new Cancion(nombre, this, letra);
		Canciones.Lista_Canciones.add(NuevaCancion);
		System.out.println("\n>>>El artista " + this.Nombre
				+ " ha compuesto la cancion " + nombre);
		return NuevaCancion;
	}

	/*
	 * Metodo que permite al artista comprar un instrumento, para ello se le
	 * debe pasar un instrumento
	 */

	/*
	 * Metodo De firmar autografo, este recibe un string que es el nombre de
	 * quien quiere el autografo y retorna otro string que tiene una
	 * dedicatoria, el nombre del fan y la "firma del artista"
	 */
	public String FirmarAutografo(String fan) {
		String autografo;
		autografo = "Con carino para " + fan + " " + NombreArtistico;
		return autografo;
	}
	public Artista(Artista o) {
		Biografia = o.Biografia;
		generosAsociados = (Lista) o.generosAsociados.clone();
		id = o.id;
		Instrumentos = (Lista) o.Instrumentos.clone();
		Nombre = o.Nombre;
		NombreArtistico = o.NombreArtistico;
	}
	public Clonar clone() {
		try {
			return new Artista(this);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;
	}
}