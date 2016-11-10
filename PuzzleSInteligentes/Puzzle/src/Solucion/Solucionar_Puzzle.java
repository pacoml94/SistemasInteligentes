package Solucion;

import Puzzle.Rectangulo;

public class Solucionar_Puzzle {
	
	private Rectangulo [][] puzzle;
	private boolean estaResuelto;
	
	public Solucionar_Puzzle(Rectangulo [][] piezas) {
		this.puzzle = piezas;
		this.estaResuelto = false;
	}
	
	public boolean getResuelto() {
		return estaResuelto;
	}
}
