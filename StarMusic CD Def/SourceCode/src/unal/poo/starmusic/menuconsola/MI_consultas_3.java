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
import unal.poo.starmusic.varios.Album;
/*
 * Los objetos de esta clase calcula y muestra la cantidad de albumes que 
 * existen en las bandas
 */


public class MI_consultas_3 extends OpcionDeMenu {
	public MI_consultas_3() {
		Nombre = "Consultar la cantidad de albumes producidos";
	}

	
	public String getNombre() {
		return Nombre;
	}

	public void ejecutar() {
		Opciones.setCabecera("\n\n--------------------------------\n"
							   + "| Numero de albumes producidos |\n");
		
		int cantidad=0,i=0;
		
		if(Bandas.Lista_Bandas.size()>0){
			Banda bandaactual;
			Enumeration enume=Bandas.Lista_Bandas.elements();
			while(enume.hasMoreElements()){
				bandaactual=(Banda)enume.nextElement();
				System.out.println("La banda "+bandaactual.getNombre()+" contiene los albumes:");
				if(bandaactual.getAlbumes().size()>0){
					i=0;
					Enumeration enume2=bandaactual.getAlbumes().elements();
					while(enume2.hasMoreElements()){
						System.out.println("\t"
								+ (++i)
								+ ")"
								+ ((Album) enume2.nextElement())
										.getNombre());
						cantidad++;
					}
				}else System.out.println("\tNo contiene albumes");
			}
		}else System.out.println("Error: No hay bandas registradas - No hay albumes registrados");
		
		System.out.println(">>>Cantidad total de albumes producidos: "+cantidad);
	}

}
