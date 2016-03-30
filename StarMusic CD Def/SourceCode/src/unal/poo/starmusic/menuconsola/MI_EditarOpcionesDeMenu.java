package unal.poo.starmusic.menuconsola;

import unal.poo.starmusic.varios.Lectura;
/*
 * Esta opcion de menu llena dinamicamente las opciones del 
 * menu del usuario, las cuales son guardadas en el archivo menu.txt 
 */
public class MI_EditarOpcionesDeMenu extends OpcionDeMenu  {

	private boolean leerRespuesta() {
		while (true) {
			System.out.print("Respuesta (y/n): ");
			String respuesta = Lectura.Leer();
			if (respuesta.equals("y")) {
				return true;
			}
			if (respuesta.equals("n")) {
				return false;
			}

		}
	}
	
	public void ejecutar() {
		MenuPrincipal menu = new MenuPrincipal();
		menu.borrarOpciones();
		System.out.println("|| Edicion de menu de Usuario ||");
		System.out.print("Desea agregar el menu registrar? ");
		if (leerRespuesta()) {
			MI_Registrar registrar = new MI_Registrar();
			System.out.print("Desea agregar el menu registrar Nuevo Artista? ");
			if (leerRespuesta())
				registrar.Opciones.addOpcion(new MI_nuevo_artista());
			System.out.print("Desea agregar el menu registrar Nuevo Banda? ");
			if (leerRespuesta())
				registrar.Opciones.addOpcion(new MI_nuevo_banda());
			System.out.print("Desea agregar el menu registrar Nuevo Premio? ");
			if (leerRespuesta())
				registrar.Opciones.addOpcion(new MI_nuevo_premio());
			System.out.print("Desea agregar el menu registrar Nuevo Album? ");
			if (leerRespuesta())
				registrar.Opciones.addOpcion(new MI_Venta_album());
			System.out.print("Desea agregar el menu registrar Nuevo Boleto? ");
			if (leerRespuesta())
				registrar.Opciones.addOpcion(new MI_Venta_Boleto());
			System.out.print("Desea agregar el menu registrar Nuevo Genero? ");
			if (leerRespuesta())
				registrar.Opciones.addOpcion(new MI_registrar_genero());

			registrar.Opciones.addOpcion(new MI_Salir("Atras"));
			menu.agregarOpcion(registrar);
		}

		System.out.print("Desea agregar el menu Acciones? ");
		if (leerRespuesta()) {
			MI_Acciones acciones = new MI_Acciones();

			System.out.print("Desea agregar el menu Acciones Banda? ");
			if (leerRespuesta()) {
				MI_banda banda = new MI_banda();

				System.out
						.print("Desea agregar el menu Acciones Banda Contratar? ");
				if (leerRespuesta())
					banda.Opciones.addOpcion(new MI_contratar());

				System.out
						.print("Desea agregar el menu Acciones Banda Despedir? ");
				if (leerRespuesta())
					banda.Opciones.addOpcion(new MI_despedir());

				System.out
						.print("Desea agregar el menu Acciones Banda Album? ");
				if (leerRespuesta()) {
					MI_acc_album acc_album = new MI_acc_album();
					acc_album.Opciones.addOpcion(new MI_crear_album());
					acc_album.Opciones.addOpcion(new MI_agregar_cancion());
					acc_album.Opciones.addOpcion(new MI_Salir("Atras"));
					banda.Opciones.addOpcion(acc_album);

				}
				System.out
						.print("Desea agregar el menu Acciones Banda crear concierto? ");
				if (leerRespuesta())
					banda.Opciones.addOpcion(new MI_crear_concierto());

				System.out
						.print("Desea agregar el menu Acciones Banda recibir premio? ");
				if (leerRespuesta())
					banda.Opciones.addOpcion(new MI_recibir_premio());

				System.out
						.print("Desea agregar el menu Acciones Banda crear cancion? ");
				if (leerRespuesta())
					banda.Opciones.addOpcion(new MI_crear_cancion());

				System.out
						.print("Desea agregar el menu Acciones Banda Añadir genero a la banda? ");
				if (leerRespuesta())
					banda.Opciones.addOpcion(new MI_anadir_gen_banda());

				banda.Opciones.addOpcion(new MI_Salir("Atras"));

				acciones.Opciones.addOpcion(banda);
				menu.agregarOpcion(acciones);
			}

			System.out.print("Desea agregar el menu Acciones Artista? ");
			if (leerRespuesta()) {
				MI_artista artista = new MI_artista();
				System.out
						.print("Desea agregar el menu Acciones Artista Componer cancion? ");
				if (leerRespuesta())
					artista.Opciones.addOpcion(new MI_art_componer_cancion());

				System.out
						.print("Desea agregar el menu Acciones Artista Añadir genero? ");
				if (leerRespuesta())
					artista.Opciones.addOpcion(new MI_art_anadir_genero());

				System.out
						.print("Desea agregar el menu Acciones Artista Firmar Autografo? ");
				if (leerRespuesta())
					artista.Opciones.addOpcion(new MI_Firmar_Autografo());

				System.out
						.print("Desea agregar el menu Acciones Artista comprar Instrumento? ");
				if (leerRespuesta())
					artista.Opciones.addOpcion(new MI_Comprar_Instrumento());

				System.out
						.print("Desea agregar el menu Acciones Artista Inventariar Instrumentos? ");
				if (leerRespuesta())
					artista.Opciones
							.addOpcion(new MI_InventariarInstrumentos());

				artista.Opciones.addOpcion(new MI_Salir("Atras"));

				acciones.Opciones.addOpcion(artista);
			}

			acciones.Opciones.addOpcion(new MI_Salir("Atras"));
			menu.agregarOpcion(acciones);
		}

		System.out.print("Desea agregar el menu Consultar? ");
		if (leerRespuesta()) {
			MI_Consultar consultar = new MI_Consultar();
			consultar.Opciones.addOpcion(new MI_consultas_1());
			consultar.Opciones.addOpcion(new MI_consultas_2());
			consultar.Opciones.addOpcion(new MI_consultas_3());
			consultar.Opciones.addOpcion(new MI_consultas_4());
			consultar.Opciones.addOpcion(new MI_consultas_5());
			consultar.Opciones.addOpcion(new MI_consultas_6());
			consultar.Opciones.addOpcion(new MI_Salir("Atras"));
			menu.agregarOpcion(consultar);
		}

		System.out.print("Desea agregar el menu calcular? ");
		if (leerRespuesta()) {
			MI_Calcular calcular = new MI_Calcular();
			System.out
					.print("Desea agregar el menu calcular Ganancias por Ventas  ");
			if (leerRespuesta())
				calcular.Opciones.addOpcion(new MI_calc_ganancia_ventas());

			System.out
					.print("Desea agregar el menu calcular ganancias por Conciertos? ");
			if (leerRespuesta())
				calcular.Opciones.addOpcion(new MI_calc_ganancia_conciertos());

			calcular.Opciones.addOpcion(new MI_Salir("Atras"));
			menu.agregarOpcion(calcular);
		}
		menu.agregarOpcion(new MI_Salir());
	}

	public String getNombre() {
		return "Editar opciones listadas en el menu principal";
	}


}
