package unal.poo.starmusic.varios;
/**
 * @author Sebastián Pérez Salas
 * @author Carlos Alejandro Ruiz Ramírez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Castaño Guzman
 */
import java.util.Enumeration;

import unal.poo.starmusic.artistas.Banda;
/*
 * Esta clase nos representa los conciertos de las bandas
 */
public class Concierto implements ObjetoIO{
	private String Nombre;
	private String Lugar;
	private long NumParticipantes;
	private float ValorEntrada;
	
	public Concierto(){
		Nombre = "";
		Lugar = "";
		NumParticipantes = 0;
		ValorEntrada = 0;
	}
	
	public Concierto(String Nombre, String Lugar, float vEntrada){
		this.Nombre = Nombre;
		this.Lugar = Lugar;
		NumParticipantes = 0;
		ValorEntrada = vEntrada;
	}
	
	public void vender_boleta(int cant){
		NumParticipantes+=cant;
	}
	
	
	public void setNombre(String Nombre){
		this.Nombre = Nombre;
	}
	
	public void setLugar(String Lugar){
		this.Lugar = Lugar;
	}
	
	public void setNumParticipantes(long nParticipantes){
		NumParticipantes = nParticipantes;
	}
	
	public void setValorEntrada(float vEntrada){
		ValorEntrada = vEntrada;
	}
	
	public String getNombre(){
		return Nombre;
	}
	
	public String getLugar(){
		return Lugar;
	}
	
	public long getNumParticipantes(){
		return NumParticipantes;
	}
	
	public float getValorEntrada(){
		return ValorEntrada;
	}
	
	//Este metodo me permite obtener un Objeto de tipo concierto que se
	//encuentra registrado en la banda especificada
	
	public static Concierto obtener_Concierto(Banda Banda) {
		System.out.println("Albunes registradas: \n");

		if (Banda.getConciertos().size() > 0) {
			Enumeration elementos = (Banda.getConciertos()).elements();
			int i = 0;

			while (elementos.hasMoreElements()) {
				System.out.println("\t" + (++i) + ") "
						+ ((Concierto) elementos.nextElement()).getNombre());
			}

			Concierto conciertoelegido;
			for (;;) {
				int concierto;
				System.out.print("\nSeleccione un album: ");
				try {
					concierto = Integer.parseInt(Lectura.Leer());
					if (concierto > 0
							&& concierto <= Banda.getConciertos().size()) {
						conciertoelegido = (Concierto) Banda.getConciertos()
								.get(concierto - 1);
						System.out.println("\nEl album : "
								+ conciertoelegido.getNombre()
								+ " fue seleccionada");

						break;
					}
				} catch (NumberFormatException e) {
				}
			}
			return conciertoelegido;
		} else {
			System.out
					.println("No existen albunes registrados, registre bandas y albunes y vuelva a intentarlo");
			return null;
		}
	}
	
}