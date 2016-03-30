package unal.poo.starmusic.varios;
/**
 * @author Sebastián Pérez Salas
 * @author Carlos Alejandro Ruiz Ramírez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Castaño Guzman
 */
/*
 * Esta interfaz nos facilita la clonacion de objetos, al definir
 * un tipo de retorno del metodo clone()
 */
public interface Clonar extends Cloneable {
	public abstract Clonar clone();
}
