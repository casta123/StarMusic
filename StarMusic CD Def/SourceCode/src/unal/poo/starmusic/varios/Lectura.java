package unal.poo.starmusic.varios;
/**
 * @author Sebastián Pérez Salas
 * @author Carlos Alejandro Ruiz Ramírez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Castaño Guzman
 */
/*
 * Implementa el método leer, el cual retorna un String con la informacion agregada
 * desde el teclado
 */
public class Lectura {
	public static String Leer(){
		int caracter;
		String cadena="";
		boolean fin=false;
		while(!fin){
			try{
				caracter=System.in.read();
				if(caracter<0 || (char)caracter=='\n'){
					fin=true;
				}else if((char)caracter!='\r'){
					cadena=cadena+(char)caracter;
				}
			}catch (java.io.IOException ex){
				fin=true;
			}
		}
		return cadena;
	}
}
