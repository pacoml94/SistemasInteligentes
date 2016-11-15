package Solucion;

import Puzzle.Rectangulo;

public class Problema {

	
	private Rectangulo [][] inicial;
	private Estado e;
	private EspacioEstados eS;
	
	public Problema(Rectangulo [][] inicial) {
		this.inicial = inicial;
		e=new Estado(inicial);
		this.eS = new EspacioEstados(e);
	}
		
}
