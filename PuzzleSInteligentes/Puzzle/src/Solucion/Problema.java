package Solucion;

import Puzzle.Rectangulo;

public class Problema {

	@SuppressWarnings("unused")
	private Rectangulo [][] inicial;
	@SuppressWarnings("unused")
	private EspacioEstados eS;
	
	public Problema(Rectangulo [][] inicial) {
		this.inicial = inicial;
		this.eS = new EspacioEstados(inicial);
	}
		
}
