package unal.poo.starmusic.varios;
/**
 * @author Sebasti�n P�rez Salas
 * @author Carlos Alejandro Ruiz Ram�rez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Casta�o Guzman
 */
/*
 * Implementa el m�todo leer, el cual retorna un String con la informacion agregada
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
