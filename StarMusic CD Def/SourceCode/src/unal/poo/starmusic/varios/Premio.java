package unal.poo.starmusic.varios;
/**
 * @author Sebastián Pérez Salas
 * @author Carlos Alejandro Ruiz Ramírez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Castaño Guzman
 */
import java.util.Calendar;

import unal.poo.starmusic.artistas.Banda;

public class Premio implements ObjetoIO,Clonar{
	private long id;
	private String nombre;
	private long tope_Ventas;
	private String Entidad;

	
	
	public Premio(String nombre, long tope_ventas, String entidad) {
		this.nombre = nombre;
		this.tope_Ventas = tope_ventas;
		this.Entidad = entidad;
		id=generarId();
	}

	public Premio() {
		nombre = "";
		tope_Ventas = 0;
		Entidad = "";
		id=generarId();
	}
	
	private long generarId(){
		Calendar hoy=Calendar.getInstance();
		String valor=""+hoy.get(Calendar.YEAR)+hoy.get(Calendar.HOUR_OF_DAY)+hoy.get(Calendar.SECOND)+(int)(Math.random()*99+1);
		return Long.valueOf(valor);
	}
	
	public Long getId(){
		return this.id;
	}

	public void setNombre(String Nombre) {
		this.nombre = Nombre;
	}

	public void setTopeDeventas(long topeventas) {
		this.tope_Ventas = topeventas;
	}

	public void setEntidad(String entidad) {
		this.Entidad = entidad;
	}

	public String getnombre() {
		return nombre;
	}

	public long getTopeDeVentas() {
		return tope_Ventas;
	}

	public String getEntidad() {
		return Entidad;
	}
	
	public Premio(Premio o){
		nombre = o.getnombre();
		id = o.getId();
		Entidad= o.getEntidad();
		tope_Ventas = o.getTopeDeVentas();
	}
	public Clonar clone(){
		try{
			return (Clonar) new Premio(this);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
}
