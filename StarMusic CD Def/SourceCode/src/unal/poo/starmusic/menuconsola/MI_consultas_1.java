package unal.poo.starmusic.menuconsola;
/**
 * @author Sebastián Pérez Salas
 * @author Carlos Alejandro Ruiz Ramírez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Castaño Guzman
 */
import unal.poo.starmusic.artistas.Banda;
import unal.poo.starmusic.artistas.Bandas;
import unal.poo.starmusic.varios.Lectura;
import unal.poo.starmusic.varios.Premio;
/*
 * Lo objetos de esta clase consultan los premios recibidos segun el tope de
 * venta especificado para cada premio.
 * Se recibe un valor minimo de ventas y se muestra los que son mayores a este
 */
public class MI_consultas_1 extends OpcionDeMenu {
	public MI_consultas_1() {
		Nombre = "Consultar los premios recibidos segun los topes de venta";
	}

	public String getNombre() {
		return Nombre;
	}

	public void ejecutar() {
		Opciones.setCabecera("\n\n--------------------------------------------------------\n"
				+ "| Consultar los premios recibidos segun topes de venta |\n");
		System.out.print("Ingrese el minimo tope de ventas para la busueda: ");
		int opcion = 0;
		int numeroDePremios = 0;
		try {
			opcion = Integer.parseInt(Lectura.Leer());
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return;
		}
		System.out.println("Bandas premiadas");
		for (int i = 0; i < Bandas.Lista_Bandas.size(); i++) {
			Banda banda = (Banda) Bandas.Lista_Bandas.elementAt(i);
			if (banda.getListaPremios().size() > 0) {
				System.out.println("Banda: " + banda.getNombre());
				for (int j = 0; j < banda.getListaPremios().size(); j++) {
					if (((Premio) banda.getListaPremios().elementAt(j)).getTopeDeVentas() >= opcion) {
						System.out.println("Nombre :"
								+ ((Premio) banda.getListaPremios().elementAt(
										j)).getnombre()
								+ " Entidad: "
								+ ((Premio) banda.getListaPremios().elementAt(
										j)).getEntidad()
								+ " Tope de Ventas"
								+ ((Premio) banda.getListaPremios().elementAt(
										j)).getTopeDeVentas());
					numeroDePremios++;
					}
				}
			}
		}
		System.out.print("El numero total de premios recibidos segun el tope de venta es: " + numeroDePremios);
	}
}
