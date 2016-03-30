package unal.poo.starmusic.menuconsola;
/**
 * @author Sebasti�n P�rez Salas
 * @author Carlos Alejandro Ruiz Ram�rez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Casta�o Guzman
 */
/*
 * Al ejecutarse esta alerta se emite la excepcion Salida, que
 * cierra el ciclo del menu que se esta ejecutando
 */
public class MI_Salir extends OpcionDeMenu {
	
	public MI_Salir(){
		Nombre="Salir";
	}
	public MI_Salir(String etiqueta){
		Nombre=etiqueta;
	}
	public String getNombre(){
		return Nombre;
	}
	
	public void ejecutar() throws SALIDA{
		throw new SALIDA();
	}
}
