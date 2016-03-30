package unal.poo.starmusic.menuconsola;
/**
 * @author Sebasti�n P�rez Salas
 * @author Carlos Alejandro Ruiz Ram�rez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Casta�o Guzman
 */
/*
 * Esta clase nos funciona de contenedora para las opciones que se encuentran
 * en MenuPrincipal/Consultar
 */
public class MI_Consultar extends OpcionDeMenu {
	
	public MI_Consultar(){
		Nombre="Consultar";
	}
	
	public String getNombre(){
		return Nombre;
	}
	
	public void ejecutar(){
		Opciones.setCabecera("\n\n----------------------------\n" +
				   "||        Consultar       ||\n" +
				   "----------------------------\n");
		Opciones.imprimir();
	}
}
