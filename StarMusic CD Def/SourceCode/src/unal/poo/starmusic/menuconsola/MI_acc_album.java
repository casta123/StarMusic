package unal.poo.starmusic.menuconsola;
/**
 * @author Sebastián Pérez Salas
 * @author Carlos Alejandro Ruiz Ramírez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Castaño Guzman
 */
/*
 * Esta clase nos funciona de contenedora para las opciones que se encuentran
 * en MenuPrincipal/Aciones/Bandas/Albumes
 */
public class MI_acc_album extends OpcionDeMenu{
	public MI_acc_album() {
		Nombre = "Acciones albumes";
	}

	public String getNombre() {
		return Nombre;
	}

	public void ejecutar() {
		Opciones.setCabecera("\n\n----------------------------\n" +
				   		   	   "||   Banda - Albumes   ||\n");
		Opciones.imprimir();
	}
}
