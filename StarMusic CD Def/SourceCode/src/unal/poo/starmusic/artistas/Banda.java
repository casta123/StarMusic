package unal.poo.starmusic.artistas;

import java.util.Calendar;
import java.util.Enumeration;

import unal.poo.starmusic.generos.Genero;
import unal.poo.starmusic.varios.*;
/**
 * @author Sebasti�n P�rez Salas
 * @author Carlos Alejandro Ruiz Ram�rez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Casta�o Guzman
 */
public class Banda implements ObjetoIO, Clonar {
	private String nombre;
	private Lista generosAsociados = new Lista();
	private Lista artistasMiembro = new Lista();
	private Lista Banda_premios = new Lista();
	private Lista Banda_albumes = new Lista();
	private Lista Banda_conciertos = new Lista();
	private short anio_Creacion;
	
	

	public Banda() {
		Calendar hoy = Calendar.getInstance();
		nombre = "";
		anio_Creacion = (short) hoy.get(Calendar.YEAR);
	}

	public Banda(String nombre, short anio) {
		this.nombre = nombre;
		if (anio > 0)
			this.anio_Creacion = anio;
		else {
			Calendar hoy = Calendar.getInstance();
			this.anio_Creacion = (short) hoy.get(Calendar.YEAR);
		}
	}

	// accedente y mutador
	public Lista getArtistas() {
		return artistasMiembro;
	}

	public Lista getAlbumes() {
		return Banda_albumes;
	}

	public Lista getConciertos() {
		return Banda_conciertos;
	}

	public String getNombre() {
		return nombre;
	}

	public void contratarArtista(Long candidato) {
		if (!artistasMiembro.contains(candidato)) {
			artistasMiembro.add(candidato);
			System.out.println("El artista ha sido contratado");
		} else
			System.out.println("El artista ya se encuetra contratado");

	}

	public void despedirArtista(Long candidato) {
		if (artistasMiembro.removeElement(candidato)) {
			System.out.println("El artista fue despedido");
		}
	}

	public void crear_Concierto(Concierto nconcierto) {
		if (!Banda_conciertos.contains(nconcierto))
			Banda_conciertos.add(nconcierto);
		else
			System.out.println("El concierto ya esta registrado");
	}

	public void recibir_premio(Long premio) {
		Banda_premios.add(premio);
	}

	public void crear_Album(Album album) {
		if (!Banda_albumes.contains(album))
			Banda_albumes.add(album);
		else
			System.out.println("El album ya esta registrado");
	}
	
	public Lista getGenerosAsociados(){
		return generosAsociados;
	}
	
	public void asociar_genero(Genero genero){
		if(!generosAsociados.contains(genero)){
			generosAsociados.add(genero);
			System.out.println("\n>>>El genero "+genero.getNombre()+" fue asociado a la banda");
		}else System.out.println("\n>>>El genero ya se encentra asociado");
	}
	public Lista getListaPremios(){
		return Banda_premios;
	}
	

	// Metodos accedernte y mutador
	public short getAnioCreacion() {
		return anio_Creacion;
	}
	
	public Banda(Banda o){
		anio_Creacion = o.anio_Creacion;
		artistasMiembro = (Lista) o.artistasMiembro.clone();
		Banda_albumes = (Lista) o.Banda_albumes.clone();
		Banda_conciertos = (Lista) o.Banda_conciertos.clone();
		Banda_premios = (Lista) o.Banda_premios.clone();
		generosAsociados = (Lista) o.generosAsociados.clone();
		nombre = o.nombre;
	}
	public Clonar clone(){
		try{
			return (Clonar) new Banda(this);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
}
