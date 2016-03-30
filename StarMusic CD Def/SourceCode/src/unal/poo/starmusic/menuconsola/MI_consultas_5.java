package unal.poo.starmusic.menuconsola;
/**
 * @author Sebastián Pérez Salas
 * @author Carlos Alejandro Ruiz Ramírez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Castaño Guzman
 */
import java.util.Enumeration;
import unal.poo.starmusic.artistas.Banda;
import unal.poo.starmusic.artistas.Bandas;
import unal.poo.starmusic.generos.Genero;
import unal.poo.starmusic.generos.Generos;
import unal.poo.starmusic.varios.Lectura;
/*
 * Esta opcion de menu recorre las bandas y determina cuales estan asociados
 * al genero indicado
 */
public class MI_consultas_5 extends OpcionDeMenu {
	public MI_consultas_5() {
		Nombre = "Consultar las bandas asociadas a un genero particular";
	}

	public String getNombre() {
		return Nombre;
	}

	public void ejecutar() {
		Opciones.setCabecera("\n\n-------------------------------\n"
				+ "| Bandas asociados a genero |\n");

		System.out.println("Generos registrados: \n");

		if (Generos.Lista_Generos.size() > 0) {
			if (Bandas.Lista_Bandas.size() > 0) {
				Enumeration elementos = (Generos.Lista_Generos).elements();
				int i = 0;

				while (elementos.hasMoreElements()) {
					System.out.println("\t" + (++i) + ") "
							+ ((Genero) elementos.nextElement()).getNombre());
				}

				Genero generolegido;
				for (;;) {
					int index;
					System.out.print("\nSeleccione un genero: ");
					try {
						index = Integer.parseInt(Lectura.Leer());
						if (index > 0 && index <= Generos.Lista_Generos.size()) {
							generolegido = (Genero) Bandas.Lista_Bandas
									.get(index - 1);
							System.out.println("\nel genero "
									+ generolegido.getNombre()
									+ " fue seleccionado");
							break;
						}
					} catch (NumberFormatException e) {
					}
				}

				System.out.println("Bandas asociados al genero "
						+ generolegido.getNombre() + ":\n");
				
				elementos = Bandas.Lista_Bandas.elements();
				i=0;
				while(elementos.hasMoreElements()){
					Banda actual=(Banda)elementos.nextElement();
					if(actual.getGenerosAsociados().contains(generolegido)){
						System.out.println("\t" + (++i) + ") "
								+ actual.getNombre());
					}
				}
				
			} else {
				System.out
						.println("No existen bandas registradas, registre bandas y vuelva a intentarlo");
			}

		} else {
			System.out
					.println("No existen generos registrados, registre generos y vuelva a intentarlo");
		}

	}
}
