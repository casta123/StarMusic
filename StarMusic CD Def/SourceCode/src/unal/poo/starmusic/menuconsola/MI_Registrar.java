package unal.poo.starmusic.menuconsola;
/**
 * @author Sebastián Pérez Salas
 * @author Carlos Alejandro Ruiz Ramírez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Castaño Guzman
 */
/*
 * Esta clase nos funciona de contenedora para las opciones que se encuentran
 * en MenuPrincipal/Registrar
 */
public class MI_Registrar extends OpcionDeMenu  {
	public MI_Registrar(){
		Nombre="Registrar";
	}
	
	public void ejecutar(){
		Opciones.setCabecera("\n\n\t||          Registrar          ||\n"
				+ "\t---------------------------------\n");

		Opciones.imprimir();
	}
	
	public String getNombre(){
		return Nombre;
	}
}
