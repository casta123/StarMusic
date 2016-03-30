package unal.poo.starmusic.menuconsola;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

import unal.poo.starmusic.varios.IOArchivo;
import unal.poo.starmusic.varios.ObjetoIO;
/*
 * Esta clase maneja las opciones de menu visibles, encargandose de leerlas
 * desde el archivo menu.txt, guardandolas, en fin...
 */
import unal.poo.starmusic.varios.Usuario;
/**
 * @author Sebastián Pérez Salas
 * @author Carlos Alejandro Ruiz Ramírez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Castaño Guzman
 */
/*
 * La clase menuPrincipal tiene la funcionalidad de determinar el menú que 
 * corresponde al usuario determinado, dependiendo si es administrador o
 * usuario. También es la encargada de leer y guardar las opciones
 * de menú en el archivo menu.txt.
 * La lista de menú es una lista estatica privada
 */
public class MenuPrincipal {
	private static Vector<OpcionDeMenu> opcionesMenu = null;

	public void cargarOpcionesMenu() {
		IOArchivo archivo = new IOArchivo("menu.txt");
		archivo.leer();
		opcionesMenu = archivo.getVector();
		if (opcionesMenu.size() == 0)
			opcionesPorDefecto();
	}

	public void guardarOpcionesMenu() {
		if (opcionesMenu == null)
			return; 

		Enumeration<OpcionDeMenu> enumeracionOpciones = opcionesMenu.elements();
		IOArchivo archivo = new IOArchivo("menu.txt");
		while (enumeracionOpciones.hasMoreElements()) {
			if (enumeracionOpciones != null)
				archivo.agregarObjeto(enumeracionOpciones.nextElement());
		}
		try {
			archivo.guardar();
		} catch (IOException e) {
			e.printStackTrace();
			try {
				System.in.read();

			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	public void borrarOpciones() {
		if (opcionesMenu == null)
			opcionesMenu = new Vector<OpcionDeMenu>();
		else
			opcionesMenu.removeAllElements();
	}
	public void opcionesPorDefecto() {
		// En este metodo se agrgan las opciones de menu que se van a ejecutar
		// por defecto
		// para el usuario final
		
		MI_Consultar consultar=new MI_Consultar();
		consultar.Opciones.addOpcion(new MI_consultas_1());
		consultar.Opciones.addOpcion(new MI_consultas_2());
		consultar.Opciones.addOpcion(new MI_consultas_3());
		consultar.Opciones.addOpcion(new MI_consultas_4());
		consultar.Opciones.addOpcion(new MI_consultas_5());
		consultar.Opciones.addOpcion(new MI_Salir("Atras"));
		
		opcionesMenu.add(consultar);
		opcionesMenu.add(new MI_Salir());
	}
	public MI_menu_general getMenu(boolean esUsuarioAdministrador) {
		// Esta funcion se encarga de determinar que menu hay que imprimir
		MI_menu_general menuPrincipal = new MI_menu_general();

		if (esUsuarioAdministrador) {
			
			//Bloque Registrar
			MI_Registrar registrar = new MI_Registrar();
			registrar.Opciones.addOpcion(new MI_nuevo_artista());
			registrar.Opciones.addOpcion(new MI_nuevo_banda());
			registrar.Opciones.addOpcion(new MI_nuevo_premio());
			registrar.Opciones.addOpcion(new MI_Venta_album());
			registrar.Opciones.addOpcion(new MI_Venta_Boleto());
			registrar.Opciones.addOpcion(new MI_registrar_genero());
			registrar.Opciones.addOpcion(new MI_Salir("Atras"));
			
			//bloque acciones
			MI_Acciones acciones = new MI_Acciones();
				MI_banda banda = new MI_banda();
					banda.Opciones.addOpcion(new MI_contratar());
					banda.Opciones.addOpcion(new MI_despedir());
						MI_acc_album acc_album= new MI_acc_album();
							acc_album.Opciones.addOpcion(new MI_crear_album());
							acc_album.Opciones.addOpcion(new MI_agregar_cancion());
							acc_album.Opciones.addOpcion(new MI_Salir("Atras"));
					banda.Opciones.addOpcion(acc_album);
					banda.Opciones.addOpcion(new MI_crear_concierto());
					banda.Opciones.addOpcion(new MI_recibir_premio());
					banda.Opciones.addOpcion(new MI_crear_cancion());
					banda.Opciones.addOpcion(new MI_anadir_gen_banda());
					banda.Opciones.addOpcion(new MI_Salir("Atras"));
				MI_artista artista=new MI_artista();
					artista.Opciones.addOpcion(new MI_art_componer_cancion());
					artista.Opciones.addOpcion(new MI_art_anadir_genero());
					artista.Opciones.addOpcion(new MI_Firmar_Autografo());
					artista.Opciones.addOpcion(new MI_Comprar_Instrumento());
					artista.Opciones.addOpcion(new MI_InventariarInstrumentos());
					artista.Opciones.addOpcion(new MI_Salir("Atras"));
				
			acciones.Opciones.addOpcion(banda);
			acciones.Opciones.addOpcion(artista);
			acciones.Opciones.addOpcion(new MI_Salir("Atras"));
			
			MI_Consultar consultar=new MI_Consultar();
				consultar.Opciones.addOpcion(new MI_consultas_1());
				consultar.Opciones.addOpcion(new MI_consultas_2());
				consultar.Opciones.addOpcion(new MI_consultas_3());
				consultar.Opciones.addOpcion(new MI_consultas_4());
				consultar.Opciones.addOpcion(new MI_consultas_5());
				consultar.Opciones.addOpcion(new MI_consultas_6());
				consultar.Opciones.addOpcion(new MI_Salir("Atras"));
			MI_Calcular calcular=new MI_Calcular();
				calcular.Opciones.addOpcion(new MI_calc_ganancia_ventas());
				calcular.Opciones.addOpcion(new MI_calc_ganancia_conciertos());
				calcular.Opciones.addOpcion(new MI_Salir("Atras"));

			menuPrincipal.Opciones.addOpcion(registrar);
			menuPrincipal.Opciones.addOpcion(acciones);
			menuPrincipal.Opciones.addOpcion(consultar);
			menuPrincipal.Opciones.addOpcion(calcular);
			menuPrincipal.Opciones.addOpcion(new MI_Administrador());
			menuPrincipal.Opciones.addOpcion(new MI_Salir());
			
			
		} else {
			// Creamos el menu dinamicamente
			for (int i = 0; i < opcionesMenu.size(); i++)
				if (opcionesMenu.elementAt(i) != null)
					menuPrincipal.Opciones.addOpcion(opcionesMenu.elementAt(i));
		}
		return menuPrincipal;
	}
	
	public void agregarOpcion(OpcionDeMenu o){
		opcionesMenu.add(o);
	}

}
