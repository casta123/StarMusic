package unal.poo.starmusic.varios;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;
/**
 * @author Sebastián Pérez Salas
 * @author Carlos Alejandro Ruiz Ramírez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Castaño Guzman
 */
/*
 * La clase InicioSesion tiene la finalidad de administrar los
 * usuarios de la apliacion, incluido su almacenamiento, lectura y escritura
 * Posee dos atributos, uno que es el usuarioAplicacion y es donde se almacena
 * el usuario con el cual se ha iniciado sesion
 * el segundo es usuario, ahí se almacenan todos los usuarios que hacen parte de 
 * la aplicacion.
 */
public class InicioSesion {
	private static Usuario usuarioAplicacion = null;
	private static Vector<Usuario> usuarios = null;

	private void cargarUsuarios() {
		IOArchivo archivo = new IOArchivo("Usuarios.txt");
		archivo.leer();
		this.usuarios = archivo.getVector();
	}

	public boolean existeUsuario(Usuario usuario) {
		if (usuarios == null)
			cargarUsuarios();
		Enumeration<Usuario> enumeracion = usuarios.elements();
		while (enumeracion.hasMoreElements()) {
			Usuario auxiliarUsuario = enumeracion.nextElement();
			if (usuario.getNombre().equals(auxiliarUsuario.getNombre()))
				return true;
		}
		return false;
	}
	public boolean autenticarUsuario(Usuario usuario) {
		if (usuarios == null)
			cargarUsuarios();

		if (usuarios.size() == 0) {
			System.out
					.println("No existen usuario, se iniciara sesion como administrador");
			usuarioAplicacion = new Usuario();
			usuarioAplicacion.setAdministrador(true);
			return true;
		}

		if (existeUsuario(usuario)) {
			Enumeration<Usuario> enumeracion = usuarios.elements();
			while (enumeracion.hasMoreElements()) {
				Usuario auxiliarUsuario = enumeracion.nextElement();
				if (usuario.getNombre().equals(auxiliarUsuario.getNombre())
						&& auxiliarUsuario.isContrasenaOk(usuario
								.getContrasena())) {
					usuarioAplicacion = auxiliarUsuario;
					return true;
				}
			}

		}
		System.out.println("Nombre de usuario o contraseña incorrecto");
		return false;
	}
	public void guardarUsuarios() {
		if (usuarios == null)
			return; // /No vamos a guardar algo que no se ha cargado

		Enumeration<Usuario> enumeracionUsuarios = usuarios.elements();
		IOArchivo archivo = new IOArchivo("Usuarios.txt");
		while (enumeracionUsuarios.hasMoreElements()) {
			archivo.agregarObjeto(enumeracionUsuarios.nextElement());
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
	public boolean agregarUsuario(Usuario usuarioAAgregar) {
		if (usuarios == null)
			cargarUsuarios();

		if (existeUsuario(usuarioAAgregar))
			return false;
		else
			usuarios.add(usuarioAAgregar);
		return true;
	}
	public Usuario eliminarUsuario(Usuario usuario) {
		if (usuarios == null)
			cargarUsuarios();
		Usuario eliminado = null;
		if (existeUsuario(usuario))
			for (int i = 0; i < usuarios.size(); i++)
				if (usuarios.elementAt(i) != null
						&& usuarios.elementAt(i).getNombre()
								.equals(usuario.getNombre())){
					eliminado = usuarios.elementAt(i);
					usuarios.removeElementAt(i);
				}
		return eliminado;

	}
	public boolean autenticado() {
		return usuarioAplicacion != null;
	}
	public boolean esAdministrador() {
		if (usuarioAplicacion != null)
			return usuarioAplicacion.isAdministrador();
		return false;
	}
	public Usuario getUsuario() {
		return usuarioAplicacion;
	}

	public void formularioEntrada() {
		while (!autenticado()) {
			Usuario usuario = new Usuario();
			System.out.print("Usuario: ");
			usuario.setNombre(Lectura.Leer());
			System.out.print("Contraseña: ");
			usuario.setContrasena(Lectura.Leer());
			autenticarUsuario(usuario);
		}
	}
	public String listado() {
		String listado = "";
		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.elementAt(i) != null)
				listado += (usuarios.elementAt(i).getNombre() + " "
						+ usuarios.elementAt(i).getContrasena() + "\n");
		}
		return listado;
	}
}
