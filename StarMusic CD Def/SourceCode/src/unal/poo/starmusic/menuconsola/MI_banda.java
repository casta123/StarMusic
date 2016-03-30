package unal.poo.starmusic.menuconsola;
/**
 * @author Sebastián Pérez Salas
 * @author Carlos Alejandro Ruiz Ramírez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Castaño Guzman
 */

/*
 * Esta clase nos funciona de contenedora para las opciones que se encuentran
 * en MenuPrincipal/Banda
 */
public class MI_banda extends OpcionDeMenu {
	public MI_banda() {
		Nombre = "Bandas";
	}

	public String getNombre() {
		return Nombre;
	}

	public void ejecutar() {
		Opciones.setCabecera("\n\n----------------------------\n" +
				   		   "||    Acciones - Bandas    ||\n");
		Opciones.imprimir();
	}
}
