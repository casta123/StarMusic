package unal.poo.starmusic.menuconsola;

/**
 * @author Sebasti�n P�rez Salas
 * @author Carlos Alejandro Ruiz Ram�rez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Casta�o Guzman
 */
/*
 * Esta clase nos funciona de contenedora para las opciones del administrador
 * No se genera dinamicamente, ya que el menu de administrador solo es visible
 * para el administrador el cual siempre es el mismo
 */
 
public class MI_Administrador extends OpcionDeMenu   {
	public String getNombre(){
		return "Administrador";
	}
	public void ejecutar(){
		MenuDeConsola menu = new MenuDeConsola();
		Opciones.setCabecera("\n\n\t||          Administrador          ||\n"
				+ "\t---------------------------------");
		menu.addOpcion(new MI_EditarOpcionesDeMenu());
		menu.addOpcion(new Mi_AgregarUsuario());
		menu.addOpcion(new MI_EliminarUsuario());
		menu.addOpcion(new MI_ListarUsuarios());
		menu.addOpcion(new MI_Salir("Atras"));
		menu.imprimir();

	}
}
