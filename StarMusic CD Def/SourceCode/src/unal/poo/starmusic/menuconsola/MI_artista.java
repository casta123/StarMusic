package unal.poo.starmusic.menuconsola;
/**
 * @author Sebasti�n P�rez Salas
 * @author Carlos Alejandro Ruiz Ram�rez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Casta�o Guzman
 */
/*
 * Esta clase nos funciona de contenedora para las opciones que se encuentran
 * en MenuPrincipal/Artista
 */
public class MI_artista extends OpcionDeMenu{
	public MI_artista() {
		Nombre = "Artistas";
	}

	public String getNombre() {
		return Nombre;
	}

	public void ejecutar() {
		Opciones.setCabecera("\n\n----------------------------\n" +
				   		   	   "||   Acciones - Artistas   ||\n");
		Opciones.imprimir();
	}
}
