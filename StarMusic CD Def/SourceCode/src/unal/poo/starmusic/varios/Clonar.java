package unal.poo.starmusic.varios;
/**
 * @author Sebasti�n P�rez Salas
 * @author Carlos Alejandro Ruiz Ram�rez
 * @author Monica Jhoana Esparza Cardona
 * @author Andres Felipe Casta�o Guzman
 */
/*
 * Esta interfaz nos facilita la clonacion de objetos, al definir
 * un tipo de retorno del metodo clone()
 */
public interface Clonar extends Cloneable {
	public abstract Clonar clone();
}
