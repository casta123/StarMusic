package unal.poo.starmusic.menuconsola;

/**
 * @author Sebasti�n P�rez Salas
 * @author Carlos Alejandro Ruiz Ram�rez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Casta�o Guzman
 */
/*
 * Contenedor principal de las opciones de menu, agrega el texto Menu de Consola al
 * iniciar la aplicacion
 */

public class MI_menu_general extends OpcionDeMenu{
	public MI_menu_general(){
		Nombre = "Menu General";
	}

	public String getNombre() {
		return Nombre;
	}

	public void ejecutar() {
		Opciones.setCabecera("\n\t--------------------------\n"
							 + "\t||    Menu de consola     ||\n" +
							 "\t---------------------------\n");
		
		Opciones.imprimir();
	}
}
