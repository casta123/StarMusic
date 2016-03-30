package unal.poo.starmusic.menuconsola;

/**
 * @author Sebasti�n P�rez Salas
 * @author Carlos Alejandro Ruiz Ram�rez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Casta�o Guzman
 */
/*
 * Esta clase nos funciona de contenedora para las opciones que se encuentran
 * en MenuPrincipal/Acciones
 */
public class MI_Acciones extends OpcionDeMenu{
	public MI_Acciones(){
		Nombre="Acciones";
	}
	
	public String getNombre(){
		return Nombre;
	}
	
	public void ejecutar(){
		Opciones.setCabecera("\n\n----------------------------\n" +
						   "||        Acciones       ||\n" +
						   "----------------------------\n");
		Opciones.imprimir();
	}
}
