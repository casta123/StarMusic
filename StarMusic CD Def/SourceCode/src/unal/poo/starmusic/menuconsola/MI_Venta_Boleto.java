package unal.poo.starmusic.menuconsola;

import unal.poo.starmusic.artistas.Banda;
import unal.poo.starmusic.artistas.Bandas;
import unal.poo.starmusic.varios.Clonar;
import unal.poo.starmusic.varios.Lectura;
import unal.poo.starmusic.varios.Concierto;
import unal.poo.starmusic.varios.Lista;
import unal.poo.starmusic.varios.Usuario;
/**
 * @author Sebastián Pérez Salas
 * @author Carlos Alejandro Ruiz Ramírez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Castaño Guzman
 */
public class MI_Venta_Boleto extends OpcionDeMenu implements deshechar{
	
	Lista bandaRehacer;
	Lista bandaDeshacer;
	
	public MI_Venta_Boleto() {
		Nombre = "Vender un Boleto";
	}

	public String getNombre() {
		return Nombre;
	}
	
	

	public void ejecutar() {
		bandaDeshacer = (Lista) Bandas.Lista_Bandas.clone();
		
		Opciones.setCabecera("\n\n-------------------------\n"
							 + "||   Venta de Boleto   ||\n");

		System.out.println("\nDatos necesarios:\n");
		Banda bandaelegida =Bandas.obtener_banda();
		if (bandaelegida != null) {
			Concierto conciertoelegido = Concierto
					.obtener_Concierto(bandaelegida);
			if (conciertoelegido != null) {
				int boletas;
				System.out.print("\n Ingrese la cantidad de boletas a vender: ");
				try{	
					boletas=Integer.parseInt(Lectura.Leer());
				}catch (NumberFormatException e) {boletas=1;}
				
				conciertoelegido.vender_boleta(boletas);
				System.out.println("\n>>>Se han realizado "+boletas+" ventas para el concierto "+conciertoelegido.getNombre());
			}
		}
		bandaRehacer = (Lista) Bandas.Lista_Bandas.clone();
	}
	
	public void deshacer() {
		if (this.bandaDeshacer != null) {
			Bandas.Lista_Bandas = bandaDeshacer;
			System.out.println(">>>>>Se ha cancelado la venta de boletos");
		}
	}
	public void rehacer() {
		if (this.bandaRehacer != null) {
			System.out.println(">>>>>Se han vendido los boletos");
			Bandas.Lista_Bandas = bandaRehacer;
		}
	}
	
	//Constructor copia
	MI_Venta_Boleto(MI_Venta_Boleto o){
		this.Opciones=o.Opciones;
		this.Nombre = o.getNombre();
	}
	
	public OpcionDeMenu clone() {
		try {
			return new MI_Venta_Boleto(this);
		} catch (Exception e) {
			return null;
		}
	}
	
}
