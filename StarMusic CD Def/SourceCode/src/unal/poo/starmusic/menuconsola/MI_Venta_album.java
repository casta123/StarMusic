package unal.poo.starmusic.menuconsola;
/**
 * @author Sebastián Pérez Salas
 * @author Carlos Alejandro Ruiz Ramírez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Castaño Guzman
 */
import unal.poo.starmusic.varios.Albumes;
import unal.poo.starmusic.varios.Lista;
import unal.poo.starmusic.varios.Venta_Album;
import unal.poo.starmusic.varios.Album;
import unal.poo.starmusic.artistas.Banda;
import unal.poo.starmusic.artistas.Bandas;

public class MI_Venta_album extends OpcionDeMenu implements deshechar {
	
	Lista bandaRehacer;
	Lista bandaDeshacer;
	
	public MI_Venta_album() {
		Nombre = "Vender un album";
	}

	public String getNombre() {
		return Nombre;
	}

	public void ejecutar() {
		bandaDeshacer = (Lista) Bandas.Lista_Bandas.clone();
		Opciones.setCabecera("\n\n------------------------\n"
				+ "||   Venta de album   ||\n\nDatos necesarios:\n");

		Banda bandaelegida = Bandas.obtener_banda();
		if (bandaelegida != null) {
			Album albumelegido = Albumes.obtener_album(bandaelegida);
			if (albumelegido != null) {
				Venta_Album venta = new Venta_Album(albumelegido);
				albumelegido.AgregarVenta(venta);
				System.out.println("\n>>>Se ha vendido una copia del album +"
						+ albumelegido.getNombre());
			}
		}
		bandaRehacer = (Lista) Bandas.Lista_Bandas.clone();
	}
	
	public void deshacer() {
		if (this.bandaDeshacer != null) {
			Bandas.Lista_Bandas = bandaDeshacer;
			System.out.println(">>>>>Se ha eliminado la venta del boleto");
		}
	}
	public void rehacer() {
		if (this.bandaRehacer != null) {
			System.out.println(">>>>>Se ha vendido el boleto");
			Bandas.Lista_Bandas = bandaRehacer;
		}
	}
	
	MI_Venta_album(MI_Venta_album o){
		bandaDeshacer = o.bandaDeshacer;
		bandaRehacer = o.bandaRehacer;
	}
	
	public OpcionDeMenu clone(){
		return new MI_Venta_album(this);
	}
}
