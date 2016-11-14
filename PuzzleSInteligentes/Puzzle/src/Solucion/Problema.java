package Solucion;

import Puzzle.Rectangulo;

public class Problema {

	private Rectangulo [][] inicial;
	private EspacioEstados eS;
	
	public Problema(Rectangulo [][] inicial) {
		this.inicial = inicial;
		this.eS = new EspacioEstados(inicial);
	}
		
}
