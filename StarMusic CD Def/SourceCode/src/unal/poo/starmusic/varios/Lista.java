package unal.poo.starmusic.varios;
/**
 * @author Sebastián Pérez Salas
 * @author Carlos Alejandro Ruiz Ramírez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Castaño Guzman
 */
import java.io.Serializable;
import java.util.Vector;
/*
 * Esta clase es hija de la clase Vector, agregando el metodo Clone y la opcion 
 * de serializar por motivos de persistencia de los listados
 */
public class Lista extends Vector<Object> implements Serializable, Clonar {
	
	public Lista(){	}
	public Lista(Lista o){
		for(int i = 0; i < o.size(); i++){
			if(o.elementAt(i) instanceof Clonar)
			this.add(((Clonar)(o.elementAt(i))).clone());
		}
	}
	public Clonar clone(){
		Clonar obj = null;
		try{
		obj = new Lista(this);
		}catch(Exception e){
			System.out.print("NO CLONEABLE OBJECT");
		}
		return obj;
	}
}
