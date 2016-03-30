package unal.poo.starmusic.menuconsola;

import unal.poo.starmusic.artistas.Banda;
import unal.poo.starmusic.artistas.Bandas;
import unal.poo.starmusic.generos.Genero;
import unal.poo.starmusic.generos.Generos;
import unal.poo.starmusic.varios.Lectura;
/**
 * @author Sebasti�n P�rez Salas
 * @author Carlos Alejandro Ruiz Ram�rez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Casta�o Guzman
 */
/*
 * Esta clase nos actua de interfaz con el genero de una banda, permite
 * asociar un nuevo genero a la Banda 
 */
public class MI_anadir_gen_banda extends OpcionDeMenu implements deshechar {
	public MI_anadir_gen_banda() {
		Nombre = "Asociar generos a la banda";
	}

	public String getNombre() {
		return Nombre;
	}

	public void ejecutar() {
		Opciones.setCabecera("\n\n---------------------------------\n"
				+ "||   Banda - Asociar generos   ||\n\nDatos necesarios:\n");
		Banda bandaelegida = Bandas.obtener_banda();
		if (bandaelegida != null) {
			for (;;) {
				Genero generoelegido = Generos.obtener_genero();
				if (generoelegido != null) {
					bandaelegida.asociar_genero(generoelegido);

					String res;
					System.out.print("\nDesea a�adir mas generos (y/n): ");
					res = Lectura.Leer();

					if (res.equals("y")) {
					} else break;
				} else break;
			}
		}
	}

}
